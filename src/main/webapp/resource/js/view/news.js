$(function(){
    $("#paginator").paginator({
        url: "/view/page/newsdata.shtml?offset=",
        pageParent: "#paginator",
        totalBars: total,
        limit:9,
        offset: 1,
        callback: function (data) {
            var html = [];
            $.each(data.data,function(i,v){
                html.push('<article class="am-g blog-entry-article" >');
                html.push('<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img" data-url="/news/'+v.id+'.shtml">');
                html.push('<img src="'+v.sourceimg+'" alt="'+v.sourceimg+'" class="am-u-sm-12" style="height: 220px;">');
                html.push('</div>');
                html.push('<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text newsarticle" data-url="/news/'+v.id+'.shtml">');
                html.push('<span><a href="/news/'+v.id+'.shtml" class="blog-color">'+v.looknumber+'阅&nbsp;</a></span>');
                html.push('<span> BeCat &nbsp;</span>');
                html.push('<span>'+v.publictime+'</span>');
                html.push('<h1><a href="/news/'+v.id+'.shtml">'+v.title+'</a></h1>');
                html.push('<p>'+v.description+'</p>');
                html.push('</div>');
                html.push('</article>');
            });
            $(".articledata").html(html.join(''));
        }
    });

    $(".articledata").on("click","div",function(){
        alert('这里是动态元素添加的事件');
        var url = $(this).data("url");
        console.log(url);
    });
})