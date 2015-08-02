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
<script type="text/javascript" src="../resources/app/adminjs/listAcc.js"></script>
<script type="text/javascript" src="../resources/app/constants.js"></script>
<script type="text/javascript" src="../resources/app/adminjs/detial.js"></script>
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
			<div class="search" style="display: none">
				<img src="image/search.png"> <input id="searchPar" type="text"
					placeholder="奥迪 A6L 2014 左大灯(查询条件请以空格分开)" />
				<button id="searchAccessory">搜索</button>
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
				<div class="result-title"></div>
				<div class="img-list" id="accessory-list">
					<img
						style="display: block; width: 500px; float: left; margin-left: 10%;"
						src="${accessory.accessoryImg}" />

					<div style="float: left; margin-left: 50px; margin-top: 5%;">
						<table style="font-size: 20px;">
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
											<c:if test="${1 == accessory.level}">selected</c:if>>A库房</option>
										<option value=2
											<c:if test="${2 == accessory.level}">selected</c:if>>B库房</option>
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
											<c:if test="${3 == accessory.partId}">selected</c:if>>已维修</option>
								</select></td>
							</tr>
							<tr>
								<td><input type="button" value="提交修改" id="sbumit"
									onclick="submit();" /></td>
								<td><input type="button" value="返回" id="back" onclick="goBack();"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	// Custom example logic
	var url = constants.imgsUpload;
	var uploader = new plupload.Uploader(
			{
				runtimes : 'html5,flash,silverlight,html4',
				browse_button : 'pickfiles', // you can pass an id...
				container : document.getElementById('container'), // ... or DOM Element itself
				url : url,
				flash_swf_url : 'lib/plupload/Moxie.swf',
				silverlight_xap_url : 'lib/plupload/Moxie.xap',
				chunk_size : '500kb',

				filters : {
					max_file_size : '10mb',
					mime_types : [ {
						title : "Image files",
						extensions : "jpg,gif,png"
					} ]
				},

				init : {
					PostInit : function() {
						document.getElementById('filelist').innerHTML = '';

						document.getElementById('uploadfiles').onclick = function() {
							uploader.start();
							return false;
						};
					},

					FilesAdded : function(up, files) {
						plupload
								.each(
										files,
										function(file) {
											document.getElementById('filelist').innerHTML += '<div id="' + file.id + '">'
													+ file.name
													+ ' ('
													+ plupload
															.formatSize(file.size)
													+ ') <b></b></div>';
										});
					},

					UploadProgress : function(up, file) {
						document.getElementById(file.id).getElementsByTagName(
								'b')[0].innerHTML = '<span>' + file.percent
								+ "%</span>";
					},

					Error : function(up, err) {
						document.getElementById('console').appendChild(
								document.createTextNode("\nError #" + err.code
										+ ": " + err.message));
					}
				}
			});

	uploader.init();
</script>
</html>