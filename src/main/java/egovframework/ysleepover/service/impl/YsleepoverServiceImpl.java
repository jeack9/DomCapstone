package egovframework.ysleepover.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.ysleepover.service.YsleepoverService;
import egovframework.ysleepover.service.YsleepoverDefaultVO;
import egovframework.ysleepover.service.YsleepoverVO;
import egovframework.ysleepover.service.impl.YsleepoverMapper;
/**
 * @Class Name : YsleepoverServiceImpl.java
 * @Description : Ysleepover Business Implement class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("ysleepoverService")
public class YsleepoverServiceImpl extends EgovAbstractServiceImpl implements
        YsleepoverService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YsleepoverServiceImpl.class);

    @Resource(name="ysleepoverMapper")
    private YsleepoverMapper ysleepoverDAO;
    
    //@Resource(name="ysleepoverDAO")
    //private YsleepoverDAO ysleepoverDAO;
    
    /** ID Generation */
    //@Resource(name="{egovYsleepoverIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * ysleepover을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YsleepoverVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYsleepover(YsleepoverVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	ysleepoverDAO.insertYsleepover(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * ysleepover을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YsleepoverVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYsleepover(YsleepoverVO vo) throws Exception {
        ysleepoverDAO.updateYsleepover(vo);
    }

    /**
	 * ysleepover을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YsleepoverVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYsleepover(YsleepoverVO vo) throws Exception {
        ysleepoverDAO.deleteYsleepover(vo);
    }

    /**
	 * ysleepover을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YsleepoverVO
	 * @return 조회한 ysleepover
	 * @exception Exception
	 */
    public YsleepoverVO selectYsleepover(YsleepoverVO vo) throws Exception {
        YsleepoverVO resultVO = ysleepoverDAO.selectYsleepover(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * ysleepover 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ysleepover 목록
	 * @exception Exception
	 */
    public List<?> selectYsleepoverList(YsleepoverDefaultVO searchVO) throws Exception {
        return ysleepoverDAO.selectYsleepoverList(searchVO);
    }
    
    public List<?> selectYsleepoverListJson(){
    	return ysleepoverDAO.selectYsleepoverListJson();
    }

    /**
	 * ysleepover 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ysleepover 총 갯수
	 * @exception
	 */
    public int selectYsleepoverListTotCnt(YsleepoverDefaultVO searchVO) {
		return ysleepoverDAO.selectYsleepoverListTotCnt(searchVO);
	}
    
    public List<?> todayAbsentStudent(){
    	return ysleepoverDAO.todayAbsentStudent();
    }
    
    
}
