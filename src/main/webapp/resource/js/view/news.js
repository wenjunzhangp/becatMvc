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
                html.push('<div class="am-u-lg-4 am-u-md-6">');
                html.push('<div class="article">');
                html.push('<div class="article-img">');
                html.push('<img src="'+v.sourceimg+'" alt="" />');
                html.push('</div>');
                html.push('<div class="article-header">');
                html.push('<h2><a href="/news/'+v.id+'.shtml" rel="">'+v.title+'</a></h2>');
                html.push('<ul class="article--meta">');
                html.push('<li class="article--meta_item -date">'+v.publictime+'</li>');
                html.push('<li class="article--meta_item comments">'+v.looknumber+'</li>');
                html.push('</ul>');
                html.push('</div>');
                html.push('<div class="article--content">');
                html.push('<p>'+v.description+'</p>');
                html.push('</div>');
                html.push('<div class="article--footer">');
                html.push('<a href="/news/'+v.id+'.shtml" class="link">详情</a>');
                html.push('</div>');
                html.push('</div>');
                html.push('</div>');
            });
            $(".datalist").html(html.join(''));
        }
    });
})