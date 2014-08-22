<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clinic Automation</title>

<!-- Bootstrap core CSS -->
<link href="plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/justified-nav.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">

</head>

<body screen_capture_injected="true" ryt14004="1">
	<div class="container">
		<%@ include file="common/head.jsp"%>
		
	<!-- Jumbotron -->	
		<form class="form-signin" role="form">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="email" class="form-control" placeholder="Email address"
				required autofocus> <input type="password"
				class="form-control" placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>
		
		<%@ include file="common/foot.jsp"%>
	</div>
</body>
</html>