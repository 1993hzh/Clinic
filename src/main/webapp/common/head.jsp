<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap core CSS -->
<link href="plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<!-- Fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="javascript:void(0)">Clinic
					Automation System</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/index.jsp">Home</a></li>
					<li><a href="#Doc">Doctor's Info</a></li>
					<li><a href="#Med">Medicine's Info</a></li>
					<li><a href="#Med">Message</a></li>
					<li><a href="#Med">Order</a></li>
					<li><a href="#Med">Check Stock</a></li>
					<li><a href="#Med">View Record</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<!-- <li>
						<form class="navbar-form navbar-right">
							<input type="text" class="form-control" placeholder="Search...">
						</form>
					</li> -->
					<li class="dropdown">
						<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
							<c:if test="${sessionScope.loginUser != null}">${loginUser.name}<b class="caret"></b>
							</c:if>
						</a>
						<c:if test="${sessionScope.loginUser != null}">
							<ul class="dropdown-menu">
								<li><a href="javascript:void(0);" onclick="location.href='clinic/user!logoff.action'">退出</a></li>
							</ul>
						</c:if>
					</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

</body>
</html>