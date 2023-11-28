package egovframework.ypoint.service;

import java.util.List;
import egovframework.ypoint.service.YpointDefaultVO;
import egovframework.ypoint.service.YpointVO;

/**
 * @Class Name : YpointService.java
 * @Description : Ypoint Business class
 * @Modification Information
 *
 * @author capstone
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YpointService {
	
	/**
	 * ypoint을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YpointVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYpoint(YpointVO vo) throws Exception;
    
    /**
	 * ypoint을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YpointVO
	 * @return void형
	 * @exception Exception
	 */
    void updateYpoint(YpointVO vo) throws Exception;
    
    /**
	 * ypoint을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YpointVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYpoint(YpointVO vo) throws Exception;
    
    /**
	 * ypoint을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YpointVO
	 * @return 조회한 ypoint
	 * @exception Exception
	 */
    YpointVO selectYpoint(YpointVO vo) throws Exception;
    
    /**
	 * ypoint 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ypoint 목록
	 * @exception Exception
	 */
    List selectYpointList(YpointDefaultVO searchVO) throws Exception;
    
    /**
	 * ypoint 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ypoint 총 갯수
	 * @exception
	 */
    int selectYpointListTotCnt(YpointDefaultVO searchVO);

    int selectPointSum(YpointVO ypointVO);
    
}
