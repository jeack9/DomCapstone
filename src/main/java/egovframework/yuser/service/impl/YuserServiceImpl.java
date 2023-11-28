package egovframework.yuser.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.yuser.service.YuserService;
import egovframework.yuser.service.YuserDefaultVO;
import egovframework.yuser.service.YuserVO;
import egovframework.yuser.service.impl.YuserMapper;
/**
 * @Class Name : YuserServiceImpl.java
 * @Description : Yuser Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("yuserService")
public class YuserServiceImpl extends EgovAbstractServiceImpl implements
        YuserService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YuserServiceImpl.class);

    @Resource(name="yuserMapper")
    private YuserMapper yuserDAO;
    
    //@Resource(name="yuserDAO")
    //private YuserDAO yuserDAO;
    
    /** ID Generation */
    //@Resource(name="{egovYuserIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * yuser을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YuserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYuser(YuserVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	yuserDAO.insertYuser(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * yuser을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YuserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYuser(YuserVO vo) throws Exception {
        yuserDAO.updateYuser(vo);
    }

    /**
	 * yuser을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YuserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYuser(YuserVO vo) throws Exception {
        yuserDAO.deleteYuser(vo);
    }

    /**
	 * yuser을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YuserVO
	 * @return 조회한 yuser
	 * @exception Exception
	 */
    public YuserVO selectYuser(YuserVO vo) throws Exception {
        YuserVO resultVO = yuserDAO.selectYuser(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
	public YuserVO selectYuser(String vo) throws Exception {
		// TODO Auto-generated method stub
		YuserVO resultVO = yuserDAO.selectYuser(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
	}

    /**
	 * yuser 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yuser 목록
	 * @exception Exception
	 */
    public List<?> selectYuserList(YuserDefaultVO searchVO) throws Exception {
        return yuserDAO.selectYuserList(searchVO);
    }

    /**
	 * yuser 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yuser 총 갯수
	 * @exception
	 */
    public int selectYuserListTotCnt(YuserDefaultVO searchVO) {
		return yuserDAO.selectYuserListTotCnt(searchVO);
	}

	@Override
	public YuserVO checkUserLogin(YuserVO userVO) {		
		return yuserDAO.checkUserLogin(userVO);
	}

	@Override
	public void updateUserpoint(YuserVO yuserVO) {
		yuserDAO.updateUserpoint(yuserVO);
		
	}

	@Override
	public void editProfileImage(YuserVO currentUser) {
		yuserDAO.editProfileImage(currentUser);
	}
    
	@Override
	public int findYuserPw(YuserVO userVO) {
		return yuserDAO.findYuserPw(userVO);
	}
	
	public void updateYuserPw(YuserVO userVO) throws Exception {
        yuserDAO.updateYuserPw(userVO);
    }
	public void updateYuserRoom(YuserVO userVO) throws Exception {
        yuserDAO.updateYuserRoom(userVO);
    }

	
	
	
}
