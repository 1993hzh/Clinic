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
<title>Medicine's Info</title>
<script type="text/javascript">
	var page_href = "clinic/medicine!list.action?page=";
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
							<th>Component</th>
							<th>Advantage</th>
							<th>Disadvantage</th>
							<th>Price</th>
							<th>Descption</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rows" items="${data.data}">
							<tr>
								<td>${rows.name}</td>
								<td>${rows.component}</td>
								<td>${rows.advantage}</td>
								<td>${rows.disadvantage}</td>
								<td>${rows.price}</td>
								<td>${rows.descption}</td>
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