<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../resources/app/js/js_lib/jquery.js"></script>
<script type="text/javascript"
	src="../resources/app/plupload/plupload.full.min.js"></script>
<script type="text/javascript"
	src="../resources/app/plupload/jquery.ui.plupload/jquery.ui.plupload.js"></script>
<script type="text/javascript"
	src="../resources/app/plupload/i18n/zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="../resources/app/admin/style.css" />
<link rel="stylesheet" href="../resources/app/adminjs/bootstrap.min.css">
<link rel="stylesheet"
	href="../resources/app/adminjs/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/app/adminjs/dashboard.css">
<script type="text/javascript" src="../resources/app/constants.js"></script>
<script type="text/javascript"
	src="../resources/app/adminjs/jquery.form.js"></script>
<script type="text/javascript" src="../resources/app/adminjs/listAcc.js"></script>
<script type="text/javascript"
	src="../resources/app/adminjs/bootstrap.js"></script>
<script>
	function submitInfo(accessoryNum) {
		console.log(accessoryNum);
		$(".sbumit").attr("disabled", "disabled");
		$(".sbumit").val("等待处理");
		$('#'+accessoryNum).ajaxSubmit(function() {
			$(".sbumit").removeAttr("disabled");
			$(".sbumit").val("提交修改");
			alert("配件状态修改成功");
		});
		return false;
	}
</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">配件销售系统</a>
		</div>
		<div class="navbar-collapse collapse">
			<form class="navbar-form navbar-left">
				<input id="searchPar" class="form-control"
					style="width: 500px; margin-left: 60%;" type="text"
					placeholder="奥迪 A6L 2014 左大灯(查询条件请以空格分开)"
					oninput="searchByLuceneA();" />
			</form>
			<div class="btn-group"
				style="margin-top: 8px; float: right; margin-right: 10%;">
				<button type="button" class="btn btn-danger">批量修改</button>
				<button type="button" class="btn btn-danger dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span class="caret"></span> <span class="sr-only">Toggle
						Dropdown</span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="javascript:void(0);">已选配件</a></li>
					<li role="separator" class="divider"></li>
				</ul>
			</div>
		</div>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="../admin/admin">A库照片上传</a></li>
					<li class="active"><a href="../admin/changes">A库库存查询</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../admin/uploadtoB">B库照片上传</a></li>
					<li><a href="../admin/changesB">B库库存查询</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../admin/findAll">总库存查询</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="#">销售记录查询</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-12 col-md-offset-1 main">
				<div class="img-list" id="accessory-list">
					<div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading">配件状态批量修改</div>
						<!-- Table -->
						<c:forEach var="item" items="${accessories}">
							<form action="${item.accessoryNum}" method="post"
								enctype="multipart/form-data"
								onsubmit="return submitInfo(${item.accessoryNum});"
								id="${item.accessoryNum}">
								<table class="table accessTable">
									<tr>
										<td style="display: block; margin-left: 30%; width: 100%;"><img
											style="width: 70px;  height: 40px;"
											src="data:image/jpeg;base64,${item.accessoryImg}" /></td>
										<td style="width: 230px;">${item.accessoryName}</td>
										<td>${item.accessoryNum}</td>
										<td><select name="partId">
												<option value="1"
													<c:if test="${item.partId == 1}">selected="selected"</c:if>>未维修</option>
												<option value="2"
													<c:if test="${item.partId == 2}">selected="selected"</c:if>>维修中</option>
												<option value="3"
													<c:if test="${item.partId == 3}">selected="selected"</c:if>>已维修</option>
										</select></td>
										<td><select name="level">
												<option value="1"
													<c:if test="${item.level == 1}">selected="selected"</c:if>>A仓库</option>
												<option value="2"
													<c:if test="${item.level == 2}">selected="selected"</c:if>>B仓库</option>
										</select></td>
										<td><input type="text" name="msg" style="height: 23px" value="${item.msg}"/></td>
										<td><input type="file" name="newImg" style="width: 200px;"/></td>
										<td><input type="submit" value="提交修改" class="sbumit" /></td>
									</tr>
								</table>
							</form>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$('#accessory-list').on('click', '.tomodifyAcce', function(e) {
		console.log($(e.target));
	});
</script>
</html>