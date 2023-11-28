<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="egovframework.yrepair.service.YrepairVO" %>
<%@ page import="egovframework.yrepairask.service.YrepairaskVO" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>eLEARNING - eLearning HTML Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/lib/animate/animate.min.css" rel="stylesheet">
    <link href="/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- DATATABLE  -->
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css">
    
    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet">
    <style>
    *{
        margin: 0;
        padding: 0;
        list-style: none;
    }
    #contentwrap{
        border-top: 2px solid black; 
        display: flex; 
        flex-direction: column;
    }

    .info{
        display: flex; 
        padding: 15px; 
        justify-content: space-evenly; 
        border-top: 1px solid #393939;
    }
    .info>div{
        padding: 0 20px;
    }
    .question-content{
        border-top: 1px solid #c9c9c9; 
        border-bottom: 1px solid #c9c9c9;
        padding: 20px;
        padding-left: 100px;        
        display: flex;
    }
    .question-icon {
      display: flex;
      justify-content: center;
      align-items: center;
      min-width: 50px;
      min-height: 50px;
      max-width: 50px;
      max-height: 50px;
      border-radius: 50%;
      color: white;
      font-size: 24px;
      background-color: #1a4890;
    }
    .ask-content{
        padding: 20px;
        padding-left: 100px;
        display: flex;        
    }
    .ask-icon{
      display: flex;
      justify-content: center;
      align-items: center;
      min-width: 50px;
      min-height: 50px;
      max-width: 50px;
      max-height: 50px;
      border-radius: 50%;
      background-color: green;      
      color: white;
      font-size: 24px;
    }
    .content > p {
        margin: 0;
        padding-left: 30px;
    }
    .repair-btn{
    	padding: 10px 30px;
    }
</style>
</head>

<body>
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->


   <!-- Navbar Start -->
	<%@ include file="/navbar.jsp" %>
	<!-- Navbar End -->


    <!-- Header Start -->
    <div class="container-fluid bg-primary py-5 mb-5 page-header">
        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-lg-10 text-center">
                    <h1 class="display-3 text-white animated slideInDown">수리접수</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                            <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">수리접수</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->
        <%         
        /* YrepairVO repair = (YrepairVO)request.getAttribute("repair");
        YrepairaskVO ask = (YrepairaskVO)request.getAttribute("ask"); */
        /* System.out.println(ask + "애스크 값 없어"); */
        %>
    <!-- 테스트게시판  Start-->
    <div class="wow fadeInUp container-xxl py-5" data-wow-delay="0.1s">
    	<div style="text-align: center; padding: 10px;">
        <div id="contentwrap">
            <div style="padding: 20px 0;">
                <h4>(${repair.roomnum}호)_${repair.subject}</h4>
            </div>
            <div class="info">
                <div>작성자: ${repair.writer}</div>
                <div>작성일: ${repair.regdate}</div>
                <div>호실: ${repair.roomnum}</div>
                <c:if test="${repair.state =='0'}">
                <div>진행 상태: <span style="border: 0; background-color: #E8ECF4; border-radius: 5px; padding: 2px 7px;">
			    		처리 중</span>
	    		</div>
			    </c:if>
			    <c:if test="${repair.state =='1'}">
                <div>진행 상태: <span style="color:#0069D9;">완료</span>
	    		</div>
			    </c:if>
            </div>
            <div class="question-content content">
                <div class="question-icon">Q</div>
                <p style="width: 90%; white-space: pre-wrap; word-wrap: break-word; text-align: left;"><b>${repair.content}</b></p>
            </div>
            <c:if test="${!empty requestScope.ask}">
            <div class="ask-content content">
                <div class="ask-icon">A</div>
                <p style="width: 90%; white-space: pre-wrap; word-wrap: break-word; text-align: left;"><b>${requestScope.ask.content}</b></p>                
            </div>
            </c:if>                
        </div>
    	</div>    
	    <div style="text-align: center; padding-top: 20px;">
	        <c:if test="${repair.state =='0' && repair.userid == loginedUserVO.userid}">
	        <button type="button" class="btn btn-outline-primary repair-btn" onclick="location.href='/yrepair/updateformYrepair.do?reno=${param.reno}'">수정</button>
	        </c:if>
	        <c:if test="${sessionScope.loginedUserVO.admin >='1' && repair.state =='0'}">
	        <button type="button" class="btn btn-outline-success repair-btn" onclick="location.href='/yrepair/askformYrepair.do?reno=${param.reno}';">답변</button>
	        </c:if>
	        <c:if test="${(repair.state =='0' && repair.userid == loginedUserVO.userid) || sessionScope.loginedUserVO.admin >='1'}">
	        <button type="button" class="btn btn-outline-danger repair-btn" onclick="delete_event()">삭제</button>
	        </c:if>
	        <button type="button" class="btn btn-outline-secondary repair-btn" onclick="location.href='/yrepair/YrepairList.do';">목록</button>
	    </div>
    </div>
    
    <!-- 테스트게시판  End-->    
        
        

    <!-- Footer Start -->
	<%@ include file="/footer.jsp" %>
	<!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->    
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/lib/wow/wow.min.js"></script>
    <script src="/lib/easing/easing.min.js"></script>
    <script src="/lib/waypoints/waypoints.min.js"></script>
    <script src="/lib/owlcarousel/owl.carousel.min.js"></script>
    
    <!-- DATATABLE 라이브러리 -->
        
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>

    <!-- Template Javascript -->
    <script src="/js/main.js"></script>
	
</body>
<script>
function delete_event(){
	  if (confirm("삭제하시겠습니까??") == true){
		  location.href = `/yrepair/deleteYrepair.do?reno=${repair.reno}`;
	  }else{
	      return;
	  }
}
</script>
</html>