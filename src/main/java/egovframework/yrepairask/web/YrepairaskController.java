package egovframework.yrepairask.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.yrepairask.service.YrepairaskService;
import egovframework.yrepairask.service.YrepairaskDefaultVO;
import egovframework.yrepairask.service.YrepairaskVO;
import recaptcha.VerifyRecaptcha;
import egovframework.yrepair.service.YrepairVO;
import egovframework.yrepair.service.YrepairService;

/**
 * @Class Name : YrepairaskController.java
 * @Description : Yrepairask Controller class
 * @Modification Information
 *
 * @author aa
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=YrepairaskVO.class)
public class YrepairaskController {

    @Resource(name = "yrepairaskService")
    private YrepairaskService yrepairaskService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    @Resource(name = "yrepairService")
    private YrepairService yrepairService;
    /**
	 * yrepairask 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 YrepairaskDefaultVO
	 * @return "/yrepairask/YrepairaskList"
	 * @exception Exception
	 */
    @RequestMapping(value="/yrepairask/YrepairaskList.do")
    public String selectYrepairaskList(@ModelAttribute("searchVO") YrepairaskDefaultVO searchVO, 
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
		
        List<?> yrepairaskList = yrepairaskService.selectYrepairaskList(searchVO);
        model.addAttribute("resultList", yrepairaskList);
        
        int totCnt = yrepairaskService.selectYrepairaskListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/yrepairask/YrepairaskList";
    } 
    
    @RequestMapping("/yrepairask/addYrepairaskView.do")
    public String addYrepairaskView(
            @ModelAttribute("searchVO") YrepairaskDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("yrepairaskVO", new YrepairaskVO());
        return "/yrepairask/YrepairaskRegister";
    }
    
    @RequestMapping("/yrepairask/addYrepairask.do")
    public String addYrepairask(
            YrepairaskVO yrepairaskVO, YrepairVO yrepairVO)
            throws Exception {
        yrepairaskService.insertYrepairask(yrepairaskVO);
        yrepairService.updateState(yrepairVO);
        return "redirect:/yrepair/YrepairList.do";
    }
    
    @RequestMapping("/yrepairask/updateYrepairaskView.do")
    public String updateYrepairaskView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") YrepairaskDefaultVO searchVO, Model model)
            throws Exception {
        YrepairaskVO yrepairaskVO = new YrepairaskVO();
        yrepairaskVO.setId(id);        
        // 변수명은 CoC 에 따라 yrepairaskVO
//        model.addAttribute(selectYrepairask(yrepairaskVO, searchVO));
        return "/yrepairask/YrepairaskRegister";
    }

    @RequestMapping("/yrepairask/selectYrepairask.do")
    public String selectYrepairask(
            YrepairaskVO yrepairaskVO, Model model) throws Exception {    		
    	try {
    		System.out.println("성공성공성공성공성공성공성공성공성공성공");
    		model.addAttribute("ask", yrepairaskService.selectYrepairask(yrepairaskVO));
    		System.out.println("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
    	}
    	catch(Exception e) {
    		System.out.println("실패실패실패실패실패실새피실패실패실패실패실패실새피");
    		model.addAttribute("ask", null);
    		System.out.println("널널널널널넌ㄹ널널널널널넌ㄹ널널널널널넌ㄹ널널널널널넌ㄹ");
    	}
		return "repairpost";
    }

    @RequestMapping("/yrepairask/updateYrepairask.do")
    public String updateYrepairask(
            YrepairaskVO yrepairaskVO,
            @ModelAttribute("searchVO") YrepairaskDefaultVO searchVO, SessionStatus status)
            throws Exception {
        yrepairaskService.updateYrepairask(yrepairaskVO);
        status.setComplete();
        return "forward:/yrepairask/YrepairaskList.do";
    }
    
    @RequestMapping("/yrepairask/deleteYrepairask.do")
    public String deleteYrepairask(
            YrepairaskVO yrepairaskVO,
            @ModelAttribute("searchVO") YrepairaskDefaultVO searchVO, SessionStatus status)
            throws Exception {
        yrepairaskService.deleteYrepairask(yrepairaskVO);
        status.setComplete();
        return "redirect:/yrepair/YrepairList.do";
    }
    
//  리캡챠
//  @ResponseBody
//  @RequestMapping(value = "/yrepair/VerifyRecaptcha.do", method = RequestMethod.POST)
//  public int VerifyRecaptcha(HttpServletRequest request) {
//      VerifyRecaptcha.setSecretKey("6Lcz6I0mAAAAANj_QMBlI7xHlnGcBM6L4p_V6T8a");
//      String gRecaptchaResponse = request.getParameter("recaptcha");
//      System.out.println(gRecaptchaResponse);
//      //0 = 성공, 1 = 실패, -1 = 오류
//      try {
//          if(VerifyRecaptcha.verify(gRecaptchaResponse))
//              return 0;
//          else return 1;
//      } catch (IOException e) {
//          e.printStackTrace();
//          return -1;
//      }
//  }

}
