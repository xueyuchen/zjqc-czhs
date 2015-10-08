var searchSaled = function(){
	var searchPar = $('#searchPar').val();
	if(!searchPar){
		return false;
	}else{
		$.ajax({
			url: constants.findBySaled + '/' + searchPar,
			type: 'get',
			success: function(data){
				if(!data){
					alert("无法查询到此配件信息，请确认是否为已售配件！")
				}else{
					$('#form').attr('action', '../accessories/' + data.accessoryNum + '?re=1');
					$('#accessoryName').html(data.accessoryName);
					$('#accessoryNum').html(data.accessoryNum);
					$('#img').attr('src', data.accessoryImg);
					$('#level').val(data.level);
					$('#partId').val(data.partId);
					$('#msg').val(data.msg);
					$('#saleMoney').val(data.saleMoney);
				}
			}
		});
	}
}