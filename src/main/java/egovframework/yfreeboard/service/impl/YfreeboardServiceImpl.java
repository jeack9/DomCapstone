package egovframework.yfreeboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.yfreeboard.service.YfreeboardService;
import egovframework.yfreeboard.service.YfreeboardDefaultVO;
import egovframework.yfreeboard.service.YfreeboardVO;
import egovframework.yfreeboard.service.impl.YfreeboardMapper;
/**
 * @Class Name : YfreeboardServiceImpl.java
 * @Description : Yfreeboard Business Implement class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("yfreeboardService")
public class YfreeboardServiceImpl extends EgovAbstractServiceImpl implements
        YfreeboardService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YfreeboardServiceImpl.class);

    @Resource(name="yfreeboardMapper")
    private YfreeboardMapper yfreeboardDAO;
    
    //@Resource(name="yfreeboardDAO")
    //private YfreeboardDAO yfreeboardDAO;
    
    /** ID Generation */
    //@Resource(name="{egovYfreeboardIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * yfreeboard을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YfreeboardVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYfreeboard(YfreeboardVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	yfreeboardDAO.insertYfreeboard(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * yfreeboard을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YfreeboardVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYfreeboard(YfreeboardVO vo) throws Exception {
        yfreeboardDAO.updateYfreeboard(vo);
    }

    /**
	 * yfreeboard을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YfreeboardVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYfreeboard(YfreeboardVO vo) throws Exception {
        yfreeboardDAO.deleteYfreeboard(vo);
    }

    /**
	 * yfreeboard을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YfreeboardVO
	 * @return 조회한 yfreeboard
	 * @exception Exception
	 */
    public YfreeboardVO selectYfreeboard(YfreeboardVO vo) throws Exception {
        YfreeboardVO resultVO = yfreeboardDAO.selectYfreeboard(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * yfreeboard 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yfreeboard 목록
	 * @exception Exception
	 */
    public List<?> selectYfreeboardList(YfreeboardDefaultVO searchVO) throws Exception {
        return yfreeboardDAO.selectYfreeboardList(searchVO);
    }

    /**
	 * yfreeboard 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yfreeboard 총 갯수
	 * @exception
	 */
    public int selectYfreeboardListTotCnt(YfreeboardDefaultVO searchVO) {
		return yfreeboardDAO.selectYfreeboardListTotCnt(searchVO);
	}

	public List<?> selectMostLike() {
		return yfreeboardDAO.selectMostLike();
		
	}
	
	public void updateVisitors(YfreeboardVO vo) {
		yfreeboardDAO.updateVisitors(vo);
	}

	@Override
	public void increaseYLikes(YfreeboardVO vo) throws Exception {
		yfreeboardDAO.increaseYLikes(vo);
		
	}

	@Override
	public void decreaseYLikes(YfreeboardVO vo) throws Exception {
		yfreeboardDAO.decreaseYLikes(vo);
		
	}
    
}
