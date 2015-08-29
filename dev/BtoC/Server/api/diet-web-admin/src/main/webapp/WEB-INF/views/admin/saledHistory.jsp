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
<link rel="stylesheet" href="../resources/app/adminjs/bootstrap.min.css">
<link rel="stylesheet"
	href="../resources/app/adminjs/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/app/adminjs/dashboard.css">
<script type="text/javascript" src="../resources/app/adminjs/Chart.js"></script>
<script type="text/javascript"
	src="../resources/app/adminjs/jquery.form.js"></script>
<script type="text/javascript" src="../resources/app/constants.js"></script>
<script type="text/javascript"
	src="../resources/app/adminjs/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../resources/app/adminjs/saleHistory.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">配件销售系统</a>
		</div>
		<div class="navbar-collapse collapse">
			<!-- <form class="navbar-form navbar-left">
				<input id="searchPar" class="form-control"
					style="width: 500px; margin-left: 60%;" type="text"
					placeholder="奥迪 A6L 2014 左大灯(查询条件请以空格分开)"
					oninput="searchByLuceneB();" />
			</form> -->
		</div>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="../admin/admin">A库照片上传</a></li>
					<li><a href="../admin/changes">A库库存查询</a></li>
				</ul>
				<hr>
				<ul class="nav nav-sidebar">
					<li><a href="../admin/uploadtoB">B库照片上传</a></li>
					<li><a href="../admin/changesB">B库库存查询</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../admin/findAll">总库存查询</a></li>
					<li><a href="#">库存分类查询</a></li>
				</ul>
				<hr>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="../admin/statist">销售记录查询</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ul class="nav nav-tabs nav-justified">
					<li role="presentation" class="active"><a href="#">周销售记录</a></li>
					<li role="presentation"><a href="#">已售配件分类记录</a></li>
					<li role="presentation"><a href="#">自定义查询</a></li>
				</ul>
				<div style="width: 50%; float: left">
					<canvas id="canvas-sale" height="450" width="600"></canvas>
				</div>
				<div
					style="width: 50%; float: left; width: 50%; float: left; height: 336px; overflow: scroll;">
					<ul class="list-group" id="accessory-list">
					</ul>
				</div>
				<div class="btn-group btn-group-justified" role="group"
					aria-label="...">
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-default"
							onclick="saledHistory(-1);">上一周</button>
					</div>
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-default"
							onclick="saledHistory(0);">本周</button>
					</div>
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-default"
							onclick="saledHistory(1);">下一周</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>