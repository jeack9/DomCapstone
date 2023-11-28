<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet">
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
                    <h1 class="display-3 text-white animated slideInDown">인사말</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                            <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">인사말</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->

    <!-- Service Start -->   
    <!-- Service End -->

    <!-- About Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-5">
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s" style="min-height: 400px;">
                    <div class="position-relative h-100">
                        <img class="img-fluid position-absolute w-100 h-100" src="/img/greeting.jpg" alt="" style="object-fit: cover;">
                    </div>
                </div>
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
                    <h6 class="section-title bg-white text-start text-primary pe-3">인사말</h6>
                    <h1 class="mb-4">글로벌생활관에 오신 것을 환영합니다!</h1>
                    <p class="mb-4">21세기 기술경쟁시대를 주도할 우리 대학교는 주문식교육의 산실로서 대학 교육을 선도하는 최우수 전문대학교로서의 명예와 자부심을 가지고 있습니다. 큰 비전과 이상을 품에 안은 여러분들을 우리 대학교 생활관(기숙사)에 입주하게 된 것을 무척 기쁘게 생각합니다.</p>
                    <p class="mb-4">미래는 준비된 이들의 몫입니다. 현실에 안주하지 않고 철저한 자기계발과 성숙된 자세로 미래를 설계한다면 여러분의 꿈은 머지않아 이루어질 것입니다. 우리 대학교 생활관(기숙사)에서 여러분들의 꿈과 이상을 실현할 수 있도록 최선을 다해 주시기 바랍니다.<br>학생복지취업처장 김 수 용
                    </p>
                    <div class="row gy-2 gx-4 mb-4">
                        <div class="col-sm-6" onclick="location.href='/facility.jsp'">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>부대시설 둘러보기</p>
                        </div>
                        <div class="col-sm-6" onclick="location.href='/WebGL.jsp'">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>생활관 둘러보기</p>
                        </div>
                        <div class="col-sm-6" onclick="location.href='/contact.jsp'">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>오시는 길</p>
                        </div>
                        <div class="col-sm-6" onclick="location.href='/room/FloorList.do?radioValue=1'">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>생활관 입사신청</p>
                        </div>
                        <div class="col-sm-6" onclick="location.href='/ynotice/YnoticeList.do'">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>공지사항</p>
                        </div>
                        <div class="col-sm-6" onclick="location.href='/manager.jsp'">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>교직원 소개</p>
                        </div>
                    </div>
                    <a class="btn btn-primary py-3 px-5 mt-2" href="/signup.jsp">회원가입</a>
                </div>
            </div>
        </div>
    </div>
    <!-- About End -->


    <!-- Team Start -->    
    <!-- Team End -->
        

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

    <!-- Template Javascript -->
    <script src="/js/main.js"></script>
</body>

</html>