package egovframework.ypayment.web;

import java.util.List;

import javax.annotation.Resource;

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

import egovframework.ypayment.service.YpaymentService;
import egovframework.ypayment.service.YpaymentDefaultVO;
import egovframework.ypayment.service.YpaymentVO;

/**
 * @Class Name : YpaymentController.java
 * @Description : Ypayment Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=YpaymentVO.class)
public class YpaymentController {

    @Resource(name = "ypaymentService")
    private YpaymentService ypaymentService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * ypayment 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 YpaymentDefaultVO
	 * @return "/ypayment/YpaymentList"
	 * @exception Exception
	 */
    @RequestMapping(value="/ypayment/YpaymentList.do")
    public String selectYpaymentList(@ModelAttribute("searchVO") YpaymentDefaultVO searchVO, 
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
		
        List<?> ypaymentList = ypaymentService.selectYpaymentList(searchVO);
        model.addAttribute("resultList", ypaymentList);
        
        int totCnt = ypaymentService.selectYpaymentListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/ypayment/YpaymentList";
    } 
    
    @RequestMapping("/ypayment/addYpaymentView.do")
    public String addYpaymentView(
            @ModelAttribute("searchVO") YpaymentDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("ypaymentVO", new YpaymentVO());
        return "/ypayment/YpaymentRegister";
    }
    
    @RequestMapping("/ypayment/addYpayment.do")
    public String addYpayment(
            YpaymentVO ypaymentVO,
            @ModelAttribute("searchVO") YpaymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ypaymentService.insertYpayment(ypaymentVO);
        status.setComplete();
        return "forward:/ypayment/YpaymentList.do";
    }
    
    @RequestMapping("/ypayment/updateYpaymentView.do")
    public String updateYpaymentView(
            @RequestParam("pno") int pno ,
            @ModelAttribute("searchVO") YpaymentDefaultVO searchVO, Model model)
            throws Exception {
        YpaymentVO ypaymentVO = new YpaymentVO();
        ypaymentVO.setPno(pno);        
        // 변수명은 CoC 에 따라 ypaymentVO
        model.addAttribute(selectYpayment(ypaymentVO, searchVO));
        return "/ypayment/YpaymentRegister";
    }

    @RequestMapping("/ypayment/selectYpayment.do")
    public @ModelAttribute("ypaymentVO")
    YpaymentVO selectYpayment(
            YpaymentVO ypaymentVO,
            @ModelAttribute("searchVO") YpaymentDefaultVO searchVO) throws Exception {
        return ypaymentService.selectYpayment(ypaymentVO);
    }

    @RequestMapping("/ypayment/updateYpayment.do")
    public String updateYpayment(
            YpaymentVO ypaymentVO,
            @ModelAttribute("searchVO") YpaymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ypaymentService.updateYpayment(ypaymentVO);
        status.setComplete();
        return "forward:/ypayment/YpaymentList.do";
    }
    
    @RequestMapping("/ypayment/deleteYpayment.do")
    public String deleteYpayment(
            YpaymentVO ypaymentVO,
            @ModelAttribute("searchVO") YpaymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ypaymentService.deleteYpayment(ypaymentVO);
        status.setComplete();
        return "forward:/ypayment/YpaymentList.do";
    }

}
