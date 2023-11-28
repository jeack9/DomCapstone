<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="No-store, No-cache, Must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Content-Language" content="ko"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="author" content="author">
<meta name="keywords" content="keywords">
<meta name="description" content="Description">
<meta name="copyright" content="copyright">
<meta name="robots" content="index,follow" />
 
<link rel="shortcut icon" type="image/x-icon" href="" />
<link rel="apple-touch-icon-precomposed" href="" />
 
 
<link href="/css/site/common.css" rel="stylesheet">
 
<!-- //css -->
 
 
<!-- <script src="/js/common/jquery-3.5.1.js"></script> -->
<script src="/js/site/jquery-1.9.1.js"></script>
 
<title>tiles Test</title>
 
</head>
 
<body>
 
    <!-- 스킵네비케이션 -->
    <div id="skipnavi" style="display:none;">
        <a href="#txt">본문 바로가기</a>
        <a href="#gnb">대메뉴 바로가기</a>
    </div>
    <!-- //스킵네비케이션 -->
 
<div class="wrap">    
    <!-- top -->
    <tiles:insertAttribute name="top" />
    <!-- //top -->
    
    <!-- gnb -->
    <tiles:insertAttribute name="gnb" />
    <!-- //gnb -->
 
        <div class="content">
            
            <!-- lnb -->
             <tiles:insertAttribute name="lnb" />
            <!-- //lnb -->
                
            <div class="cont_body">        
                
                <!--  content_body -->
                <tiles:insertAttribute name="content" />
                <!--  content_body -->
            </div>
        </div>
    
<!-- footer -->
<footer id="foot_layout">
    <tiles:insertAttribute name="footer" />
</footer>
<!-- //footer -->
 
 
</div>    
 
</body>
</html>