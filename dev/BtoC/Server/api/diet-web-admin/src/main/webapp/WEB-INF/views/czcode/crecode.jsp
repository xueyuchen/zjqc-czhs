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
<script type="text/javascript" src="../resources/app/js/createfile.js" /></script>
<script type="text/javascript" src="../resources/app/js/downloadfile.js" /></script>
<script type="text/javascript" src="../resources/app/js/crecode.js"></script>
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
							data-target="#chart-container">残值编码检生成</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="line-chart">
								<form action="createcode" method="post">
									<fieldset>
										<table>
											<tr>
												<td>需要生产编码数量：</td>
												<td><input type="text" name="num" id="num"/></td>
												<!-- <td><select name="num" id="num">
														<option value="1000">1000</option>
														<option value="950">950</option>
														<option value="900">900</option>
														<option value="850">850</option>
														<option value="800">800</option>
														<option value="750">750</option>
														<option value="650">650</option>
														<option value="600">600</option>
														<option value="550">550</option>
														<option value="500">500</option>
														<option value="450">450</option>
														<option value="400">400</option>
														<option value="350">350</option>
														<option value="300">300</option>
														<option value="250">250</option>
														<option value="200">200</option>
														<option value="150">150</option>
														<option value="100">100</option>
														<option value="50">50</option>
												</select></td>  -->
												<td>生成月份：</td>
												<td><select name="month" id="month">
												    <option value="1">1月份</option>
												    <option value="2">2月份</option>
												    <option value="3">3月份</option>
												    <option value="4">4月份</option>
												    <option value="5">5月份</option>
												    <option value="6">6月份</option>
												    <option value="7">7月份</option>
												    <option value="8">8月份</option>
												    <option value="9">9月份</option>
												    <option value="10">10月份</option>
												    <option value="11">11月份</option>
												    <option value="12">12月份</option>
												</select></td>
											</tr>
											<tr>
												<td>区域：</td>
												<td><select name="local" id="local"
													onchange="showWorker()">
														<option value=""></option>
														<option value="0">本部</option>
														<option value="1">西南</option>
														<option value="2">西北</option>
														<option value="3">东南</option>
														<option value="4">东北</option>
														<option value="5">大案</option>
														<option value="6">快查</option>
														<option value="7">车商</option>
												</select></td>
											</tr>
											<tr>
												<td>编码归属人：</td>
												<td><select name="workerId" id="workerId">

												</select></td>
											</tr>
											<tr>
												<td></td>
												<td><input type="submit" class="number" value="生成编码"></td>
											</tr>
										</table>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>