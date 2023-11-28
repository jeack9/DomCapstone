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
    
    
<script>

var certicode = "";
function usercheck(){
	var username = document.getElementById('form2Example7').value;//이름
	  var id = document.getElementById('form2Example17').value;//아이디(학번)
	  var phone = document.getElementById('form2Example27').value;//휴대폰

	  if(username.length <1) {//이름 썼는지 확인
		    alert('이름을 입력해주세요.');
		    document.getElementById('form2Example7').focus();
		    return false;
		}
	  
	  if(id.length <1) {//아이디(학번) 썼는지 확인
	    alert('학번을 입력해주세요.');
	    document.getElementById('form2Example17').focus();
	    return false;
	  }

	  if(phone.length <1) {//휴대폰 썼는지 확인
	    alert('휴대폰번호를 입력해주세요.');
	    document.getElementById('form2Example27').focus();
	    return false;
	  }

	  $.ajax({
	       url:'/yuser/findYuserPw.do', //request 보낼 서버의 경로
	       type:'post', // 메소드(get, post, put 등)
	       data:{'userphone': phone, 'userid': id, 'username': username}, //보낼 데이터 id=1
	       dataType: "json",
	       success: function(data) {
	           //서버로부터 정상적으로 응답이 왔을 때 실행
	            objData = data;
	           //alert("정상수신 , result = "+data.searchedVO);
	          //alert("id = "+data.searchedVO.id);
	           //alert("userid = "+data.searchedVO.userid);
	           //alert("userpw = "+data.searchedVO.userpw);
	        alert("휴대폰으로 인증번호를 발송하였습니다.");   
	        certicode = data.findVO;
	        
	        const target = document.getElementById('form2Example37');
	        target.disabled = true;
	        
	        const target2 = document.getElementById('form2Example57');
	        target2.disabled = false;
	        
	        document.getElementById('form2Example7').readOnly = true;
	        document.getElementById('form2Example17').readOnly = true;
	        document.getElementById('form2Example27').readOnly = true;
	        
	        document.getElementById('form2Example47').focus();
	        
	       },
	       error: function(err) {
	           //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
	           objErr = err;
	          //alert("오류발생 , error="+err.state());
	          alert("가입하신 정보를 찾을 수 없습니다.");
	       }
	   });
}


//휴대폰 인증번호 대조
function certicheck(){
	if(document.getElementById('form2Example47').value == certicode) {
		alert('인증성공');		
		document.memberloginfrm.action="/findpw2.jsp";
		document.memberloginfrm.submit();
		
	}
	else {
		alert('인증실패');
	}	
}



</script>

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



	
	
	
	
	
	
	
	
	
	
	<section class="vh-100" style="background-color: #181D38;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
            <div class="col-md-6 col-lg-5 d-none d-md-block">
              <img src="/img/gcimg.jpg"
                alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; width:100%; height:100%;" />
            </div>
            <div class="col-md-6 col-lg-7 d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black">

                <form action ="/yuser/findYuserPw.do" method="post" id="memberloginfrm" name="memberloginfrm" target="_self">

                  <div class="d-flex align-items-center mb-3 pb-1">
                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                    <span class="h1 fw-bold mb-0">비밀번호 찾기</span>
                  </div>

                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">휴대폰 번호로 본인인증후 비밀번호를 변경해 드립니다.</h5>
                  
				<div class="form-outline mb-4">
                    <input type="text" id="form2Example7" name="username" class="form-control form-control-lg" onkeydown="return event.key !== ' ';" />
                    <label class="form-label" for="form2Example7">이름</label>
                  </div>	


                  <div class="form-outline mb-4">
                    <input type="text" id="form2Example17" name="userid" class="form-control form-control-lg" onkeydown="return event.key !== ' ';" />
                    <label class="form-label" for="form2Example17">학번</label>
                  </div>

                  <!-- <div class="form-outline mb-4">
                    <input type="number" pattern="[0-9]*" id="form2Example27" name="userphone" class="form-control form-control-lg" onkeydown="return event.key !== ' ';"/>
                    <label class="form-label" for="form2Example27">휴대폰</label>
                  </div> -->
                  
                <div class="row">
                  	<div class="mb-4">
                    	<div class="form-outline">
                      		<div class="input-group">
						  		<input type="text" class="form-control" name="userphone" pattern="[0-9]*" onkeydown="return event.key !== ' ';" aria-label="" id="form2Example27" aria-describedby="form2Example37">
						  		<button class="btn btn-outline-secondary" type="button" id="form2Example37" onclick="usercheck();">인증하기</button>
							</div>
                      <label class="form-label" for="form2Example27">휴대폰(숫자만 입력)</label>
                    	</div>
                  	</div>
                </div>
                
                <div class="row">
                  	<div class="mb-4">
                    	<div class="form-outline">
                      		<div class="input-group">
						  		<input type="text" class="form-control" pattern="[0-9]*" onkeydown="return event.key !== ' ';" aria-label="" id="form2Example47" aria-describedby="form2Example57">
						  		<button class="btn btn-outline-secondary" type="button" id="form2Example57" onclick="certicheck();" disabled='disabled'>인증하기</button>
							</div>
                      <label class="form-label" for="form2Example47">인증번호</label>
                    	</div>
                  	</div>
                </div>
                </form>
                  

                  <div class="pt-1 mb-4">
                    <!-- <button class="btn btn-dark btn-lg btn-block" type="button" onclick="#">확인</button> -->
                  </div>

                  <a class="small text-muted" href="/signin.jsp">로그인 하러가기</a>
                  <p class="mb-5 pb-lg-2" style="color: #393f81;">회원이 아니신가요? <a href="/signup.jsp"
                      style="color: #393f81;">회원가입</a></p>
                  <a href="#!" class="small text-muted">Terms of use.</a>
                  <a href="#!" class="small text-muted">Privacy policy</a>
                

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

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