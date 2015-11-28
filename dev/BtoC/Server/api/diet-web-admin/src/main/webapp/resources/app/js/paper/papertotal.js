function countPaper(pageIndex) {
	$('#table tbody').empty();
	var fromDt = new Date($("#fromDt").val());
	var toDt = new Date($("#toDt").val());
	if (typeof (pageIndex) == "undefined") {
		pageIndex = 0;
	}
	$.ajax({
		type : "get",
		url : "StatisticsPaper",
		async : false,
		data : {
			fromDt : fromDt,
			toDt : toDt,
			size : 20,
			page : pageIndex
		},
		success : function(data) {
			if (data) {
				console.log(data);
				var html = "";
				for ( var i in data.content) {
					var issu = '';
					for ( var j in data.content[i].workers) {
						if (data.content[i].workers[j].local == '1') {
							data.content[i].workers[j].local = '西南';
						} else if (data.content[i].workers[j].local == '2') {
							data.content[i].workers[j].local = '西北';
						} else if (data.content[i].workers[j].local == '3') {
							data.content[i].workers[j].local = '东南';
						} else if (data.content[i].workers[j].local == '4') {
							data.content[i].workers[j].local = '东北';
						} else if (data.content[i].workers[j].local == '0') {
							data.content[i].workers[j].local = '本部';
						} else if (data.content[i].workers[j].local == '5') {
							data.content[i].workers[j].local = '大案';
						} else if (data.content[i].workers[j].local == '6') {
							data.content[i].workers[j].local = '快查';
						}
						issu = data.content[i].workers[j].local + ' '
								+ data.content[i].workers[j].workerName + '/'
								+ issu;
					}
					html += "<tr><td>" + data.content[i].entryDt + "</td><td>"
							+ data.content[i].paperCode + "</td><td>"
							+ data.content[i].carLicensePlate + "</td><td>"
							+ data.content[i].reportCode + "</td><td>"
							+ data.content[i].printNum + "</td><td>" + issu
							+ "</td></tr>";
				}
			}
			$("#table tbody").append(html);
			pageFooter(data.number, data.totalElements);
		}
	});
}
function pageFooter(pageIndex, count) {
	if (!$("#Pagination").html()) {
		$("#Pagination").pagination(count, {
			callback : countPaper,
			prev_text : '< 上一页',
			next_text : '下一页 >',
			items_per_page : 20,
			num_display_entries : 3,
			current_page : pageIndex,
			num_edge_entries : 2
		});
	}
}