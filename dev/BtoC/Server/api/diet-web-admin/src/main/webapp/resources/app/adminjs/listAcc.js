function changeDate() {
	$("#accessory-list").empty();
	var key = $("#key").val();
	if (!key) {
		return null;
	}
	$
			.ajax({
				url : constants.searchByDate + "?key=" + key,
				type : "get",
				success : function(data) {
					var str = "";
					for ( var i in data) {
						str = str
								+ '<div class="part-detial"><img src="data:image/jpg;base64,'
								+ data[i].accessoryImg + '">'
								+ '<a href="../accessories/' + data[i].accessoryNum
								+ '">' + data[i].accessoryName
								+ '</a><br><span>编号：</span>'
								+ data[i].accessoryNum + '</div>';
					}
					$("#accessory-list").append(str);
				}
			});
}

function searchByNum() {
	$("#accessory-list").empty();
	var accessoryNum = $("#searchPar").val();
	if (!accessoryNum) {
		return null;
	} else {
		$
				.ajax({
					url : constants.accessory + "\\" + accessoryNum,
					type : "get",
					success : function(data) {
						var str = "";
						str = str
								+ '<div class="part-detial"><img src="data:image/jpg;base64,'
								+ data.accessoryImg + '">' + '<span>'
								+ data.accessoryName
								+ '</span><br><span>编号：</span>'
								+ data.accessoryNum + '</div>';
						$("#accessory-list").append(str);
					}
				});
	}
}

function finishUpload() {
	$.ajax({
		url : constants.savephotoa,
		type : 'get',
		success : function() {
			alert("照片整理完成！");
		}
	});
}
