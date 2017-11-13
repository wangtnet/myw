<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>home</title>
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
<body>
11 request:${requestScope.message}
<div class="container">
    <div class="row" id="headerContainer"></div>
    <div class="row" id="rowSearch" >
    </div>
    <div class="row" id="rowContent">
    </div>
    <div class="row" id="foot" style="height: 100px">

    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        var d = new Date();
        var t = d.getTime();
        $('#headerContainer').load('head?t='+t);
        $('#rowSearch').load('static/views/search.html?t='+t);
        $('#rowContent').load('static/views/home/li.html?t='+t);
       
        $('#right').load('static/views/right.html?t='+t);
    });
</script>
<script>document.write('<script src="http://' + (location.host || 'localhost').split(':')[0] + ':35729/livereload.js?snipver=1"></' + 'script>')</script>
</body>
</html>