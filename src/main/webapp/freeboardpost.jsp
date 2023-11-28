<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="egovframework.yfreeboard.service.YfreeboardVO"%>
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
	<%@ include file="/navbar.jsp" %>
	<!-- Navbar End -->


	<!-- Header Start -->
	<div class="container-fluid bg-primary py-5 mb-5 page-header">
		<div class="container py-5">
			<div class="row justify-content-center">
				<div class="col-lg-10 text-center">
					<h1 class="display-3 text-white animated slideInDown">기숙사
						자유게시판</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb justify-content-center">
							<li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
							<li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
							<li class="breadcrumb-item text-white active" aria-current="page">기숙사
								자유게시판</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- Header End -->



	<!-- 테스트게시판 글 상세보기  Start-->
	<!-- <div style="text-align:center;">    
        <div>제목 글쓴이 작성일</div>
        <div><p>내용</p></div>
        <div>추천수</div>
        <div>목록가기</div>
    </div> -->

	<style>
div#gallerypostdiv {
	border: 0px solid red;
	padding-left: 10px;
	width: 99.9%;
	height: 80%;
}

div#posttitle {
	font-weight: bold;
	font-size: 2em;
	height: 5%;
}

div#postdate {
	font-size: 0.9em;
	height: 5%;
}

div.posthrdiv {
	height: 1%;
}

div#postcontent {
	font-size: 1.5em;
	width: 99.9%;
	height: 75%;
	border: 0px solid blue;
}

div#postcontent>img {
	max-width: 100%;
	height: auto;
}

div#postcontent>p {
	height: 50%;
	padding: 2px;
}

div#postcontentbtn {
	text-align: center;
	margin-bottom: 10px;
}

div#postcontentbtn>button {
	margin-left: 3px;
	height: 99.9%;
	width: 3%;
}

div#postcontentbtn>i {
	font-size: 3em;
}

div#postcontentbtn>i:hover {
	cursor: pointer;
}

div#postunderbtn {
	margin-top: 20px;
	text-align: center;
	border: 0px solid red;
	height: 6%;
}

div#postunderbtn>button {
	height: 100%;
	width: 5%;
}
</style>
	<script>
		function loginPlz() {
			alert("비회원은 추천 기능을 이용할 수 없습니다. 로그인을 해주세요.");
		}

		function likeClick(id) {//개추 누르면 호출

			$.ajax({
				url : '/ylikes/selectYlikes.do', //request 보낼 서버의 경로
				type : 'post', // 메소드(get, post, put 등)
				data : {
					'bno' : id
				}, //보낼 데이터 id=1
				dataType : "json",
				success : function(data) {
					//서버로부터 정상적으로 응답이 왔을 때 실행
					objData = data;
					//alert("정상수신 , result = "+data.searchedVO);
					//alert("id = "+data.searchedVO.id);
					//alert("userid = "+data.searchedVO.userid);
					//alert("userpw = "+data.searchedVO.userpw);     
					$('#likesDiv').text(data.searchedVO.likes);

				},
				error : function(err) {
					//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
					objErr = err;
					//alert("오류발생 , error="+err.state());
					alert("에러뜸 ㅅㄱ");
				}
			});
		}
	</script>

	<%
		try {
		YfreeboardVO selectedVO = (YfreeboardVO) request.getAttribute("selectedVO");

		System.out.println("널인가요??" + selectedVO == null);
	} catch (Exception e) {
	}
	%>

	<%-- <div style="text-align:center;">
    <div id="posttitle">제목 : ${selectedVO.subject}</div>
    <div id="postdate">${selectedVO.regdate}&nbsp;&nbsp;| ${selectedVO.writer}</div>
    <div class="posthrdiv"><hr></div>
    <div id="postcontent">
        <p>${selectedVO.content}</p>
    </div>
    <div id="postcontentbtn">
        <i class="fa-solid fa-star" onclick="likeClick('${selectedVO.bno}');"></i>
    </div>
    <div style="font-size:2em;" id="likesDiv">${selectedVO.likes}</div>
    <div class="posthrdiv"><hr></div>
    <div id="postunderbtn">
        <button onclick="location.href='/yfreeboard/YfreeboardList.do'">목록</button>
    </div>
