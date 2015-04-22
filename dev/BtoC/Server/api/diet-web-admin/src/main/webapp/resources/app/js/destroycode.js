function destroycode(){
	var workerId = $("#worker").val();
	$.ajax({
		type : "post",
		url : "destroycode",
		data : {
			workerId : workerId,
		},
		success : function(data) {
			alert(data.message);
		},
		error : function(data) {
			alert(data.message);
		}
	});
}