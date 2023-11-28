package egovframework.yuser.web;

import java.io.File;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.ymail.TestMailer;
import egovframework.yuser.service.YuserService;
import egovframework.yuser.service.YuserDefaultVO;
import egovframework.yuser.service.YuserVO;

/**
 * @Class Name : YuserController.java
 * @Description : Yuser Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=YuserVO.class)
public class YuserController {
	
	@Resource(name = "testMailer")
	private TestMailer testMailer;  //사용

    @Resource(name = "yuserService")
    private YuserService yuserService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * yuser 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 YuserDefaultVO
	 * @return "/yuser/YuserList"
	 * @exception Exception
	 */
    
    @RequestMapping("/sendmail.do")
	@ResponseBody
	public ModelAndView sendmail(@RequestParam HashMap<Object, Object> param) {
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	
		try {
			testMailer.sendMail("asd02141@naver.com", "영진전문대학교 글로벌캠퍼스 기숙사 홈페이지에서온 문의사항 메일입니다", "이름: " + param.get("yname") + "\n" + "이메일: " + param.get("yemail") + "\n" + "제목: " + param.get("ytitle") + "\n" + "내용: " + param.get("ycontent") + "\n");
		} catch (Exception e) {
			e.printStackTrace();
			return null;			
		}

// 아래는 첨부파일용이라 우리는 첨부파일 쓸일 없음		
//		try {
//			testMailer.sendMail("asd02141@naver.com", "이것은 제목", "스프링으로 구현해서 보내본다.","E:/파일위치","보낼파일명.확장자");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "FAIL";			
//		}		
		return jsonView;
	}	
    
    @RequestMapping("/yuser/checkUserLogin.do")
    public String checkUserLogin(
            YuserVO userVO, Model model, HttpServletRequest request) throws Exception {
    	try {
    		userVO = yuserService.checkUserLogin(userVO);
    		model.addAttribute("loginedUserVO", userVO);
    	}catch(Exception e) {
    		model.addAttribute("loginedUserVO", userVO);
    	}
    	
    	//request.getSession().setAttribute("loginedUserVO", userVO);
    	return "loginProcess";
    }
    
    @RequestMapping("/yuser/userLogout.do")
    public String userLogout(HttpServletRequest request) throws Exception {
    	request.getSession().removeAttribute("loginedUserVO");
    	return "index";
    } 
    
    @RequestMapping("/yuser/addYuserView.do")
    public String addYuserView(
            @ModelAttribute("searchVO") YuserDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("yuserVO", new YuserVO());
        return "/yuser/YuserRegister";
    }
    
    @RequestMapping("/yuser/addYuser.do")
    public String addYuser(
            YuserVO yuserVO,
            @ModelAttribute("searchVO") YuserDefaultVO searchVO, SessionStatus status)
            throws Exception {
    	yuserVO.setAppendix("uploads\\" + "yger.png");
        yuserService.insertYuser(yuserVO);
        status.setComplete();
        return "signin";
    }
    
    @RequestMapping("/yuser/updateYuserView.do")
    public String updateYuserView(
            @RequestParam("userno") int userno ,
            @ModelAttribute("searchVO") YuserDefaultVO searchVO, Model model)
            throws Exception {
        YuserVO yuserVO = new YuserVO();
        yuserVO.setUserno(userno);        
        // 변수명은 CoC 에 따라 yuserVO
        model.addAttribute(selectYuser(yuserVO, searchVO));
        return "/yuser/YuserRegister";
    }

    @RequestMapping("/yuser/selectYuser.do")
    public @ModelAttribute("yuserVO")
    YuserVO selectYuser(
            YuserVO yuserVO,
            @ModelAttribute("searchVO") YuserDefaultVO searchVO) throws Exception {
        return yuserService.selectYuser(yuserVO);
    }
    
    
    @RequestMapping("/yuser/checkId.do")
    @ResponseBody
    public
    ModelAndView checkId(YuserVO yuserVO) throws Exception {
    	ModelAndView json = new ModelAndView("jsonView");
    	YuserVO s;
    	try {
    		s = yuserService.selectYuser(yuserVO);
    		System.out.println("값이 있나요!!" + (s !=null));
        	json.addObject("isthere", s != null);
    	}catch(Exception d) {
    		System.out.println("에러 내용 : " + d.getMessage());
    		json.addObject("isthere", false);
    	}
    	
    	return json;
    }

    @RequestMapping("/yuser/updateYuser.do")
    public String updateYuser(
            YuserVO yuserVO,
            @ModelAttribute("searchVO") YuserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        yuserService.updateYuser(yuserVO);
        status.setComplete();
        return "forward:/yuser/YuserList.do";
    }
    
    @RequestMapping("/yuser/deleteYuser.do")
    public String deleteYuser(
            YuserVO yuserVO,
            @ModelAttribute("searchVO") YuserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        yuserService.deleteYuser(yuserVO);
        status.setComplete();
        return "forward:/yuser/YuserList.do";
    }

    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    @RequestMapping("/yuser/editPoint.do")
    public void editPoint(YuserVO userVO) throws Exception {
//    	yuserService.editPoint(userVO);	
    }
    
    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    @RequestMapping("/yuser/test.do")
    public ModelAndView test(HttpServletRequest request) throws Exception {
    	ModelAndView testJson = new ModelAndView("jsonView");
    	testJson.addObject("testData", "통신성공");
    	return testJson;
    }
    
    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    @RequestMapping(value="yuser/YuserListJson.do")
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
    @ResponseBody
    @RequestMapping(value="/yuser/editProfileImage.do")
    public ModelAndView editProfileImage(final MultipartHttpServletRequest multiRequest,HttpServletRequest request, ModelMap model) throws Exception {  			    	
    	ModelAndView json = new ModelAndView("jsonView");
    	HttpSession session = request.getSession();
    	YuserVO currentUser = (YuserVO) session.getAttribute("loginedUserVO");
    	String filename ="";
	try {
		List<MultipartFile> list = multiRequest.getFiles("append");
    	if(list.size() > 0) {
    		if(list.get(0).getOriginalFilename().length() > 0) {
	   		String temp[] = list.get(0).getOriginalFilename().split("[.]");
	   		String exten = temp[temp.length - 1];
	   		filename = UUID.randomUUID().toString() + "." + exten;
	      	
	   		list.get(0).transferTo(new File("C:\\eGovFrame-3.10.0\\workspace.edu\\Test\\src\\main\\webapp\\uploads\\" + filename));
	   		list.get(0).transferTo(new File("C:\\eGovFrame-3.10.0\\workspace.edu\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Test\\uploads\\" + filename));
	   	
	   		currentUser.setAppendix("uploads/" + filename);
    		}
    	}
	}catch(Exception e) {
		
		System.out.println(e.getMessage());		
	}
	yuserService.editProfileImage(currentUser);
	json.addObject("imgSrc", "uploads/" +filename);
	return json;
    }
    
    @RequestMapping("/yuser/editYuser.do")
    public String editYuser(YuserVO yuserVO,HttpServletRequest request)throws Exception {
    	HttpSession session = request.getSession();
		/*
		 * try { List<MultipartFile> list = multiRequest.getFiles("append");
		 * if(list.size() > 0) { if(list.get(0).getOriginalFilename().length() > 0) {
		 * String temp[] = list.get(0).getOriginalFilename().split("[.]"); String exten
		 * = temp[temp.length - 1]; String filename = UUID.randomUUID().toString() + "."
		 * + exten;
		 * 
		 * list.get(0).transferTo(new File(
		 * "C:\\eGovFrame-3.10.0\\workspace.edu\\Test\\src\\main\\webapp\\uploads\\" +
		 * filename)); yuserVO.setAppendix("uploads/" + filename); } } }catch(Exception
		 * e) {
		 * 
		 * System.out.println(e.getMessage()); }
		 */
    	yuserService.updateYuser(yuserVO);
    	YuserVO currentUser = yuserService.checkUserLogin(yuserVO);
    	session.setAttribute("loginedUserVO", currentUser);
        return "index";
    }
    
    @RequestMapping(value="/yuser/insertYuserVO.do")
    public String insertKjhgalleryVO(final MultipartHttpServletRequest multiRequest,YuserVO vo, ModelMap model) throws Exception {  			
    	vo.setAppendix("uploads/yger.png");
	try {
		List<MultipartFile> list = multiRequest.getFiles("append");
    	if(list.size() > 0) {
    		if(list.get(0).getOriginalFilename().length() > 0) {
	   		String temp[] = list.get(0).getOriginalFilename().split("[.]");
	   		String exten = temp[temp.length - 1];
	   		String filename = UUID.randomUUID().toString() + "." + exten;
	      	
	   		list.get(0).transferTo(new File("C:\\eGovFrame-3.10.0\\workspace.edu\\Test\\src\\main\\webapp\\uploads\\" + filename));
	   		list.get(0).transferTo(new File("C:\\eGovFrame-3.10.0\\workspace.edu\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Test\\uploads\\" + filename));
			vo.setAppendix("uploads/" + filename);
    		}
    	}
	}catch(Exception e) {
		
		System.out.println(e.getMessage());		
	}
		yuserService.insertYuser(vo);
    	return "signin";
    }
    
    @RequestMapping("/yuser/findYuserPw.do")
    @ResponseBody
    public ModelAndView findYuserPw(YuserVO userVO) throws Exception {
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	int asd = yuserService.findYuserPw(userVO);
    	
    	if(asd>0) {//입력한 이름,학번,폰번 으로 해당하는 회원정보 찾음
    		System.out.println("찾음");
    		System.out.println("찾음");
    		System.out.println("찾음");
    		System.out.println("찾음");
    		String phone = userVO.getUserphone();    		
    		Random rand  = new Random(); //랜덤숫자 생성하기 !!
            String numStr = "";
            
            for(int i=0; i<4; i++) {
                String ran = Integer.toString(rand.nextInt(10));
                numStr+=ran;
            }
    		ExampleController exampleController = new ExampleController();//coolsms 컨트롤러
    		exampleController.sendOne(phone,numStr);//단일메세지 전송 메소드 호출
    		jsonView.addObject("findVO",numStr);
    	}
    	else {//못 찾음
    		System.out.println("못찾음");
    		System.out.println("못찾음");
    		System.out.println("못찾음");
    		System.out.println("못찾음");
    		System.out.println("못찾음");
    		return null;    	
    	}
    	
    	return jsonView;
    }
    
    @RequestMapping("/yuser/updateYuserPw.do")
    public String updateYuserPw(
            YuserVO yuserVO, SessionStatus status)
            throws Exception {
        yuserService.updateYuserPw(yuserVO);
        status.setComplete();
        return "signin";
    }
}
