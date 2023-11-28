package egovframework.room.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.room.service.RoomService;
import egovframework.room.service.RoomDefaultVO;
import egovframework.room.service.RoomVO;
import egovframework.room.service.impl.RoomMapper;
/**
 * @Class Name : RoomServiceImpl.java
 * @Description : Room Business Implement class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("roomService")
public class RoomServiceImpl extends EgovAbstractServiceImpl implements
        RoomService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomServiceImpl.class);

    @Resource(name="roomMapper")
    private RoomMapper roomDAO;
    
    //@Resource(name="roomDAO")
    //private RoomDAO roomDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRoomIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * room을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RoomVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRoom(RoomVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	roomDAO.insertRoom(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * room을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RoomVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRoom(RoomVO vo) throws Exception {
        roomDAO.updateRoom(vo);
    }

    /**
	 * room을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RoomVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRoom(RoomVO vo) throws Exception {
        roomDAO.deleteRoom(vo);
    }

    /**
	 * room을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RoomVO
	 * @return 조회한 room
	 * @exception Exception
	 */
    public RoomVO selectRoom(RoomVO vo) throws Exception {
        RoomVO resultVO = roomDAO.selectRoom(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * room 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return room 목록
	 * @exception Exception
	 */
    public List<?> selectRoomList(RoomDefaultVO searchVO) throws Exception {
        return roomDAO.selectRoomList(searchVO);
    }

    /**
	 * room 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return room 총 갯수
	 * @exception
	 */
    public int selectRoomListTotCnt(RoomDefaultVO searchVO) {
		return roomDAO.selectRoomListTotCnt(searchVO);
	}
    public List<?> selectSearchList(RoomDefaultVO searchVO) throws Exception {
        return roomDAO.selectSearchList(searchVO);
    }
    public List<?> selectFloorList(RoomDefaultVO searchVO) throws Exception {
		// TODO Auto-generated method stub
		return roomDAO.selectFloorList(searchVO);
	}
	@Override
	public RoomVO selectRoom(String vo) throws Exception {
		RoomVO resultVO = roomDAO.selectRoom(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
	}

	@Override
	public void updateJoinRoom(RoomVO roomVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoomVO selectFloor(String floor) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
    
}
