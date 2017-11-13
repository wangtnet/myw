
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >

<head>
	<title>login</title>
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
	}

	#checkCode{
		background-image:url(/my/user/checkCode) ;
	}
</style>
<link rel="stylesheet" href="../js/lib/jquery-validation-1.14.0/demo/css/screen.css">
<script src="../js/lib/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="../js/lib/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<body>
<div class="head">
	<h2>登录</h2>
	<a href="/my/home">  继续浏览?  </a>
</div>

<div class="main">
	<form action="/my/home" method="post" id="post">
		<div class="row">
			<label class="left">
				用户名
			</label>
			<input type="text" class="right" name="username" class="required">
		</div>
		<div class="row">
			<label class="left">
				或邮箱登录
			</label>
			<input type="text" class="right" name="email" class="required">
		</div>
		<div class="row">
			<label class="left">
				密码
			</label>
			<input type="password" class="right" name="password" id="password" class="required">
		</div>


		<div class="row">
			<label class="left">
				验证码
			</label>

			<input type="button" id="checkCode" class="button right1" style="float: left; " value="" name="checkCode">
			<input type="text" id="registercode"  class="right2" name="registercode"  >


		</div>
		<div class="row2">
			<input type="submit" value="登录" style="margin-left: 20%;width: 20%;height: 70%">
		</div>
	</form>

</div>
<script>
    $(function(){

        var validate = $("#post").validate({
            onfocusout: function(element) { $(element).valid(); },
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
  
                registercode:{
                    required: "必填选项",
					remote:"验证码输入不正确"
                }
            }
        });
    });

    $("#checkCode").bind("click",function(){
        var timestamp = Date.parse(new Date());
        $("#checkCode").css("background-image","url(/my/user/checkCode?t="+timestamp+")");

    });
</script>

</body>
</html>