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
    
    <!-- SelectPoint Stylesheet -->
<!--     <link href="/css/selectPoint.css" rel="stylesheet"> -->
</head>

<body>
<script>
      $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
      });
    </script>
    <!-- Spinner End -->

	<!-- Navbar Start -->
	<%@ include file="/navbar.jsp" %>
	<!-- Navbar End -->
	
	  <!-- Header Start -->
    <div class="container-fluid bg-primary py-5 mb-5 page-header">
        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-lg-10 text-center">
                    <h1 class="display-3 text-white animated slideInDown">상 벌점 조회</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                            <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">상 벌점 조회</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->

    

	 <div class="container-xl">
      <div>
        <div class="table-wrapper">
          <div class="table-title">
            <div class="row">
              <div class="col-sm-8">
              <c:if test="${!empty sessionScope.loginedUserVO }">
                <h2>현재 벌점 &nbsp; <b><c:out value="${loginedUserVO.userpoint}"/></b></h2>
                </c:if>
              </div>
            </div>
          </div>
          <c:if test="${ypointList.size() == 0}">
          	조회된 상 벌점이 없습니다.
          </c:if>
           <table class="table">
            <thead>
              <tr>
                <th>내용</th>
                <th>상벌점</th>
                <th>부과자</th>
                <th>날짜</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="points" items="${ypointList}">
              <tr>
                <td>${points.pointreason}</td>
                <c:if test="${points.pointchange > 0}">
                	<td style="color:green">+${points.pointchange}</td>
                </c:if>
                <c:if test="${points.pointchange <= 0}">
                	<td style="color:red;">${points.pointchange}</td>
                </c:if>
                <td>${points.manager}</td>
                <td>${points.pointdate.split(" ")[0]}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
         
        </div>
      </div>
      <div>
      억울하면 학과 사무실에 전화하세요
      </div>
    </div>
 




  




  

  


        

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