package egovframework.ypoint.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.ypoint.service.YpointService;
import egovframework.ypoint.service.YpointDefaultVO;
import egovframework.ypoint.service.YpointVO;
import egovframework.yuser.service.YuserService;
import egovframework.yuser.service.YuserVO;

/**
 * @Class Name : YpointController.java
 * @Description : Ypoint Controller class
 * @Modification Information
 *
 * @author capstone
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=YpointVO.class)
public class YpointController {

    @Resource(name = "ypointService")
    private YpointService ypointService;
    
    @Resource(name = "yuserService")
    private YuserService yuserService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * ypoint 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 YpointDefaultVO
	 * @return "/ypoint/YpointList"
	 * @exception Exception
	 */
    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    @RequestMapping(value="/ypoint/YpointListJson.do")
    public ModelAndView selectYpointListJson(@ModelAttribute("searchVO") YpointDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	ModelAndView json = new ModelAndView("jsonView");
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
//		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> ypointList = ypointService.selectYpointList(searchVO);
        model.addAttribute("resultList", ypointList);
        json.addObject("resultList", ypointList);
        int totCnt = ypointService.selectYpointListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return json;
    } 
    
    
    @RequestMapping(value="/ypoint/YpointList.do")
    public String selectYpointList(@ModelAttribute("searchVO") YpointDefaultVO searchVO, 
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
//		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> ypointList = ypointService.selectYpointList(searchVO);
        model.addAttribute("ypointList", ypointList);
        int totCnt = ypointService.selectYpointListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        return "forward:/ypoint/selectPointSum.do?userid=" + searchVO.getUserid();
    } 
    
    @RequestMapping("/ypoint/addYpointView.do")
    public String addYpointView(
            @ModelAttribute("searchVO") YpointDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("ypointVO", new YpointVO());
        return "/ypoint/YpointRegister";
    }
    // 관리자가 상벌점 제출할 때 yuserpoint 추가
    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    @RequestMapping("/ypoint/insertYpoint.do")
    public void editPoint(YpointVO ypointVO, YuserVO yuserVO) throws Exception {
    	ypointService.insertYpoint(ypointVO);
    	yuserService.updateUserpoint(yuserVO);
    }
    
    @RequestMapping("/ypoint/updateYpointView.do")
    public String updateYpointView(
            @RequestParam("pointno") int pointno ,
            @ModelAttribute("searchVO") YpointDefaultVO searchVO, Model model)
            throws Exception {
        YpointVO ypointVO = new YpointVO();
        ypointVO.setPointno(pointno);        
        // 변수명은 CoC 에 따라 ypointVO
        model.addAttribute(selectYpoint(ypointVO, searchVO));
        return "/ypoint/YpointRegister";
    }

    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    @RequestMapping("/ypoint/selectYpoint.do")
    public @ModelAttribute("ypointVO")
    ModelAndView selectYpoint(
            YpointVO ypointVO,
            @ModelAttribute("searchVO") YpointDefaultVO searchVO) throws Exception {
    	ModelAndView json = new ModelAndView("jsonView");
    	System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
    	System.out.println(ypointService.selectYpoint(ypointVO));
    	System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    	json.addObject("result", ypointService.selectYpointList(ypointVO));
    	System.out.println("제이슨ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅂㅁㅁㅁㅁㅁㅇㅁㄴㅇㅁ");
    	System.out.println(json);
    	return json;
    }

    @RequestMapping("/ypoint/updateYpoint.do")
    public String updateYpoint(
            YpointVO ypointVO,
            @ModelAttribute("searchVO") YpointDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ypointService.updateYpoint(ypointVO);
        status.setComplete();
        return "forward:/ypoint/YpointList.do";
    }
    
    @RequestMapping("/ypoint/deleteYpoint.do")
    public String deleteYpoint(
            YpointVO ypointVO,
            @ModelAttribute("searchVO") YpointDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ypointService.deleteYpoint(ypointVO);
        status.setComplete();
        return "forward:/ypoint/YpointList.do";
    }
    
    @RequestMapping("/ypoint/selectPointSum.do")
    public String selectPointSum(
            YpointVO ypointVO, Model model)
            throws Exception {
    	try {
    		model.addAttribute("pointSum",ypointService.selectPointSum(ypointVO));
    	}catch(Exception e) {
    		model.addAttribute("pointSum",0);
    	}
        
        return "selectPoint";
    }
    
}
