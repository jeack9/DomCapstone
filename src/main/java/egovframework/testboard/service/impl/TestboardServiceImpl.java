package egovframework.testboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.testboard.service.TestboardService;
import egovframework.testboard.service.TestboardDefaultVO;
import egovframework.testboard.service.TestboardVO;
import egovframework.testboard.service.impl.TestboardMapper;
/**
 * @Class Name : TestboardServiceImpl.java
 * @Description : Testboard Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-25
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("testboardService")
public class TestboardServiceImpl extends EgovAbstractServiceImpl implements
        TestboardService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(TestboardServiceImpl.class);

    @Resource(name="testboardMapper")
    private TestboardMapper testboardDAO;
    
    //@Resource(name="testboardDAO")
    //private TestboardDAO testboardDAO;
    
    /** ID Generation */
    //@Resource(name="{egovTestboardIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * testboard을 등록한다.
	 * @param vo - 등록할 정보가 담긴 TestboardVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertTestboard(TestboardVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	testboardDAO.insertTestboard(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * testboard을 수정한다.
	 * @param vo - 수정할 정보가 담긴 TestboardVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateTestboard(TestboardVO vo) throws Exception {
        testboardDAO.updateTestboard(vo);
    }

    /**
	 * testboard을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 TestboardVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteTestboard(TestboardVO vo) throws Exception {
        testboardDAO.deleteTestboard(vo);
    }

    /**
	 * testboard을 조회한다.
	 * @param vo - 조회할 정보가 담긴 TestboardVO
	 * @return 조회한 testboard
	 * @exception Exception
	 */
    public TestboardVO selectTestboard(TestboardVO vo) throws Exception {
        TestboardVO resultVO = testboardDAO.selectTestboard(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * testboard 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return testboard 목록
	 * @exception Exception
	 */
    public List<?> selectTestboardList(TestboardDefaultVO searchVO) throws Exception {
        return testboardDAO.selectTestboardList(searchVO);
    }

    /**
	 * testboard 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return testboard 총 갯수
	 * @exception
	 */
    public int selectTestboardListTotCnt(TestboardDefaultVO searchVO) {
		return testboardDAO.selectTestboardListTotCnt(searchVO);
	}

	@Override
	public List<?> selectBoardTopList(TestboardDefaultVO searchVO) throws Exception {
		// TODO Auto-generated method stub
		return testboardDAO.selectBoardTopList(searchVO);
	}
	
	public void updateBoardLikes(TestboardVO vo) throws Exception {
        testboardDAO.updateBoardLikes(vo);
    }
    
}
