package egovframework.ysleepover.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

import egovframework.ysleepover.service.YsleepoverService;
import egovframework.ysleepover.service.YsleepoverDefaultVO;
import egovframework.ysleepover.service.YsleepoverVO;

import egovframework.yuser.service.YuserVO;

/**
 * @Class Name : YsleepoverController.java
 * @Description : Ysleepover Controller class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=YsleepoverVO.class)
public class YsleepoverController {

    @Resource(name = "ysleepoverService")
    private YsleepoverService ysleepoverService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * ysleepover 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 YsleepoverDefaultVO
	 * @return "/ysleepover/YsleepoverList"
	 * @exception Exception
	 */
    @RequestMapping(value="/ysleepover/YsleepoverList.do")
    public String selectYsleepoverList(@ModelAttribute("searchVO") YsleepoverDefaultVO searchVO, 
    		ModelMap model, HttpSession session)
            throws Exception {
    	YuserVO user = (YuserVO) session.getAttribute("loginedUserVO");
    	searchVO.setSearchKeyword(user.getUserid());
    	
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
		
        List<?> ysleepoverList = ysleepoverService.selectYsleepoverList(searchVO);
        model.addAttribute("resultList", ysleepoverList);
        model.addAttribute("name", user.getUsername());
        
        int totCnt = ysleepoverService.selectYsleepoverListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        return "sleepover";
    }
    
    @RequestMapping("/ysleepover/selectYsleepoverListJson.do")
    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    public ModelAndView selectYsleepoverListJson()
            throws Exception {
    	ModelAndView json = new ModelAndView("jsonView");
    	json.addObject("result", ysleepoverService.selectYsleepoverListJson());
        return json;
    }
    
    
    @RequestMapping("/ysleepover/addYsleepoverView.do")
    public String addYsleepoverView(
            @ModelAttribute("searchVO") YsleepoverDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("ysleepoverVO", new YsleepoverVO());
        return "/ysleepover/YsleepoverRegister";
    }
    
    @RequestMapping("/ysleepover/addYsleepover.do")
    public String addYsleepover(
            YsleepoverVO ysleepoverVO, Model model)
            throws Exception {
        ysleepoverService.insertYsleepover(ysleepoverVO);
        return "redirect:/ysleepover/YsleepoverList.do";
    }
    
    @RequestMapping("/ysleepover/updateYsleepoverView.do")
    public String updateYsleepoverView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") YsleepoverDefaultVO searchVO, Model model)
            throws Exception {
        YsleepoverVO ysleepoverVO = new YsleepoverVO();
        ysleepoverVO.setId(id);        
        // 변수명은 CoC 에 따라 ysleepoverVO
        model.addAttribute(selectYsleepover(ysleepoverVO, searchVO));
        return "/ysleepover/YsleepoverRegister";
    }

    @RequestMapping("/ysleepover/selectYsleepover.do")
    public @ModelAttribute("ysleepoverVO")
    YsleepoverVO selectYsleepover(
            YsleepoverVO ysleepoverVO,
            @ModelAttribute("searchVO") YsleepoverDefaultVO searchVO) throws Exception {
        return ysleepoverService.selectYsleepover(ysleepoverVO);
    }
    
    @RequestMapping("/ysleepover/updateYsleepoverJson.do")
    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateYsleepoverJson(
            YsleepoverVO ysleepoverVO)
            throws Exception {
    	ModelAndView json = new ModelAndView("jsonView");
    	try {
    		ysleepoverService.updateYsleepover(ysleepoverVO);
    		 json.addObject("result", true);
    	}catch(Exception e) {
    		json.addObject("result", false);
    	}
        
         
       
        return json;
    }
    
    @RequestMapping("/ysleepover/todayAbsentStudent.do")
    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    public ModelAndView todayAbsentStudent(
            YsleepoverVO ysleepoverVO)
            throws Exception {
    	ModelAndView json = new ModelAndView("jsonView");
    	json.addObject("result", ysleepoverService.todayAbsentStudent());
        return json;
    }

    @RequestMapping("/ysleepover/updateYsleepover.do")
    public String updateYsleepover(
            YsleepoverVO ysleepoverVO,
            @ModelAttribute("searchVO") YsleepoverDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ysleepoverService.updateYsleepover(ysleepoverVO);
        status.setComplete();
        return "forward:/ysleepover/YsleepoverList.do";
    }
    
    @RequestMapping("/ysleepover/deleteYsleepover.do")
    public String deleteYsleepover(
            YsleepoverVO ysleepoverVO,
            @ModelAttribute("searchVO") YsleepoverDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ysleepoverService.deleteYsleepover(ysleepoverVO);
        status.setComplete();
        return "forward:/ysleepover/YsleepoverList.do";
    }

}
