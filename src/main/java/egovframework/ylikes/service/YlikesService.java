package egovframework.ylikes.service;

import java.util.List;
import egovframework.ylikes.service.YlikesDefaultVO;
import egovframework.ylikes.service.YlikesVO;

/**
 * @Class Name : YlikesService.java
 * @Description : Ylikes Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YlikesService {
	
	/**
	 * ylikes을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YlikesVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYlikes(YlikesVO vo) throws Exception;
    
    /**
	 * ylikes을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YlikesVO
	 * @return void형
	 * @exception Exception
	 */
    void updateYlikes(YlikesVO vo) throws Exception;
    
    /**
	 * ylikes을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YlikesVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYlikes(YlikesVO vo) throws Exception;
    
    /**
	 * ylikes을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YlikesVO
	 * @return 조회한 ylikes
	 * @exception Exception
	 */
    YlikesVO selectYlikes(YlikesVO vo) throws Exception;
    
    /**
	 * ylikes 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ylikes 목록
	 * @exception Exception
	 */
    List selectYlikesList(YlikesDefaultVO searchVO) throws Exception;
    
    /**
	 * ylikes 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ylikes 총 갯수
	 * @exception
	 */
    int selectYlikesListTotCnt(YlikesDefaultVO searchVO);
    
}
