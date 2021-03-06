<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script src="js/jquery.twbsPagination.min.js"></script>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
var page_href;
	$(function() {
		var totalPages =  <c:if test="${data.totalPages eq 0}">1</c:if><c:if test="${data.totalPages != 0}">${data.totalPages}</c:if>;
		$('#pagination-page').twbsPagination({
			totalPages : totalPages,
			visiblePages : 7,
			paginationClass : 'pagination',
			startPage : ${data.page},
			href : page_href + '{{number}}',
			first : 'First',
			prev : 'Prev',
			next : 'Next',
			last : 'Last',
		})
	})
</script>

<div class="text-center">
	<ul id="pagination-page" class="pagination"></ul>
</div>