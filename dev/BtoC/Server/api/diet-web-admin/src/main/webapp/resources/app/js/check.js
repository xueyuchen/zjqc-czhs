document.write("script language='javascript' src='/js_lib/jquery.js'></script")
function sendForm(){
	alert("123");
	$.ajax({url:"code/checkcode", data:$("#codeNum"), success:function(data){
		alert(data.map.message);
	}});
}