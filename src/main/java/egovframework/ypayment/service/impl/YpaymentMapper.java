package egovframework.ypayment.service.impl;

import java.util.List;

import egovframework.ypayment.service.YpaymentVO;
import egovframework.ypayment.service.YpaymentDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : YpaymentMapper.java
 * @Description : Ypayment Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("ypaymentMapper")
public interface YpaymentMapper {

	/**
	 * ypayment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YpaymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertYpayment(YpaymentVO vo) throws Exception;

    /**
	 * ypayment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YpaymentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYpayment(YpaymentVO vo) throws Exception;

    /**
	 * ypayment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YpaymentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYpayment(YpaymentVO vo) throws Exception;

    /**
	 * ypayment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YpaymentVO
	 * @return 조회한 ypayment
	 * @exception Exception
	 */
    public YpaymentVO selectYpayment(YpaymentVO vo) throws Exception;

    /**
	 * ypayment 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ypayment 목록
	 * @exception Exception
	 */
    public List<?> selectYpaymentList(YpaymentDefaultVO searchVO) throws Exception;

    /**
	 * ypayment 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ypayment 총 갯수
	 * @exception
	 */
    public int selectYpaymentListTotCnt(YpaymentDefaultVO searchVO);

}
