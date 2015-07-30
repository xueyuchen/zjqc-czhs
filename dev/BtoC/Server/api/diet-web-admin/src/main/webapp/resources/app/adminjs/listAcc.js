function changeDate(){
	$("#accessory-list").empty();
	var key = $("#key").val();
	if(!key){
		return null;
	}
	$.ajax({
		url: constants.accessoriesSearch + "?key=" + key,
		type: "get",
		success: function(data){
			var str = "";
			for(var i in data){
				str = str + '<div class="part-detial"><img src="'+data[i].accessoryImg +'">' + '<span>' + data[i].accessoryName + '</span><br><span>编号：</span>' + data[i].accessoryNum + '</div>';
			}
			$("#accessory-list").append(str);
		}
	});
}

function finishUpload(){
	$.ajax({
		url: constants.copy,
		type: 'get',
		success: function(){
			alert("照片整理完成！");
		}
	});
}