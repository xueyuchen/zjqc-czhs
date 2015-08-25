function login() {
	var username = $('#username').val();
	var password = $('#password').val();
	$.ajax({
		url : "login",
		type : 'post',
		data : {
			username : username,
			password : password
		},
		success : function(data) {
		},
		error : function() {
		}
	});
}