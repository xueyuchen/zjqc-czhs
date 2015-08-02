<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../resources/app/jsuser/jquery.min.js"></script>
<script type="text/javascript"
	src="../resources/app/plupload/plupload.full.min.js"></script>
<script type="text/javascript"
	src="../resources/app/plupload/jquery.ui.plupload/jquery.ui.plupload.js"></script>
<script type="text/javascript"
	src="../resources/app/plupload/i18n/zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="../resources/app/admin/style.css" />
<script type="text/javascript" src="../resources/app/constants.js"></script>
<script type="text/javascript" src="../resources/app/adminjs/listAcc_B.js"></script>
</head>
<body>
	<div class="container">
		<!--<div class="before-header">-->

		<!--</div>-->
		<header>
		<div class="title-box">
			<span>子杰汽车配件专卖</span>
		</div>
		<div class="search-box">
			<div class="search">
				<img src="image/search.png"> <input id="searchPar" type="text"
					placeholder="输入编号进行查询" oninput="searchByLuceneB();"/>
				<button id="searchAccessory" onclick="searchByNum();">搜索</button>
			</div>

		</div>
		<div class="login-box"></div>
		</header>
		<div class="advertising">
			<div class="advertising-left">
				<div>
					<a href="../admin/admin">A库照片上传</a>
				</div>
				<div>
					<a href="../admin/changes">A库配件</a>
				</div>
				<div>
					<a href="../admin/uploadtoB">B库照片上传</a>
				</div>
				<div>
					<a href="../admin/changesB">B库配件</a>
				</div>
			</div>
			<div class="advertising-right"></div>
		</div>
		<div class="page-body">

			<div class="search-result">
				<div class="result-title">
					<!-- <input type="date" id="key" onchange="changeDateB();" /> -->
				</div>
				<div class="img-list" id="accessory-list"></div>
			</div>
		</div>
	</div>
</body>
</html>