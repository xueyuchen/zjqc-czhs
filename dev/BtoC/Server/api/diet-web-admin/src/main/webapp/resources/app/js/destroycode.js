function destroycode() {
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
function showWorker() {
	$('#worker').empty();
	var local = $('#local').val();
	$.ajax({
		type : "get",
		url : "getworkers",
		async : false,
		data : {
			local : local
		},
		success : function(data) {
			for ( var i in data) {
				$('#worker').append(
						'<option value=' + data[i].workerId + '>'
								+ data[i].workerName + '</option>');
			}
		},
		error : function(data) {
			alert(data.message);
		}
	});
}

function expiredcode() {
	$.ajax({
		type : "get",
		url : "expiredcode",
		async : false,
		success : function() {
			alert("注销成功！");
		},
		error : function() {
			alert("注销失败！请联系管理员！");
		}
	});
}