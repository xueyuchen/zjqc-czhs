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
			if(data.local == "1"){
				$('#local').val("东");
			}else if(data.local == "2"){
				$('#local').val("西");
			}else if(data.local == "3"){
				$('#local').val("南");
			}else if(data.local == "4"){
				$('#local').val("北");
			}
		}
	});
}