<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="plugin/bootstrap//css/bootstrap.min.css">
<link rel="stylesheet"
	href="plugin/bootstrap//css/bootstrap-theme.min.css">

<script src="js/jquery-1.11.1.min.js"></script>
<script src="plugin/bootstrap/js/bootstrap.min.js"></script>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>"/>