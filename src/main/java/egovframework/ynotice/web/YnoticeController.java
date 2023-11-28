package egovframework.ynotice.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.ynotice.service.YnoticeService;
import egovframework.ynotice.service.YnoticeDefaultVO;
import egovframework.ynotice.service.YnoticeVO;

/**
 * @Class Name : YnoticeController.java
 * @Description : Ynotice Controller class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-06-06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=YnoticeVO.class)
public class YnoticeController {

    @Resource(name = "ynoticeService")
    private YnoticeService ynoticeService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * ynotice 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 YnoticeDefaultVO
	 * @return "/ynotice/YnoticeList"
	 * @exception Exception
	 */
    @RequestMapping(value="/ynotice/YnoticeList.do")
    public String selectYnoticeList(@ModelAttribute("searchVO") YnoticeDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> ynoticeList = ynoticeService.selectYnoticeList(searchVO);
        model.addAttribute("noticeList", ynoticeList);
        
        int totCnt = ynoticeService.selectYnoticeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "notice";
    } 
    
    @RequestMapping("/ynotice/addYnoticeView.do")
    public String addYnoticeView(
            @ModelAttribute("searchVO") YnoticeDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("ynoticeVO", new YnoticeVO());
        return "/ynotice/YnoticeRegister";
    }
    
    @RequestMapping("/ynotice/addYnotice.do")
    @ResponseBody
    public String addYnotice(
            YnoticeVO ynoticeVO)
            throws Exception {
        ynoticeService.insertYnotice(ynoticeVO);
        return "";
    }
    
    @RequestMapping("/ynotice/getNoticeInform.do")
    public String getNoticeInform(
            YnoticeVO ynoticeVO, Model model)
            throws Exception {
    	model.addAttribute("selectedVO", ynoticeService.selectYnotice(ynoticeVO));
        return "noticeupdate";
    }
    
    @RequestMapping("/ynotice/updateYnoticeView.do")
    public String updateYnoticeView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") YnoticeDefaultVO searchVO, Model model)
            throws Exception {
        YnoticeVO ynoticeVO = new YnoticeVO();
        ynoticeVO.setId(id);        
        // 변수명은 CoC 에 따라 ynoticeVO
       // model.addAttribute(selectYnotice(ynoticeVO, searchVO));¿
        return "/ynotice/YnoticeRegister";
    }
    
    @RequestMapping("/ynotice/selectYnotice.do")
    public
    String selectYnotice(
            YnoticeVO ynoticeVO, Model model) throws Exception {
    	try {
    		ynoticeService.updateVisitor(ynoticeVO);   
        	YnoticeVO s = ynoticeService.selectYnotice(ynoticeVO);
        	System.out.println("제목은 " + s.getSubject());
        	model.addAttribute("notice", s);
    	}catch(Exception e) {
    		System.out.println("에러발생!!!" + e.getMessage());
    		
    	}
    	
        return "noticepost";
    }

    @RequestMapping("/ynotice/updateYnotice.do")
    @ResponseBody
    public String updateYnotice(
            YnoticeVO ynoticeVO)
            throws Exception {
        ynoticeService.updateYnotice(ynoticeVO);
        return "";
    }
    
    @RequestMapping("/ynotice/deleteYnotice.do")
    public String deleteYnotice(
            YnoticeVO ynoticeVO,
            @ModelAttribute("searchVO") YnoticeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ynoticeService.deleteYnotice(ynoticeVO);
        return "forward:/ynotice/YnoticeList.do";
    }

}
