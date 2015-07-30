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
					<a href="#">B库配件</a>
				</div>
				<div>
					<a href="#">入库查询</a>
				</div>
			</div>
			<div class="advertising-right"></div>
		</div>
		<div class="page-body">

			<div class="search-result">
				<div class="result-title"></div>
				<div class="img-list" id="accessory-list">
					<img
						style="display: block; width: 500px; float: left; margin-left: 15%;"
						src="image/part-img/100000.jpg" />

					<div style="float: left; margin-left: 100px; margin-top: 10%;">
						<table style="font-size: 20px;">
							<tr>
								<td>配件名称：</td>
								<td>${accessory.accessoryName}</td>
							</tr>
							<tr>
								<td>库房：</td>
								<td><select>
										<option>A库房</option>
										<option>B库房</option>
										<option>销售库房</option>
								</select></td>
							</tr>
							<tr>
								<td>维修状态：</td>
								<td><select>
										<option>未维修</option>
										<option>维修中</option>
										<option>已维修</option>
								</select></td>
							</tr>
							<tr>
								<td><input type="button" value="提交修改" /></td>
								<td><input type="button" value="返回"></td>
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