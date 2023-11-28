package egovframework.room.service;

import java.util.List;

import egovframework.room.service.RoomDefaultVO;
import egovframework.room.service.RoomVO;

/**
 * @Class Name : RoomService.java
 * @Description : Room Business class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RoomService {
	
	/**
	 * room을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RoomVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRoom(RoomVO vo) throws Exception;
    
    /**
	 * room을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RoomVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRoom(RoomVO vo) throws Exception;

	void updateJoinRoom(RoomVO roomVO) throws Exception;
    /**
	 * room을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RoomVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRoom(RoomVO vo) throws Exception;
    
    /**
	 * room을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RoomVO
	 * @return 조회한 room
	 * @exception Exception
	 */
    RoomVO selectRoom(RoomVO vo) throws Exception;
    RoomVO selectRoom(String vo) throws Exception;
    RoomVO selectFloor(String floor) throws Exception;
    /**
	 * room 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return room 목록
	 * @exception Exception
	 */
    List selectRoomList(RoomDefaultVO searchVO) throws Exception;

	List selectFloorList(RoomDefaultVO searchVO)  throws Exception;
    /**
	 * room 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return room 총 갯수
	 * @exception
	 */
    int selectRoomListTotCnt(RoomDefaultVO searchVO);


    
}
