package egovframework.testuser.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.testuser.service.TestuserService;
import egovframework.testuser.service.TestuserDefaultVO;
import egovframework.testuser.service.TestuserVO;
import egovframework.testuser.service.impl.TestuserMapper;
/**
 * @Class Name : TestuserServiceImpl.java
 * @Description : Testuser Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("testuserService")
public class TestuserServiceImpl extends EgovAbstractServiceImpl implements
        TestuserService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(TestuserServiceImpl.class);

    @Resource(name="testuserMapper")
    private TestuserMapper testuserDAO;
    
    //@Resource(name="testuserDAO")
    //private TestuserDAO testuserDAO;
    
    /** ID Generation */
    //@Resource(name="{egovTestuserIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * testuser을 등록한다.
	 * @param vo - 등록할 정보가 담긴 TestuserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertTestuser(TestuserVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	testuserDAO.insertTestuser(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * testuser을 수정한다.
	 * @param vo - 수정할 정보가 담긴 TestuserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateTestuser(TestuserVO vo) throws Exception {
        testuserDAO.updateTestuser(vo);
    }

    /**
	 * testuser을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 TestuserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteTestuser(TestuserVO vo) throws Exception {
        testuserDAO.deleteTestuser(vo);
    }

    /**
	 * testuser을 조회한다.
	 * @param vo - 조회할 정보가 담긴 TestuserVO
	 * @return 조회한 testuser
	 * @exception Exception
	 */
    public TestuserVO selectTestuser(TestuserVO vo) throws Exception {
        TestuserVO resultVO = testuserDAO.selectTestuser(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * testuser 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return testuser 목록
	 * @exception Exception
	 */
    public List<?> selectTestuserList(TestuserDefaultVO searchVO) throws Exception {
        return testuserDAO.selectTestuserList(searchVO);
    }

    /**
	 * testuser 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return testuser 총 갯수
	 * @exception
	 */
    public int selectTestuserListTotCnt(TestuserDefaultVO searchVO) {
		return testuserDAO.selectTestuserListTotCnt(searchVO);
	}

	@Override
	public TestuserVO checkUserLogin(TestuserVO userVO) {
		return testuserDAO.checkUserLogin(userVO);
	}
    
}
