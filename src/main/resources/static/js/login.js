/*! jQuery v3.4.1 | (c) JS Foundation and other contributors | jquery.org/license */
$(function(){
	$("#inputForm").bind("input propertychange",function(){
		var email=$("#inputEmail").val();
		if(validatorEmail(email)==false)
		{
			$("#inputEmail").css("border","3px solid #B21F2D");
			$("#submitBtn").addClass("disabledBtn");
		}
		else {
			$("#inputEmail").css("border","3px solid #34CE57");
			$("#submitBtn").removeClass("disabledBtn");
		}
	});
	$("#submitBtn").click(function(){
		$.ajax({
			type:"post",
			url:"user/login",
			dataType:"json",
			async: false,
			data:{
				"email": $("#inputEmail").val(),
				"password": $("#inputPassword").val(),
			},
			success: function(data){
				if(data)
				{
					console.log("登录成功");
					alert("登录成功");
					window.location.href="register.html";
				}
			},
			error: function(error){
				if(error)
				{
					console.log("登录失败");
					alert("登录失败");
					window.location.href="index.html";
				}
			}
		});
	});

});

 /*
     * 验证邮箱格式是否正确
     */
function validatorEmail(value){
        // 正则验证格式
        eval("var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;");
        return RegExp(reg).test(value);
    }
