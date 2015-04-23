function enterpaper() {
	var paperCode = $('#paperCode').val();
	var reportCode = $('#reportCode').val();
	var carLicensePlate = $('#carLicensePlate').val();
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
			for(var i in data){
				allMessage = allMessage + data[i] + "\n";
			}
			$("#codeArrayInfos").text(allMessage);
		}
	});
}