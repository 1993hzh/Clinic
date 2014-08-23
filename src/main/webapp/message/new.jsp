<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/include.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Message</title>
</head>
<body>
	<div class="container">
		<div class="head">
			<%@ include file="/common/head.jsp"%>
		</div>
		<div class="content text-center" style="margin-top:60px;">
			<form class="form-horizontal" role="form" action="clinic/message!create.action" id="newMessage">
				<div class="form-group">
					<label class="col-sm-2 control-label">Receiver</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="accounts" id="accounts" 
							placeholder="Place ',' between each receiver" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Theme</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="theme" id="theme" placeholder="Message Theme" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Content</label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="10" name="content" id="content" style="resize:none;"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-default" onclick="create_message()">Submit</button>
					</div>
				</div>
			</form>
		</div>
		<div class="foot">
			<%@ include file="/common/foot.jsp"%>
		</div>
	</div>
</body>
</html>