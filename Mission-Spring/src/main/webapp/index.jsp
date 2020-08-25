<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<header>
	<%@include file="/WEB-INF/include/topMenu.jsp" %>
	<%-- <jsp:include page="/WEB-INF/include/topMenu.jsp" /> --%>
</header>
	<a href="${ pageContext.request.contextPath }/board">게시판</a><br> 
	<c:choose>
		<c:when test="${ empty loginVO }">
			<a href="${ pageContext.request.contextPath }/login">로그인</a><br> 
		</c:when>
		<c:otherwise>
			<a href="${ pageContext.request.contextPath }/logout">로그아웃</a><br> 
		</c:otherwise>
	</c:choose>
	
<footer>
	<%@include file="/WEB-INF/include/footer.jsp" %>
</footer>
</body>
</html>