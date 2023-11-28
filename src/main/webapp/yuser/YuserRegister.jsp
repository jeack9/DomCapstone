<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : YuserRegister.jsp
  * @Description : Yuser Register 화면
  * @Modification Information
  * 
  * @author kjh
  * @since 2023-05-15
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<c:set var="registerFlag" value="${empty yuserVO.userno ? '등록' : '수정'}"/>			

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="yuserVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/yuser/YuserList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/yuser/deleteYuser.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/yuser/addYuser.do' : '/yuser/updateYuser.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="yuserVO" name="detailForm" id="detailForm" >
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images//title_dot.gif'/>" alt="" /><c:out value="${registerFlag}"/></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="table">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" >
		<colgroup>
			<col width="150"/>
			<col width=""/>
		</colgroup>
			
		<c:if test="${registerFlag == '수정'}">
		</c:if>
		<c:if test="${registerFlag == '등록'}">
		</c:if>		
		<tr>
			<th>userno</th>
			<td>
				<form:input path="userno" cssClass="txt"/>
				&nbsp;<form:errors path="userno" />
			</td>
		</tr>	
		<tr>
			<th>userid</th>
			<td>
				<form:input path="userid" cssClass="txt"/>
				&nbsp;<form:errors path="userid" />
			</td>
		</tr>	
		<tr>
			<th>userpw</th>
			<td>
				<form:input path="userpw" cssClass="txt"/>
				&nbsp;<form:errors path="userpw" />
			</td>
		</tr>	
		<tr>
			<th>username</th>
			<td>
				<form:input path="username" cssClass="txt"/>
				&nbsp;<form:errors path="username" />
			</td>
		</tr>	
		<tr>
			<th>userphone</th>
			<td>
				<form:input path="userphone" cssClass="txt"/>
				&nbsp;<form:errors path="userphone" />
			</td>
		</tr>	
		<tr>
			<th>useraddr</th>
			<td>
				<form:input path="useraddr" cssClass="txt"/>
				&nbsp;<form:errors path="useraddr" />
			</td>
		</tr>	
		<tr>
			<th>appendix</th>
			<td>
				<form:input path="appendix" cssClass="txt"/>
				&nbsp;<form:errors path="appendix" />
			</td>
		</tr>	
		<tr>
			<th>admin</th>
			<td>
				<form:input path="admin" cssClass="txt"/>
				&nbsp;<form:errors path="admin" />
			</td>
		</tr>	
		<tr>
			<th>usergrade</th>
			<td>
				<form:input path="usergrade" cssClass="txt"/>
				&nbsp;<form:errors path="usergrade" />
			</td>
		</tr>	
		<tr>
			<th>userpoint</th>
			<td>
				<form:input path="userpoint" cssClass="txt"/>
				&nbsp;<form:errors path="userpoint" />
			</td>
		</tr>	
		<tr>
			<th>departno</th>
			<td>
				<form:input path="departno" cssClass="txt"/>
				&nbsp;<form:errors path="departno" />
			</td>
		</tr>	
		<tr>
			<th>roomno</th>
			<td>
				<form:input path="roomno" cssClass="txt"/>
				&nbsp;<form:errors path="roomno" />
			</td>
		</tr>	
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();">List</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<c:if test="${registerFlag == '수정'}">
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();">삭제</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			</c:if>
			<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();">Reset</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li></ul>
	</div>
</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
</form:form>
</body>
</html>

