function crecode() {
	var num = $("#num").val();
	var workerId = $("#workerId").val();
	$.ajax({
		type : "get",
		url : "createcode.do",
		async : false,
		data : {
			num : num,
			workerId : workerId
		},
		success : function(data) {
			alert('残值编码生成成功！');
		},
		error : function(data) {
			alert(data.message);
		}
	});
}