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
                html.push('<div class="qing-entry-text">');
                html.push('<div class="qing-list-title"><span class="qing-category"><i></i>'+v.category+'</span><a href="/blog/'+v.id+'.shtml">'+v.title+'</a></div>');
                html.push('<div class="qing-list-hint">');
                html.push('<span><i class="am-icon-user qing-color-author" title="作者"></i> '+v.author+' &nbsp;</span>');
                html.push('<span><i class="am-icon-clock-o qing-color-clock" title="时间"></i> '+v.createtime+'</span>');
                html.push('<span><i class="am-icon-eye-slash qing-color-eye" title="阅读"></i> 阅读('+v.looknum+')</span>');
                html.push('<span><i class="am-icon-heart-o qing-color-heart" title="点赞"></i> 点赞('+v.fabulous+')</span></div>');
                html.push('<p class="qing-list-content">'+v.abstractremark+'</p>');
                html.push('<div class="qing-list-foot">');
                html.push('<i class="am-icon-tags"></i> <span class="am-radius">'+v.type+'</span>');
                html.push('<a href="/blog/'+v.id+'.shtml" class="qing-read-more">阅读全文&gt;&gt;</a></div>');
                html.push('</div>');
            });
            $(".blog-list").html(html.join(''));
        }
    });
})