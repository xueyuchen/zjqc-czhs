<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>残值单、残值编码查询系统</title>
<link href="./resources/app/cssuser/bootstrap.css" rel="stylesheet"
	type="text/css" media="all">
<link href="./resources/app/cssuser/style.css" rel="stylesheet"
	type="text/css" media="all" />
<!--web-fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--js-->
<script src="./resources/app/jsuser/jquery.min.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
</head>
<body>
<div class="intro">
        <div class="container">
            <div class="intro-main">
                <h2>PICC人保成都分公司</h2>
                <h3>欢迎使用残值查询系统</h3>
                <span class="b"> </span>
            </div>
            <div class="clearfix"></div>
        </div>
        <h4 ><a href='users/login'>login in</a></h4>
    </div>
	<div class="header">
		<div class="container">
			<div class="header-bottom">
				<h1>残值单查询</h1>
				<form>
					<input type="text" value="Enter a Job Description"
						onfocus="this.value = '';"
						onblur="if (this.value = '请输入需要查询的编号') {this.value = '请输入需要查询的编号';}">
					<input type="submit" class="ser" value="查询"><br> <select
						name="cars">
						<option value="选择">残值单号</option>
						<option value="saab">残值编码</option>
					</select>
				</form>
			</div>
		</div>
	</div>
	<div class="intro-strip"></div>
	<!--about start here-->
</body>
</html>