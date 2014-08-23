<%@page import="java.util.Date"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String loginMsg = (String) request.getAttribute("loginMsg");
	if (loginMsg == null) {
		loginMsg = "";
	}
%>
<%@ include file="common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clinic Automation</title>

<link href="css/justified-nav.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>

<body screen_capture_injected="true" ryt14004="1">
	<div class="container">
		<%@ include file="common/head.jsp"%>
		<c:if test="${loginUser == null }">
			<div id="login">
				<!-- Jumbotron -->
				<form class="form-signin" role="form" id="form_login" type="post"
					action="clinic/user!login.action">
					<h2 class="form-signin-heading">Please sign in</h2>
					<input type="text" class="form-control" placeholder="User Account"
						name="account" required autofocus> <input type="password"
						class="form-control" placeholder="Password" name="password"
						required>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="btn_login">Sign in</button>
					<label id="loginMsg">${loginMsg}</label>
				</form>
			</div>
		</c:if>
		<c:if test="${loginUser != null }">
			Welcome, ${loginUser.name}, time: <fmt:formatDate
				value="<%=new Date()%>" pattern="yyyy-MM-dd HH:mm" />
		</c:if>
		<%@ include file="common/foot.jsp"%>
	</div>
</body>
</html>