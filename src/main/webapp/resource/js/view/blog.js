$(function(){
    $("#paginator").paginator({
        url: "/view/page/blogdata.shtml?offset=",
        pageParent: "#paginator",
        totalBars: total,
        limit:9,
        offset: 1,
        callback: function (data) {
            var html = [];
            $.each(data.data,function(i,v){
                html.push('');
            });
            $(".blog-list").html(html.join(''));
        }
    });
})