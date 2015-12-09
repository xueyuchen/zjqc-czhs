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
<link rel="stylesheet" type="text/css"
	href="../resources/app/js/bootstrap-datetimepicker.css">
<link rel="stylesheet"
	href="../resources/app/lib/font-awesome/css/font-awesome.css">
<script type="text/javascript"
	src="../resources/app/js/js_lib/jquery.js" /></script>
<script type="text/javascript"
	src="../resources/app/js/worker/workertotal.js"></script>
<script type="text/javascript" src="../resources/app/lib/jquery.page.js"></script>
<title>残值管理系统</title>
<style type="text/css">
#line-chart {
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

table.gridtable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}

table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
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
				</div>
			</div>
			<div class="span9">
				<script type="text/javascript" src="lib/jqplot/jquery.jqplot.min.js"></script>
				<script type="text/javascript" charset="utf-8"
					src="javascripts/graphDemo.js"></script>


				<div class="row-fluid">
					<div class="block">
						<p class="block-heading" data-toggle="collapse"
							data-target="#chart-container">定损员使用统计</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="line-chart">
								<fieldset>
									<table>
										<tr>
											<td>查询开始日期：</td>
											<td><input type="text" id="fromDt" class="form_datetime"
												data-date-format="yyyy-mm-dd" /></td>
											<td>查询结束日期：</td>
											<td><input type="text" id="toDt" class="form_datetime"
												data-date-format="yyyy-mm-dd" /></td>
											<td><input type="button" onclick="countPaper();"
												value="查询" /></td>
										</tr>
										<tr>
											<td>查询区域：</td>
											<td><select name="local" id="local">
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
											<td>锁定定损员查询：</td>
											<td><input type="text" id="workerName"></td>
										</tr>
									</table>
								</fieldset>
								<fieldset>
									<table id="table" class="gridtable" style="display: none">
										<thead>
											<tr>
												<th style="width: 250px">区域：</th>
												<th style="width: 250px">定损员姓名：</th>
												<th style="width: 250px">生成数量：</th>
												<th style="width: 250px">起始编码：</th>
												<th style="width: 250px">使用数量：</th>
												<th style="width: 250px">生成日期：</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
										<tfoot>
											<tr>
												<td colspan="6" align="center">
													<div id="Pagination" class="digg"></div>
												</td>
											</tr>
										</tfoot>
									</table>
									<table id="table1" class="gridtable" style="display: none">
										<thead>
											<tr>
												<th style="width: 250px">录入时间：</th>
												<th style="width: 150px">残值单单号：</th>
												<th style="width: 150px">车牌号：</th>
												<th style="width: 150px">报案号：</th>
												<th style="width: 110px">收残数量：</th>
												<th style="width: 350px">定损员</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
										<tfoot>
											<tr>
												<td colspan="6" align="center">
													<div id="Pagination1" class="digg"></div>
												</td>
											</tr>
										</tfoot>
									</table>
								</fieldset>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/app/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="../resources/app/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript"
		src="../resources/app/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript">
		$(".form_datetime").datetimepicker({
			language : 'zh-CN',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});
	</script>
</body>
</html>