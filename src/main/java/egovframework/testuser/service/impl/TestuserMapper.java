package egovframework.testuser.service.impl;

import java.util.List;

import egovframework.testuser.service.TestuserVO;
import egovframework.testuser.service.TestuserDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : TestuserMapper.java
 * @Description : Testuser Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("testuserMapper")
public interface TestuserMapper {

	/**
	 * testuser을 등록한다.
	 * @param vo - 등록할 정보가 담긴 TestuserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertTestuser(TestuserVO vo) throws Exception;

    /**
	 * testuser을 수정한다.
	 * @param vo - 수정할 정보가 담긴 TestuserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateTestuser(TestuserVO vo) throws Exception;

    /**
	 * testuser을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 TestuserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteTestuser(TestuserVO vo) throws Exception;

    /**
	 * testuser을 조회한다.
	 * @param vo - 조회할 정보가 담긴 TestuserVO
	 * @return 조회한 testuser
	 * @exception Exception
	 */
    public TestuserVO selectTestuser(TestuserVO vo) throws Exception;

    /**
	 * testuser 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return testuser 목록
	 * @exception Exception
	 */
    public List<?> selectTestuserList(TestuserDefaultVO searchVO) throws Exception;

    /**
	 * testuser 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return testuser 총 갯수
	 * @exception
	 */
    public int selectTestuserListTotCnt(TestuserDefaultVO searchVO);

	public TestuserVO checkUserLogin(TestuserVO userVO);

}
