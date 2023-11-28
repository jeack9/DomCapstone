package egovframework.yfreeboard.service.impl;

import java.util.List;

import egovframework.yfreeboard.service.YfreeboardVO;
import egovframework.yfreeboard.service.YfreeboardDefaultVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : YfreeboardMapper.java
 * @Description : Yfreeboard Mapper Class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("yfreeboardMapper")
public interface YfreeboardMapper {

	/**
	 * yfreeboard을 등록한다.
	 * @param vo - 등록할 정보가 담긴 YfreeboardVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertYfreeboard(YfreeboardVO vo) throws Exception;

    /**
	 * yfreeboard을 수정한다.
	 * @param vo - 수정할 정보가 담긴 YfreeboardVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYfreeboard(YfreeboardVO vo) throws Exception;

    /**
	 * yfreeboard을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 YfreeboardVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYfreeboard(YfreeboardVO vo) throws Exception;

    /**
	 * yfreeboard을 조회한다.
	 * @param vo - 조회할 정보가 담긴 YfreeboardVO
	 * @return 조회한 yfreeboard
	 * @exception Exception
	 */
    public YfreeboardVO selectYfreeboard(YfreeboardVO vo) throws Exception;

    /**
	 * yfreeboard 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return yfreeboard 목록
	 * @exception Exception
	 */
    public List<?> selectYfreeboardList(YfreeboardDefaultVO searchVO) throws Exception;

    /**
	 * yfreeboard 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return yfreeboard 총 갯수
	 * @exception
	 */
    public int selectYfreeboardListTotCnt(YfreeboardDefaultVO searchVO);

	public List<?> selectMostLike();

	public void updateVisitors(YfreeboardVO vo);

	public void decreaseYLikes(YfreeboardVO vo) throws Exception;
	public void increaseYLikes(YfreeboardVO vo) throws Exception;
}
