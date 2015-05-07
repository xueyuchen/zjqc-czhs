function createfile(){
	$.ajax({
		type : "get",
		url : "createfile.do",
		async : false,
		success : function(data) {
			if(data){
				alert('残值编码文件生成完成');
			}
		},
		error : function(data) {
			alert(data.message);
		}
	});
}