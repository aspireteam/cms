/*	册检查JS	*/

/* 初始化值 */
var check_username = 0; // 检查用户名
var check_password = 0; // 检查密码
var check_email = 0;
var check_username_repeat; // 检查用户重复

/* 初始化事件绑定 */
$(document).ready(function() {
	// 绑定检测用户名事件
	$('#regist_username').blur(checkUsernameFormat);
	// 绑定检查密码事件
	$('#regist_password').blur(checkPasswordFormat);
	// 绑定检查邮箱事件
	$('#regist_email').blur(checkEmailFormat);
	// 绑定点击同意协议，提交按钮可用事件
	$('#regist_agreement').change(agreeAgreement);
	// 绑定提交事件
	$('#regist_submit').click(regist_submit);
})


/* 注册  */
function regist_submit() {
	// 提交之前检查
	if (check_username + check_password + check_email < 2) {
		return;
	}
	console.log(check_username + check_password + check_email);
	// 获取要提交的数据
	var username = $('#regist_username');
	var password = $('#regist_password');
	var email = $('#regist_email');
	// 将数据写入data中
	var data = {
		username : username.val(),
		password : password.val(),
		email : email.val()
	}
	// 设置发送的后台地址
	var url = "user/regist";
	$.post(url, data, function(result) {
		console.log(result.state);
		if (result.state == 0) {
			// 成功则运行成功提醒
			successMessage();
		} else {
			// 失败则运行失败提醒
			failMessage();
		}
	});
}

/* 注册成功提示 */
function successMessage() {
	// 设置成功消息
	$('#regist_model_body').html("注册成功！");
	$("#regist_model").modal();
}

/* 注册失败提示 */
function failMessage() {
	// 设置失败消息
	$('#regist_model_body').html("注册失败！");
	$("#regist_model").modal();
}


/* 用户名格式检查 */
function checkUsernameFormat() {
	// 获取用户名对象
	var checkObject = $('#regist_username');
	// 获得提示信息的对象
	var message = $('#regist_prompt_username');
	// 预先设置为错误颜色
	checkObject.addClass("alert-danger");
	// 正则表达式
	reg = /^[a-zA-Z0-9_]{3,15}$/;
	// 正则匹配检查
	if (reg.test(checkObject.val())) {
		// 执行ajax向后台发送数据验证用户名是否被占用	
		checkUserIsExist();
		// 根据ajax设置的值来验证
		if (!check_username_repeat) {
			// 通过验证设置为绿色颜色
			checkObject.removeClass("alert-danger");
			checkObject.addClass("alert-success");
			// 清除提醒的消息
			message.text("");
			// 设置check_username=1
			check_username = 1;
			return;
		} else {
			message.text("用户名已存在");
			check_username = 0;
			return;
		}
	}
	// 设置提示信息
	message.text("请输入3-15的数字、字母或下划线");
	// 没通过则check_username=0
	check_username = 0;
}


/* 检查用户名是否已经被占用 */
function checkUserIsExist() {
	// 获取用户对象
	var checkObject = $('#regist_username');
	// 获取消息对象
	var message = $('#regist_prompt_username');
	// 获取data信息
	var data = {
		username : checkObject.val()
	};
	// 设置发送的后台地址
	var url = "user/checkuser";
	// 向后台发送信息,获得信息的反馈结果
	$.ajax({
		type : "post",
		url : url,
		data : data,
		async : false,
		success : function(result) {
			if (result.state == 0) {
				// 设置检查状态
				check_username_repeat = false;
			} else {
				// 设置检查状态
				check_username_repeat = true;
			}
		}
	});
}

/* 输入密码格式检查 */
function checkPasswordFormat() {
	// 获取密码对象
	var checkObject = $('#regist_password');
	// 预先设置为错误颜色
	checkObject.addClass("alert-danger");
	// 获得提示信息的对象
	var message = $('#regist_prompt_password');
	// 验证密码长度
	if (checkObject.val().length >= 6 && checkObject.val().length <= 15) {
		// 通过验证设置为绿色颜色
		checkObject.removeClass("alert-danger");
		checkObject.addClass("alert-success");
		// 清除提醒的消息
		message.text("");
		check_password = 1;
		return;
	}
	message.text("请输入长度为6-15位的密码");
	check_password = 0;
}

/* 输入邮箱格式检查 */
function checkEmailFormat() {
	// 获取密码对象
	var checkObject = $('#regist_email');
	// 获得提示信息的对象
	var message = $('#regist_prompt_email');
	// 预先设置为错误颜色
	checkObject.addClass("alert-danger");
	if (!checkObject.val()) {
		// 移出所有颜色
		checkObject.removeClass("alert-danger");
		checkObject.removeClass("alert-success");
		// 清除提醒的消息
		message.text("");
		// 设置check_email = 0;
		check_email = 0;
		return;
	}
	// 设置正则表达式
	var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	// 验证密码长度
	if (reg.test(checkObject.val())) {
		// 通过验证设置为绿色颜色
		checkObject.removeClass("alert-danger");
		checkObject.addClass("alert-success");
		// 清除提醒的消息
		message.text("");
		check_email = 0;
		return;
	}
	message.text("请输入正确格式的邮箱");
	check_email = -1;
}

/* 同意协议才可点击注册  */
function agreeAgreement() {
	// 设置提交按钮是否可用
	if ($(this).is(':checked')) {
		$('#regist_submit').attr("disabled", false);
	} else {
		$('#regist_submit').attr("disabled", true);
	}


}