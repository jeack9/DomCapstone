package egovframework.ycomment.service.impl;

import java.util.List;

import egovframework.ycomment.service.YcommentVO;
import egovframework.ycomment.service.YcommentDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : YcommentMapper.java
 * @Description : Ycomment Mapper Class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("ycommentMapper")
public interface YcommentMapper {

	/**
	 * ycomment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YcommentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertYcomment(YcommentVO vo) throws Exception;

    /**
	 * ycomment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YcommentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYcomment(YcommentVO vo) throws Exception;

    /**
	 * ycomment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YcommentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYcomment(YcommentVO vo) throws Exception;

    /**
	 * ycomment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YcommentVO
	 * @return 조회한 ycomment
	 * @exception Exception
	 */
    public YcommentVO selectYcomment(YcommentVO vo) throws Exception;

    /**
	 * ycomment 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ycomment 목록
	 * @exception Exception
	 */
    public List<?> selectYcommentList(YcommentDefaultVO searchVO) throws Exception;

    /**
	 * ycomment 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ycomment 총 갯수
	 * @exception
	 */
    public int selectYcommentListTotCnt(YcommentDefaultVO searchVO);
    
    public void insertReply(YcommentVO vo);

	public void updateIsRemoveOne(YcommentVO ycommentVO);

}
