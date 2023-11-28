package egovframework.ycomment.service;

import java.util.List;
import egovframework.ycomment.service.YcommentDefaultVO;
import egovframework.ycomment.service.YcommentVO;

/**
 * @Class Name : YcommentService.java
 * @Description : Ycomment Business class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YcommentService {
	
	/**
	 * ycomment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YcommentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYcomment(YcommentVO vo) throws Exception;
    
    /**
	 * ycomment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YcommentVO
	 * @return void형
	 * @exception Exception
	 */
    void updateYcomment(YcommentVO vo) throws Exception;
    
    /**
	 * ycomment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YcommentVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYcomment(YcommentVO vo) throws Exception;
    
    /**
	 * ycomment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YcommentVO
	 * @return 조회한 ycomment
	 * @exception Exception
	 */
    YcommentVO selectYcomment(YcommentVO vo) throws Exception;
    
    /**
	 * ycomment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ycomment 목록
	 * @exception Exception
	 */
    List selectYcommentList(YcommentDefaultVO searchVO) throws Exception;
    
    /**
	 * ycomment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ycomment 총 갯수
	 * @exception
	 */
    int selectYcommentListTotCnt(YcommentDefaultVO searchVO);

	public void insertReply(YcommentVO ycommentVO);

	void updateIsRemoveOne(YcommentVO ycommentVO);
    
}
