package egovframework.ynotice.service.impl;

import java.util.List;

import egovframework.ynotice.service.YnoticeVO;
import egovframework.ynotice.service.YnoticeDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : YnoticeMapper.java
 * @Description : Ynotice Mapper Class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-06-06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("ynoticeMapper")
public interface YnoticeMapper {

	/**
	 * ynotice을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YnoticeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertYnotice(YnoticeVO vo) throws Exception;

    /**
	 * ynotice을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YnoticeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYnotice(YnoticeVO vo) throws Exception;

    /**
	 * ynotice을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YnoticeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYnotice(YnoticeVO vo) throws Exception;

    /**
	 * ynotice을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YnoticeVO
	 * @return 조회한 ynotice
	 * @exception Exception
	 */
    public YnoticeVO selectYnotice(YnoticeVO vo) throws Exception;

    /**
	 * ynotice 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ynotice 목록
	 * @exception Exception
	 */
    public List<?> selectYnoticeList(YnoticeDefaultVO searchVO) throws Exception;

    /**
	 * ynotice 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ynotice 총 갯수
	 * @exception
	 */
    public int selectYnoticeListTotCnt(YnoticeDefaultVO searchVO);

	public void updateVisitor(YnoticeVO vo);

}
