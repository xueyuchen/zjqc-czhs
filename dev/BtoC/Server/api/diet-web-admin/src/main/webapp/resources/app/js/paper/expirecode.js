function expirecode() {
	var codeArray = $('#codeArray').val();
	if (!codeArray) {
		alert("请输入需要注销的残值编码！");
		return;
	}
	$.ajax({
		type : "post",
		url : "expire",
		async : false,
		data : {
			codeArray : codeArray
		},
		success : function(data) {
			$("#codeArrayInfos").text("残值编码已注销，本次注销数量：" + data);
			alert("残值编码已注销！");
		}
	});
}