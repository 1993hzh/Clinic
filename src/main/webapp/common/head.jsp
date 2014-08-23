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
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="javascript:void(0)">Clinic Automation System</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="clinic/user!list.action">Doctor's Info</a></li>
					<li><a href="clinic/medicine!list.action">Medicine's Info</a></li>
					<%-- loginUser can see, all roles --%>
					<c:if test="${sessionScope.loginUser != null}">
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">Message<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="message/new.jsp">New</a></li>
								<li class="divider"></li>
								<li><a href="clinic/message!listInbox.action">Inbox</a></li>
								<li class="divider"></li>
								<li><a href="clinic/message!listSent.action">Sent</a></li>
							</ul>
						</li>
					</c:if>
					<%-- doctor,salesman,supplier can see --%>
					<c:if test="${sessionScope.loginUser.role eq 'doctor' || sessionScope.loginUser.role eq 'salesman' || sessionScope.loginUser.role eq 'supplier'}">
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">Order<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="order/new.jsp">New</a></li>
								<c:if test="${sessionScope.loginUser.role eq 'supplier'|| sessionScope.loginUser.role eq 'salesman'}">
									<li class="divider"></li>
									<li><a href="clinic/order!listReceive.action">Receive</a></li>
								</c:if>
								<c:if test="${sessionScope.loginUser.role eq 'doctor'|| sessionScope.loginUser.role eq 'salesman'}">
									<li class="divider"></li>
									<li><a href="clinic/order!listSend.action">Send</a></li>
								</c:if>
							</ul>
						</li>
					</c:if>
					<%-- salesman can see --%>
					<c:if test="${sessionScope.loginUser.role eq 'salesman'}">
						<li><a href="#">Check Stock</a></li>
					</c:if>
					<%-- doctor can see --%>
					<c:if test="${sessionScope.loginUser.role eq 'doctor'}">
						<li><a href="#">View Record</a></li>
					</c:if>
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