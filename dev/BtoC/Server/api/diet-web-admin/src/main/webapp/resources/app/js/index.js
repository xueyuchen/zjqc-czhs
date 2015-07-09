function querycode() {
//	$("#result1").hide();
//	$("#result2").hide();
	$("#carLicensePlate").val("");
	var option = $("#option").val();
	var code = $("#code").val();
	if(!code){
		alert("请填写需要查询的编码号或单号");
		return;
	}
	$.ajax({
		type : "get",
		url : "users/querypaper",
		data : {
			option : option,
			code : code
		},
		async : false,
		success : function(data) {
			if (data) {
				alert(data.message);
				if (data.paper) {
					var str = '';
					$("#carLicensePlate").val(data.paper.carLicensePlate);
					$("#carLicensePlate2").val(data.paper.carLicensePlate);
					$("#reportCode").val(data.paper.reportCode);
					$("#paperCode").val(data.paperCode);
					$("#countNum").val(data.countNum);
					$("#reportCode").val(data.paper.reportCode);
					$("#entryDt").val(data.paper.entryDt);
					for(var i in data.worker){
						str += data.worker[i].workerName + " ";
					}
					$("#workers").val(str);
					Avgrund.show("#result1");
				}
				if (data.workerName) {
					$("#workerName").val(data.workerName);
					if (data.local == "1") {
						$('#local').val("西南");
					} else if (data.local == "2") {
						$('#local').val("西北");
//					} else if (data.local == "3") {
//						$('#local').val("南");
//					} else if (data.local == "4") {
//						$('#local').val("北");
					}
					$("#creDt").val(data.creDt);
					$("#entryDt1").val(data.entryDt);
					Avgrund.show("#result2");
				}
			}
		}
	});
}

function empty() {
	Avgrund.hide("#result2");
	Avgrund.hide("#result1");
	$("#code").val("");
	$("#carLicensePlate").val("");
	$("#carLicensePlate2").val("");
	$("#reportCode").val("");
	$("#countNum").val("");
	$("#reportCode").val("");
	$("#entryDt").val("");
	$("#workerName").val("");
	$('#local').val("");
	$("#creDt").val("");
	$("#entryDt1").val("");
//	$("#result1").hide();
//	$("#result2").hide();
	if ($("#option").val() == "czbm") {
		$("#submit").hide();
	} else {
		$("#submit").show();
	}
}