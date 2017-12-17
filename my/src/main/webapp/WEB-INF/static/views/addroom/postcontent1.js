 function lunbo(imgpath){
        $('.carousel-indicators').append("<li data-target='#carousel-example-captions' data-slide-to='"+3+"' ></li>");
        var strHtml= "<div class='item'> <img  style='margin: 0 auto;height: 500px'  src='/my/static/"
        +imgpath
        +"' data-holder-rendered='true'><div class='carousel-caption'></div></div>";
        alert(imgpath);
        debugger;
        $('.carousel-inner').append(strHtml);
}

var validate = $("#post1").validate({
            onfocusout: function(element) { $(element).valid(); },
            rules:{
                courtname:{
                    required:true
                },
                areaname:{
                    required:true,
                   // email:true
                },
                /*
                password:{
                    required:true,
                    rangelength:[3,10]
                },*/
            },
            messages:{
                courtname:{
                    required:"必填选项"
                },
                areaname:{
                    required:"必填选项",
                    //email:"E-Mail格式不正确"
                },
                /*
                password:{
                    required: "必填选项",
                    rangelength: "密码最小长度:3, 最大长度:10。"
                }*/
            }
});
     
function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)  return  unescape(r[2]); 
    return null;
}

var map = new AMap.Map('container', {
    resizeEnable: true,
    zoom:11,
    center: [116.40, 39.91]
});
//$(":submit").click(function(){ submit();});

var roomid =GetQueryString("liid");

$(function(){ 

    $("#liid").text(GetQueryString("liid"));
    if(GetQueryString("liid")==null) return;

    $.ajax({
            url:"/my/room/liid/"+GetQueryString("liid"),
            type:"get",
            processData:false,
            contentType:false,
            success:function(data){
                debugger;
                console.log("over..");
                //alert(data);
                for(var item in data){                       
                    console.log(item+" "+data[item]);  
                    var str="#"+item;
                    $(str).val(data[item]);   
                } 
                refreshImages(data); 
            }
    });
});

function submit(){
    var obj = $('#post1').serialize();
　      $.ajax({
            url:"/my/room",
            type:"post",
            data:obj,
            processData:false,
            //contentType:"application/x-www-form-urlencoded",
            success:function(data){
                console.log("over..");
                window.location.href ="/my/addroom?liid="+data;
            }
        });
    return false;
}

function refreshImages(response){
    debugger;

    var carouselHTML = '<div id="carousel-example-captions" class="carousel slide"  data-ride="carousel" data-wrap="false">'
        + '<ol class="carousel-indicators">';

    if(response.image1!=null){
        carouselHTML=carouselHTML+ '<li data-target="#carousel-example-captions" data-slide-to="0" class="active"/>';
    }
    if(response.image2!=null){
        carouselHTML=carouselHTML+ '<li data-target="#carousel-example-captions" data-slide-to="1"/>'
    }
    if(response.image3!=null){
        carouselHTML=carouselHTML+  '<li data-target="#carousel-example-captions" data-slide-to="2"/>'
    }
    carouselHTML=carouselHTML+  '</ol>'
        + '<div class="carousel-inner" role="listbox">'
    if(response.image1!=null){
        carouselHTML=carouselHTML+ '<div class="item active" id="one">'
        +' <img  style="margin: 0 auto;height: 500px" src="/my/static/'+response.image1+'" data-holder-rendered="true"> '
        + '<div class="carousel-caption"/>'
        + '</div>';
    }
    if(response.image2!=null){
        carouselHTML=carouselHTML+ '<div class="item" id="two">'
        +' <img  style="margin: 0 auto;height: 500px" src="/my/static/'+response.image2+'" data-holder-rendered="true"> '
        + '<div class="carousel-caption"/>'
        + '</div>';
    }
    if(response.image3!=null){
        carouselHTML=carouselHTML+ '<div class="item" id="three">'
        +' <img  style="margin: 0 auto;height: 500px" src="/my/static/'+response.image3+'" data-holder-rendered="true"> '
        + '<div class="carousel-caption"/>'
        + '</div>';
    }
 
    carouselHTML=carouselHTML + '</div>'
        +'<a class="left carousel-control" href="#carousel-example-captions" role="button" data-slide="prev"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span><span class="sr-only">Previous</span></a>'
        +'<a class="right carousel-control" href="#carousel-example-captions" role="button" data-slide="next"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><span class="sr-only">Next</span></a>'
        + '</div>';
        $("#lunboimg").append(carouselHTML);
        
    // 在这里面append 一个图片几个即可 
}

var d = new Date();
var t = d.getTime();

$('#one-specific-file').ajaxfileupload({
        action: '/my/room/upload/'+GetQueryString("liid")+'?roomid='+GetQueryString("liid")+'&t='+t,
        onComplete: function(response){
                    //alert(response);
                    //refreshImages(response);
                    debugger;
                    lunbo(response);
                }
});

function savePage(){
    var flag = $("#post1").valid();
    if(!flag){
        //没有通过验证
        return;
    }
    alert("savePage");
    submit();
}

function addImage(){
    alert("addImage");
    $("#uploadclick").trigger("click");
}