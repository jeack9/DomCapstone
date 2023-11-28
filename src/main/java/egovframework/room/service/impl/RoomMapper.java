package egovframework.room.service.impl;

import java.util.List;

import egovframework.room.service.RoomVO;
import egovframework.room.service.RoomDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : RoomMapper.java
 * @Description : Room Mapper Class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("roomMapper")
public interface RoomMapper {

	/**
	 * room을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RoomVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertRoom(RoomVO vo) throws Exception;

    /**
	 * room을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RoomVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRoom(RoomVO vo) throws Exception;
    public void updateJoinRoom(RoomVO vo) throws Exception;
    /**
	 * room을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RoomVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRoom(RoomVO vo) throws Exception;

    /**
	 * room을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RoomVO
	 * @return 조회한 room
	 * @exception Exception
	 */
    public RoomVO selectRoom(RoomVO vo) throws Exception;
    public RoomVO selectRoom(String vo) throws Exception;
    /**
	 * room 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return room 목록
	 * @exception Exception
	 */
    public List<?> selectRoomList(RoomDefaultVO searchVO) throws Exception;
    public List<?> selectFloorList(RoomDefaultVO searchVO) throws Exception;
    /**
	 * room 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return room 총 갯수
	 * @exception
	 */
    public int selectRoomListTotCnt(RoomDefaultVO searchVO);

	public List<?> selectSearchList(RoomDefaultVO searchVO);

	

}
