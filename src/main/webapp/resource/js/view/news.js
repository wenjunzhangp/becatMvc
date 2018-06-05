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
                html.push('<img src="/resource/images/news/b01.jpg" alt="" />');
                html.push('</div>');
                html.push('<div class="article-header">');
                html.push('<h2><a href="#" rel="">云适配：价值驱动是占有市场的关键</a></h2>');
                html.push('<ul class="article--meta">');
                html.push('<li class="article--meta_item -date">December 28, 2015</li>');
                html.push('<li class="article--meta_item comments">33 Comments</li>');
                html.push('</ul>');
                html.push('</div>');
                html.push('<div class="article--content">');
                html.push('<p>作为一家技术创新型企业，技术的先进性和创新型是构建企业核心竞争力的根本。但是要想占领市场并获得持续增长，需要从服务市场的角度出发，为用户输出价值，也是云适配的发展宗旨。</p>');
                html.push('</div>');
                html.push('<div class="article--footer">');
                html.push('<a href="#" class="link">Read More</a>');
                html.push('</div>');
                html.push('</div>');
                html.push('</div>');
            });
            $(".datalist").html(html.join(''));
        }
    });
})