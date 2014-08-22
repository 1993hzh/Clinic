<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="header">
		<div id="navigation">
			<ul class="nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Doctor's Info</a></li>
				<li><a href="#">Medicine's Info</a></li>
			</ul>
		</div>
		<div id="search">
			<form action="" method="">
				<input type="text" value="Search" class="txtfield"
					onblur="javascript:if(this.value==''){this.value=this.defaultValue;}"
					onfocus="javascript:if(this.value==this.defaultValue){this.value='';}" />
				<input type="submit" value="" class="button" />
			</form>
		</div>
	</div>
</body>
</html>