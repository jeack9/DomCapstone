package egovframework.yfreeboard.service;

import java.util.List;

import egovframework.yfreeboard.service.YfreeboardDefaultVO;
import egovframework.yfreeboard.service.YfreeboardVO;

/**
 * @Class Name : YfreeboardService.java
 * @Description : Yfreeboard Business class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YfreeboardService {
	
	/**
	 * yfreeboard을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YfreeboardVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYfreeboard(YfreeboardVO vo) throws Exception;
    
    /**
	 * yfreeboard을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YfreeboardVO
	 * @return void형
	 * @exception Exception
	 */
    void updateYfreeboard(YfreeboardVO vo) throws Exception;
    
    /**
	 * yfreeboard을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YfreeboardVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYfreeboard(YfreeboardVO vo) throws Exception;
    
    /**
	 * yfreeboard을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YfreeboardVO
	 * @return 조회한 yfreeboard
	 * @exception Exception
	 */
    YfreeboardVO selectYfreeboard(YfreeboardVO vo) throws Exception;
    
    /**
	 * yfreeboard 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yfreeboard 목록
	 * @exception Exception
	 */
    List selectYfreeboardList(YfreeboardDefaultVO searchVO) throws Exception;
    
    /**
	 * yfreeboard 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yfreeboard 총 갯수
	 * @exception
	 */
    int selectYfreeboardListTotCnt(YfreeboardDefaultVO searchVO);

	List selectMostLike();
	
	public void updateVisitors(YfreeboardVO vo);
    
	void increaseYLikes(YfreeboardVO vo) throws Exception;
    void decreaseYLikes(YfreeboardVO vo) throws Exception;
}
