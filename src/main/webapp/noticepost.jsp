<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="egovframework.ynotice.service.YnoticeVO"%>
<%@ page import="egovframework.time.Time"%>
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
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="/lib/animate/animate.min.css" rel="stylesheet">
<link href="/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="/css/style.css" rel="stylesheet">

<!-- comment Stylesheet -->
<link href="/css/comment.css" rel="stylesheet">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />

<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" />


<script src="https://kit.fontawesome.com/bbfc782959.js"
	crossorigin="anonymous"></script>
</head>

<body>
	<!-- Spinner Start -->
	<div id="spinner"
		class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
		<div class="spinner-border text-primary"
			style="width: 3rem; height: 3rem;" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>
	<!-- Spinner End -->


	<!-- Navbar Start -->
	<%@ include file="/navbar.jsp"%>
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

	<%
		try {
		YnoticeVO notice = (YnoticeVO) request.getAttribute("notice");
	} catch (Exception e) {
		System.out.println("에러 발생" + e.getMessage());
	}
	%>
	<div class="container mt-5" style="padding-bottom : 50px;">
		<div class="row">
			<div class="col-lg-8">
				<!-- Post content-->
				<article>
					<!-- Post header-->
					<header class="mb-4">
						<!-- Post title-->
						<h1 class="fw-bolder mb-1">${notice.subject}</h1>
						<!-- Post meta content-->
						<div class="text-muted fst-italic mb-2">
							등록날짜 : ${notice.regdate}
							<c:if test="${notice.moddate != null}">
								수정날짜 : ${notice.moddate}
							</c:if>
						</div>
						<!-- Post categories-->
						<c:if test="${!empty sessionScope.loginedUserVO }">
							<c:if test="${sessionScope.loginedUserVO.admin >= 1}">
								<a class="badge bg-secondary text-decoration-none link-light"
									href="/ynotice/getNoticeInform.do?id=${notice.id}">수정하기</a>
								<a class="badge bg-secondary text-decoration-none link-light"
									href="/ynotice/deleteYnotice.do?id=${notice.id}">삭제하기</a>
							</c:if>
						</c:if>
					</header>
					<!-- Preview image figure-->
					<div id="content-div" style="min-height : 450px;">
						<figure class="mb-4"></figure>
						<section class="mb-5">${notice.content}</section>
					</div>
				</article>

			</div>
			<!-- Side widgets-->
			<div class="col-lg-4">
				<!-- Search widget-->
				<div class="card mb-4">
					<div class="card-header">Search</div>
					<div class="card-body">
						<div class="input-group">
							<input class="form-control" type="text"
								placeholder="Enter search term..."
								aria-label="Enter search term..."
								aria-describedby="button-search" />
							<button class="btn btn-primary" id="button-search" type="button">Go!</button>
						</div>
					</div>
				</div>
				<!-- Categories widget-->
				<div class="card mb-4">
					<div class="card-header">Categories</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<ul class="list-unstyled mb-0">
									<li><a href="#!">Web Design</a></li>
									<li><a href="#!">HTML</a></li>
									<li><a href="#!">Freebies</a></li>
								</ul>
							</div>
							<div class="col-sm-6">
								<ul class="list-unstyled mb-0">
									<li><a href="#!">JavaScript</a></li>
									<li><a href="#!">CSS</a></li>
									<li><a href="#!">Tutorials</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- Side widget-->
				<div class="card mb-4">
					<div class="card-header">Side Widget</div>
					<div class="card-body">You can put anything you want inside
						of these side widgets. They are easy to use, and feature the
						Bootstrap 5 card component!</div>
				</div>
			</div>
		</div>
	</div>





		<!-- Footer Start -->
		<%@ include file="/footer.jsp"%>
		<!-- Footer End -->


		<!-- Back to Top -->
		<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
			class="bi bi-arrow-up"></i></a>


		<!-- JavaScript Libraries -->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
		<script src="/lib/wow/wow.min.js"></script>
		<script src="/lib/easing/easing.min.js"></script>
		<script src="/lib/waypoints/waypoints.min.js"></script>
		<script src="/lib/owlcarousel/owl.carousel.min.js"></script>



		<!-- Template Javascript -->
		<script src="/js/main.js"></script>
</body>

</html>