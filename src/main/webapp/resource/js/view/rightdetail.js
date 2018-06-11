$(function(){

    $.ajax({
        url : "/view/page/noticelimit.shtml",
        type : "get",
        cache:true,
        dataType : "json",
        success : function(data){
            var html = [];
            $.each(data.data,function(i,v){
                html.push('<li><a href="/notice/'+v.id+'.shtml" target="_blank">'+v.title+'</a><span class="rss-date">'+v.publictime+'</span></li>');
            });
            $(".noticedata").html(html.join(''));
        }
    })

    $.ajax({
        url : "/view/page/linklimit.shtml",
        type : "get",
        cache:true,
        dataType : "json",
        success : function(data){
            var html = [];
            $.each(data.data,function(i,v){
                html.push('<li><a href="'+v.domainurl+'" target="_blank">'+v.domainname+'</a></li>');
            });
            $(".linkdata").html(html.join(''));
        }
    })
})