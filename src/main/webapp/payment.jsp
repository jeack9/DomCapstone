<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
    
    <!-- 결제api 부트페이 -->
    <script src="https://cdn.bootpay.co.kr/js/bootpay-3.3.1.min.js" type="application/javascript"></script>
    <link rel="stylesheet" type="text/css" href="/css/hacademy-cinema.css">
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
                    <h1 class="display-3 text-white animated slideInDown">입사신청</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                            <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">Room</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->


    <!-- Categories Start -->
    
    <!-- Categories Start -->


    <!-- Courses Start -->
    <style>
                                    * {
                                        box-sizing: border-box;
                                    }

                                    body {
                                    	
                                    	width:100%;
                                        background-color: black;
                                    }

                                    .float-box {
                                        position:  relative;
                                        margin: 0 auto;
                                        width: 90%;
                                        text-align: center;
                                        border: 3px solid pink;
                                    }

                                    .float-box>div:not #img {
                                        /* float: left; */
                                        display: inline-block;
                                        width: 90%;

                                    }

                                    .float-box::after {
                                        content: "";
                                        display: block;
                                        clear: both;
                                    }

                                    .float-box>.result {
                                        padding: 0.5rem;
                                    }

                                    body {
                                        background-image: url("/images/tiger.png");
                                         background-repeat: no-repeat;
                                        background-position: 100% 60%;
                                        
                                    }

                                    .cinema-seat span {

                                        position: absolute;
                                        top: 60%;
                                        left: 50%;
                                        transform: translate(-50%, -50%);
                                        font-size: 27px;
                                        font-weight: 700;


                                    }

                                    .cinema-seat span:first-of-type {
                                        position: absolute;
                                        top: 40%;
                                        left: 50%;
                                        transform: translate(-50%, -50%);
                                    }

                                    .result_wrap {
                                        position:  relative;
                                        margin: 0 auto;
                                        width: 300px;
                                        height: 150px;
                                    }
                                    .result_wrap span{
                                    width: 100px;
                                    height:50px;
                                    margin: 30px 0 ;}
                                    #result {
                                        width: 100px;
                                        font-size: 25px;
                                        text-align: center;
                                        font-weight: 700;
                                        color: white;

                                    }
                                </style>
                                

                                <script src="/js/hacademy-cinema.js"></script>
     
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
#radioForm{
	text-align : center;
}
label{
font-size: 30px;
color : white;
vertical-align:top;
}

</style>
<div>
  <form id="radioForm">
    <label><input type="radio" name="radioValue" value="1" style="width:30px;height:30px;border:1px;"> 1층</label>
    <label><input type="radio" name="radioValue" value="2" style="width:30px;height:30px;border:1px;"> 2층</label>
     <label><input type="radio" name="radioValue" value="3" style="width:30px;height:30px;border:1px;">3층</label>
      <input type="hidden" id="selectedValue" value="">
  </form>
</div>
                                
<script>
  $(document).ready(function() {
    $('input[name="radioValue"]').on('change', function() {
      var selectedValue = $(this).val();
      $('#radioForm').attr('action', '/room/FloorList.do');
      $('#selectedValue').val(selectedValue);
      localStorage.setItem('selectedValue', selectedValue);
      $('#radioForm').submit();
    });
    
   var storedValue = localStorage.getItem('selectedValue'); // 로컬 스토리지에서 값 가져오기
    var selectedValue = storedValue ? storedValue : ''; // 가져온 값이 있을 경우 사용, 없을 경우 빈 문자열 사용
    $('input[name="radioValue"][value="' + selectedValue + '"]').prop('checked', true);
  });
</script>
    							<div class="float-box">
                                    <div id="reloadDiv">
                                        <form id="roomForm" name="roomForm" method="get" action="/room/updateRoom.do"
                                            accept-charset="utf-8">
                                            <input type="hidden" name="selectedValue" id="selectedValue"
                                                value="${selectedValue}" />
                                            <div id="cinema" class="cinema-wrap" data-name="">
                                                <!-- manager 관리자, client 고객, rowsize 열, colsize 행, fill : manual 수동, auto 자동 -->
                                                <div class="cinema-seat-area" data-rowsize="3" data-colsize="17"
                                                    data-mode="client" data-fill="client" data-seatno="visible"
                                                    data-choice="single">
                                                    <c:forEach var="room" items="${resultList}" varStatus="status">
                                                     
														
                                                        <div class="cinema-seat" data-state="${room.state}"
                                                            data-row="${room.row}" data-col="${room.col}"
                                                            data-num="${room.num}" data-people="${room.people}"
                                                            data-hosu="${room.roomno}" data-floor="${room.floor}"></div>
                                                         
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </form>
                                        

                                    </div>

                                </div>
  
    <!-- Courses End -->

