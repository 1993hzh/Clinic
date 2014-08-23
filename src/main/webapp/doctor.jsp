<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/include.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doctor's Info</title>
<script type="text/javascript">
	var page_href = "clinic/user!list.action?page=";
</script>
</head>
<body>
	<div class="container">
		<div class="head">
			<%@ include file="/common/head.jsp"%>
		</div>
		<div class="content text-center" style="margin-top: 60px;">
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Specility</th>
							<th>Experience</th>
							<th>Qualification</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rows" items="${data.data}">
							<tr>
								<td>${rows.name}</td>
								<td>${rows.specility}</td>
								<td>${rows.experience}</td>
								<td>${rows.specility}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<jsp:include page="/common/page.jsp" />
		<div class="foot">
			<%@ include file="/common/foot.jsp"%>
		</div>
	</div>
</body>
</html>