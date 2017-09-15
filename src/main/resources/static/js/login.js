/*	册检查JS	*/

/* 初始化变量 */
var rememberPassword = 0;

/* 初始化事件绑定 */
$(document).ready(function() {
	// 绑定登录事件
	$('#login_submit').click(login_submit);
	// 绑定记住密码事件
	$('#login_rememberPassword').change(login_rememberPassword);
	
	// 记住密码功能验证是否有存储在本地的用户名、密码，有则自动填充
	var str = getCookie("loginInfo");
	str = str.substring(1,str.length-1);
	var username = str.split(",")[0];
	var password = str.split(",")[1];
	// 自动填充用户名和密码
	$("#login_username").val(username);
	$("#login_password").val(password);
})

/* 登录 */
function login_submit() {
	console.log("xxxxxx");
	// 获取要提交用户名
	var username = $('#login_username');
	// 获取要提交的密码
	var password = $('#login_password');
	// 获取是否需要记住密码
	var rePassword = rememberPassword;
	// 将数据放入data
	var data = {
		username : username.val(),
		password : password.val(),
		rememberPassword : rePassword
	};
	// 设置发送的地址
	var url = "user/login";
	$.post(url, data, function(result) {
		if (result.state == 0) {
			console.log(result.state);
			// 成功则运行成功提醒
			successActive();
		} else {
			console.log("false");
			// 失败则运行失败提醒
			failActive();
		}
	});
}

//成功则跳转页面
function successActive() {
	window.location.href = "www.baidu.com";
}

//失败则提示信息
function failActive() {
	$('#login_prompt').val("账号或者密码错误");
}

/* 记住密码  */
function login_rememberPassword() {
	// 改变记住密码变量值，方便传给后台
	if ($(this).is(':checked')) {
		rememberPassword = 1;
	} else {
		rememberPassword = 0;
	}
}

//获取cookie
function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') c = c.substring(1);
		if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
	}
	return "";
}