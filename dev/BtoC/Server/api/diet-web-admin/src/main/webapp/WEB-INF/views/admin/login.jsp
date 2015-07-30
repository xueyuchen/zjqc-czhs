<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../resources/app/jsuser/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../resources/app/admin/style.css" />
<script type="text/javascript" src="../resources/app/adminjs/listAcc.js"></script>
<script type="text/javascript" src="../resources/app/constants.js"></script>
<script type="text/javascript" src="../resources/app/adminjs/login.js"></script>
</head>
<body>
	<div class="container">
		<header> </header>
		<div class="advertising">
			<div class="advertising-left"></div>
			<div class="advertising-right"></div>
		</div>
		<div style="height: 30px"></div>
		<div class="page-body" id="imgForm-list">
			<form action="login" method="post">
				用户名：<input type="text" name="username" id="username" /> 密码：<input
					type="password" name="password" id="password" />
				<button value="登录" onclick="login();">登录</button>
				<input type="submit" value="登录"/>
			</form>
		</div>
	</div>
</body>
</html>