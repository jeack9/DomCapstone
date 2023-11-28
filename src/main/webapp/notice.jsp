<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="egovframework.yfreeboard.service.YfreeboardVO" %>
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
                    <h1 class="display-3 text-white animated slideInDown">공지사항</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                            <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">공지사항</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->
        
    <!-- 테스트게시판  Start-->
    <div class="wow fadeInUp container-xxl py-5" data-wow-delay="0.1s">
    	<c:if test="${!empty sessionScope.loginedUserVO }">
    	<c:if test="${sessionScope.loginedUserVO.admin >= 1 }">
    	<div style="text-align:right;"><button class="btn btn-primary" type="button" onclick="location.href='/noticeform.jsp'">글쓰기</button></div>
    	</c:if>
    	</c:if>
    	<table id="freeboard-table" class="table" style="width:100%">
    		<thead>
	  		<tr>
		      <th>번호</th>
		      <th>제목</th>
		      <th>글쓴이</th>
		      <th>작성일</th>
		      <th>조회수</th>
	  		</tr>
	  		</thead>
	  		<tbody>
	  		<c:forEach var="notice" items="${noticeList}">
	  		<tr>
	  			
	  				<td>${notice.id }</td>
				    <td onclick="location.href='/ynotice/selectYnotice.do?id=${notice.id}'" style="cursor:pointer;">${notice.subject}</td>
				    <td>${notice.writer} </td>
				    <td>${notice.regdate.split(" ")[0] }</td>		
				    <td>${notice.visitors}</td>  	
	  		</tr>
	  		</c:forEach>
	  		</tbody>
  		</table>
  		
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
$(document).ready( function () {
    $('#freeboard-table').DataTable({
        responsive : true,
        ordering: true,
        language: {
            url: '/js/ko.json',
        },
        "lengthMenu": [ [5, 10, 20, -1], ["5줄 보기", "10줄 보기", "20줄 보기", "모두 보기"]],
        "lengthChange": true, 
        "pageLength": 10, // 디폴트 레코드 개수
        // "info": false, //좌측 아래 요약정보
        "pagingType": "full_numbers",
        "pagingTag": 'button',
        "ordering": false,
        "columnDefs": [
            { "width": "40%", "targets": 1 },
            { "width": "5%", "targets": 4 },
        ]
    });
} );
</script>

</html>