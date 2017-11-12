    <%@ page contentType="text/html; charset=utf8"%>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
    <style type="text/css">
        #header {
            height: 70px;
            line-height: 60px;
            background: #fff;
            position: relative;
            z-index: 99;
            border-bottom: solid 1px #ddd;
           

        }

        #header #headerlogo {
            float: left;
            padding-left:80px;
            width: 250px;
            height: 40px;
            display: inline;
            margin-top: 13px;
        }

        #header p {
            float: left;
            display: inline;
            height: 50px;
            padding-bottom: 20px;
            padding-left: 10px;
            font-family: "Microsoft Yahei",Arial,sans-serif,Arial,STHeiti;
            font-size: 19px;
            line-height: 150%;
            font-weight: 600;

            margin-top: 20px;
        }


        #header img{
            width: 32px;
            height: 32px;
        }

        .nav {
            display: inline;
            margin-top: 10px;
        }
        #header .nav {
            float: left;
            padding-left: 40px;
            height: 60px;
        }
        ul, ol {
            list-style: none outside none;
        }
        .nav ul li {
            float: left;
            position: relative;
        }
        #header .nav ul li a.s {
            font-size: 16px;
            line-height: 50px;
            display: inline-block;
            padding: 0 20px;
            text-decoration:none;
        }

        #header a:hover, #sub-header a.active {
            color: #ffa000;
        }

        #header a {
            color: #666;
            font-size: 14px;
            line-height: 20px;
        }

        #content {
            position: relative;
            z-index: 9;
            background: grey;
            height: 300px;
        }
        #searchpan{
            height: 200px;
        }
    #header ul.fr {
        float: right;
        padding-top: 27px;
    }

    #header ul.fr li {
            float: left;
            position: relative;
            padding: 0 7px;
        	height: 16px;
        	line-height: 16px;
        	border-bottom: 0px;
        }

    #header ul.fr li a {
        padding-left: 10px;
        position: relative;
        text-decoration: none;
    }


    #sub-header ul.fr li a:hover {
        color: #ffa000;
    }

    .fr {
        float: right;
    }
    </style>
    <div id="header">
        <img id="headerlogo" src="static/images/img/t.PNG"  />
        <p>南京</p>
    12 request:${requestScope.loginFlag}
        <div class="nav" >
            <ul class="clearfix">
                <li><a href="/" title="首页" class="active s" onclick="_gaq.push(['_trackEvent', 'home_310000', 'click', 'ownhome'])">首页</a></li>
                <li><a href="http://www.ziroomapartment.com/" title="自如寓" class="s" onclick="_gaq.push(['_trackEvent', 'home_310000', 'click', 'apart'])">自如寓</a></li>

                <li><a href="http://www.ziroom.com/zhuanti/minsu/index.html" title="民宿" class="s" onclick="_gaq.push(['_trackEvent', 'home_310000', 'click', 'minsu'])">民宿</a>
                </li>
                <li><a href="/ziroomer/" title="生活" class="s" onclick="_gaq.push(['_trackEvent', 'home_310000', 'click', 'life'])">生活</a></li>

      <div class="btn-group">
        <li  class=" dropdown-toggle" 
                data-toggle="dropdown">
            <a href="#">默认 <span class="caret"></span>
        </li>
        <ul class="dropdown-menu" role="menu">
            <li><a href="#">功能</a></li>
            <li><a href="#">另一个功能</a></li>
            <li><a href="#">其他</a></li>
            <li class="divider"></li>
            <li><a href="#">分离的链接</a></li>
        </ul>
        </div>


                </ul>
                  </div>
            <ul class="fr" id="topRightList" class="clearfix">
          

                <c:choose>
                    <c:when test="${requestScope.loginFlag== 'true'}">  
                    
                          <li class="app">
                    <a rel="nofollow" target="_blank" href="http://zhuanti.ziroom.com/zhuanti/app/index.html"><b></b>个人信息</a>
                   <!--  
                    <div class="box">
                        <p>我的发布</p>
                        <p>账号设置</p>
                         background-image: url(img/WALL.PNG);
                    </div>
                    -->
                </li>
                    
                        <li id="ziroom_login" style="opacity: 1;"><a href="addroom">免费发布</a></li>  
                    </c:when>
     
  
                    <c:otherwise> 
                        <li id="ziroom_login" style="opacity: 1;"><a href="static/views/loginm.html" rel="nofollow">登录</a></li>
                        <li id="ziroom_reg" style="opacity: 1;"><a href="static/views/registerm.html" rel="nofollow">注册</a></li>
                    
                 
                    </c:otherwise>
                </c:choose>
                         
                

            </ul>



</div>