<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="egovframework.yuser.service.YuserVO" %>
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

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet">
    
    <!-- freeboardform Stylesheet (직접만든거) -->
    <link href="/css/freeboardform.css" rel="stylesheet">
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
                    <h1 class="display-3 text-white animated slideInDown">기숙사 자유게시판</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                            <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">기숙사 자유게시판</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->


    <!-- Testimonial Start -->
    
    <!-- Testimonial End -->
        
        <%YfreeboardVO selectedVO = (YfreeboardVO) request.getAttribute("selectedVO"); %>
        
    <!-- 글작성 폼  Start-->
    <div class="container-xxl py-5 text-justify">
            <div class="write-main">
              <div>
                <span>제목${inform.subject}</span><input id="titleInput" value="${selectedVO.subject}"  style="width: 80%" type="text" />
              </div>
              <div>
                <span>내용</span>
                <textarea
                	
                  name="writearea"
                  id="writearea"
                  cols="30"
                  rows="10"
                >
                ${selectedVO.content}
                </textarea>
              </div>
            </div>
            <div style="text-align : center; margin-top:20px">
            <button class="btn btn-primary" onclick="updateBoard()">수정하기</button>
            </div>
            
    </div>
    <!-- 글작성 폼  End-->    
        
        

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
    
    <!-- 에디터 불러오기  -->
    <script src="//cdn.ckeditor.com/4.21.0/standard/ckeditor.js"></script>
    <script>
    $(function () {
        CKEDITOR.replace("writearea", {
          filebrowserUploadUrl:
            "${pageContext.request.contextPath}/yfreeboard/addImage.do",
          width: "80%",
          height: "300px",
        });
      });
    
    <%YuserVO user = (YuserVO) session.getAttribute("loginedUserVO");%>
    const updateBoard = () => {
    	var content = CKEDITOR.instances.writearea.getData();
    	var subject = $('#titleInput').val();
    	var text = content.replace(/[<][^>]*[>]/gi, "");
    	var onlytext = text.replace(/&nbsp;/gi, "");
    	var bno = <%=selectedVO.getBno()%>
    	saveJson(content, subject, onlytext, bno);
       
    };
    
    function saveJson(content, subject, onlytext, bno) {
  	   $.ajax({
  	       url:"/yfreeboard/updateYfreeboard.do", //request 보낼 서버의 경로
  	       type:'post', // 메소드(get, post, put 등)
  	       data: {'content': content, 'subject' : subject, 'onlytext' : onlytext, 'bno' : bno},
  	       dataType: "json",
  	       async : false,
  	       success: function(data) {
  	    	  alert("수정완료");
  	    	 location.href = '/yfreeboard/YfreeboardList.do'
  	       },
  	       error: function(err) {
  	    	   alert('에러났어요!!');
  	       }
  	   });
  	   
    }
    </script>
</body>

</html>