package egovframework.ypayment.service;

import java.util.List;
import egovframework.ypayment.service.YpaymentDefaultVO;
import egovframework.ypayment.service.YpaymentVO;

/**
 * @Class Name : YpaymentService.java
 * @Description : Ypayment Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YpaymentService {
	
	/**
	 * ypayment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YpaymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYpayment(YpaymentVO vo) throws Exception;
    
    /**
	 * ypayment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YpaymentVO
	 * @return void형
	 * @exception Exception
	 */
    void updateYpayment(YpaymentVO vo) throws Exception;
    
    /**
	 * ypayment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YpaymentVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYpayment(YpaymentVO vo) throws Exception;
    
    /**
	 * ypayment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YpaymentVO
	 * @return 조회한 ypayment
	 * @exception Exception
	 */
    YpaymentVO selectYpayment(YpaymentVO vo) throws Exception;
    
    /**
	 * ypayment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ypayment 목록
	 * @exception Exception
	 */
    List selectYpaymentList(YpaymentDefaultVO searchVO) throws Exception;
    
    /**
	 * ypayment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ypayment 총 갯수
	 * @exception
	 */
    int selectYpaymentListTotCnt(YpaymentDefaultVO searchVO);
    
}
