function crecode() {
	var num = $("#num").val();
	var workerId = $("#workerId").val();
	$.ajax({
		type : "get",
		url : "createcode.do",
		async : false,
		data : {
			num : num,
			workerId : workerId
		},
		success : function(data) {
			alert('残值编码生成成功！');
		},
		error : function(data) {
			alert(data.message);
		}
	});
}
function showWorker() {
	$('#workerId').empty();
	var local = $('#local').val();
	$.ajax({
		type : "get",
		url : "getworkers",
		async : false,
		data : {
			local : local
		},
		success : function(data) {
			for(var i in data){
				$('#workerId').append('<option value='+ data[i].workerId +'>'+ data[i].workerName +'</option>');
			}
		},
		error : function(data) {
			alert(data.message);
		}
	});
}