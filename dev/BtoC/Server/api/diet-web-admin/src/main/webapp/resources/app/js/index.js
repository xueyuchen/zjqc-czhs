function querycode() {
	var option = $("#option").val();
	var code = $("#code").val();
	var paperCode = $('#paperCode').val();
	$.ajax({
		type : "get",
		url : "users/querypaper",
		data : {
			option : option,
			code : code,
			paperCode : paperCode
		},
		async : false,
		success : function(data) {
			if (data) {
				alert(data.message);
				$("#carLicensePlate").val(data.carLicensePlate);
			}
		}
	});
}