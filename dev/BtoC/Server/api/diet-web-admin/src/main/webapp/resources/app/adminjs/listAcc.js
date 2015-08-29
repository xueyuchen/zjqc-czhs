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
						if (data[i].level == 1) {
							data[i].level = "A库房";
						} else if (data[i].level == 2) {
							data[i].level = "B库房";
						}
						if (data[i].partId == 1) {
							data[i].partId = "未维修";
						} else if (data[i].partId == 2) {
							data[i].partId = "维修中";
						} else if (data[i].partId == 3) {
							data[i].partId = "已维修";
						}
						str = str
								+ '<div class="part-detial"><img src="data:image/jpg;base64,'
								+ data[i].accessoryImg + '">'
								+ '<a href="../accessories/'
								+ data[i].accessoryNum + '">'
								+ data[i].accessoryName
								+ '</a><br><span>编号：</span>'
								+ data[i].accessoryNum + '<br><span>状态：</span>'
								+ data[i].partId + '</div>';
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
	$("#copyfiles").attr("disabled", "disabled");
	$("#copyfiles").html("照片处理中...");
	var partId = $("#partId").val();
	$.ajax({
		url : constants.savephotoa + "?partId=" + partId,
		type : 'get',
		success : function() {
			$("#copyfiles").removeAttr("disabled");
			$("#copyfiles").html("复制照片到A库");
			alert("照片整理完成！");
		}
	});
}

function finishUploadToB() {
	$("#copyfiles").attr("disabled", "disabled");
	$("#copyfiles").html("照片处理中...");
	$.ajax({
		url : constants.savephotob,
		type : 'get',
		success : function() {
			$("#copyfiles").removeAttr("disabled");
			$("#copyfiles").html("复制照片到B库");
			alert("照片整理完成！");
		}
	});
}

var pageable = {
	firstPage : 0,
	totalPage : null,
	currentPage : null,
	hasNextPage : false,
	nextPage : null
};
function searchByLuceneAll() {
	var key = $('#searchPar').val();
	$.callBack = true;
	$
			.ajax({
				url : constants.searchByLuceneAll + "?key=" + key + "&page="
						+ pageable.firstPage,
				type : "get",
				success : function(data) {
					if (data.totalElements > 16 * data.page) {
						pageable.hasNextPage = true;
						pageable.nextPage = data.page;
					} else {
						pageable.hasNextPage = false;
					}
					$("#accessory-list").empty();
					var str = "";
					for ( var i in data.content) {
						if (data.content[i].partId == 1) {
							data.content[i].partId = "未维修";
						} else if (data.content[i].partId == 2) {
							data.content[i].partId = "维修中";
						} else if (data.content[i].partId == 3) {
							data.content[i].partId = "已维修";
						}
						if (data.content[i].level == 1) {
							data.content[i].level = "A库房";
						} else if (data.content[i].level == 2) {
							data.content[i].level = "B库房";
						}
						str = str
								+ '<div class="part-detial"><img src="data:image/jpg;base64,'
								+ data.content[i].accessoryImg + '">'
								+ '<a href="../accessories/'
								+ data.content[i].accessoryNum + '">'
								+ data.content[i].accessoryName
								+ '</a><br>编号：<span>'
								+ data.content[i].accessoryNum + '</span><br>'
								+ data.content[i].level
								+ '&nbsp<span>状态：</span>'
								+ data.content[i].partId + '</div>';
					}
					$("#accessory-list").append(str);
				}
			});
}
function searchByLuceneA() {
	var key = $('#searchPar').val();
	$.callBack = true;
	$
			.ajax({
				url : constants.searchByLuceneA + "?key=" + key + "&page="
						+ pageable.firstPage,
				type : "get",
				success : function(data) {
					if (data.totalElements > 16 * data.page) {
						pageable.hasNextPage = true;
						pageable.nextPage = data.page;
					} else {
						pageable.hasNextPage = false;
					}
					$("#accessory-list").empty();
					var str = "";
					for ( var i in data.content) {
						if (data.content[i].partId == 1) {
							data.content[i].partId = "未维修";
						} else if (data.content[i].partId == 2) {
							data.content[i].partId = "维修中";
						} else if (data.content[i].partId == 3) {
							data.content[i].partId = "已维修";
						}
						str = str
						+'<div class="col-sm-6 col-md-3"><div class="thumbnail">'
						+'<img id='
						+data.content[i].accessoryNum +' src="data:image/jpg;base64,'
						+data.content[i].accessoryImg +'" alt="..."><div class="caption"><h5>'
						+data.content[i].accessoryName+'</h5><span>'
						+data.content[i].accessoryNum + '</span>&nbsp<span>'
						+data.content[i].partId + '</span>&nbsp<br><span>'
						+data.content[i].msg + '&nbsp&nbsp&nbsp</span>'
						+'<a href="../accessories/'
						+data.content[i].accessoryNum +'" class="btn btn-primary" role="button">修改</a>'
						+'</div></div></div>'
					}
					$("#accessory-list").append(str);
				}
			});
}

