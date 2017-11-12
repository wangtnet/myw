<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>11</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">


<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="static/js/lib/jquery.ajaxfileupload.js"></script>
<script type="text/javascript" src="static/js/lib/handlebars-1.0.0.beta.6.js"></script>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>基本地图展示</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
    <script src="http://webapi.amap.com/maps?v=1.4.1&key=6118ca43cedb54862985e310c05312e9"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
<body>
<div class="container">
    <div class="row" id="headerContainer"></div>
    <div class="row">
        <div class="col-md-9" id="left">
        </div>
        <div class="col-md-3" id="right">.col-md-4</div>
    </div>
    <div class="row" id="foot" style="height: 100px">

    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){

        
        var d = new Date();
        var t = d.getTime();
        $('#headerContainer').load('head?t='+t);
        $('#left').load('static/views/addroom/postcontent1.html?t='+t);
       // $('#left').load('showcontent.html');
        $('#right').load('static/views/addroom/addright.html?t='+t);
    });
</script>
<script>document.write('<script src="http://' + (location.host || 'localhost').split(':')[0] + ':35729/livereload.js?snipver=1"></' + 'script>')</script>
</body>
</html>