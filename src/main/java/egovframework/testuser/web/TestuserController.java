package egovframework.testuser.web;

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

import egovframework.testuser.service.TestuserService;
import egovframework.testuser.service.TestuserDefaultVO;
import egovframework.testuser.service.TestuserVO;

/**
 * @Class Name : TestuserController.java
 * @Description : Testuser Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=TestuserVO.class)
public class TestuserController {

    @Resource(name = "testuserService")
    private TestuserService testuserService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * testuser 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 TestuserDefaultVO
	 * @return "/testuser/TestuserList"
	 * @exception Exception
	 */
    
    @RequestMapping("/testuser/checkUserLogin.do")
    public String checkUserLogin(
            TestuserVO userVO, Model model, HttpServletRequest request) throws Exception {
    	System.out.println("id : " + userVO.getId());
    	System.out.println("userid : " + userVO.getUserid());
    	System.out.println("userpw: " + userVO.getUserpw());
    	userVO = testuserService.checkUserLogin(userVO);
    	System.out.println("id : " + userVO.getId());
    	System.out.println("userid : " + userVO.getUserid());
    	System.out.println("userpw : " + userVO.getUserpw());
    	model.addAttribute("result", userVO);
    	
    	request.getSession().setAttribute("loginedUserVO", userVO);
    	return "index";
    }
    
    @RequestMapping("/testuser/userLogout.do")
    public String userLogout(HttpServletRequest request) throws Exception {
    	request.getSession().removeAttribute("loginedUserVO");
    	return "index";
    }
    
    @RequestMapping(value="/testuser/TestuserList.do")
    public String selectTestuserList(@ModelAttribute("searchVO") TestuserDefaultVO searchVO, 
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
		
        List<?> testuserList = testuserService.selectTestuserList(searchVO);
        model.addAttribute("resultList", testuserList);
        
        int totCnt = testuserService.selectTestuserListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/testuser/TestuserList";
    } 
    
    @RequestMapping("/testuser/addTestuserView.do")
    public String addTestuserView(
            @ModelAttribute("searchVO") TestuserDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("testuserVO", new TestuserVO());
        return "/testuser/TestuserRegister";
    }
    
    @RequestMapping("/testuser/addTestuser.do")
    public String addTestuser(
            TestuserVO testuserVO,
            @ModelAttribute("searchVO") TestuserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        testuserService.insertTestuser(testuserVO);
        status.setComplete();
        return "forward:/testuser/TestuserList.do";
    }
    
    @RequestMapping("/testuser/updateTestuserView.do")
    public String updateTestuserView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") TestuserDefaultVO searchVO, Model model)
            throws Exception {
        TestuserVO testuserVO = new TestuserVO();
        testuserVO.setId(id);        
        // 변수명은 CoC 에 따라 testuserVO
        model.addAttribute(selectTestuser(testuserVO, searchVO));
        return "/testuser/TestuserRegister";
    }

    @RequestMapping("/testuser/selectTestuser.do")
    public @ModelAttribute("testuserVO")
    TestuserVO selectTestuser(
            TestuserVO testuserVO,
            @ModelAttribute("searchVO") TestuserDefaultVO searchVO) throws Exception {
        return testuserService.selectTestuser(testuserVO);
    }

    @RequestMapping("/testuser/updateTestuser.do")
    public String updateTestuser(
            TestuserVO testuserVO,
            @ModelAttribute("searchVO") TestuserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        testuserService.updateTestuser(testuserVO);
        status.setComplete();
        return "forward:/testuser/TestuserList.do";
    }
    
    @RequestMapping("/testuser/deleteTestuser.do")
    public String deleteTestuser(
            TestuserVO testuserVO,
            @ModelAttribute("searchVO") TestuserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        testuserService.deleteTestuser(testuserVO);
        status.setComplete();
        return "forward:/testuser/TestuserList.do";
    }

}
