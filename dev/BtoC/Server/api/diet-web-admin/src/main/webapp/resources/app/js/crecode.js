function crecode() {
	var local = $("#local").val();
	var num = $("#num").val();
	var person = $("#person").val();
	if (!num || num == '') {
		alert('请输入需要创建的残值编码数量');
		return false;
	}
	if (!person || person == '') {
		alert('请输入此批条码对应人员姓名');
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
			person : person
		},
		success : function(data) {
			alert('残值编码生成成功！');
		},
		error : function(data) {
			alert(data.message);
		}
	});
}