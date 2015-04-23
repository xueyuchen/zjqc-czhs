function countPaper() {
	var fromDt = new Date($("#fromDt").val());
	var toDt = new Date($("#toDt").val());
	$.ajax({
		type : "get",
		url : "StatisticsPaper",
		async : false,
		data : {
			fromDt : fromDt,
			toDt : toDt
		},
		success : function(data) {
			if (data) {
				console.log(data);
				var html = "";
				for ( var i in data) {
					console.log(data[i].carLicensePlate);
					html += "<tr><td>" + data[i].paperCode + "</td><td>"
							+ data[i].carLicensePlate + "</td><td>"
							+ data[i].reportCode + "</td><td>"
							+ data[i].countCode + "</td></tr>";
				}
			}
			$("#table").append(html);
		}
	});
}