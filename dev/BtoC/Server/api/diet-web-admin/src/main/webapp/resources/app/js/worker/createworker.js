function createworker() {
	var local = $("#local").val();
	var workerName = $("#workerName").val();
	$.ajax({
		type : "post",
		url : "createworker",
		async : false,
		data : {
			local : local,
			workerName : workerName
		},
		success : function(data) {
			alert(data.message);
		},
		error : function(data) {
			alert(data.message);
		}
	});
}