<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clinic Automation</title>
</head>
<body>
	<div class="container">
		<%@ include file="common/head.jsp"%>
		<div class="content">
			<form class="form-horizontal">
				<div class="control-group">
					<label class="control-label" for="inputEmail">Email</label>
					<div class="controls">
						<input type="text" id="inputEmail" placeholder="Email">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPassword">Password</label>
					<div class="controls">
						<input type="password" id="inputPassword" placeholder="Password">
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn">Sign in</button>
					</div>
				</div>
			</form>
		</div>
		<%@ include file="common/foot.jsp"%>
	</div>
</body>
</html>