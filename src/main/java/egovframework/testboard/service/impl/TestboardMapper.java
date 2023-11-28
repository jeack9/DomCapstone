package egovframework.testboard.service.impl;

import java.util.List;

import egovframework.testboard.service.TestboardVO;
import egovframework.testboard.service.TestboardDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : TestboardMapper.java
 * @Description : Testboard Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-25
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("testboardMapper")
public interface TestboardMapper {

	/**
	 * testboard을 등록한다.
	 * @param vo - 등록할 정보가 담긴 TestboardVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertTestboard(TestboardVO vo) throws Exception;

    /**
	 * testboard을 수정한다.
	 * @param vo - 수정할 정보가 담긴 TestboardVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateTestboard(TestboardVO vo) throws Exception;

    /**
	 * testboard을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 TestboardVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteTestboard(TestboardVO vo) throws Exception;

    /**
	 * testboard을 조회한다.
	 * @param vo - 조회할 정보가 담긴 TestboardVO
	 * @return 조회한 testboard
	 * @exception Exception
	 */
    public TestboardVO selectTestboard(TestboardVO vo) throws Exception;

    /**
	 * testboard 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return testboard 목록
	 * @exception Exception
	 */
    public List<?> selectTestboardList(TestboardDefaultVO searchVO) throws Exception;

    /**
	 * testboard 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return testboard 총 갯수
	 * @exception
	 */
    public int selectTestboardListTotCnt(TestboardDefaultVO searchVO);

	public List<?> selectBoardTopList(TestboardDefaultVO searchVO) throws Exception; 
	
	public void updateBoardLikes(TestboardVO vo) throws Exception;
}
