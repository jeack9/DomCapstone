<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="egovframework.ysleepover.service.YsleepoverVO" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>eLEARNING - eLearning HTML Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">

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
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="/css/style.css" rel="stylesheet">
<style>
	.notsign{
		color:red;
	}
	
	.sign{
		color:blue;
	}
</style>
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
					<h1 class="display-3 text-white animated slideInDown">외출 / 외박 신청</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb justify-content-center">
							<li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
							<li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
							<li class="breadcrumb-item text-white active" aria-current="page">Contact</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- Header End -->


	<!-- Contact Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<!-- Account details card-->

			<div class="card mb-4">
				<div class="card-header">규정</div>
				<div class="card-body">
					<p>
						1. 추가 버튼을 클릭한 후, 외출/외박 신청 내역을 입력을 하고 저장을 클릭합니다. <br /> 2. 외출 외박
						이력 및 승인에서 입력내용을 확인합니다.<br /> 3. 수정 및 삭제가 불가능합니다.<br /> 4. 외출시
						23시 50분까지 입실 완료해야 한다. (23시 50분이 넘는 경우는 무조건 무단외박 벌점이 부여됩니다.)<br />
						5. 귀가 예정일은 점호를 받는 날짜를 기재한다.
					</p>
				</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">외출 / 외박 신청</div>
				<div class="card-body">
					<form action="/ysleepover/addYsleepover.do" method="post" name="updatefrm">
						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" disabled name="applicant" id="floatingInput" value="<c:out value="${loginedUserVO.username}"/>"/> 
									<input type="text" class="form-control" name="userid" id="floatingInput" style="display:none" value="<c:out value="${loginedUserVO.userid}"/>"/> 
									<label
										for="floatingInput">
										신청자</label>
								</div>
							</div>
						</div>
						<div class="row g-3">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" name="place" class="form-control" required autocomplete="off"
										 /> <label
										for="floatingInput">외출/외박 장소</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input required type="text" name="startdate" class="form-control datePicker readonly"  autocomplete="off"
										id="floatingInput" />
									<label for="floatingInput">외박 일자</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input required  type="text" name="enddate" class="form-control datePicker readonly"  autocomplete="off"
										id="floatingInput" />
									<label for="floatingInput">귀가 예정일</label>
								</div>
							</div>
						</div>
						<div class="row g-3">
							
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="phone" id="floatingInput" required autocomplete="off"
										required/> <label
										for="floatingInput">보호자 연락처</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input readonly type="text" name="applydate" class="form-control" required
										id="nowdate"/> <label
										for="floatingInput">신청일자</label>
								</div>
							</div>
						</div>
						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="reason" id="floatingInput" required autocomplete="off"
										/> <label
										for="floatingInput">사유</label>
								</div>
							</div>
						</div>
						<button class="btn btn-primary" type="submit">신청</button>
					</form>
					
				</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">신청 내역</div>
				<div class="card-body">
					<table class="table">
						<thead>
							<th>신청일자</th>
							<th>외출/외박 장소</th>
							<th>보호자 연락처</th>
							<th>사유</th>
							<th>외출/외박일자</th>
							<th>귀가예정일</th>
							<th>승인여부</th>
						</thead>
						<tbody>
							<c:forEach var="item" items="${resultList}">
								<tr>
								<td>${item.applydate}</td>
								
								<td>${item.place}</td>
								<td>${item.phone}</td>
								<td>${item.reason}</td>
								<td>${item.startdate}</td>
								<td>${item.enddate}</td>
								<c:if test="${item.issignoff > 0}">
									<td class="sign">승인</td>
								</c:if>
								<c:if test="${item.issignoff == 0}">
									<td class="notsign">미승인</td>
								</c:if>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Contact End -->


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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	
	<script>
	$(".readonly").on("input", function() {
	    $(this).val(''); // value를 빈 문자열('')로 설정
	  });
</script>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.ko.min.js"></script>
	<!-- Template Javascript -->
	<script src="/js/main.js"></script>
	<script>
      $(".datePicker")
        .datepicker({
          format: "yyyy-mm-dd", //데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
          autoclose: true, //사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
          calendarWeeks: false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
          clearBtn: false, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
          disableTouchKeyboard: false, //모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
          immediateUpdates: false, //사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false
          templates: {
            leftArrow: "&laquo;",
            rightArrow: "&raquo;",
          }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징
          showWeekDays: true, // 위에 요일 보여주는 옵션 기본값 : true
          todayHighlight: true, //오늘 날짜에 하이라이팅 기능 기본값 :false
          toggleActive: true, //이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
          weekStart: 0, //달력 시작 요일 선택하는 것 기본값은 0인 일요일
          language: "ko", //달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
        })
        .on("changeDate", function (e) {
          /* 이벤트의 종류 */
          //show : datePicker가 보이는 순간 호출
          //hide : datePicker가 숨겨지는 순간 호출
          //clearDate: clear 버튼 누르면 호출
          //changeDate : 사용자가 클릭해서 날짜가 변경되면 호출 (개인적으로 가장 많이 사용함)
          //changeMonth : 월이 변경되면 호출
          //changeYear : 년이 변경되는 호출
          //changeCentury : 한 세기가 변경되면 호출 ex) 20세기에서 21세기가 되는 순간
          console.log(e);
          // e.date를 찍어보면 Thu Jun 27 2019 00:00:00 GMT+0900 (한국 표준시) 위와 같은 형태로 보인다.
        });
     	// 현재 날짜 객체 생성
        var currentDate = new Date();
        // 연도 가져오기
        var year = currentDate.getFullYear();
        // 월 가져오기 (0부터 시작하므로 1을 더해줘야 함)
        var month = currentDate.getMonth() + 1;
        // 일 가져오기
        var day = currentDate.getDate();
		$("#nowdate").val(year + "-" + (month.length <= 1 ? month : "0" + month) + "-" + day);
    </script>
</body>

</html>