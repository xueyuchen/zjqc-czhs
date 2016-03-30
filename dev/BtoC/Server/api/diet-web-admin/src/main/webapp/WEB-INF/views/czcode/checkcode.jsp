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
<script type="text/javascript" src='../resources/app/js/checkcode.js'></script>
<title>残值管理系统</title>
<style type="text/css">
#line-chart {
	height: 300px;
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
				<a class="brand" href="#"><span class="first"></span> <span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<span><img alt="center"
						src="../resources/app/images/piccandczhs.png"></span></a>
			</div>
		</div>
	</div>
	<div class="container-fluid">

		<div class="row-fluid">
			<div class="span3" style="height: 750px">
				<div class="sidebar-nav">
					<div class="nav-header" data-toggle="collapse"
						data-target="#accounts-menu">
						<i class="icon-briefcase"></i>定损员管理
					</div>
					<ul id="accounts-menu" class="nav nav-list collapse in">
						<li><a href="../workers/tocre">定损员录入</a></li>
						<li><a href="../workers/tostatistics">定损员使用统计</a></li>
					</ul>
					<div class="nav-header" data-toggle="collapse"
						data-target="#dashboard-menu">
						<i class="icon-dashboard"></i>残值编码管理
					</div>
					<ul id="dashboard-menu" class="nav nav-list collapse in">
						<li><a href="../codes/tocre">残值编码生成 </a></li>
						<li><a href="../codes/tocheck">残值编码检测</a></li>
						<li><a href="../codes/todestroy">残值编码销毁</a></li>
						<li><a href="../codes/toexpire">残值编码注销</a></li>
					</ul>
					<div class="nav-header" data-toggle="collapse"
						data-target="#accounts-menu">
						<i class="icon-briefcase"></i>残值单管理
					</div>
					<ul id="accounts-menu" class="nav nav-list collapse in">
						<li><a href="../papers/tocre">残值单单号生成</a></li>
						<li><a href="../papers/toenter">残值单录入</a></li>
					</ul>
					<div class="nav-header" data-toggle="collapse"
						data-target="#accounts-menu">
						<i class="icon-briefcase"></i>残值统计
					</div>
					<ul id="accounts-menu" class="nav nav-list collapse in">
						<li><a href="../papers/tototal">残值回收账目</a></li>
					</ul>
					<div class="nav-header" data-toggle="collapse"
						data-target="#accounts-menu">
						<i class="icon-briefcase"></i>修理厂信息
					</div>
					<ul id="accounts-menu" class="nav nav-list collapse in">
						<li><a href="../garage/tocreate">修理厂录入</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<script type="text/javascript" src="lib/jqplot/jquery.jqplot.min.js"></script>
				<script type="text/javascript" charset="utf-8"
					src="javascripts/graphDemo.js"></script>


				<div class="row-fluid">
					<div class="block-height">
						<p class="block-heading" data-toggle="collapse"
							data-target="#chart-container">残值编码检测</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="line-chart">
								<fieldset>
									<table>
										<tr>
											<td>请输入要检测的残值编码：</td>
											<td><input type='text' name='codeNum' id='codeNum' /></td>
										</tr>
										<tr>
											<td></td>
											<td><input type='button' onclick='checkcode();'
												value='检测' /></td>
										</tr>
										<tr>
											<td>&nbsp</td>
										</tr>
										<tr>
											<td>定损员：</td>
											<td><input type='text' id='workerName'
												readonly="readonly" /></td>
											<td>生成日期：</td>
											<td><input type='text' id='creDt' readonly="readonly" /></td>
										</tr>
										<tr>
											<td>归属地：</td>
											<td><input type='text' id='local' readonly="readonly" /></td>
											<td>查询结果：</td>
											<td><textarea id='message'
													style="height: 130px; color: red; width: 206px" readonly></textarea></td>
										</tr>
									</table>
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