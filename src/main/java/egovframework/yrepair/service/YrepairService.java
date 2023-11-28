package egovframework.yrepair.service;

import java.util.List;
import egovframework.yrepair.service.YrepairDefaultVO;
import egovframework.yrepair.service.YrepairVO;

/**
 * @Class Name : YrepairService.java
 * @Description : Yrepair Business class
 * @Modification Information
 *
 * @author aa
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YrepairService {
	
	/**
	 * yrepair을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YrepairVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYrepair(YrepairVO vo) throws Exception;
    
    /**
	 * yrepair을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YrepairVO
	 * @return void형
	 * @exception Exception
	 */
    void updateYrepair(YrepairVO vo) throws Exception;
    
    /**
	 * yrepair을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YrepairVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYrepair(YrepairVO vo) throws Exception;
    
    /**
	 * yrepair을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YrepairVO
	 * @return 조회한 yrepair
	 * @exception Exception
	 */
    YrepairVO selectYrepair(YrepairVO vo) throws Exception;
    
    /**
	 * yrepair 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yrepair 목록
	 * @exception Exception
	 */
    List selectYrepairList(YrepairDefaultVO searchVO) throws Exception;
    
    /**
	 * yrepair 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yrepair 총 갯수
	 * @exception
	 */
    int selectYrepairListTotCnt(YrepairDefaultVO searchVO);

	void updateState(YrepairVO yrepairVO) throws Exception;
    
}