function searchByLuceneB() {
	var key = $('#searchPar').val();
	$.callBack = true;
	$
			.ajax({
				url : constants.searchByLuceneB + "?key=" + key + "&page="
						+ pageable.firstPage,
				type : "get",
				success : function(data) {
					if (data.totalElements > 16 * page) {
						pageable.hasNextPage = true;
						pageable.nextPage = page;
					} else {
						pageable.hasNextPage = false;
					}
					$("#accessory-list").empty();
					var str = "";
					for ( var i in data.content) {
						if (data.content[i].partId == 1) {
							data.content[i].partId = "未维修";
						} else if (data.content[i].partId == 2) {
							data.content[i].partId = "维修中";
						} else if (data.content[i].partId == 3) {
							data.content[i].partId = "已维修";
						}
						str = str
								+ '<div class="part-detial"><img src="data:image/jpg;base64,'
								+ data.content[i].accessoryImg + '">'
								+ '<a href="../accessories/'
								+ data.content[i].accessoryNum + '">'
								+ data.content[i].accessoryName
								+ '</a><br><span>编号：</span>'
								+ data.content[i].accessoryNum
								+ '<br><span>状态：</span>'
								+ data.content[i].partId + '</div>';
					}
					$("#accessory-list").append(str);
				}
			});
}
function toModifyList() {
	var $numList = $('.dropdown-menu').children().eq(1).nextAll();
	var numList = '';
	for (var i = 0; i < $numList.length; i++) {
		console.log($($numList[i]).children().html());
		numList = numList + $($numList[i]).children().html() + ",";
	}
	$('#numList').val(numList);
	$('#listForm').submit();
}
function saveNum(e) {
	alert(e);
}
$(window)
		.on(
				"scroll",
				function() {
					var key = $("#searchPar").val();
					console.log($(document).scrollTop());
					console.log($(document).height());
					console.log($(window).height());
					console.log(pageable);
					if ($(document).scrollTop() >= $(document).height()
							- $(window).height()) {
						console.log(pageable);
						if (pageable.hasNextPage && $.callBack == true) {
							$.callBack = false;
							$
									.ajax({
										url : constants.searchByLuceneA
												+ "?key=" + key + "&page="
												+ pageable.nextPage,
										type : "get",
										success : function(data) {
											if (data.totalElements > 30 * data.page) {
												pageable.hasNextPage = true;
												pageable.nextPage = data.page;
											} else {
												pageable.hasNextPage = false;
											}
											var str = "";
											for ( var i in data.content) {
												if (data.content[i].partId == 1) {
													data.content[i].partId = "未维修";
												} else if (data.content[i].partId == 2) {
													data.content[i].partId = "维修中";
												} else if (data.content[i].partId == 3) {
													data.content[i].partId = "已维修";
												}
												str = str
												+'<div class="col-sm-6 col-md-3"><div class="thumbnail">'
												+'<img id='
												+data.content[i].accessoryNum +' src="data:image/jpg;base64,'
												+data.content[i].accessoryImg +'" alt="..."><div class="caption"><h5>'
												+data.content[i].accessoryName+'</h5><span>'
												+data.content[i].accessoryNum + '</span>&nbsp<span>'
												+data.content[i].partId + '</span>&nbsp<br><span>'
												+data.content[i].msg + '&nbsp&nbsp&nbsp</span>'
												+'<a href="../accessories/'
												+data.content[i].accessoryNum +'" class="btn btn-primary" role="button">修改</a>'
												+'</div></div></div>'
											}
											$("#accessory-list").append(str);
											$.callBack = true;
										}
									});
						}
					}
				});
