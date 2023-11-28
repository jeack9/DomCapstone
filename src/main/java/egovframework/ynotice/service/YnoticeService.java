package egovframework.ynotice.service;

import java.util.List;
import egovframework.ynotice.service.YnoticeDefaultVO;
import egovframework.ynotice.service.YnoticeVO;

/**
 * @Class Name : YnoticeService.java
 * @Description : Ynotice Business class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-06-06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YnoticeService {
	
	/**
	 * ynotice을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YnoticeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYnotice(YnoticeVO vo) throws Exception;
    
    /**
	 * ynotice을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YnoticeVO
	 * @return void형
	 * @exception Exception
	 */
    void updateYnotice(YnoticeVO vo) throws Exception;
    
    /**
	 * ynotice을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YnoticeVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYnotice(YnoticeVO vo) throws Exception;
    
    /**
	 * ynotice을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YnoticeVO
	 * @return 조회한 ynotice
	 * @exception Exception
	 */
    YnoticeVO selectYnotice(YnoticeVO vo) throws Exception;
    
    /**
	 * ynotice 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ynotice 목록
	 * @exception Exception
	 */
    List selectYnoticeList(YnoticeDefaultVO searchVO) throws Exception;
    
    /**
	 * ynotice 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ynotice 총 갯수
	 * @exception
	 */
    int selectYnoticeListTotCnt(YnoticeDefaultVO searchVO);

	void updateVisitor(YnoticeVO ynoticeVO);
    
}
