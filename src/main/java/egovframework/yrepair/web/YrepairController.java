package egovframework.yrepair.web;

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

import egovframework.yrepair.service.YrepairService;
import egovframework.yrepair.service.YrepairDefaultVO;
import egovframework.yrepair.service.YrepairVO;
import recaptcha.VerifyRecaptcha;
import egovframework.yrepairask.service.YrepairaskService;
import egovframework.yrepairask.service.YrepairaskVO;
/**
 * @Class Name : YrepairController.java
 * @Description : Yrepair Controller class
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
@SessionAttributes(types=YrepairVO.class)
public class YrepairController {

    @Resource(name = "yrepairService")
    private YrepairService yrepairService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    @Resource(name = "yrepairaskService")
    private YrepairaskService yrepairaskService;
    /**
	 * yrepair 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 YrepairDefaultVO
	 * @return "/yrepair/YrepairList"
	 * @exception Exception
	 */
    @RequestMapping(value="/yrepair/YrepairList.do")
    public String selectYrepairList(@ModelAttribute("searchVO") YrepairDefaultVO searchVO, 
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
		
        List<?> yrepairList = yrepairService.selectYrepairList(searchVO);
        model.addAttribute("yrepairList", yrepairList);
        
        int totCnt = yrepairService.selectYrepairListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "repair";
    } 
    
    @RequestMapping("/yrepair/addYrepairView.do")
    public String addYrepairView(
            @ModelAttribute("searchVO") YrepairDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("yrepairVO", new YrepairVO());
        return "/yrepair/YrepairRegister";
    }
    
    @RequestMapping("/yrepair/addYrepair.do")
    public String addYrepair(
            YrepairVO yrepairVO,
            @ModelAttribute("searchVO") YrepairDefaultVO searchVO, SessionStatus status)
            throws Exception {
        yrepairService.insertYrepair(yrepairVO);
        status.setComplete();
        return "redirect:/yrepair/YrepairList.do";
    }
    
    @RequestMapping("/yrepair/updateYrepairView.do")
    public String updateYrepairView(
            @RequestParam("reno") int reno ,
            @ModelAttribute("searchVO") YrepairDefaultVO searchVO, Model model)
            throws Exception {
        YrepairVO yrepairVO = new YrepairVO();
        yrepairVO.setReno(reno);        
        // 변수명은 CoC 에 따라 yrepairVO
//        model.addAttribute(selectYrepair(yrepairVO, searchVO));
        return "/yrepair/YrepairRegister";
    }

    @RequestMapping("/yrepair/selectYrepair.do")
    public String selectYrepair(YrepairVO yrepairVO, Model model) throws Exception {
    	model.addAttribute("repair", yrepairService.selectYrepair(yrepairVO));                      
    	return "forward:/yrepairask/selectYrepairask.do";
    }
    
    @RequestMapping("/yrepair/askformYrepair.do")
    public String askformYrepair(YrepairVO yrepairVO, Model model) throws Exception {
    	model.addAttribute("repair", yrepairService.selectYrepair(yrepairVO));        	                       
    	return "repairask";
    }
    
    @RequestMapping("/yrepair/updateformYrepair.do")
    public String selectUpdateYrepair(YrepairVO yrepairVO, Model model) throws Exception {
    	model.addAttribute("repair", yrepairService.selectYrepair(yrepairVO));        	                       
    	return "repairupdate";
    }
    
    @RequestMapping("/yrepair/updateYrepair.do")
    public String updateYrepair(
            YrepairVO yrepairVO,SessionStatus status)
            throws Exception {
        yrepairService.updateYrepair(yrepairVO);
        status.setComplete();
        return "redirect:/yrepair/YrepairList.do";
    }
    
    @RequestMapping("/yrepair/deleteYrepair.do")
    public String deleteYrepair(
            YrepairVO yrepairVO,
            @ModelAttribute("searchVO") YrepairDefaultVO searchVO, SessionStatus status)
            throws Exception {
        yrepairService.deleteYrepair(yrepairVO);
        status.setComplete();
        return "forward:/yrepairask/deleteYrepairask.do";
    }

//    리캡챠
    @ResponseBody
    @RequestMapping(value = "/yrepair/VerifyRecaptcha.do", method = RequestMethod.POST)
    public int VerifyRecaptcha(HttpServletRequest request) {
        VerifyRecaptcha.setSecretKey("6Lcz6I0mAAAAANj_QMBlI7xHlnGcBM6L4p_V6T8a");
        String gRecaptchaResponse = request.getParameter("recaptcha");
        System.out.println(gRecaptchaResponse);
        //0 = 성공, 1 = 실패, -1 = 오류
        try {
            if(VerifyRecaptcha.verify(gRecaptchaResponse))
                return 0;
            else return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
