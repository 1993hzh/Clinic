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
<title>Inbox</title>
<script type="text/javascript">
	var page_href = "clinic/message!listInbox.action?page=";
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
						<th>Sender</th>
						<th>Theme</th>
						<th>Time</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rows" items="${data.data}">
						<tr>
							<td>
								<button type="button" class="close" onclick="delete_message('${rows.id}','receive',this)">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
							</td>
							<td class="message_user">${rows.sender.name}</td>
							<td class="theme_content">${rows.theme}&nbsp;-&nbsp;${rows.content}</td>
							<td class="message_sendtime"><fmt:formatDate value="${rows.sendTime}" pattern="yyyy-MM-dd HH:mm" /></td>
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