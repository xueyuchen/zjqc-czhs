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
			window.location.href = "todestroy";
		},
		error : function(data) {
			alert(data.message);
		}
	});
}