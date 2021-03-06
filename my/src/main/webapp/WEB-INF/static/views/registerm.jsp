<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
<head>
	<title>register</title>
</head>

<style type="text/css">
	.head h2{
		float: left;
		border-left: solid blue 3px;
		margin-top: 30px;
		padding-left: 35px;
		margin-left: 5px;
		font-size: 20px;
	}
	.head a{
		margin-top: 30px;
		float: right;
		text-decoration: none;
		padding-right: 10%;
	}
	.main{
		clear: both;
		padding-top: 30px;
		border-top: #ccc solid 1px;
		padding-left: 100px;
	}
	.row{
		clear: both;
		height: 35px;
		margin-left: 40px;
		padding: 5px;
	}

	.left{
		margin-left: 10%;
		float: left;
		width: 15%;  /*为什么一加上left就*/
	}

	.right{
		width: 20%;
		float: left;
		height: 25px;
	}
	.right1{
		width: 8%;
		float: left;
		height: 30px;
	}
	.right2{
		width: 11%;
		float: left;
		height: 25px;
		margin-left: 1%;
	}
	.right input{
		height: 25px;
	}
	input{
		height: 30px;
	}

	.row2{
		clear: both;
		height: 45px;
		margin-left: 40px;
		padding: 25px;
	}
	.row input {
		border: 1px solid #ccc ;
	}
	.row2 input{
		border: 1px solid #aaa ;
		background-color: #ffa100;
		margin:10px;
	}

	#checkCode{
		background-image:url(/my/user/checkCode) ;
	}
</style>
<link rel="stylesheet" href="static/js/lib/jquery-validation-1.14.0/demo/css/screen.css">
<script src="static/js/lib/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="static/js/lib/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<body>
<div class="head">
	<h2>注册账号</h2>
	<a href="/my/homer">  返回主页?  </a>
</div>

<div class="main">
	<form action="/my/user/register" method="post" id="post">
		<div class="row">
			<label class="left">
				用户名
			</label>
			<input type="text" class="right" id="username" name="username" class="required">
		</div>
		<div class="row">
			<label class="left">
				密码
			</label>
			<input type="password" class="right" name="password" id="password" class="required">
		</div>
		<div class="row">
			<label class="left">
				确认密码
			</label>
			<input type="password" class="right" id="confirm_password" name="confirm_password" id="confirm_password" class="required">
		</div>
		<div class="row">
			<label class="left">
				邮箱
			</label>
			<input type="text" class="right" name="email" id="email" class="required">
		</div>
		<div class="row">
			<label class="left">
				验证码
			</label>
<!--
			<input type="button" id="checkCode" class="button right1" style="float: left; " value="" name="checkCode">
			<input type="text" id="registercode"  class="right2" name="registercode"  >
-->
			<input type="text" class="right" name="registercode" class="required">
		</div>
		<div class="row2 ">
			<input type="button" id="sendCode" value="发验证码到邮箱" class="button right1" style="width:10%; float: left;margin-left: 17%; " value="">
			<input type="submit" value="立即注册" class="button right1"  value="">
		</div>

	</form>

</div>
<script>
/*
    $.validator.setDefaults({
        submitHandler: function() {
            alert("submitted!");
        }
    });
*/
    $(function(){

        var validate = $("#post").validate({
           // onfocusout: function(element) { $(element).valid(); },
            rules:{
                username:{
                    required:true
                },
                email:{
                    required:true,
                    email:true
                },
                password:{
                    required:true,
                    rangelength:[3,10]
                },
                confirm_password:{
                    required:true,
                    equalTo:"#password"
                },
                registercode:{
                    required:true,
                    rangelength:[4]
                },
                /*
                registercode:{
                    required:true,
                    remote:{                                          //验证用户名是否存在
                        type:"get",
                        url:"/my/user/checkRegistercode",             //servlet
                        data: {   
                        	registercode:function(){
                                return $("#registercode").val();
                                },
                        },
                        dataFilter: function (data) {　　　　//判断控制器返回的内容
                            if (data == "true") {
                                return true;
                            }
                            else {
                                return false;
                            }
                        }
                    }
                }
                */
            },
            messages:{
                username:{
                    required:"必填选项"
                },
                email:{
                    required:"必填选项",
                    email:"E-Mail格式不正确"
                },
                password:{
                    required: "必填选项",
                    rangelength: "密码最小长度:3, 最大长度:10。"
                },
                confirm_password:{
                    required: "必填选项",
                    equalTo:"两次密码输入不一致"
                },
                registercode:{
                    required: "必填选项(点击发验证码到邮箱，然后进邮箱获取)",
					remote:"验证码输入不正确"
                }
            }
        });
    });

    function submit(){
        var obj = $('#post').serialize();
    　      $.ajax({
                url:"/my/user/register",
                type:"post",
                data:obj,
                processData:false,
                //contentType:"application/x-www-form-urlencoded",
                success:function(data){
                    console.log("over..");
                    alert(data);
                    if(data=='1')
                    {
                    	$("#sendCode").text("验证码已发送有效时间1小时");
                    }
                    //window.location.href ="/my/addroom?liid="+data;
                }
            });
        return false;
    }

    $("#sendCode").bind("click",function(){
    	$("#username").valid(); 
    	$("#password").valid(); 
    	$("#confirm_password").valid(); 
    	$("#email").valid(); 
    	submit();
        //var timestamp = Date.parse(new Date());
        //$("#checkCode").css("background-image","url(/my/user/checkCode?t="+timestamp+")");
    });
    /*
    $("#checkCode").bind("click",function(){
        var timestamp = Date.parse(new Date());
        $("#checkCode").css("background-image","url(/my/user/checkCode?t="+timestamp+")");
    });*/

</script>

</body>
</html>