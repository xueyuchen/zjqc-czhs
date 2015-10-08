function submitInfo(){
	$("#sbumit").attr("disabled", "disabled");
	$("#sbumit").html("等待处理");
	$('#form').ajaxSubmit(function(){
		$("#sbumit").removeAttr("disabled");
		$("#sbumit").html("提交修改");
		alert("配件状态修改成功");
	});
	return false;
}

function goBack(){
	window.history.back();
}