<% 
//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//Date now = new Date();
//String now_dt = format.format(now);
%>

<style>
	form#payfrm > div { margin: 10px; }
</style>

<script>
function payCheck() {
	  //실제 복사하여 사용시에는 모든 주석을 지운 후 사용하세요
	  BootPay.request({
	      price: '1000', //실제 결제되는 가격
	 
	      // 관리자로그인 -> 결제설치 -> 인증키 및 보안 -> WEB Application ID
	      application_id: "6443c41b755e27001ce57da5",
	 
	      name: '기숙사 방 결제', //결제창에서 보여질 이름
	      pg: 'nicepay',
	      method: '', //결제수단, 입력하지 않으면 결제수단 선택부터 화면이 시작합니다.
	      show_agree_window: 0, // 부트페이 정보 동의 창 보이기 여부
	      items: [
	          {
	              item_name: '나는 아이템', //상품명
	              qty: 1, //수량
	              unique: '123', //해당 상품을 구분짓는 primary key
	              price: 1000, //상품 단가
	          }
	      ],
	      order_id: '고유order_id_1234', //고유 주문번호로, 생성하신 값을 보내주셔야 합니다.
	  }).error(function (data) {
	      //결제 진행시 에러가 발생하면 수행됩니다.
	      alert('결제 에러 발생');
	      console.log(data);
	  }).cancel(function (data) {
	      //결제가 취소되면 수행됩니다.	      
	      console.log(data);
	  }).close(function (data) {
	      // 결제창이 닫힐때 수행됩니다. (성공,실패,취소에 상관없이 모두 수행됨)
	      console.log(data);
	  }).done(function (data) {
	      //결제가 정상적으로 완료되면 수행됩니다
	      //비즈니스 로직을 수행하기 전에 결제 유효성 검증을 하시길 추천합니다.
	      document.payfrm.submit();
	      alert('결제 정상 완료');
	      console.log(data);
	  });
}
function loginCheck(){
	alert("로그인해주세요");
}
</script>

    <!-- Testimonial Start -->
   		<div style="text-align:center;">
            <!-- <form  method="post" action="/room/updateRoom.do"> -->
   			<form name="payfrm"  method="post" action="/room/updateRoom.do">
                                            <div class="result_wrap">
                                                <span  class="result" id="result" name="result" value="">
                                                </span>
                                                <input type="hidden" name="value" id="input" value="">
                                                <input type="hidden" name="payment" value="1000">
                                                 <input type="hidden" name="floor" id="floor" value="">
												<c:if test="${!empty sessionScope.loginedUserVO }">
                                                <button type="button" onclick="payCheck()">예약하기</button>
                                                <!--<button type="submit">예약하기</button>-->
                                                </c:if>
                                                <c:if test="${empty sessionScope.loginedUserVO }">
                                                <button type="button" onclick="loginCheck()">예약하기</button>
                                                
                                                </c:if>
                                                
                                            </div>
                                        </form>
                                         
                                        
   		</div>
        
   		<script>
                                    var activeSeat;
                                    var names;
                                   
                                    window.addEventListener("load", function () {

                                        var cinema = new Hacademy.Reservation("#cinema");
                                        cinema.addChangeListener(function (seat) {
                                            print(this);
                                        });
                                        print(cinema);
                                        function print(app) {
                                            activeSeat = app.getQueryString();
                                            names = activeSeat?.split('=', 1);
                                            document.querySelector("#result").textContent = names;

                                            $('#input').val(names);
                                             var storedValue = localStorage.getItem('selectedValue'); // 로컬 스토리지에서 값 가져오기
                                             var selectedValue = storedValue ? storedValue : ''; // 가져온 값이 있을 경우 사용, 없을 경우 빈 문자열 사용
                                             $('#floor').val(selectedValue);
                                        }


                                    });


                                </script>
                                <script src="https://code.jquery.com/jquery-3.6.0.slim.js"
                                    integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY="
                                    crossorigin="anonymous"></script>
    <!-- Testimonial End -->
        

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