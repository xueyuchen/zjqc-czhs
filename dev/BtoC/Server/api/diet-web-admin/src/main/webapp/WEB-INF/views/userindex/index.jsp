<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>残值单、残值编码查询系统</title>
<script src="./resources/app/jsuser/jquery.min.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="./resources/app/cssuser/index.css" rel="stylesheet">
<script type="text/javascript" src="./resources/app/js/index.js"></script>
</head>
<body>
	<div id="header">
		<h1 class="logo">
			<a href="http://www.epicc.com.cn" title="PICC中国人民财险"> <img
				src="./resources/app/images/logo.png">
			</a>
		</h1>
		<div class="tel">
			<h1>
				<a href="http://www.epicc.com.cn" title="PICC中国人民财险">中保官网 </a> |<a
					href="users/login">管理登陆</a>
			</h1>
		</div>
	</div>
	<div class="main">
		<div class="query">
			<div
				style="height: 220px; line-height: 40%; overflow: hidden; text-align: center;">
			</div>
			<div style="margin: 0 auto; width: 80%;">
				<form action="users/downjpg" method="post">
					<select id="option" style="border: none; padding: 10px">
						<option value="czdh">残值单号</option>
						<option value="czbm">残值编码</option>
					</select> <input type="text" id="code" name="code" /> <input type="submit"
						value="下载" style="width: 55px; height: 44px; float: right;" /><input
						type="button" value="查询" onclick="querycode();"
						style="width: 55px; height: 44px; float: right;" /> <input
						type="text" id="carLicensePlate" name="carLicensePlate"
						style="font-size: 15px; display: none" readonly="readonly" />
				</form>
			</div>
			<div class="result1" style="display: none" id="result1">
				<table>
					<tr>
						<td style="font-size: 20px;">报案号：</td>
						<td><input type="text" id="reportCode" name="reportCode"
							style="font-size: 15px;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td style="font-size: 20px;">车牌号：</td>
						<td><input type="text" id="carLicensePlate2"
							name="carLicensePlate" style="font-size: 15px;"
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td style="font-size: 20px;">残值上缴数量：</td>
						<td><input type="text" id="countNum" name="countNum"
							style="font-size: 15px;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td style="font-size: 20px;">残值录入日期：</td>
						<td><input type="text" id="entryDt" name="entryDt"
							style="font-size: 15px;" readonly="readonly" /></td>
					</tr>
				</table>
			</div>
			<div class="result2" style="display: none;" id="result2">
				<table>
					<tr>
						<td style="font-size: 20px;">定损员：</td>
						<td><input type="text" style="font-size: 15px;"
							id="workerName" name="workerName" /></td>
					</tr>
					<tr>
						<td style="font-size: 20px;">归属地：</td>
						<td><input type="text" style="font-size: 15px;" id="local"
							name="local" /></td>
					</tr>
					<tr>
						<td style="font-size: 20px;">生成日期：</td>
						<td><input type="text" style="font-size: 15px;" id="creDt"
							name="creDt" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>