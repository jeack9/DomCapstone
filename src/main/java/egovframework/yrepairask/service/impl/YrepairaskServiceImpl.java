package egovframework.yrepairask.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.yrepairask.service.YrepairaskService;
import egovframework.yrepairask.service.YrepairaskDefaultVO;
import egovframework.yrepairask.service.YrepairaskVO;
import egovframework.yrepairask.service.impl.YrepairaskMapper;
/**
 * @Class Name : YrepairaskServiceImpl.java
 * @Description : Yrepairask Business Implement class
 * @Modification Information
 *
 * @author aa
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("yrepairaskService")
public class YrepairaskServiceImpl extends EgovAbstractServiceImpl implements
        YrepairaskService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YrepairaskServiceImpl.class);

    @Resource(name="yrepairaskMapper")
    private YrepairaskMapper yrepairaskDAO;
    
    //@Resource(name="yrepairaskDAO")
    //private YrepairaskDAO yrepairaskDAO;
    
    /** ID Generation */
    //@Resource(name="{egovYrepairaskIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * yrepairask을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YrepairaskVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYrepairask(YrepairaskVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	yrepairaskDAO.insertYrepairask(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * yrepairask을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YrepairaskVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYrepairask(YrepairaskVO vo) throws Exception {
        yrepairaskDAO.updateYrepairask(vo);
    }

    /**
	 * yrepairask을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YrepairaskVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYrepairask(YrepairaskVO vo) throws Exception {
        yrepairaskDAO.deleteYrepairask(vo);
    }

    /**
	 * yrepairask을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YrepairaskVO
	 * @return 조회한 yrepairask
	 * @exception Exception
	 */
    public YrepairaskVO selectYrepairask(YrepairaskVO vo) throws Exception {
        YrepairaskVO resultVO = yrepairaskDAO.selectYrepairask(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * yrepairask 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yrepairask 목록
	 * @exception Exception
	 */
    public List<?> selectYrepairaskList(YrepairaskDefaultVO searchVO) throws Exception {
        return yrepairaskDAO.selectYrepairaskList(searchVO);
    }

    /**
	 * yrepairask 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yrepairask 총 갯수
	 * @exception
	 */
    public int selectYrepairaskListTotCnt(YrepairaskDefaultVO searchVO) {
		return yrepairaskDAO.selectYrepairaskListTotCnt(searchVO);
	}
    
}
