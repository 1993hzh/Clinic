<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clinic Automation</title>

<!-- Custom styles for this template -->
<link href="css/justified-nav.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">

<script type="text/javascript">
	$(function() {
		$("#btn_login").click(function() {
			$.ajax({
				url : 'clinic/user!login.action',
				data : $("#form_login").serialize(),
				type : "post",
				success : function(msg) {
					$("#login").html(msg);
				}
			});
		});
	});
</script>
</head>

<body screen_capture_injected="true" ryt14004="1">
	<div class="container">
		<%@ include file="common/head.jsp"%>
		<div id="login">
			<!-- Jumbotron -->
			<form class="form-signin" role="form" id="form_login">
				<h2 class="form-signin-heading">Please sign in</h2>
				<input type="text" class="form-control" placeholder="User Account"
					name="account" required autofocus> <input type="password"
					class="form-control" placeholder="Password" name="password"
					required>
				<button class="btn btn-lg btn-primary btn-block" type="submit"
					id="btn_login">Sign in</button>
			</form>
		</div>
		<%@ include file="common/foot.jsp"%>
	</div>
</body>
</html>