function checkcode() {
	var codeNum = $('#codeNum').val();
	$.ajax({
		type : "post",
		url : "checkcode",
		async : false,
		data : {
			codeNum: codeNum
		},
		success : function(data) {
			alert(data.message);
			$('#workerName').val(data.workerName);
			$('#creDt').val(data.creDt);
			$('#message').val(data.message).css('color','red');
			$('#local').val(data.local);
		}
	});
}