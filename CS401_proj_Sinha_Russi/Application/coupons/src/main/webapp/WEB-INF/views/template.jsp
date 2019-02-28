<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Template</title>
	<script src="/resources/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="/resources/js/bootstrap.min.js" type="text/javascript"></script>
	<link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="/resources/css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header class="${headerhide}">
        <jsp:include page="header.jsp"/>
    </header>
    <jsp:include page="${partial}"/>
    <footer class="${footerhide}">
        <jsp:include page="footer.jsp"/>
    </footer>
</body>
</html>