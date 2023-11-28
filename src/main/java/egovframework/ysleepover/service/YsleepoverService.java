package egovframework.ysleepover.service;

import java.util.List;
import egovframework.ysleepover.service.YsleepoverDefaultVO;
import egovframework.ysleepover.service.YsleepoverVO;

/**
 * @Class Name : YsleepoverService.java
 * @Description : Ysleepover Business class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YsleepoverService {
	
	/**
	 * ysleepover을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YsleepoverVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYsleepover(YsleepoverVO vo) throws Exception;
    
    /**
	 * ysleepover을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YsleepoverVO
	 * @return void형
	 * @exception Exception
	 */
    void updateYsleepover(YsleepoverVO vo) throws Exception;
    
    /**
	 * ysleepover을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YsleepoverVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYsleepover(YsleepoverVO vo) throws Exception;
    
    /**
	 * ysleepover을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YsleepoverVO
	 * @return 조회한 ysleepover
	 * @exception Exception
	 */
    YsleepoverVO selectYsleepover(YsleepoverVO vo) throws Exception;
    
    /**
	 * ysleepover 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ysleepover 목록
	 * @exception Exception
	 */
    List selectYsleepoverList(YsleepoverDefaultVO searchVO) throws Exception;
    
    /**
	 * ysleepover 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ysleepover 총 갯수
	 * @exception
	 */
    int selectYsleepoverListTotCnt(YsleepoverDefaultVO searchVO);

	List<?> selectYsleepoverListJson();

	List<?> todayAbsentStudent();
    
}
