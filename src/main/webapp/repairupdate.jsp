<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="egovframework.yrepair.service.YrepairVO" %>
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
    .row{
        display: flex;        
        border-bottom: 1px solid #c9c9c9;
    }
    .item1{
        flex-grow: 1;  
        flex-basis: 0;
        background: #e8eef6;
        padding: 10px 20px;
        display: flex;
        align-items: center;
    }
    .item2{
        flex-grow: 7;
        flex-basis: 0;
        padding: 10px;
    }
    .item2 > input {
        width: 20%;
        height: 25px;
        padding: 5px 10px;
        font-size: 15px;      
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
    YrepairVO repair = (YrepairVO)request.getAttribute("repair");
    %>
    <!-- 테스트게시판  Start-->
    <div class="wow fadeInUp container-xxl py-5" data-wow-delay="0.1s">
    <form action="/yrepair/updateYrepair.do?reno=${repair.reno}" name="yrepairfrm" >
    <div id="main-container" style="padding: 0 12px; border-top: 2px solid black;">
        <div class="row">
            <div class="item1">호실</div>
            <div class="item2"><input type="text" id="roomnum" name="roomnum" placeholder="호실" value="${repair.roomnum}" required></div>
        </div>
        <div class="row">
            <div class="item1">제목</div>
            <div class="item2"><input type="text" name="subject" placeholder="제목" value="${repair.subject}" required></div>
        </div>
        <div class="row">
            <div class="item1">작성자</div>
            <div class="item2"><input type="text" name="writer" placeholder="작성자" value="${repair.writer}" required></div>
        </div>
        <div class="row" style="display: flex;">
            <div class="item1">학번</div>
            <div class="item2"><input type="text" name="userid" value="${repair.userid}" readonly></div>
        </div>
        <div class="row">
            <div class="item1">문의내용</div>
            <div class="item2">
                <textarea name="content" id="" style="padding: 10px; min-height: 250px; width: 80%;">${repair.content}</textarea>
            </div>
        </div>
    </div>
    <div class="g-recaptcha" 
    data-sitekey="6Lcz6I0mAAAAAFztdEQSItVU0AtvQlNXt4C7U8Ri" style="display: flex;
    justify-content: center;
    padding-top: 20px;">
    </div>
    <div style="text-align: center; padding-top: 20px;">
        <button type="submit" id="submit_btn" class="btn btn-primary" style="padding: 10px 30px;">수정</button>
        <button type="button" class="btn btn-outline-primary" onclick="location.href='/yrepair/YrepairList.do';" style="padding: 10px 30px;">목록</button>
    </div>
    </form>
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
    
    <!-- 리캡챠  -->
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    
    <!-- DATATABLE 라이브러리 -->  
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>

    <!-- Template Javascript -->
    <script src="/js/main.js"></script>
	
</body>
<script>
	let validation = false;
	const roomNumValidation = () =>{
		const roomNum = document.querySelector("#roomnum").value;		
		const onlyNumber = /^[0-9]+$/.test(roomNum);
        return onlyNumber;
	}
/* 	$("#").click(function() {
        $.ajax({
            url: '/yrepair/VerifyRecaptcha.do',
            type: 'post',
            data: {
                recaptcha: $("#g-recaptcha-response").val()
            },
            success: function(data) {
                switch (data) {
                    case 0:
                    	validation = true;      
                        alert("자동 가입 방지 봇 통과");
                    	yrepairfrm.submit();
                        break;

                    case 1:
                        alert("자동 가입 방지 봇을 확인 한뒤 진행 해 주세요.");
                        break;

                    default:
                        alert("자동 가입 방지 봇을 실행 하던 중 오류가 발생 했습니다. [Error bot Code : " + Number(data) + "]");
                        break;
                }
                return validation;
            }
        });
    }); */
</script>
</html>