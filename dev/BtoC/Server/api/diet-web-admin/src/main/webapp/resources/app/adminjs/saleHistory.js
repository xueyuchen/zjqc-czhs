Date.prototype.Format = function(fmt) { // author: meizz
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}
var saledHistory = function(isNext) {
	$('#accessory-list').empty();
	var dateStr = $('#centerDate').html();
	if(!dateStr){
		var dateStr = new Date().Format('yyyy-MM-dd');
	}
	console.log(dateStr);
	$.ajax({
		url : constants.saleHistory,
		type : 'get',
		data : {
			dateStr : dateStr,
			isNext : isNext
		},
		success : function(data) {
			console.log(data);
			for (var i = 0; i < data.days.length; i++) {
				data.days[i] = data.days[i].substring(0, 10);
				if(i == 1){
					$('#centerDate').html(data.days[i]);
				}
			}
			var barChartData = {
				labels : data.days,
				datasets : [ {
					fillColor : "rgba(151,187,205,0.5)",
					strokeColor : "rgba(151,187,205,0.8)",
					highlightFill : "rgba(151,187,205,0.75)",
					highlightStroke : "rgba(151,187,205,1)",
					data : data.num
				}, {
					fillColor : "rgba(220,220,220,0.5)",
					strokeColor : "rgba(220,220,220,0.8)",
					highlightFill : "rgba(220,220,220,0.75)",
					highlightStroke : "rgba(220,220,220,1)",
					data : data.inNum
				} ]
			}
			var ctx = document.getElementById("canvas-sale").getContext("2d");
			window.myBar = new Chart(ctx).Bar(barChartData, {
				responsive : true
			});
			for (var j = 0; j < data.accessories.length; j++) {
				$('#accessory-list').append(
						'<li class="list-group-item">'
								+ data.accessories[j].accessoryName + '&nbsp'
								+ '￥' + data.accessories[j].saleMoney +'</li>')
			}
		}
	});
}

var saledBHistory = function(isNext) {
	$('#accessory-list').empty();
	var dateStr = $('#centerDate').html();
	if(!dateStr){
		var dateStr = new Date().Format('yyyy-MM-dd');
	}
	console.log(dateStr);
	$.ajax({
		url : constants.saleBHistory,
		type : 'get',
		data : {
			dateStr : dateStr,
			isNext : isNext
		},
		success : function(data) {
			console.log(data);
			for (var i = 0; i < data.days.length; i++) {
				data.days[i] = data.days[i].substring(0, 10);
				if(i == 1){
					$('#centerDate').html(data.days[i]);
				}
			}
			var barChartData = {
				labels : data.days,
				datasets : [ {
					fillColor : "rgba(151,187,205,0.5)",
					strokeColor : "rgba(151,187,205,0.8)",
					highlightFill : "rgba(151,187,205,0.75)",
					highlightStroke : "rgba(151,187,205,1)",
					data : data.num
				}, {
					fillColor : "rgba(220,220,220,0.5)",
					strokeColor : "rgba(220,220,220,0.8)",
					highlightFill : "rgba(220,220,220,0.75)",
					highlightStroke : "rgba(220,220,220,1)",
					data : data.inNum
				} ]
			}
			var ctx = document.getElementById("canvas-sale").getContext("2d");
			window.myBar = new Chart(ctx).Bar(barChartData, {
				responsive : true
			});
			for (var j = 0; j < data.accessories.length; j++) {
				$('#accessory-list').append(
						'<li class="list-group-item">'
								+ data.accessories[j].accessoryName + '&nbsp'
								+ '￥' + data.accessories[j].saleMoney +'</li>')
			}
		}
	});
}