<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.error {
	margin-left: 10px;
	color: red;
	vertical-align: middle;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/include/topMenu.jsp" %>
	<section>
		<div align="center">
			<hr width="80%">
			<h2>게시물 등록폼</h2>
			<hr width="80%">
			<br>
			<form:form commandName="boardVO" methiod="post">
				<table border="1" style="width: 80%;">
					<tr>
						<th width="23%">제목</th>
						<td><form:input path="title" size="50" /> 
						<form:errors path="title" class="error" /></td>
					</tr>
					<tr>
						<th width="23%">글쓴이</th>
						<td><form:input path="writer" size="50" /> 
						<form:errors path="writer" class="error" /></td>
					</tr>
					<tr>
						<th width="23%">내용</th>
						<td><form:textarea path="content" size="80" /> 
						<form:errors path="content" class="error" /></td>
					</tr>
				</table>
				<input type="submit" value=" 등록  ">
			</form:form>

		</div>
	</section>
	<%@include file="/WEB-INF/include/footer.jsp" %>