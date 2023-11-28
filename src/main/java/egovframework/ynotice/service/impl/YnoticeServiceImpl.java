package egovframework.ynotice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.ynotice.service.YnoticeService;
import egovframework.ynotice.service.YnoticeDefaultVO;
import egovframework.ynotice.service.YnoticeVO;
import egovframework.ynotice.service.impl.YnoticeMapper;
/**
 * @Class Name : YnoticeServiceImpl.java
 * @Description : Ynotice Business Implement class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-06-06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("ynoticeService")
public class YnoticeServiceImpl extends EgovAbstractServiceImpl implements
        YnoticeService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YnoticeServiceImpl.class);

    @Resource(name="ynoticeMapper")
    private YnoticeMapper ynoticeDAO;
    
    //@Resource(name="ynoticeDAO")
    //private YnoticeDAO ynoticeDAO;
    
    /** ID Generation */
    //@Resource(name="{egovYnoticeIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * ynotice을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YnoticeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYnotice(YnoticeVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	ynoticeDAO.insertYnotice(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * ynotice을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YnoticeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYnotice(YnoticeVO vo) throws Exception {
        ynoticeDAO.updateYnotice(vo);
    }

    /**
	 * ynotice을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YnoticeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYnotice(YnoticeVO vo) throws Exception {
        ynoticeDAO.deleteYnotice(vo);
    }

    /**
	 * ynotice을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YnoticeVO
	 * @return 조회한 ynotice
	 * @exception Exception
	 */
    public YnoticeVO selectYnotice(YnoticeVO vo) throws Exception {
        YnoticeVO resultVO = ynoticeDAO.selectYnotice(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * ynotice 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ynotice 목록
	 * @exception Exception
	 */
    public List<?> selectYnoticeList(YnoticeDefaultVO searchVO) throws Exception {
        return ynoticeDAO.selectYnoticeList(searchVO);
    }

    /**
	 * ynotice 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ynotice 총 갯수
	 * @exception
	 */
    public int selectYnoticeListTotCnt(YnoticeDefaultVO searchVO) {
		return ynoticeDAO.selectYnoticeListTotCnt(searchVO);
	}
    
    public void updateVisitor(YnoticeVO vo) {
    	ynoticeDAO.updateVisitor(vo);
    }
    
}
