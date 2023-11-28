package egovframework.yuser.service;

import java.util.List;
import egovframework.yuser.service.YuserDefaultVO;
import egovframework.yuser.service.YuserVO;

/**
 * @Class Name : YuserService.java
 * @Description : Yuser Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YuserService {
	
	/**
	 * yuser을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YuserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYuser(YuserVO vo) throws Exception;
    
    /**
	 * yuser을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YuserVO
	 * @return void형
	 * @exception Exception
	 */
    void updateYuser(YuserVO vo) throws Exception;
    
    
    /**
	 * yuser을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YuserVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYuser(YuserVO vo) throws Exception;
    
    /**
	 * yuser을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YuserVO
	 * @return 조회한 yuser
	 * @exception Exception
	 */
    YuserVO selectYuser(YuserVO vo) throws Exception;
    YuserVO selectYuser(String vo) throws Exception;
    /**
	 * yuser 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yuser 목록
	 * @exception Exception
	 */
    List selectYuserList(YuserDefaultVO searchVO) throws Exception;
    
    /**
	 * yuser 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return yuser 총 갯수
	 * @exception
	 */
    int selectYuserListTotCnt(YuserDefaultVO searchVO);
    
    YuserVO checkUserLogin(YuserVO userVO);

	void updateUserpoint(YuserVO yuserVO);

	void editProfileImage(YuserVO currentUser);
    
	int findYuserPw(YuserVO userVO);
	
	void updateYuserPw(YuserVO userVO) throws Exception;
	void updateYuserRoom(YuserVO userVO) throws Exception;

	
    
}
