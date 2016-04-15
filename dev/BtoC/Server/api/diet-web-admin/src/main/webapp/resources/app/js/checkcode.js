function checkcode() {
	$("#workerName").val("");
	$("#creDt").val("");
	$("#local").val("");
	$("#message").val("");
	var codeNum = $('#codeNum').val();
	if (!codeNum) {
		alert("请输入残值编码！");
		return;
	}
	$.ajax({
		type : "post",
		url : "checkcode",
		async : false,
		data : {
			codeNum : codeNum
		},
		success : function(data) {
			alert(data.message);
			$('#workerName').val(data.workerName);
			$('#creDt').val(data.creDt);
			$('#message').val(data.message).css('color', 'red');
			if (data.local == "1") {
				$('#local').val("西南");
			} else if (data.local == "2") {
				$('#local').val("西北");
			} else if (data.local == "3") {
				$('#local').val("东南");
			} else if (data.local == "4") {
				$('#local').val("东北");
			} else if (data.local == "5") {
				$('#local').val("大案");
			} else if (data.local == "6") {
				$('#local').val("快查");
			} else if (data.local == "7") {
				$('#local').val("车商");
			} else if (data.local == "0") {
				$('#local').val("本部");
			} else if (data.local == "8") {
				$('#local').val("国际");
			}
		}
	});
}