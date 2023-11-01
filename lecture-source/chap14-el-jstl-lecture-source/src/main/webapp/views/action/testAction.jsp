<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <%@ include file="common.jsp" %>  --%>
<!-- 태그를 열면 닫기 태그를 반드시 작성해야 한다. 작성하지 않으면 500 에러가 발생한다. -->
<jsp:include page="common.jsp"/> <!--<jsp>태그 : 단축 명령어, 여닫는 구문 필요 없음 /> 만 뒤에 붙여주기-->
<h1>여기서부터 내용입니다.</h1>

<% request.setAttribute("name", "홍길동"); %>

<jsp:forward page="testForward.jsp"/>
</body>
</html>
