<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="egovframework.yuser.service.YuserVO" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
<style>
	@media screen and (min-width: 992px) {
      .hidelogbtn {
        display: none;
      }
    }
    
    @media screen and (max-width: 992px) {
      .hidelogbtn {
        display: block;
      }
    }
</style>

    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
        <a href="/main.do" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
            <!-- <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>eLEARNING</h2> -->
            <img alt="" src="/img/logo.svg">
        </a>
        <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
                <div class="nav-item dropdown">
                    <a href="" class="nav-link dropdown-toggle" style="font-weight : 700;" data-bs-toggle="dropdown">생활관 안내</a>
                    <div class="dropdown-menu fade-down m-0">
                        <a href="/greeting.jsp" class="dropdown-item">인사말</a>
                        <a href="/manager.jsp" class="dropdown-item">교직원 소개</a>
                        <a href="/ynotice/YnoticeList.do" class="dropdown-item">공지사항</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="" class="nav-link dropdown-toggle" style="font-weight : 700;" data-bs-toggle="dropdown">생활관 소개</a>
                    <div class="dropdown-menu fade-down m-0">
                        <a href="/facility.jsp" class="dropdown-item">부대 시설</a>
                        <a href="/WebGL.jsp" class="dropdown-item">생활관 둘러보기</a>
                        <a href="/contact.jsp" class="dropdown-item">오시는 길</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="" class="nav-link dropdown-toggle" style="font-weight : 700;" data-bs-toggle="dropdown">커뮤니티</a>
                    <div class="dropdown-menu fade-down m-0">
                        <a href="/yfreeboard/YfreeboardList.do" class="dropdown-item">자유게시판</a>
                        <a href="/yrepair/YrepairList.do" class="dropdown-item">수리접수</a>
                    </div>
                </div>
                
                <a href="/room/FloorList.do?radioValue=1" style="font-weight : 700;" class="nav-item nav-link">입사신청</a>		                           
                <c:if test="${empty sessionScope.loginedUserVO }">
                 <a href="/signin.jsp" style="font-weight : 700;" class="nav-item nav-link hidelogbtn">로그인</a>		            
                	<a href="/signin.jsp" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">로그인<i class="fa fa-arrow-right ms-3"></i></a>
                	<!-- <a href="/signin.jsp" class="nav-item nav-link" style="background-color: #06BBCC; color: white;">&nbsp;&nbsp;로그인<i class="fa fa-arrow-right ms-3"></i></a> -->
                </c:if>
                <c:if test="${!empty sessionScope.loginedUserVO }">
	                <div class="nav-item dropdown">
		                <a href="" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" style="font-weight:700" >${loginedUserVO.username}님 
		                <img src="/${loginedUserVO.appendix}" style="border-radius : 50%" width="22px" height="22px" /></a>
		                <div class="dropdown-menu fade-down m-0">
		                    <a href="/editProfile.jsp" class="dropdown-item">회원 정보수정</a>	
		                    <a href="/ypoint/YpointList.do?userid=${loginedUserVO.userid}" class="dropdown-item">상 벌점 조회</a>	
		                    <a href="/ysleepover/YsleepoverList.do" class="dropdown-item">외출/외박 신청</a>	
		                </div>	
	                </div>
	                <a href="/logout.jsp" style="font-weight : 700;" class="nav-item nav-link hidelogbtn">로그아웃</a>
                	<%-- <a class="nav-item nav-link" style="font-weight:700">${loginedUserVO.username}님</a> --%>
                	<a href="/logout.jsp" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">로그아웃<i class="fa fa-arrow-right ms-3"></i></a>
                </c:if>                
            </div>                   
        </div>
    </nav>
    <!-- Navbar End -->
</body>
</html>