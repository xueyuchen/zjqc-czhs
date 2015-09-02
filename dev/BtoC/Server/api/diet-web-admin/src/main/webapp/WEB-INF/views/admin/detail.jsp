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
<script type="text/javascript" src="../resources/app/adminjs/listAcc.js"></script>
<script type="text/javascript"
	src="../resources/app/adminjs/jquery.form.js"></script>
<script type="text/javascript" src="../resources/app/constants.js"></script>
<script type="text/javascript"
	src="../resources/app/adminjs/bootstrap.min.js"></script>
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
					<li><a href="../admin/admin">成库照片上传</a></li>
					<li><a href="../admin/changes">成库库存查询</a></li>
					<li><a href="../admin/totalA">成库库存统计</a></li>
				</ul>
				<hr>
				<ul class="nav nav-sidebar">
					<li><a href="../admin/uploadtoB">都库照片上传</a></li>
					<li><a href="../admin/changesB">都库库存查询</a></li>
					<li><a href="../admin/totalB">都库库存统计</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../admin/findAll">总库存查询</a></li>
					<li><a href="#">库存分类查询</a></li>
				</ul>
				<hr>
				<ul class="nav nav-sidebar">
					<li><a href="../admin/statist">销售记录查询</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">配件详细信息</h1>
				<img style="display: block; width: 50%; float: left;"
					src="${accessory.accessoryImg}" />

				<div style="float: left; margin-left: 50px; margin-top: 1%;">
					<form action="${accessory.accessoryNum}" method="post"
						enctype="multipart/form-data" id="form"
						onsubmit="return submitInfo();">
						<table class="table table-striped">
							<tr>
								<td>配件名称：</td>
								<td>${accessory.accessoryName}</td>
							</tr>
							<tr>
								<td>配件编号：</td>
								<td id="accessoryNum">${accessory.accessoryNum}</td>
							</tr>
							<tr>
								<td>库房：</td>
								<td><select name="level" id="level">
										<option value=1
											<c:if test="${1 == accessory.level}">selected</c:if>>成库</option>
										<option value=2
											<c:if test="${2 == accessory.level}">selected</c:if>>都库</option>
										<option value=3
											<c:if test="${3 == accessory.level}">selected</c:if>>销售库房</option>
								</select></td>
							</tr>
							<tr>
								<td>维修状态：</td>
								<td><select name="partId" id="partId">
										<option value=1
											<c:if test="${1 == accessory.partId}">selected</c:if>>未维修</option>
										<option value=2
											<c:if test="${2 == accessory.partId}">selected</c:if>>维修中</option>
										<option value=3
											<c:if test="${3 == accessory.partId}">selected</c:if>>成品</option>
								</select></td>
							</tr>
							<%-- <tr>
								<td>维修人：</td>
								<td><input name="worker" id="worker" value="${accessory.worker}"/></td>
							</tr> --%>
							<tr>
								<td>备注：</td>
								<td>
									<input type="text" name="msg" value="${accessory.msg}">
								</td>
							</tr>
							<tr>
								<td>销售价格：</td>
								<td>
									<input type="text" name="saleMoney">
								</td>
							</tr>
							<tr>
								<td colspan="3"><input type="file" name="newImg" /></td>
							</tr>
							<tr>
								<td>
									<button type="button" id="sbumit"
										data-complete-text="finished!" class="btn btn-primary"
										autocomplete="off" onclick="submitInfo();">提交修改</button>
								</td>
								<td>
									<button type="button" id="back" data-complete-text="finished!"
										class="btn btn-primary" autocomplete="off" onclick="goBack();">返回</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../resources/app/adminjs/detial.js"></script>
</html>