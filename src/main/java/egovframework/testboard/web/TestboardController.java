package egovframework.testboard.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

import egovframework.testboard.service.TestboardService;
import egovframework.testboard.service.TestboardDefaultVO;
import egovframework.testboard.service.TestboardVO;

/**
 * @Class Name : TestboardController.java
 * @Description : Testboard Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-25
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=TestboardVO.class)
public class TestboardController {

    @Resource(name = "testboardService")
    private TestboardService testboardService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * testboard 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 TestboardDefaultVO
	 * @return "/testboard/TestboardList"
	 * @exception Exception
	 */
    
	
	 @RequestMapping(value="/testboard/updateBoardLikes.do") 
	 public @ResponseBody ModelAndView updateBoardLikes(TestboardVO vo, HttpServletRequest request) throws Exception {
		 testboardService.updateBoardLikes(vo);
		 ModelAndView jsonView = new ModelAndView("jsonView");
		 TestboardVO selectedvo = testboardService.selectTestboard(vo);
		 request.getSession().setAttribute("selectedVO", selectedvo);
		 jsonView.addObject("searchedVO",selectedvo);
		 return jsonView;
	 }
	 

    @RequestMapping("/testboard/selectBoardPost.do")
    public String selectBoardPost(TestboardVO testboardvo, HttpServletRequest request) throws Exception{
    	TestboardVO vo = testboardService.selectTestboard(testboardvo);
    	request.getSession().setAttribute("selectedVO", vo);
    	return "freeboardpost";	
    }
    
    
    @RequestMapping(value="/testboard/TestboardList.do")
    public String selectTestboardList(@ModelAttribute("searchVO") TestboardDefaultVO searchVO, 
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
		
        List<?> testboardList = testboardService.selectTestboardList(searchVO);
        model.addAttribute("resultList", testboardList);
        List<?> selectBoardTopList = testboardService.selectBoardTopList(searchVO);
        model.addAttribute("resultList2", selectBoardTopList);
        
        
        int totCnt = testboardService.selectTestboardListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "freeboard";
    } 
    
    @RequestMapping("/testboard/addTestboardView.do")
    public String addTestboardView(
            @ModelAttribute("searchVO") TestboardDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("testboardVO", new TestboardVO());
        return "/testboard/TestboardRegister";
    }
    
    @RequestMapping("/testboard/addTestboard.do")
    public String addTestboard(
            TestboardVO testboardVO,
            @ModelAttribute("searchVO") TestboardDefaultVO searchVO, SessionStatus status)
            throws Exception {
        testboardService.insertTestboard(testboardVO);
        status.setComplete();
        return "forward:/testboard/TestboardList.do";
    }
    
    @RequestMapping("/testboard/updateTestboardView.do")
    public String updateTestboardView(
            @RequestParam("bno") int bno ,
            @ModelAttribute("searchVO") TestboardDefaultVO searchVO, Model model)
            throws Exception {
        TestboardVO testboardVO = new TestboardVO();
        testboardVO.setBno(bno);        
        // 변수명은 CoC 에 따라 testboardVO
        model.addAttribute(selectTestboard(testboardVO, searchVO));
        return "/testboard/TestboardRegister";
    }

    @RequestMapping("/testboard/selectTestboard.do")
    public @ModelAttribute("testboardVO")
    TestboardVO selectTestboard(
            TestboardVO testboardVO,
            @ModelAttribute("searchVO") TestboardDefaultVO searchVO) throws Exception {
        return testboardService.selectTestboard(testboardVO);
    }

    @RequestMapping("/testboard/updateTestboard.do")
    public String updateTestboard(
            TestboardVO testboardVO,
            @ModelAttribute("searchVO") TestboardDefaultVO searchVO, SessionStatus status)
            throws Exception {
        testboardService.updateTestboard(testboardVO);
        status.setComplete();
        return "forward:/testboard/TestboardList.do";
    }
    
    @RequestMapping("/testboard/deleteTestboard.do")
    public String deleteTestboard(
            TestboardVO testboardVO,
            @ModelAttribute("searchVO") TestboardDefaultVO searchVO, SessionStatus status)
            throws Exception {
        testboardService.deleteTestboard(testboardVO);
        status.setComplete();
        return "forward:/testboard/TestboardList.do";
    }

}
