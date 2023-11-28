package egovframework.yrepairask.service;

import java.util.List;
import egovframework.yrepairask.service.YrepairaskDefaultVO;
import egovframework.yrepairask.service.YrepairaskVO;

/**
 * @Class Name : YrepairaskService.java
 * @Description : Yrepairask Business class
 * @Modification Information
 *
 * @author aa
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YrepairaskService {
	
	/**
	 * yrepairask을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YrepairaskVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYrepairask(YrepairaskVO vo) throws Exception;
    
    /**
	 * yrepairask을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YrepairaskVO
	 * @return void형
	 * @exception Exception
	 */
    void updateYrepairask(YrepairaskVO vo) throws Exception;
    
    /**
	 * yrepairask을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YrepairaskVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYrepairask(YrepairaskVO vo) throws Exception;
    
    /**
	 * yrepairask을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YrepairaskVO
	 * @return 조회한 yrepairask
	 * @exception Exception
	 */
    YrepairaskVO selectYrepairask(YrepairaskVO vo) throws Exception;
    
    /**
	 * yrepairask 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yrepairask 목록
	 * @exception Exception
	 */
    List selectYrepairaskList(YrepairaskDefaultVO searchVO) throws Exception;
    
    /**
	 * yrepairask 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yrepairask 총 갯수
	 * @exception
	 */
    int selectYrepairaskListTotCnt(YrepairaskDefaultVO searchVO);
    
}
