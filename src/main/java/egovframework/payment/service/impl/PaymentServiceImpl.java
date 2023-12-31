package egovframework.payment.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.payment.service.PaymentService;
import egovframework.payment.service.PaymentDefaultVO;
import egovframework.payment.service.PaymentVO;
import egovframework.payment.service.impl.PaymentMapper;
/**
 * @Class Name : PaymentServiceImpl.java
 * @Description : Payment Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("paymentService")
public class PaymentServiceImpl extends EgovAbstractServiceImpl implements
        PaymentService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Resource(name="paymentMapper")
    private PaymentMapper paymentDAO;
    
    //@Resource(name="paymentDAO")
    //private PaymentDAO paymentDAO;
    
    /** ID Generation */
    //@Resource(name="{egovPaymentIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * payment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PaymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPayment(PaymentVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	paymentDAO.insertPayment(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * payment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PaymentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayment(PaymentVO vo) throws Exception {
        paymentDAO.updatePayment(vo);
    }

    /**
	 * payment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PaymentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePayment(PaymentVO vo) throws Exception {
        paymentDAO.deletePayment(vo);
    }

    /**
	 * payment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PaymentVO
	 * @return 조회한 payment
	 * @exception Exception
	 */
    public PaymentVO selectPayment(PaymentVO vo) throws Exception {
        PaymentVO resultVO = paymentDAO.selectPayment(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * payment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return payment 목록
	 * @exception Exception
	 */
    public List<?> selectPaymentList(PaymentDefaultVO searchVO) throws Exception {
        return paymentDAO.selectPaymentList(searchVO);
    }

    /**
	 * payment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return payment 총 갯수
	 * @exception
	 */
    public int selectPaymentListTotCnt(PaymentDefaultVO searchVO) {
		return paymentDAO.selectPaymentListTotCnt(searchVO);
	}
    
}
