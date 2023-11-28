package egovframework.payment.web;

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

import egovframework.payment.service.PaymentService;
import egovframework.payment.service.PaymentDefaultVO;
import egovframework.payment.service.PaymentVO;

/**
 * @Class Name : PaymentController.java
 * @Description : Payment Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=PaymentVO.class)
public class PaymentController {

    @Resource(name = "paymentService")
    private PaymentService paymentService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * payment 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 PaymentDefaultVO
	 * @return "/payment/PaymentList"
	 * @exception Exception
	 */
    @RequestMapping(value="/index.do")
    public String goIndex(@ModelAttribute("searchVO") PaymentDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
        return "/WEB-INF/views/gc/index";
    }
    
    
    @RequestMapping(value="/payment/PaymentList.do")
    public String selectPaymentList(@ModelAttribute("searchVO") PaymentDefaultVO searchVO, 
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
		
        List<?> paymentList = paymentService.selectPaymentList(searchVO);
        model.addAttribute("resultList", paymentList);
        
        int totCnt = paymentService.selectPaymentListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/payment/PaymentList";
    } 
    
    @RequestMapping("/payment/addPaymentView.do")
    public String addPaymentView(
            @ModelAttribute("searchVO") PaymentDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("paymentVO", new PaymentVO());
        return "/payment/PaymentRegister";
    }
    
    @RequestMapping("/payment/addPayment.do")
    public String addPayment(
            PaymentVO paymentVO,
            @ModelAttribute("searchVO") PaymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        paymentService.insertPayment(paymentVO);
        status.setComplete();
        return "forward:/main.do";
    }
    
    @RequestMapping("/payment/updatePaymentView.do")
    public String updatePaymentView(
            @RequestParam("pno") int pno ,
            @ModelAttribute("searchVO") PaymentDefaultVO searchVO, Model model)
            throws Exception {
        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setPno(pno);        
        // 변수명은 CoC 에 따라 paymentVO
        model.addAttribute(selectPayment(paymentVO, searchVO));
        return "/payment/PaymentRegister";
    }

    @RequestMapping("/payment/selectPayment.do")
    public @ModelAttribute("paymentVO")
    PaymentVO selectPayment(
            PaymentVO paymentVO,
            @ModelAttribute("searchVO") PaymentDefaultVO searchVO) throws Exception {
        return paymentService.selectPayment(paymentVO);
    }

    @RequestMapping("/payment/updatePayment.do")
    public String updatePayment(
            PaymentVO paymentVO,
            @ModelAttribute("searchVO") PaymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        paymentService.updatePayment(paymentVO);
        status.setComplete();
        return "forward:/payment/PaymentList.do";
    }
    
    @RequestMapping("/payment/deletePayment.do")
    public String deletePayment(
            PaymentVO paymentVO,
            @ModelAttribute("searchVO") PaymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        paymentService.deletePayment(paymentVO);
        status.setComplete();
        return "forward:/payment/PaymentList.do";
    }

}
