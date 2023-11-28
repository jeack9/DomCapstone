package egovframework.yfreeboard.web;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import com.google.gson.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.yfreeboard.service.YfreeboardService;
import egovframework.yfreeboard.service.YfreeboardDefaultVO;
import egovframework.yfreeboard.service.YfreeboardVO;
import egovframework.yuser.service.YuserVO;

/**
 * @Class Name : YfreeboardController.java
 * @Description : Yfreeboard Controller class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=YfreeboardVO.class)
public class YfreeboardController {

    @Resource(name = "yfreeboardService")
    private YfreeboardService yfreeboardService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * yfreeboard 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 YfreeboardDefaultVO
	 * @return "/yfreeboard/YfreeboardList"
	 * @exception Exception
	 */
    @RequestMapping(value="/yfreeboard/YfreeboardList.do")
    public String selectYfreeboardList(@ModelAttribute("searchVO") YfreeboardDefaultVO searchVO, 
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
//		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> yfreeboardList = yfreeboardService.selectYfreeboardList(searchVO);
        model.addAttribute("yfreeboardList", yfreeboardList);
        
        int totCnt = yfreeboardService.selectYfreeboardListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "forward:/yfreeboard/getMostLike.do";
    } 
    
    
    @RequestMapping(value="/yfreeboard/getMostLike.do")
    public String getMostLike(Model model)
            throws Exception {
    	System.out.println("1111");
    	model.addAttribute("likeList", yfreeboardService.selectMostLike());
    	System.out.println("2222");
        return "freeboard";
    } 
    
    @RequestMapping(value="/main.do")
    public String Main(Model model)
            throws Exception {    	
    	model.addAttribute("likeList", yfreeboardService.selectMostLike());    	
        return "main";
    } 
    
    
    
    
    @RequestMapping("/yfreeboard/addYfreeboardView.do")
    public String addYfreeboardView(
            @ModelAttribute("searchVO") YfreeboardDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("yfreeboardVO", new YfreeboardVO());
        return "/yfreeboard/YfreeboardRegister";
    }
    
    @RequestMapping("/yfreeboard/addYfreeboard.do")
    @ResponseBody
    public ModelAndView addYfreeboard(
            YfreeboardVO yfreeboardVO)
            throws Exception {
        yfreeboardService.insertYfreeboard(yfreeboardVO); 
        return new ModelAndView("jsonView");
    }
    
//    @RequestMapping("/yfreeboard/updateYfreeboardView.do")
//    public String updateYfreeboardView(
//            @RequestParam("bno") int bno ,
//            @ModelAttribute("searchVO") YfreeboardDefaultVO searchVO, Model model)
//            throws Exception {
//        YfreeboardVO yfreeboardVO = new YfreeboardVO();
//        yfreeboardVO.setBno(bno);        
//        // 변수명은 CoC 에 따라 yfreeboardVO
//        model.addAttribute(selectYfreeboard2(yfreeboardVO, searchVO));
//        return "/yfreeboard/YfreeboardRegister";
//    }
    
    

    @RequestMapping("/yfreeboard/selectYfreeboard.do")
    public String selectYfreeboard(
            YfreeboardVO yfreeboardVO, Model model) throws Exception {
    	yfreeboardService.updateVisitors(yfreeboardVO);
    	try {
    		model.addAttribute("selectedVO", yfreeboardService.selectYfreeboard(yfreeboardVO));
    	}catch(Exception e) {
    		System.out.println("에러발생!!");
    	}    	
    	
        return "forward:/ycomment/YcommentList.do?searchKeyword=" + yfreeboardVO.getBno();
    }

    
    
    @RequestMapping("/yfreeboard/getFreeBoardInform.do")
    public String getFreeBoardInform(
            YfreeboardVO yfreeboardVO, Model model) throws Exception {
    	try {
    		model.addAttribute("selectedVO", yfreeboardService.selectYfreeboard(yfreeboardVO));
    	}catch(Exception e) {
    		System.out.println("에러발생!!");
    	}    	
    	
        return "freeboardupdate";
    }
    
    
    
    @RequestMapping("/yfreeboard/updateYfreeboard.do")
    @ResponseBody
    public ModelAndView updateYfreeboard(
            YfreeboardVO yfreeboardVO)
            throws Exception {
        yfreeboardService.updateYfreeboard(yfreeboardVO);
        return new ModelAndView("jsonView");
    }
    
    @RequestMapping("/yfreeboard/deleteYfreeboard.do")
    public String deleteYfreeboard(
            YfreeboardVO yfreeboardVO,
            @ModelAttribute("searchVO") YfreeboardDefaultVO searchVO, SessionStatus status)
            throws Exception {
        yfreeboardService.deleteYfreeboard(yfreeboardVO);
        status.setComplete();
        return "redirect:/yfreeboard/YfreeboardList.do";
    }
    

    @RequestMapping("/yfreeboard/addImage.do")
    public void addImage(MultipartHttpServletRequest multiRequest, HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
    	
    	PrintWriter printWriter = null;    	
    	try {
    		List<MultipartFile> list = multiRequest.getFiles("upload");
        	if(list.size() > 0) {        		
       		String temp[] = list.get(0).getOriginalFilename().split("[.]");
       		String exten = temp[temp.length - 1];
       		String filename = UUID.randomUUID().toString() + "." + exten;
       		
			
			list.get(0).transferTo(new File(
			"C:\\eGovFrame-3.10.0\\workspace.edu\\Test\\src\\main\\webapp\\uploads\\" +
			filename)); list.get(0).transferTo(new File(
			"C:\\eGovFrame-3.10.0\\workspace.edu\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Test\\uploads\\"
			+ filename));
          	
//          	list.get(0).transferTo(new File("C:\\apache-tomcat-8.5.90\\webapps\\ROOT\\uploads\\" + filename));
          	JsonObject jsonObject = new JsonObject();
          	printWriter = resp.getWriter();
          	jsonObject.addProperty("uploaded", 1);
          	jsonObject.addProperty("fileName", filename);
          	System.out.println(req.getSession().getServletContext().getRealPath("/dbimage"));
          	jsonObject.addProperty("url", "/uploads/" + filename);
          	printWriter.print(jsonObject);
        	}
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

}
