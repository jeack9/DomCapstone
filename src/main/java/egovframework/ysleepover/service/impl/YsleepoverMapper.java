package egovframework.ysleepover.service.impl;

import java.util.List;

import egovframework.ysleepover.service.YsleepoverVO;
import egovframework.ysleepover.service.YsleepoverDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : YsleepoverMapper.java
 * @Description : Ysleepover Mapper Class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("ysleepoverMapper")
public interface YsleepoverMapper {

	/**
	 * ysleepover을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YsleepoverVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertYsleepover(YsleepoverVO vo) throws Exception;

    /**
	 * ysleepover을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YsleepoverVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYsleepover(YsleepoverVO vo) throws Exception;

    /**
	 * ysleepover을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YsleepoverVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYsleepover(YsleepoverVO vo) throws Exception;

    /**
	 * ysleepover을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YsleepoverVO
	 * @return 조회한 ysleepover
	 * @exception Exception
	 */
    public YsleepoverVO selectYsleepover(YsleepoverVO vo) throws Exception;

    /**
	 * ysleepover 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ysleepover 목록
	 * @exception Exception
	 */
    public List<?> selectYsleepoverList(YsleepoverDefaultVO searchVO) throws Exception;

    /**
	 * ysleepover 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ysleepover 총 갯수
	 * @exception
	 */
    public int selectYsleepoverListTotCnt(YsleepoverDefaultVO searchVO);

	public List<?> selectYsleepoverListJson();

	public List<?> todayAbsentStudent();

}
