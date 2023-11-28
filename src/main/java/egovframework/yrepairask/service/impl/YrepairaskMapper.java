package egovframework.yrepairask.service.impl;

import java.util.List;

import egovframework.yrepairask.service.YrepairaskVO;
import egovframework.yrepairask.service.YrepairaskDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : YrepairaskMapper.java
 * @Description : Yrepairask Mapper Class
 * @Modification Information
 *
 * @author aa
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("yrepairaskMapper")
public interface YrepairaskMapper {

	/**
	 * yrepairask을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YrepairaskVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertYrepairask(YrepairaskVO vo) throws Exception;

    /**
	 * yrepairask을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YrepairaskVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYrepairask(YrepairaskVO vo) throws Exception;

    /**
	 * yrepairask을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YrepairaskVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYrepairask(YrepairaskVO vo) throws Exception;

    /**
	 * yrepairask을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YrepairaskVO
	 * @return 조회한 yrepairask
	 * @exception Exception
	 */
    public YrepairaskVO selectYrepairask(YrepairaskVO vo) throws Exception;

    /**
	 * yrepairask 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return yrepairask 목록
	 * @exception Exception
	 */
    public List<?> selectYrepairaskList(YrepairaskDefaultVO searchVO) throws Exception;

    /**
	 * yrepairask 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return yrepairask 총 갯수
	 * @exception
	 */
    public int selectYrepairaskListTotCnt(YrepairaskDefaultVO searchVO);

}
