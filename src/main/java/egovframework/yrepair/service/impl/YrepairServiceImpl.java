package egovframework.yrepair.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.yrepair.service.YrepairService;
import egovframework.yrepair.service.YrepairDefaultVO;
import egovframework.yrepair.service.YrepairVO;
import egovframework.yrepair.service.impl.YrepairMapper;
/**
 * @Class Name : YrepairServiceImpl.java
 * @Description : Yrepair Business Implement class
 * @Modification Information
 *
 * @author aa
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("yrepairService")
public class YrepairServiceImpl extends EgovAbstractServiceImpl implements
        YrepairService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YrepairServiceImpl.class);

    @Resource(name="yrepairMapper")
    private YrepairMapper yrepairDAO;
    
    //@Resource(name="yrepairDAO")
    //private YrepairDAO yrepairDAO;
    
    /** ID Generation */
    //@Resource(name="{egovYrepairIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * yrepair을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YrepairVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYrepair(YrepairVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	yrepairDAO.insertYrepair(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * yrepair을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YrepairVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYrepair(YrepairVO vo) throws Exception {
        yrepairDAO.updateYrepair(vo);
    }

    /**
	 * yrepair을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YrepairVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYrepair(YrepairVO vo) throws Exception {
        yrepairDAO.deleteYrepair(vo);
    }

    /**
	 * yrepair을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YrepairVO
	 * @return 조회한 yrepair
	 * @exception Exception
	 */
    public YrepairVO selectYrepair(YrepairVO vo) throws Exception {
        YrepairVO resultVO = yrepairDAO.selectYrepair(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * yrepair 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yrepair 목록
	 * @exception Exception
	 */
    public List<?> selectYrepairList(YrepairDefaultVO searchVO) throws Exception {
        return yrepairDAO.selectYrepairList(searchVO);
    }

    /**
	 * yrepair 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yrepair 총 갯수
	 * @exception
	 */
    public int selectYrepairListTotCnt(YrepairDefaultVO searchVO) {
		return yrepairDAO.selectYrepairListTotCnt(searchVO);
	}

	public void updateState(YrepairVO yrepairVO) throws Exception {
		yrepairDAO.updateState(yrepairVO);
		
	}
    
}
