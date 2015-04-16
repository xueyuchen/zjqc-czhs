function downloadfile(){
	$.ajax({
		type : "get",
		url : "downfile.do",
		async : false,
		success: function(data) {
			if(data){
				alert('文件下载成功！');
			}
		}
	});
}