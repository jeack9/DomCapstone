package egovframework.ylikes.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.yfreeboard.service.YfreeboardService;
import egovframework.yfreeboard.service.YfreeboardVO;
import egovframework.ylikes.service.YlikesService;
import egovframework.ylikes.service.YlikesDefaultVO;
import egovframework.ylikes.service.YlikesVO;
import egovframework.yuser.service.YuserVO;

/**
 * @Class Name : YlikesController.java
 * @Description : Ylikes Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=YlikesVO.class)
public class YlikesController {

	@Resource(name = "yfreeboardService")
    private YfreeboardService yfreeboardService;
	
    @Resource(name = "ylikesService")
    private YlikesService ylikesService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * ylikes 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 YlikesDefaultVO
	 * @return "/ylikes/YlikesList"
	 * @exception Exception
	 */
    @RequestMapping(value="/ylikes/YlikesList.do")
    public String selectYlikesList(@ModelAttribute("searchVO") YlikesDefaultVO searchVO, 
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
		
        List<?> ylikesList = ylikesService.selectYlikesList(searchVO);
        model.addAttribute("resultList", ylikesList);
        
        int totCnt = ylikesService.selectYlikesListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/ylikes/YlikesList";
    } 
    
    @RequestMapping("/ylikes/addYlikesView.do")
    public String addYlikesView(
            @ModelAttribute("searchVO") YlikesDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("ylikesVO", new YlikesVO());
        return "/ylikes/YlikesRegister";
    }
    
    @RequestMapping("/ylikes/addYlikes.do")
    public String addYlikes(
            YlikesVO ylikesVO,
            @ModelAttribute("searchVO") YlikesDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ylikesService.insertYlikes(ylikesVO);
        status.setComplete();
        return "forward:/ylikes/YlikesList.do";
    }
    
    @RequestMapping("/ylikes/updateYlikesView.do")
    public String updateYlikesView(
            @RequestParam("lno") int lno ,
            @ModelAttribute("searchVO") YlikesDefaultVO searchVO, Model model)
            throws Exception {
        YlikesVO ylikesVO = new YlikesVO();
        ylikesVO.setLno(lno);        
        // 변수명은 CoC 에 따라 ylikesVO
        //model.addAttribute(selectYlikes(ylikesVO, searchVO));
        return "/ylikes/YlikesRegister";
    }

//    @RequestMapping("/ylikes/selectYlikes.do")
//    public @ModelAttribute("ylikesVO")
//    YlikesVO selectYlikes(
//            YlikesVO ylikesVO,
//            @ModelAttribute("searchVO") YlikesDefaultVO searchVO) throws Exception {
//        return ylikesService.selectYlikes(ylikesVO);
//    }
    
    
    
    @RequestMapping("/ylikes/selectYlikes.do")
    public @ResponseBody ModelAndView selectKjhgallerylikes(YlikesVO ylikesVO, HttpServletRequest request) throws Exception {
    	
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	
    	YuserVO yuserVO = (YuserVO) request.getSession().getAttribute("loginedUserVO");
    	
    	int asd = ylikesVO.getBno();

    	ylikesVO.setUserid(yuserVO.getUserid());
    	//ylikesVO.setBno(asd);
    	

    	int qqq = ylikesService.selectYlikesListTotCnt(ylikesVO);//중복 검증 위해서 셀렉트 해서 likes 테이블에서 일치하는 행  조회함(갯수 반환) 
    	
    	
   	if(qqq>0) {//해당 하는거 찾음. 즉 중복이므로 likes 테이블 데이터 삭제하고 추천은 -1 
   		yfreeboardService.decreaseYLikes((YfreeboardVO) request.getSession().getAttribute("selectedVO"));
   		ylikesService.deleteYlikes(ylikesVO);
	} else {//해당 하는거 못 찾음 likes 테이블에 데이터 집어넣고 추천은 +1
		yfreeboardService.increaseYLikes((YfreeboardVO) request.getSession().getAttribute("selectedVO"));
		ylikesService.insertYlikes(ylikesVO);
    }
    	
    		
    	
    	
//    	
//   
//    		KjhgalleryVO vo = new KjhgalleryVO();
//        	vo.setId(asd);
    	
    	
    	YfreeboardVO vo2 = yfreeboardService.selectYfreeboard((YfreeboardVO) request.getSession().getAttribute("selectedVO"));
    	request.getSession().setAttribute("selectedVO", vo2);
    	jsonView.addObject("searchedVO", vo2);
		 return jsonView;
    }
    
    
    
    
    
    
    
    
    
    
    

    @RequestMapping("/ylikes/updateYlikes.do")
    public String updateYlikes(
            YlikesVO ylikesVO,
            @ModelAttribute("searchVO") YlikesDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ylikesService.updateYlikes(ylikesVO);
        status.setComplete();
        return "forward:/ylikes/YlikesList.do";
    }
    
    @RequestMapping("/ylikes/deleteYlikes.do")
    public String deleteYlikes(
            YlikesVO ylikesVO,
            @ModelAttribute("searchVO") YlikesDefaultVO searchVO, SessionStatus status)
            throws Exception {
        ylikesService.deleteYlikes(ylikesVO);
        status.setComplete();
        return "forward:/ylikes/YlikesList.do";
    }

}
