package egovframework.ylikes.service.impl;

import java.util.List;

import egovframework.ylikes.service.YlikesVO;
import egovframework.ylikes.service.YlikesDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : YlikesMapper.java
 * @Description : Ylikes Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("ylikesMapper")
public interface YlikesMapper {

	/**
	 * ylikes을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YlikesVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertYlikes(YlikesVO vo) throws Exception;

    /**
	 * ylikes을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YlikesVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYlikes(YlikesVO vo) throws Exception;

    /**
	 * ylikes을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YlikesVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYlikes(YlikesVO vo) throws Exception;

    /**
	 * ylikes을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YlikesVO
	 * @return 조회한 ylikes
	 * @exception Exception
	 */
    public YlikesVO selectYlikes(YlikesVO vo) throws Exception;

    /**
	 * ylikes 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ylikes 목록
	 * @exception Exception
	 */
    public List<?> selectYlikesList(YlikesDefaultVO searchVO) throws Exception;

    /**
	 * ylikes 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ylikes 총 갯수
	 * @exception
	 */
    public int selectYlikesListTotCnt(YlikesDefaultVO searchVO);

}
