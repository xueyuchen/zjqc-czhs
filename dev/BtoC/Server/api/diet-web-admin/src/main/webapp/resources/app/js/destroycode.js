function destroycode(){
	var person = $("#persons").val();
	$.ajax({
		type : "post",
		url : "destroycode.do",
		async : false,
		dataType : "json",
		data : {
			person : person,
		},
		success : function(data) {
			alert('残值编码销毁成功！');
		},
		error : function(data) {
			alert(data.message);
		}
	});
}