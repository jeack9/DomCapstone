package egovframework.ypoint.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.ypoint.service.YpointService;
import egovframework.ypoint.service.YpointDefaultVO;
import egovframework.ypoint.service.YpointVO;
import egovframework.ypoint.service.impl.YpointMapper;
/**
 * @Class Name : YpointServiceImpl.java
 * @Description : Ypoint Business Implement class
 * @Modification Information
 *
 * @author capstone
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("ypointService")
public class YpointServiceImpl extends EgovAbstractServiceImpl implements
        YpointService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YpointServiceImpl.class);

    @Resource(name="ypointMapper")
    private YpointMapper ypointDAO;
    
    //@Resource(name="ypointDAO")
    //private YpointDAO ypointDAO;
    
    /** ID Generation */
    //@Resource(name="{egovYpointIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * ypoint을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YpointVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYpoint(YpointVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	ypointDAO.insertYpoint(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * ypoint을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YpointVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYpoint(YpointVO vo) throws Exception {
        ypointDAO.updateYpoint(vo);
    }

    /**
	 * ypoint을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YpointVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYpoint(YpointVO vo) throws Exception {
        ypointDAO.deleteYpoint(vo);
    }

    /**
	 * ypoint을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YpointVO
	 * @return 조회한 ypoint
	 * @exception Exception
	 */
    public YpointVO selectYpoint(YpointVO vo) throws Exception {
        YpointVO resultVO = ypointDAO.selectYpoint(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * ypoint 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ypoint 목록
	 * @exception Exception
	 */
    public List<?> selectYpointList(YpointDefaultVO searchVO) throws Exception {
        return ypointDAO.selectYpointList(searchVO);
    }

    /**
	 * ypoint 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ypoint 총 갯수
	 * @exception
	 */
    public int selectYpointListTotCnt(YpointDefaultVO searchVO) {
		return ypointDAO.selectYpointListTotCnt(searchVO);
	}

	@Override
	public int selectPointSum(YpointVO ypointVO) {
		// TODO Auto-generated method stub
		return ypointDAO.selectPointSum(ypointVO);
	}
    
}
