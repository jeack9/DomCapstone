package egovframework.ycomment.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.ycomment.service.YcommentService;
import egovframework.ycomment.service.YcommentDefaultVO;
import egovframework.ycomment.service.YcommentVO;
import egovframework.ycomment.service.impl.YcommentMapper;
/**
 * @Class Name : YcommentServiceImpl.java
 * @Description : Ycomment Business Implement class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("ycommentService")
public class YcommentServiceImpl extends EgovAbstractServiceImpl implements
        YcommentService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YcommentServiceImpl.class);

    @Resource(name="ycommentMapper")
    private YcommentMapper ycommentDAO;
    
    //@Resource(name="ycommentDAO")
    //private YcommentDAO ycommentDAO;
    
    /** ID Generation */
    //@Resource(name="{egovYcommentIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * ycomment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YcommentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYcomment(YcommentVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	ycommentDAO.insertYcomment(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * ycomment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YcommentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYcomment(YcommentVO vo) throws Exception {
        ycommentDAO.updateYcomment(vo);
    }

    /**
	 * ycomment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YcommentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYcomment(YcommentVO vo) throws Exception {
        ycommentDAO.deleteYcomment(vo);
    }

    /**
	 * ycomment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YcommentVO
	 * @return 조회한 ycomment
	 * @exception Exception
	 */
    public YcommentVO selectYcomment(YcommentVO vo) throws Exception {
        YcommentVO resultVO = ycommentDAO.selectYcomment(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * ycomment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ycomment 목록
	 * @exception Exception
	 */
    public List<?> selectYcommentList(YcommentDefaultVO searchVO) throws Exception {
        return ycommentDAO.selectYcommentList(searchVO);
    }

    /**
	 * ycomment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ycomment 총 갯수
	 * @exception
	 */
    public int selectYcommentListTotCnt(YcommentDefaultVO searchVO) {
		return ycommentDAO.selectYcommentListTotCnt(searchVO);
	}


	public void insertReply(YcommentVO ycommentVO) {
		 ycommentDAO.insertReply(ycommentVO);
	}

	public void updateIsRemoveOne(YcommentVO ycommentVO) {
		ycommentDAO.updateIsRemoveOne(ycommentVO);
		// TODO Auto-generated method stub
		
	}
    
}
