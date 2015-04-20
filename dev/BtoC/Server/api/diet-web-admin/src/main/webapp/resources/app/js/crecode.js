function crecode() {
	var local = $("#local").val();
	var num = $("#num").val();
	var workerId = $("#workerId").val();
	if (!local || local == '') {
		alert('请输入此批条码归属地');
		return false;
	}
	$.ajax({
		type : "post",
		url : "createcode.do",
		async : false,
		dataType : "json",
		data : {
			local : local,
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