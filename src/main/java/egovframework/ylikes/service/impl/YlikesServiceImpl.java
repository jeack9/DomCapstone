package egovframework.ylikes.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.ylikes.service.YlikesService;
import egovframework.ylikes.service.YlikesDefaultVO;
import egovframework.ylikes.service.YlikesVO;
import egovframework.ylikes.service.impl.YlikesMapper;
/**
 * @Class Name : YlikesServiceImpl.java
 * @Description : Ylikes Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("ylikesService")
public class YlikesServiceImpl extends EgovAbstractServiceImpl implements
        YlikesService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YlikesServiceImpl.class);

    @Resource(name="ylikesMapper")
    private YlikesMapper ylikesDAO;
    
    //@Resource(name="ylikesDAO")
    //private YlikesDAO ylikesDAO;
    
    /** ID Generation */
    //@Resource(name="{egovYlikesIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * ylikes을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YlikesVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYlikes(YlikesVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	ylikesDAO.insertYlikes(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * ylikes을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YlikesVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYlikes(YlikesVO vo) throws Exception {
        ylikesDAO.updateYlikes(vo);
    }

    /**
	 * ylikes을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YlikesVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYlikes(YlikesVO vo) throws Exception {
        ylikesDAO.deleteYlikes(vo);
    }

    /**
	 * ylikes을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YlikesVO
	 * @return 조회한 ylikes
	 * @exception Exception
	 */
    public YlikesVO selectYlikes(YlikesVO vo) throws Exception {
        YlikesVO resultVO = ylikesDAO.selectYlikes(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * ylikes 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ylikes 목록
	 * @exception Exception
	 */
    public List<?> selectYlikesList(YlikesDefaultVO searchVO) throws Exception {
        return ylikesDAO.selectYlikesList(searchVO);
    }

    /**
	 * ylikes 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ylikes 총 갯수
	 * @exception
	 */
    public int selectYlikesListTotCnt(YlikesDefaultVO searchVO) {
		return ylikesDAO.selectYlikesListTotCnt(searchVO);
	}
    
}
