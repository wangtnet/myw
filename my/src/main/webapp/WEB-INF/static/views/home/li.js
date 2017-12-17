$.ajax({
    url: "/my/room/all",
    type: "get",
    processData: false,
    contentType: false,
    success: function(data) {
        debugger;
        console.log("over..");
        var mdata = new Object();
        mdata.student = data;
        var myTemplate = Handlebars.compile($("#table-template").html());
        $('#tableList').html(myTemplate(mdata));
    }
});