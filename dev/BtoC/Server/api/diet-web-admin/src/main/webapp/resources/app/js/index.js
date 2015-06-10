function querycode() {
	$("#result1").hide();
	$("#result2").hide();
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
					$("#carLicensePlate").val(data.paper.carLicensePlate);
					$("#carLicensePlate2").val(data.paper.carLicensePlate);
					$("#reportCode").val(data.paper.reportCode);
					$("#countNum").val(data.countNum);
					$("#reportCode").val(data.paper.reportCode);
					$("#entryDt").val(data.paper.entryDt);
					$("#result1").show();
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
					$("#result2").show();
				}
			}
		}
	});
}

function empty() {
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
	$("#result1").hide();
	$("#result2").hide();
	if ($("#option").val() == "czbm") {
		$("#submit").hide();
	} else {
		$("#submit").show();
	}
}