<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="../resources/app/lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="../resources/app/stylesheets/theme.css">
<link rel="stylesheet"
	href="../resources/app/lib/font-awesome/css/font-awesome.css">
<script type="text/javascript"
	src="../resources/app/js/js_lib/jquery.js" /></script>
<script type="text/javascript">
	
</script>
<script type="text/javascript">
	function crecode() {
		var local = $("#local").val();
		var num = $("#num").val();
		if (!num || num == "") {
			alert("请输入需要创建的残值编码数量！");
			return false;
		}
		$.ajax({
			type : "post",
			url : "createcode.do",
			async : false,
			dataType : "json",
			data : {
				local : local,
				num : num
			},
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					$("#table").append(
							"<tr><td>" + (i + 1) + "</td><td>"
									+ data[i].codeNum + "</td<></tr>");
				}
			},
			error : function(data) {
				alert(data.message);
			}
		});
	}
</script>
<title>Insert title here</title>
<style type="text/css">
#line-chart {
    height: 900px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<ul class="nav pull-right">

					<li id="fat-menu" class="dropdown"><a href="#" id="drop3"
						role="button" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-user"></i> <i class="icon-caret-down"></i>
					</a>

						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="#">Settings</a></li>
							<li class="divider"></li>
							<li><a tabindex="-1" href="sign-in.html">Logout</a></li>
						</ul></li>

				</ul>
				<a class="brand" href="index.html"><span class="first"></span> <span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<span><img alt="center"
						src="../resources/app/images/piccandczhs.png"></span></a>
			</div>
		</div>
	</div>
	<div class="container-fluid">

		<div class="row-fluid">
			<div class="span3">
				<div class="sidebar-nav">
					<div class="nav-header" data-toggle="collapse"
						data-target="#dashboard-menu">
						<i class="icon-dashboard"></i>残值编码管理
					</div>
					<ul id="dashboard-menu" class="nav nav-list collapse in">
						<li><a href="./tocre">残值编码生成 </a></li>
						<li><a href="./home">残值编码检验</a></li>
						<li><a href="./tocre">残值编码查询</a></li>
					</ul>
					<div class="nav-header" data-toggle="collapse"
						data-target="#accounts-menu">
						<i class="icon-briefcase"></i>残值单管理
					</div>
					<ul id="accounts-menu" class="nav nav-list collapse in">
						<li><a href="sign-in.html">残值单单号生成</a></li>
						<li><a href="sign-up.html">残值单查询</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<script type="text/javascript" src="lib/jqplot/jquery.jqplot.min.js"></script>
				<script type="text/javascript" charset="utf-8"
					src="javascripts/graphDemo.js"></script>


				<div class="row-fluid">
					<div class="block">
						<p class="block-heading" data-toggle="collapse"
							data-target="#chart-container">残值编码检验</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="line-chart">
								<fieldset>
									<table>
										<tr>
											<td>残值单号：</td>
											<td><input type="text" name="reportCode" id="reportCode"></td>
											<td><input type="button" class="number" value="查询"
												onclick="crecode();"></td>
										</tr>
									</table>
								</fieldset>
								<fieldset>
									<table id="table">
										<tr>
											<td>残值单号</td>
											<td>车牌号</td>
											<td>报案号</td>
											<td>残值编码</td>
											<td>残值状态</td>
										</tr>
										<tr>
											<td>12345678</td>
											<td>川A99999</td>
											<td>87654321</td>
											<td>1425282517870</td>
											<td>交残成功</td>
										</tr>
										<tr>
											<td>12345678</td>
											<td>川A99999</td>
											<td>87654321</td>
											<td>1425282518029</td>
											<td>交残成功</td>
										</tr>
										<tr>
											<td>12345678</td>
											<td>川A99999</td>
											<td>87654321</td>
											<td>1425282707985</td>
											<td>交残成功</td>
										</tr>
										<tr>
											<td>12345678</td>
											<td>川A99999</td>
											<td>87654321</td>
											<td>1425282708038</td>
											<td>交残成功</td>
										</tr>
									</table>
									<span>总计&nbsp&nbsp&nbsp4&nbsp&nbsp&nbsp样</span>
								</fieldset>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>