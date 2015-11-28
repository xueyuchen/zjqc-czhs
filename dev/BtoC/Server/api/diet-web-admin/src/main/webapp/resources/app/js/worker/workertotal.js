function countPaper(pageIndex) {
	$('#table tbody').empty();
	$("#table1 tbody").empty();
	$("#table").hide();
	$("#table1").hide();
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
	if (workerName && local) {
		$.ajax({
			type : "post",
			url : "totalpaperbyworker",
			async : false,
			data : {
				fromDt : fromDt,
				toDt : toDt,
				workerName : workerName,
				local : local,
				size : 20,
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
						} else if (data.content[i].local == '3') {
							data.content[i].local = '东南';
						} else if (data.content[i].local == '4') {
							data.content[i].local = '东北';
						} else if (data.content[i].local == '0') {
							data.content[i].local = '本部';
						} else if (data.content[i].local == '5') {
							data.content[i].local = '大案';
						} else if (data.content[i].local == '6') {
							data.content[i].local = '快查';
						}
						html += "<tr><td>" + data.content[i].entryDt
								+ "</td><td>" + data.content[i].paperCode
								+ "</td><td>" + data.content[i].carLicensePlate
								+ "</td><td>" + data.content[i].reportCode
								+ "</td><td>" + data.content[i].printNum
								+ "</td><td>" + data.content[i].local + '/'
								+ data.content[i].workerName + "</td></tr>";
					}
				}
				$("#table1 tbody").append(html);
				pageFooter1(data.number, data.totalElements);
				$("#table1").show();
			}
		});
	} else {
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
						} else if (data.content[i].local == '3') {
							data.content[i].local = '东南';
						} else if (data.content[i].local == '4') {
							data.content[i].local = '东北';
						} else if (data.content[i].local == '0') {
							data.content[i].local = '本部';
						} else if (data.content[i].local == '5') {
							data.content[i].local = '大案';
						} else if (data.content[i].local == '6') {
							data.content[i].local = '快查';
						}
						html += "<tr><td>" + data.content[i].local
								+ "</td><td>" + data.content[i].workerName
								+ "</td><td>" + data.content[i].codeNum
								+ "</td><td>" + data.content[i].firstCode
								+ "</td><td>" + data.content[i].usedNum
								+ "</td><td>" + data.content[i].creDt
								+ "</td></tr>";
					}
				}
				$("#table tbody").append(html);
				pageFooter(data.number, data.totalElements);
				$("#table").show();
			}
		});
	}
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
function pageFooter1(pageIndex, count) {
	if (!$("#Pagination1").html()) {
		$("#Pagination1").pagination(count, {
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
