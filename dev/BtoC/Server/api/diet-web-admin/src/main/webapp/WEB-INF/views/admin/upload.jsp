<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../resources/app/jsuser/jquery.min.js"></script>
<script type="text/javascript" src="../resources/app/plupload/plupload.full.min.js"></script>
<script type="text/javascript" src="../resources/app/plupload/jquery.ui.plupload/jquery.ui.plupload.js"></script>
<script type="text/javascript" src="../resources/app/plupload/i18n/zh_CN.js"></script>
<script type="text/javascript" src="../resources/app/constants.js"></script>
</head>
<body style="font: 13px Verdana; background: #eee; color: #333">
	<h1>配件照片上传</h1>

	<p>友情提示：一次可以上传多张照片，所有照片上传进度为100%后，才能关闭浏览器</p>

	<div id="filelist">Your browser doesn't have Flash, Silverlight
		or HTML5 support.</div>
	<br />

	<div id="container">
		<a id="pickfiles" href="javascript:;">[选择照片]</a> <a id="uploadfiles"
			href="javascript:;">[上传照片]</a>
	</div>

	<br />
	<pre id="console"></pre>


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
												document
														.getElementById('filelist').innerHTML += '<div id="' + file.id + '">'
														+ file.name
														+ ' ('
														+ plupload
																.formatSize(file.size)
														+ ') <b></b></div>';
											});
						},

						UploadProgress : function(up, file) {
							document.getElementById(file.id)
									.getElementsByTagName('b')[0].innerHTML = '<span>'
									+ file.percent + "%</span>";
						},

						Error : function(up, err) {
							document.getElementById('console').appendChild(
									document.createTextNode("\nError #"
											+ err.code + ": " + err.message));
						}
					}
				});

		uploader.init();
	</script>
</body>
</html>