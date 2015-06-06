function countPaper() {
	$('#table tbody').empty();
	var fromDt = new Date($("#fromDt").val());
	var toDt = new Date($("#toDt").val());
	var workerName = $("#workerName").val();
	$.ajax({
		type : "post",
		url : "statisticsworker",
		async : false,
		data : {
			fromDt : fromDt,
			toDt : toDt,
			workerName: workerName
		},
		success : function(data) {
			if (data) {
				console.log(data);
				var html = "";
				for ( var i in data) {
					console.log(data[i].carLicensePlate);
					html += "<tr><td>" + data[i].workerName + "</td><td>"
							+ data[i].codeNum + "</td><td>"
							+ data[i].creDt + "</td></tr>";
				}
			}
			$("#table").append(html);
		}
	});
}