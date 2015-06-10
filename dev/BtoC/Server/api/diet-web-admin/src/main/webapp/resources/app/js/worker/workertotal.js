function countPaper(pageIndex) {
	$('#table tbody').empty();
	var fromDt = new Date($("#fromDt").val());
	var toDt = new Date($("#toDt").val());
	var workerName = $("#workerName").val();
	var local = $('#local').val();
	if (typeof (pageIndex) == "undefined") {
		pageIndex = 0;
	}
	if (!workerName && !local) {
		alert('定损员、区域请至少输入一项！');
		return false;
	}
	$.ajax({
		type : "post",
		url : "statisticsworker",
		async : false,
		data : {
			fromDt : fromDt,
			toDt : toDt,
			workerName : workerName,
			local : local,
			size : 10,
			page : pageIndex
		},
		success : function(data) {
			if (data) {
				console.log(data);
				var html = "";
				for ( var i in data.content) {
					if (data.content[i].local == '1') {
						data.content[i].local = '西南';
					} else if (data.content[i].local == '2') {
						data.content[i].local = '西北';
					}
					html += "<tr><td>" + data.content[i].local + "</td><td>"
							+ data.content[i].workerName + "</td><td>"
							+ data.content[i].codeNum + "</td><td>"
							+ data.content[i].usedNum + "</td><td>"
							+ data.content[i].creDt + "</td></tr>";
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
			items_per_page : 10,
			num_display_entries : 3,
			current_page : pageIndex,
			num_edge_entries : 2
		});
	}
}