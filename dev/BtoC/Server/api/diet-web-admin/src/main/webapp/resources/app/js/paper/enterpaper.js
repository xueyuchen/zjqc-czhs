function checkpaper() {
	var paperCode = $('#paperCode').val();
	var reportCode = $('#reportCode').val();
	var carLicensePlate = $('#carLicensePlate').val();
	var codeArray = $('#codeArray').val();
	if(!paperCode || !reportCode || !carLicensePlate || !codeArray){
		alert("请输入完整的录入信息！");
		return;
	}
	$.ajax({
		type : "post",
		url : "check",
		async : false,
		data : {
			paperCode : paperCode,
			reportCode : reportCode,
			carLicensePlate : carLicensePlate,
			codeArray : codeArray
		},
		success : function(data) {
			var allMessage = "";
			for ( var i in data.errors) {
				allMessage = allMessage + data.errors[i] + "\n";
			}
			$("#codeArrayInfos").text(allMessage);
			$("#codeTotal").val(data.codeTotal);
		}
	});
}

function entrypaper() {
	var paperCode = $('#paperCode').val();
	var reportCode = $('#reportCode').val();
	var carLicensePlate = $('#abbr').val() + $('#carLicensePlate').val();
	var codeArray = $('#codeArray').val();
	$.ajax({
		type : "post",
		url : "enter",
		async : false,
		data : {
			paperCode : paperCode,
			reportCode : reportCode,
			carLicensePlate : carLicensePlate,
			codeArray : codeArray
		},
		success : function(data) {
			var allMessage = "";
			for ( var i in data.errors) {
				allMessage = allMessage + data.errors[i] + "\n";
			}
			$("#codeArrayInfos").text(allMessage);
			$("#codeTotal").val(data.codeTotal);
		}
	});
}

function reset() {
	$("#codeArrayInfos").text("");
	$("#codeTotal").val("");
	$("#paperCode").val("");
	$("#reportCode").val("");
	$("#carLicensePlate").val("");
	$("#codeArray").val("");
}