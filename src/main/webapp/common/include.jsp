<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>" />

<link rel="stylesheet" href="plugin/bootstrap//css/bootstrap.min.css">
<link href="plugin/bootstrap//css/bootstrap-theme.min.css">
<link href="css/commonCss.css">

<script src="js/jquery-1.11.1.min.js"></script>
<script src="plugin/bootstrap/js/bootstrap.min.js"></script>

<script src="js/commonJs.js"></script>
