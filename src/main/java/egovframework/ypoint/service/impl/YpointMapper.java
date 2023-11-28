package egovframework.ypoint.service.impl;

import java.util.List;

import egovframework.ypoint.service.YpointVO;
import egovframework.ypoint.service.YpointDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : YpointMapper.java
 * @Description : Ypoint Mapper Class
 * @Modification Information
 *
 * @author capstone
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("ypointMapper")
public interface YpointMapper {

	/**
	 * ypoint을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YpointVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertYpoint(YpointVO vo) throws Exception;

    /**
	 * ypoint을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YpointVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYpoint(YpointVO vo) throws Exception;

    /**
	 * ypoint을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YpointVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYpoint(YpointVO vo) throws Exception;

    /**
	 * ypoint을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YpointVO
	 * @return 조회한 ypoint
	 * @exception Exception
	 */
    public YpointVO selectYpoint(YpointVO vo) throws Exception;

    /**
	 * ypoint 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ypoint 목록
	 * @exception Exception
	 */
    public List<?> selectYpointList(YpointDefaultVO searchVO) throws Exception;

    /**
	 * ypoint 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ypoint 총 갯수
	 * @exception
	 */
    public int selectYpointListTotCnt(YpointDefaultVO searchVO);

	public int selectPointSum(YpointVO ypointVO);

}