</div> --%>

	<div class="container mt-5" style="padding-bottom : 50px;">
		<div class="row">
			<div class="col-lg-8">
				<!-- Post content-->
				<article>
					<!-- Post header-->
					<header class="mb-4">
						<!-- Post title-->
						<h1 class="fw-bolder mb-1">${selectedVO.subject}</h1>
						<!-- Post meta content-->
						<div class="text-muted fst-italic mb-2">
							등록날짜 : ${selectedVO.regdate}
							<c:if test="${selectedVO.moddate != null}">
								수정날짜 : ${selectedVO.moddate}
							</c:if>
						</div>
						<!-- Post categories-->
						<c:if test="${!empty sessionScope.loginedUserVO }">
							<c:if test="${selectedVO.userid == loginedUserVO.userid}">
								<a class="badge bg-secondary text-decoration-none link-light"
									href="/yfreeboard/getFreeBoardInform.do?bno=${selectedVO.bno}">수정하기</a>
								<a class="badge bg-secondary text-decoration-none link-light"
									href="/yfreeboard/deleteYfreeboard.do?bno=${selectedVO.bno}">삭제하기</a>
							</c:if>
						</c:if>
					</header>
					<!-- Preview image figure-->
					<div id="content-div" style="min-height : 450px;">
						<figure class="mb-4"></figure>
						<section class="mb-5">${selectedVO.content}</section>
					</div>
				</article>
				<div id="postcontentbtn">
					<c:if test="${!empty sessionScope.loginedUserVO }">
						<i class="fa-solid fa-star"
							onclick="likeClick('${selectedVO.bno}');"></i>
					</c:if>
					<c:if test="${empty sessionScope.loginedUserVO }">
						<i class="fa-solid fa-star" onclick="loginPlz();"></i>
					</c:if>
				</div>
				<div style="font-size: 2em; text-align: center;" id="likesDiv">${selectedVO.likes}</div>



				<div class="container" style="width: 100%">
					<div
						class="row height d-flex justify-content-center align-items-center">
						<div class="col-md">
							<div class="card">
								<div class="p-3">
									<h6>Comments</h6>
								</div>

								<!-- 입력창 -->
								<div
									class="mt-3 d-flex flex-row align-items-center p-3 form-color">
									<c:if test="${loginedUserVO != null}">
									<img src="/${loginedUserVO.appendix}" width="50" height="50"
										class="rounded-circle mr-2" />
									</c:if>
									<c:if test="${loginedUserVO == null}">
									<img src="/uploads/yger.png" width="50" height="50"
										class="rounded-circle mr-2" />
									</c:if>
									<form style="width: 100%" action="/ycomment/addYcomment.do">
										<div class="input-group">
											<c:if test="${!empty sessionScope.loginedUserVO }">
											<input type="text" name="content" class="form-control"
												placeholder="답글창이에요!" /> <input
												name="bno" value="${selectedVO.bno}" style="display: none;" />

											<input name="userid" value="${loginedUserVO.userid}"
												style="display: none;" />
												<div class="input-group-prepend">
												<button class="btn btn-outline-secondary"
													style="height: 100%;" type="submit">답글달기</button>
											</div>
											</c:if>
											
											<c:if test="${empty sessionScope.loginedUserVO }">
												<input type="text" name="content" class="form-control"
												placeholder="회원만 됩니다..." disabled/>
												<div class="input-group-prepend">
												<button class="btn btn-outline-secondary"
													style="height: 100%;" type="button">답글달기</button>
											</div>
											</c:if>
											

										</div>
									</form>
								</div>
								<!-- 입력창끝 -->
								<div class="mt-2">
									<c:forEach var="comments" items="${commentList}">
										<div class="d-flex flex-row p-3"
											style="margin-left: ${comments.reLevel * 72}px; margin-right: ${comments.reLevel * 16}px">
											<img src="/${comments.appendix}" width="40" height="40"
												class="rounded-circle mr-3" />
											<div class="w-100">
												<div
													class="d-flex justify-content-between align-items-center">
													<div class="d-flex flex-row align-items-center">
														<span class="mr-2"> ${comments.username} </span> <small
															class="c-badge">컴퓨터정보계열</small>
													</div>
													<small>${Time.makeDate(comments.regdate)}</small>
												</div>
												<p class="text-justify comment-text mb-0">
													<c:if test="${comments.isremove > 0}">
														<span style="color: gray">[삭제된 댓글 입니다]</span>
													</c:if>
													<c:if test="${comments.isremove == 0}">
													${comments.content}
												</c:if>
												</p>
												<div class="d-flex flex-row user-feed">


													<c:if test="${comments.isremove == 0}">
														<c:if test="${loginedUserVO.userid == comments.userid}">
															<span class="edit mr-3" cno="${comments.cno}"><i
																class="fa fa-edit mr-2"></i>수정</span>
															<span class="mr-3 remove" cno="${comments.cno}"><i
																class="fa fa-trash mr-2"></i>삭제</span>
														</c:if>
													</c:if>
													<c:if test="${loginedUserVO != null}">
														<c:if test="${comments.reLevel == 0}">
														<span cno="${comments.cno}" class="mr-3 reply"><i
															class="fa fa-comment mr-2"></i>답글</span>
															</c:if>
													</c:if>
												</div>
												<!-- 답글 창 -->
												<div
													class="mt-3 d-flex flex-row align-items-center p-3 form-color inputdivs"
													style="display: none !important"
													id="replydiv${comments.cno}">
													<img src="/${loginedUserVO.appendix}" width="50" height="50"
														class="rounded-circle mr-2" />
													<form style="width: 100%" action="/ycomment/addReply.do">
														<div class="input-group">

															<input type="text" name="content" class="form-control"
																placeholder="답글창이에요!" /> <input name="ref"
																value="${comments.ref}" style="display: none;" /> <input
																name="bno" value="${selectedVO.bno}"
																style="display: none;" />
															<c:if test="${!empty sessionScope.loginedUserVO }">
															<input name="userid" value="${loginedUserVO.userid}"
																style="display: none;" />
															</c:if>
															<div class="input-group-prepend">
																<button class="btn btn-outline-secondary"
																	style="height: 100%;" type="submit">답글달기</button>
															</div>

														</div>
													</form>
												</div>
												<!-- 답글창 끝 -->
												<!-- 수정 창 -->
												<div
													class="mt-3 d-flex flex-row align-items-center p-3 form-color inputdivs"
													style="display: none !important"
													id="editdiv${comments.cno}">
													<img src="/${loginedUserVO.appendix}" width="50" height="50"
														class="rounded-circle mr-2" />
													<form action="/ycomment/updateYcomment.do"
														style="width: 100%">
														<div class="input-group">

															<input type="text" name="content" class="form-control"
																placeholder="수정창이에요!" /> <input name="cno"
																value="${comments.cno}" style="display: none;" />
															<div class="input-group-prepend">
																<button class="btn btn-outline-secondary"
																	style="height: 100%;" type="submit">수정하기</button>
															</div>

														</div>
													</form>
												</div>
												<!-- 수정 끝 -->
											</div>
										</div>
									</c:forEach>

									<!-- <nav aria-label="...">
										<ul class="pagination pagination-sm justify-content-center">
											<li class="page-item disabled"><a class="page-link"
												href="#" tabindex="-1">1</a></li>
											<li class="page-item"><a class="page-link" href="#">2</a></li>
											<li class="page-item"><a class="page-link" href="#">3</a></li>
										</ul>
									</nav> -->
								</div>
							</div>
						</div>
					</div>
				</div>

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
	<%@ include file="/footer.jsp" %>
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

	<script>
		$("#content-div p").addClass("fs-5");
		$("#content-div p").addClass("mb-4");

		$('.showReplyWindow').click(function() {
			var target = "replydiv" + $(this).attr("cno");
			if ($("#" + target).css("display") == 'block') {
				$("#" + target).css("display", "none");
			} else {
				$("#" + target).css("display", "block");
			}

		});

		$('.showUpdateWindow').click(function() {
			var target = "updatediv" + $(this).attr("cno");
			if ($("#" + target).css("display") == 'block') {
				$("#" + target).css("display", "none");
			} else {
				$("#" + target).css("display", "block");
			}

		});

		$('.reply').click(function() {

			var cno = $(this).attr("cno");
			var target = "replydiv" + cno;

			if ($("#" + target).attr("style") == 'display: none !important') {
				$(".inputdivs").attr("style", 'display: none !important');
				$("#" + target).attr('style', 'display: block');
			} else {
				$("#" + target).attr('style', 'display: none !important');

			}

		});

		$('.edit').click(function() {

			var cno = $(this).attr("cno");
			var target = "editdiv" + cno;

			if ($("#" + target).attr("style") == 'display: none !important') {
				$(".inputdivs").attr("style", 'display: none !important');
				$("#" + target).attr('style', 'display: block');

			} else {
				$("#" + target).attr('style', 'display: none !important');

			}

		});

		$('.remove').click(function() {
			var cno = $(this).attr("cno");
			var delConfirm = confirm('삭제 하시겠습니까?');
			if (delConfirm) {
				location.href = '/ycomment/deleteYcomment.do?cno=' + cno;
			}

		});
	</script>
</body>

</html>