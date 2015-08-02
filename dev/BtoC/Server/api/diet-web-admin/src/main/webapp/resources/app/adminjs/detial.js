function submit(){
	var partId = $("#partId").val();
	var level = $("#level").val();
	var accessoryNum = $("#accessoryNum").html();
	$.ajax({
		url : constants.accessory + "\\" + accessoryNum,
		data: {
			level: level,
			partId: partId
		},
		type: 'post',
		success: function(){
			alert("配件状态修改成功");
		}
	});
}

function goBack(){
	window.history.back();
}