<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 현재 문서에 포함시킬 JSP 파일도 WEB-INF 디렉토리 내의 views 디렉토리 내에 위치해야함 --%>
	<%-- 상대 경로로 접근 --%>
	<jsp:include page="inc/top.jsp"></jsp:include> <%-- "/inc/top.jsp"로 하면 맨 앞 / 치는 순간 경로가 webapp으로 가서 오류남 --%>
	<h1>main.jsp</h1>
	<hr>
	<form action="test1" method="get">
		<input type="submit" value="test1 서블릿 요청(GET)">
	</form>
</body>
</html>