package egovframework.yuser.service.impl;

import java.util.List;

import egovframework.yuser.service.YuserVO;
import egovframework.yuser.service.YuserDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.testuser.service.TestuserVO;

/**
 * @Class Name : YuserMapper.java
 * @Description : Yuser Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("yuserMapper")
public interface YuserMapper {

	/**
	 * yuser을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YuserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertYuser(YuserVO vo) throws Exception;

    /**
	 * yuser을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YuserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYuser(YuserVO vo) throws Exception;

    /**
	 * yuser을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YuserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYuser(YuserVO vo) throws Exception;

    /**
	 * yuser을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YuserVO
	 * @return 조회한 yuser
	 * @exception Exception
	 */
    public YuserVO selectYuser(YuserVO vo) throws Exception;
    public YuserVO selectYuser(String vo) throws Exception;
    /**
	 * yuser 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return yuser 목록
	 * @exception Exception
	 */
    public List<?> selectYuserList(YuserDefaultVO searchVO) throws Exception;

    /**
	 * yuser 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return yuser 총 갯수
	 * @exception
	 */
    public int selectYuserListTotCnt(YuserDefaultVO searchVO);

    public YuserVO checkUserLogin(YuserVO userVO);

	public void updateUserpoint(YuserVO yuserVO);

	public void editProfileImage(YuserVO currentUser);
	
	public int findYuserPw(YuserVO userVO);
	
	public void updateYuserPw(YuserVO userVO) throws Exception;

	public void updateYuserRoom(YuserVO userVO) throws Exception;

}
