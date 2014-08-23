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
<title>Send</title>
<script type="text/javascript">
	var page_href = "clinic/order!listSend.action?page=";
</script>
</head>
<body>
	<div class="container">
		<div class="head">
			<%@ include file="/common/head.jsp"%>
		</div>
		<div class="content text-center" style="margin-top:60px;">
			<table class="table table-hover">
				<thead>
					<tr>
						<th></th>
						<c:if test="${sessionScope.loginUser.role eq 'doctor'}">
							<th>patient</th>
						</c:if>
						<th>createTime</th>
						<th>receiver</th>
						<th>status</th>
						<th>cost</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rows" items="${data.data}">
						<tr>
							<c:if test="${sessionScope.loginUser.role eq 'doctor'}">
								<th>${rows.patient.name}</th>
							</c:if>
							<td><fmt:formatDate value="${rows.createTime}" pattern="yyyy-MM-dd HH:mm" /></td>
							<td>${rows.receiver.name}</td>
							<td>${rows.statusDTO}</td>
							<td>${rows.cost}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<jsp:include page="/common/page.jsp"/>
		<div class="foot">
			<%@ include file="/common/foot.jsp"%>
		</div>
	</div>
</body>
</html>