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
<link rel="stylesheet" href="../resources/app/adminjs/bootstrap.min.css">
<link rel="stylesheet"
	href="../resources/app/adminjs/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/app/adminjs/dashboard.css">
<script type="text/javascript" src="../resources/app/adminjs/listAcc.js"></script>
<script type="text/javascript" src="../resources/app/constants.js"></script>
<script type="text/javascript"
	src="../resources/app/adminjs/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">配件销售系统</a>
		</div>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="../admin/admin">A库照片上传</a></li>
					<li><a href="../admin/changes">A库库存查询</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../admin/uploadtoB">B库照片上传</a></li>
					<li><a href="../admin/changesB">B库库存查询</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="#">销售记录查询</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">A库配件照片上传</h1>

				<p>友情提示：一次可以上传多张照片，所有照片上传进度为100%后，才能关闭浏览器</p>

				<div id="filelist">Your browser doesn't have Flash,
					Silverlight or HTML5 support.</div>
				<br />

				<div id="container">
					<button type="button" class="btn btn-primary" id="pickfiles">选择照片</button>
					<button type="button" class="btn btn-primary" id="uploadfiles">上传照片</button>
					<button id="copyfiles" class="btn btn-primary" onclick="finishUpload();">复制照片到A库</button>
				</div>

				<br />
				<pre id="console"></pre>
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
						plupload.each(files, function(file) {
											document.getElementById('filelist').innerHTML += '<div style="  display: block;float: left;width: 40%;" id="' + file.id + '">'
													+ file.name
													+ ' ('
													+ plupload.formatSize(file.size)
													+ ') </div>' + '<div class="progress" style="width: 60%">'
								                    + '<div class="progress-bar" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">0%'
							                    + '</div></div>';
										});
					},

					UploadProgress : function(up, file) {
						$("#"+file.id).next().children().css("width", file.percent+"%").html(file.percent + "%");
						//document.getElementById(file.id).getElementsByTagName(
						//		'b')[0].innerHTML = '<span>' + file.percent
						//		+ "%</span>";
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