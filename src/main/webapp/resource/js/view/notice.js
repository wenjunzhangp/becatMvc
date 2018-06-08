$(function(){
    $("#paginator").paginator({
        url: "/view/page/noticedata.shtml?offset=",
        pageParent: "#paginator",
        totalBars: total,
        limit:6,
        offset: 1,
        callback: function (data) {
            var html = [];
            $.each(data.data,function(i,v){
                html.push('<div class="qing-entry-text">');
                html.push('<div class="qing-list-title">');
                html.push('<span class="qing-category">'+v.category+'<i></i></span>');
                html.push('<a href="/notice/'+v.id+'.shtml">'+v.title+'</a>');
                html.push('</div>');
                html.push('<div class="qing-list-hint">');
                html.push('<span><i class="am-icon-user qing-color-author" title="作者"></i> BeCat &nbsp;</span>');
                html.push('<span><i class="am-icon-clock-o qing-color-clock" title="时间"></i>'+v.publictime+'</span>');
                html.push('<span><i class="am-icon-eye-slash qing-color-eye" title="阅读"></i> 暂不统计</span>');
                html.push('</div>');
                html.push('<p class="qing-list-content">'+v.content+'</p>');
                html.push('<div class="qing-list-foot">');
                html.push('<i class="am-icon-tags"></i><span class="am-radius">公告</span> <a href="/notice/'+v.id+'.shtml" class="qing-read-more">阅读全文&gt;&gt;</a>');
                html.push('</div>');
                html.push('</div>');
            });
            $(".blog-list").html(html.join(''));
        }
    });
})