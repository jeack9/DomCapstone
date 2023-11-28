package egovframework.room.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.yfreeboard.service.YfreeboardService;
import egovframework.ypayment.service.YpaymentService;
import egovframework.ypayment.service.YpaymentVO;
import egovframework.ypoint.service.YpointVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.yuser.service.YuserDefaultVO;
import egovframework.yuser.service.YuserService;
import egovframework.yuser.service.YuserVO;
import egovframework.room.service.RoomService;
import egovframework.room.service.RoomDefaultVO;
import egovframework.room.service.RoomVO;

/**
 * @Class Name : RoomController.java
 * @Description : Room Controller class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=RoomVO.class)
public class RoomController {
	@Resource(name = "yuserService")
    private YuserService yuserService;
	
    @Resource(name = "roomService")
    private RoomService roomService;
    
    @Resource(name = "ypaymentService")
    private YpaymentService ypaymentService;
    
    
    
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * room 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 RoomDefaultVO
	 * @return "/room/RoomList"
	 * @exception Exception
	 */
    @RequestMapping(value="/room/RoomList.do")
    public String selectRoomList(@ModelAttribute("searchVO") RoomDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> roomList = roomService.selectRoomList(searchVO);
        model.addAttribute("resultList", roomList);
        
        int totCnt = roomService.selectRoomListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "payment";
    } 
    @RequestMapping("/room/FloorList.do")
    public String selectFloorList(@ModelAttribute("searchVO") RoomDefaultVO searchVO, HttpServletRequest request,
    		ModelMap model)
            throws Exception {
    	String floor = request.getParameter("radioValue");
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		searchVO.setFloor(floor);
		
        List<?> roomList = roomService.selectFloorList(searchVO);
        System.out.print("방개수는" + roomList.size());
        model.addAttribute("resultList", roomList);
        model.addAttribute("floor", floor);
        int totCnt = roomService.selectRoomListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "payment";
    } 
    
    
    @RequestMapping("/room/selectRoom.do")
    public @ModelAttribute("roomVO")
    RoomVO selectRoom(
            RoomVO roomVO,
            @ModelAttribute("searchVO") RoomDefaultVO searchVO) throws Exception {
        return roomService.selectRoom(roomVO);
    }
    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    @RequestMapping(value="/room/YuserListJson.do")
    public ModelAndView selectYuserList(@ModelAttribute("searchVO") YuserDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	ModelAndView json = new ModelAndView("jsonView");
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));    	
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
//		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> yuserList = yuserService.selectYuserList(searchVO);
        model.addAttribute("resultList", yuserList);
        json.addObject("resultList", yuserList);
        int totCnt = yuserService.selectYuserListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return json;
    }
 // 관리자가 상벌점 제출할 때 yuserpoint 추가
    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    @RequestMapping("/room/insertYRoom.do")
    public void editPoint(RoomVO roomVO, YuserVO yuserVO) throws Exception {
    	roomVO = roomService.selectRoom(roomVO.getRoomno());
    	if(roomVO.getPeople()==1) {
    	
    		if(roomVO.getUserone().equals(yuserVO.getUserid())) {
    			roomVO.setUserone("");
    		}
    		else if(roomVO.getUsertwo().equals(yuserVO.getUserid())) {
    			roomVO.setUsertwo("");
    		}
    		roomVO.setPeople(0);
    		yuserVO.setRoomno("");
    	}
    	else if(roomVO.getPeople()==2) {
    		if(roomVO.getUserone().equals(yuserVO.getUserid())) {
    			roomVO.setUserone("");
    		}
    		else if(roomVO.getUsertwo().equals(yuserVO.getUserid())) {
    			roomVO.setUsertwo("");
    		}
    		roomVO.setPeople(1);
    		roomVO.setState("normal");
    		yuserVO.setRoomno("");
    	}
    	
    	roomService.updateRoom(roomVO);
    	yuserService.updateYuserRoom(yuserVO);
    }
    @RequestMapping("/room/updateRoom.do")
    public String updateRoom(
            RoomVO roomVO,HttpServletRequest request,
            @ModelAttribute("searchVO") RoomDefaultVO searchVO, SessionStatus status)
            throws Exception {
    	request.setCharacterEncoding("utf-8");
    	//String user = request.getParameter("user");
    	
    	String name = request.getParameter("value");
    	String floor = request.getParameter("floor");
    	YuserVO userVO = (YuserVO) request.getSession().getAttribute("loginedUserVO");
    	
    	
    	roomVO = roomService.selectRoom(name);
    	
    	
    	int people = roomVO.getPeople();
    	switch(roomVO.getState()) {
    	case "normal" : 
    		if(userVO.getRoomno()== null || userVO.getRoomno().isEmpty()) {
    			if(people==1) {
    	    		roomVO.setState("disabled");
    	    		people=2;
    	    		roomVO.setPeople(people);
    	    		if(roomVO.getUserone().isEmpty()) {
    	    			roomVO.setUserone(userVO.getUserid());
    	    		}else {
    	    			roomVO.setUsertwo(userVO.getUserid());
    	    		}
    	    		
    	    		userVO.setRoomno(name);
    	    	}
    	    	else if(people==0) {
    	    		people=1;
    	    		roomVO.setPeople(people);
    	    		roomVO.setUserone(userVO.getUserid());
    	    		userVO.setRoomno(name);
    	    	}
    			roomService.updateRoom(roomVO);
        		yuserService.updateYuserRoom(userVO);
        		YpaymentVO paymentVO = new YpaymentVO();
        		paymentVO.setName(name);
        		paymentVO.setUserid(userVO.getUserid());
        		ypaymentService.insertYpayment(paymentVO);
    			break;
    		}
    		else {
    			String uNum = userVO.getRoomno();
    			RoomVO yroomVO = roomService.selectRoom(uNum);
    			int yetpeple = yroomVO.getPeople();
    			yroomVO.setPeople(yetpeple-1);
    			roomService.updateRoom(yroomVO);
    			if(people==1) {
    	    		roomVO.setState("disabled");
    	    		people=2;
    	    		roomVO.setPeople(people);
    	    		if(roomVO.getUserone().isEmpty()) {
    	    			roomVO.setUserone(userVO.getUserid());
    	    		}else {
    	    			roomVO.setUsertwo(userVO.getUserid());
    	    		}
    	    		userVO.setRoomno(name);
    	    	}
    	    	else if(people==0) {
    	    		people=1;
    	    		roomVO.setPeople(people);
    	    		roomVO.setUserone(userVO.getUserid());
    	    		userVO.setRoomno(name);
    	    	}
    			roomService.updateRoom(roomVO);
        		yuserService.updateYuserRoom(userVO);
        		YpaymentVO paymentVO = new YpaymentVO();
        		paymentVO.setName(name);
        		paymentVO.setUserid(userVO.getUserid());
        		ypaymentService.insertYpayment(paymentVO);
    			break;
    		}
    	case "disabled" : 
    		roomVO.setState("normal");
    		people=0;
    		roomVO.setPeople(people);
    		userVO.setRoomno("");
    		roomService.updateRoom(roomVO);
    		yuserService.updateYuser(userVO);

    		break;
    	}
    	System.out.println("층수는" + floor);
                status.setComplete();
        return "forward:/room/FloorList.do?radioValue="+floor+"&floor="+floor;
    }
    
    @RequestMapping("/room/deleteRoom.do")
    public String deleteRoom(
            RoomVO roomVO,
            @ModelAttribute("searchVO") RoomDefaultVO searchVO, SessionStatus status)
            throws Exception {
        roomService.deleteRoom(roomVO);
        status.setComplete();
        return "forward:/room/RoomList.do";
    }
    
}
