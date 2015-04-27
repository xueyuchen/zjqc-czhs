function querycode() {
	var option = $("#option").val();
	var code = $("#code").val();
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
				$("#reportCode").val(data.reportCode);
			}
		}
	});
}