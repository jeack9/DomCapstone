package egovframework.ypayment.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.ypayment.service.YpaymentService;
import egovframework.ypayment.service.YpaymentDefaultVO;
import egovframework.ypayment.service.YpaymentVO;
import egovframework.ypayment.service.impl.YpaymentMapper;
/**
 * @Class Name : YpaymentServiceImpl.java
 * @Description : Ypayment Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("ypaymentService")
public class YpaymentServiceImpl extends EgovAbstractServiceImpl implements
        YpaymentService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YpaymentServiceImpl.class);

    @Resource(name="ypaymentMapper")
    private YpaymentMapper ypaymentDAO;
    
    //@Resource(name="ypaymentDAO")
    //private YpaymentDAO ypaymentDAO;
    
    /** ID Generation */
    //@Resource(name="{egovYpaymentIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * ypayment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YpaymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYpayment(YpaymentVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	ypaymentDAO.insertYpayment(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * ypayment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YpaymentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYpayment(YpaymentVO vo) throws Exception {
        ypaymentDAO.updateYpayment(vo);
    }

    /**
	 * ypayment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YpaymentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYpayment(YpaymentVO vo) throws Exception {
        ypaymentDAO.deleteYpayment(vo);
    }

    /**
	 * ypayment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YpaymentVO
	 * @return 조회한 ypayment
	 * @exception Exception
	 */
    public YpaymentVO selectYpayment(YpaymentVO vo) throws Exception {
        YpaymentVO resultVO = ypaymentDAO.selectYpayment(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * ypayment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ypayment 목록
	 * @exception Exception
	 */
    public List<?> selectYpaymentList(YpaymentDefaultVO searchVO) throws Exception {
        return ypaymentDAO.selectYpaymentList(searchVO);
    }

    /**
	 * ypayment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ypayment 총 갯수
	 * @exception
	 */
    public int selectYpaymentListTotCnt(YpaymentDefaultVO searchVO) {
		return ypaymentDAO.selectYpaymentListTotCnt(searchVO);
	}
    
}
