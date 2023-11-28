package egovframework.payment.service;

import java.util.List;
import egovframework.payment.service.PaymentDefaultVO;
import egovframework.payment.service.PaymentVO;

/**
 * @Class Name : PaymentService.java
 * @Description : Payment Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PaymentService {
	
	/**
	 * payment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PaymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertPayment(PaymentVO vo) throws Exception;
    
    /**
	 * payment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PaymentVO
	 * @return void형
	 * @exception Exception
	 */
    void updatePayment(PaymentVO vo) throws Exception;
    
    /**
	 * payment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PaymentVO
	 * @return void형 
	 * @exception Exception
	 */
    void deletePayment(PaymentVO vo) throws Exception;
    
    /**
	 * payment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PaymentVO
	 * @return 조회한 payment
	 * @exception Exception
	 */
    PaymentVO selectPayment(PaymentVO vo) throws Exception;
    
    /**
	 * payment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return payment 목록
	 * @exception Exception
	 */
    List selectPaymentList(PaymentDefaultVO searchVO) throws Exception;
    
    /**
	 * payment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return payment 총 갯수
	 * @exception
	 */
    int selectPaymentListTotCnt(PaymentDefaultVO searchVO);
    
}
