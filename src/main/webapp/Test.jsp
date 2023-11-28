<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>
<!--여기에 div 추가 -->
	<div class="g-recaptcha" data-sitekey="6Lcz6I0mAAAAAFztdEQSItVU0AtvQlNXt4C7U8Ri"></div>
    <button id="test_btn">테스트 버튼</button>
 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <!-- 여기에 스크립트 추가 -->
 
    <script>
        $(document).ready(function() {
            $("#test_btn").click(function() {
                $.ajax({
                    url: '/yrepair/VerifyRecaptcha.do',
                    type: 'post',
                    data: {
                        recaptcha: $("#g-recaptcha-response").val()
                    },
                    success: function(data) {
                        switch (data) {
                            case 0:
                                alert("자동 가입 방지 봇 통과");
                                break;
 
                            case 1:
                                alert("자동 가입 방지 봇을 확인 한뒤 진행 해 주세요.");
                                break;
 
                            default:
                                alert("자동 가입 방지 봇을 실행 하던 중 오류가 발생 했습니다. [Error bot Code : " + Number(data) + "]");
                                break;
                        }
                    }
                });
            });
        });
 
    </script>
</body>
</html>