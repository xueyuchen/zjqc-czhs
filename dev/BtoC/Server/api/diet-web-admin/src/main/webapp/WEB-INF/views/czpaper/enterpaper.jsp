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
<script type="text/javascript"
	src='../resources/app/js/paper/enterpaper.js'></script>
<title>残值管理系统</title>
<style type="text/css">
#line-chart {
	height: 500px;
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
						data-target="#accounts-menu">
						<i class="icon-briefcase"></i>定损员管理
					</div>
					<ul id="accounts-menu" class="nav nav-list collapse in">
						<li><a href="../workers/tocre">定损员录入</a></li>
					</ul>
					<div class="nav-header" data-toggle="collapse"
						data-target="#dashboard-menu">
						<i class="icon-dashboard"></i>残值编码管理
					</div>
					<ul id="dashboard-menu" class="nav nav-list collapse in">
						<li><a href="../codes/tocre">残值编码生成 </a></li>
						<li><a href="../codes/tocheck">残值编码检测</a></li>
						<li><a href="../codes/todestroy">残值编码销毁</a></li>
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
				</div>
			</div>
			<div class="span9">
				<script type="text/javascript" src="lib/jqplot/jquery.jqplot.min.js"></script>
				<script type="text/javascript" charset="utf-8"
					src="javascripts/graphDemo.js"></script>


				<div class="row-fluid">
					<div class="block">
						<p class="block-heading" data-toggle="collapse"
							data-target="#chart-container">残值单录入</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="line-chart">
								<table>
									<tr>
										<td width="80">残值单号：</td>
										<td><input type="text" name="paperCode" id="paperCode"></td>
										<td width="80">报案号：</td>
										<td><input type="text" name="reportCode"
											id="reportCode"></td>
									</tr>
								</table>
								<table>
									<tr>
										<td width="80">车牌号：</td>
										<td><select style="width: 70px" id="abbr" name="abbr">
												<option value="川">川</option>
												<option value="渝 ">渝 </option>
												<option value="贵">黔</option>
												<option value="京">京</option>
												<option value="津">津</option>
												<option value="沪">沪</option>
												<option value="冀">冀</option>
												<option value="晋">晋</option>
												<option value="辽">辽</option>
												<option value="吉">吉</option>
												<option value="黑">黑</option>
												<option value="苏">苏</option>
												<option value="浙">浙</option>
												<option value="皖">皖</option>
												<option value="豫">豫</option>
												<option value="鲁">鲁</option>
												<option value="赣">赣</option>
												<option value="闽">闽</option>
												<option value="鄂">鄂</option>
												<option value="湘">湘</option>
												<option value="粤">粤</option>
												<option value="琼">琼</option>
												<option value="云">云</option>
												<option value="甘">甘</option>
												<option value="青">青</option>
												<option value="桂">桂</option>
												<option value="宁">宁</option>
												<option value="藏">藏</option>
												<option value="新">新</option>
										</select></td>
										<td><input type="text" name="carLicensePlate"
											id="carLicensePlate" style="width: 134px"></td>
										<td width="80">残值总数：</td>
										<td><input type="text" name="codeTotal" id="codeTotal"
											readonly="readonly"></td>
									</tr>
								</table>
								<table>
									<tr>
										<td width="80">残值编号：</td>
										<td><textarea name="reportCode" id="codeArray"
												style="height: 330px; width: 110px"></textarea></td>
										<td width="80">警告信息：</td>
										<td><textarea name="reportCode" id="codeArrayInfos"
												style="height: 330px; color: red; width: 400px" readonly></textarea></td>
									</tr>
									<tr>
										<td></td>
										<td><input type="button" value="检测"
											onclick="checkpaper();" /></td>
										<td></td>
										<td><input type="button" value="录入"
											onclick="entrypaper();" /></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>