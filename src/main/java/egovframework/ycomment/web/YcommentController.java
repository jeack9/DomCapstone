package egovframework.ycomment.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.ycomment.service.YcommentService;
import egovframework.ycomment.service.YcommentDefaultVO;
import egovframework.ycomment.service.YcommentVO;
import egovframework.yfreeboard.service.YfreeboardVO;

/**
 * @Class Name : YcommentController.java
 * @Description : Ycomment Controller class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=YcommentVO.class)
public class YcommentController {
	
    @Resource(name = "ycommentService")
    private YcommentService ycommentService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * ycomment 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 YcommentDefaultVO
	 * @return "/ycomment/YcommentList"
	 * @exception Exception
	 */
    @RequestMapping(value="/ycomment/YcommentList.do")
    public String selectYcommentList(@ModelAttribute("searchVO") YcommentDefaultVO searchVO, 
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
		
        List<?> ycommentList = ycommentService.selectYcommentList(searchVO);
        model.addAttribute("commentList", ycommentList);
        
        int totCnt = ycommentService.selectYcommentListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "freeboardpost";
    } 
    
    @RequestMapping("/ycomment/addYcommentView.do")
    public String addYcommentView(
            @ModelAttribute("searchVO") YcommentDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("ycommentVO", new YcommentVO());
        return "/ycomment/YcommentRegister";
    }
    
    @RequestMapping("/ycomment/addYcomment.do")
    public String addYcomment(
            YcommentVO ycommentVO)
            throws Exception {
        ycommentService.insertYcomment(ycommentVO);
        return "redirect:/yfreeboard/selectYfreeboard.do?bno=" + ycommentVO.getBno();
    }
    
    @RequestMapping("/ycomment/addReply.do")
    public String addReply(
            YcommentVO ycommentVO)
            throws Exception {
        ycommentService.insertReply(ycommentVO);
        return "redirect:/yfreeboard/selectYfreeboard.do?bno=" + ycommentVO.getBno();
    }
    
    @RequestMapping("/ycomment/updateYcommentView.do")
    public String updateYcommentView(
            @RequestParam("cno") int cno ,
            @ModelAttribute("searchVO") YcommentDefaultVO searchVO, Model model)
            throws Exception {
        YcommentVO ycommentVO = new YcommentVO();
        ycommentVO.setCno(cno);        
        // 변수명은 CoC 에 따라 ycommentVO
        model.addAttribute(selectYcomment(ycommentVO, searchVO));
        return "/ycomment/YcommentRegister";
    }

    @RequestMapping("/ycomment/selectYcomment.do")
    public @ModelAttribute("ycommentVO")
    YcommentVO selectYcomment(
            YcommentVO ycommentVO,
            @ModelAttribute("searchVO") YcommentDefaultVO searchVO) throws Exception {
        return ycommentService.selectYcomment(ycommentVO);
    }

    @RequestMapping("/ycomment/updateYcomment.do")
    public String updateYcomment(YcommentVO ycommentVO)
            throws Exception {
        ycommentService.updateYcomment(ycommentVO);
        return "redirect:/yfreeboard/selectYfreeboard.do?ycommentVO=" + ycommentVO.getBno();
    }
    
//    @RequestMapping("/ycomment/deleteYcomment.do")
//    public String deleteYcomment(
//            YcommentVO ycommentVO,
//            @ModelAttribute("searchVO") YcommentDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        ycommentService.deleteYcomment(ycommentVO);
//        status.setComplete();
//        return "forward:/ycomment/YcommentList.do";
//    }
    
    @RequestMapping("/ycomment/deleteYcomment.do")
    public String deleteYcomment(
            YcommentVO ycommentVO,
            @ModelAttribute("searchVO") YcommentDefaultVO searchVO, SessionStatus status, HttpServletRequest request, Model model)
            throws Exception {
        ycommentService.updateIsRemoveOne(ycommentVO);
        status.setComplete();
        
        YfreeboardVO vo = new YfreeboardVO();
        vo = (YfreeboardVO)request.getSession().getAttribute("selectedVO");
        
        
        return "redirect:/yfreeboard/selectYfreeboard.do?bno="+vo.getBno();
    }

}
