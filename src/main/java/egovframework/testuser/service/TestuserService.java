package egovframework.testuser.service;

import java.util.List;

import egovframework.testuser.service.TestuserDefaultVO;
import egovframework.testuser.service.TestuserVO;

/**
 * @Class Name : TestuserService.java
 * @Description : Testuser Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface TestuserService {
	
	/**
	 * testuser을 등록한다.
	 * @param vo - 등록할 정보가 담긴 TestuserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertTestuser(TestuserVO vo) throws Exception;
    
    /**
	 * testuser을 수정한다.
	 * @param vo - 수정할 정보가 담긴 TestuserVO
	 * @return void형
	 * @exception Exception
	 */
    void updateTestuser(TestuserVO vo) throws Exception;
    
    /**
	 * testuser을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 TestuserVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteTestuser(TestuserVO vo) throws Exception;
    
    /**
	 * testuser을 조회한다.
	 * @param vo - 조회할 정보가 담긴 TestuserVO
	 * @return 조회한 testuser
	 * @exception Exception
	 */
    TestuserVO selectTestuser(TestuserVO vo) throws Exception;
    
    /**
	 * testuser 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return testuser 목록
	 * @exception Exception
	 */
    List selectTestuserList(TestuserDefaultVO searchVO) throws Exception;
    
    /**
	 * testuser 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return testuser 총 갯수
	 * @exception
	 */
    int selectTestuserListTotCnt(TestuserDefaultVO searchVO);
    
    TestuserVO checkUserLogin(TestuserVO userVO);
}
