package egovframework.testboard.service;

import java.util.List;
import egovframework.testboard.service.TestboardDefaultVO;
import egovframework.testboard.service.TestboardVO;

/**
 * @Class Name : TestboardService.java
 * @Description : Testboard Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-25
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface TestboardService {
	
	/**
	 * testboard을 등록한다.
	 * @param vo - 등록할 정보가 담긴 TestboardVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertTestboard(TestboardVO vo) throws Exception;
    
    /**
	 * testboard을 수정한다.
	 * @param vo - 수정할 정보가 담긴 TestboardVO
	 * @return void형
	 * @exception Exception
	 */
    void updateTestboard(TestboardVO vo) throws Exception;
    
    /**
	 * testboard을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 TestboardVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteTestboard(TestboardVO vo) throws Exception;
    
    /**
	 * testboard을 조회한다.
	 * @param vo - 조회할 정보가 담긴 TestboardVO
	 * @return 조회한 testboard
	 * @exception Exception
	 */
    TestboardVO selectTestboard(TestboardVO vo) throws Exception;
    
    /**
	 * testboard 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return testboard 목록
	 * @exception Exception
	 */
    List selectTestboardList(TestboardDefaultVO searchVO) throws Exception;
    
    /**
	 * testboard 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return testboard 총 갯수
	 * @exception
	 */
    int selectTestboardListTotCnt(TestboardDefaultVO searchVO);
    
    List selectBoardTopList(TestboardDefaultVO searchVO) throws Exception;
    
    void updateBoardLikes(TestboardVO vo) throws Exception;
}

