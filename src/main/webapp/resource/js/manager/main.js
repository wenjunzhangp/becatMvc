//获取系统时间
var newDate = '';
getLangDate();
//值小于10时，在前面补0
function dateFilter(date){
    if(date < 10){return "0"+date;}
    return date;
}
function getLangDate(){
    var dateObj = new Date(); //表示当前系统时间的Date对象
    var year = dateObj.getFullYear(); //当前系统时间的完整年份值
    var month = dateObj.getMonth()+1; //当前系统时间的月份值
    var date = dateObj.getDate(); //当前系统时间的月份中的日
    var day = dateObj.getDay(); //当前系统时间中的星期值
    var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
    var week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串
    var hour = dateObj.getHours(); //当前系统时间的小时值
    var minute = dateObj.getMinutes(); //当前系统时间的分钟值
    var second = dateObj.getSeconds(); //当前系统时间的秒钟值
    var timeValue = "" +((hour >= 12) ? (hour >= 18) ? "晚上" : "下午" : "上午" ); //当前时间属于上午、晚上还是下午
    newDate = dateFilter(year)+"年"+dateFilter(month)+"月"+dateFilter(date)+"日 "+" "+dateFilter(hour)+":"+dateFilter(minute)+":"+dateFilter(second);
    document.getElementById("nowTime").innerHTML = timeValue+"好！ 欢迎使用BeCat。当前时间为： "+newDate+"　"+week;
    setTimeout("getLangDate()",1000);
}

layui.use(['form','element','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        element = layui.element;
        $ = layui.jquery;
    //icon动画
    $(".panel a").hover(function(){
        $(this).find(".layui-anim").addClass("layui-anim-scaleSpring");
    },function(){
        $(this).find(".layui-anim").removeClass("layui-anim-scaleSpring");
    })
    $(".panel a").click(function(){
        parent.addTab($(this));
    })
    //系统基本参数
    $.ajax({
        url : "/console/sysconfig.shtml",
        type : "get",
        cache:true,
        dataType : "json",
        success : function(data){
            if(data.status==200){
                fillParameter(data);
            }else{
                layer.msg(data.msg);
            }
        }
    })
    //填充数据方法
    function fillParameter(data){
        //判断字段数据是否存在
        function nullData(data){
            if(data == '' || data == "undefined"){
                return "未定义";
            }else{
                return data;
            }
        }
        $(".version").text(nullData(data.data.currentVersion));      //当前版本
        $(".author").text(nullData(data.data.author));        //开发作者
        $(".homePage").text(nullData(data.data.domainUrl));    //网站首页
        $(".server").text(nullData(data.data.serverConfig));        //服务器环境
        $(".dataBase").text(nullData(data.data.databaseVersion));    //数据库版本
        $(".maxUpload").text(nullData(data.data.maxFile));    //最大上传限制
    }

    //最新文章列表
    $.ajax({
        url : "/console/indusData.shtml",
        type : "get",
        cache:true,
        dataType : "json",
        success : function(data){
            if(data.status==200){
                var hotNewsHtml = '';
                $.each(data.data,function(i,v){
                    hotNewsHtml += '<tr><td align="left" width="80%"><a href="javascript:;"> '+v.title+'</a></td><td>'+v.publictime+'</td></tr>';
                });
                $(".hot_news").html(hotNewsHtml);
            }else{
                layer.msg(data.msg);
            }
        }
    })

    //BeCat发展历程
    $.ajax({
        url : "/console/eventData.shtml",
        type : "get",
        cache:true,
        dataType : "json",
        success : function(data){
            if(data.status==200){
                var plateventHtml = '';
                $.each(data.data,function(i,v){
                    plateventHtml += '<li class="layui-timeline-item">' +
                        '<i class="layui-icon layui-timeline-axis">&#xe63f;</i>' +
                        '<div class="layui-timeline-content layui-text">' +
                        '<div class="layui-timeline-title">' +
                        '<h3 class="layui-inline">'+v.title+'</h3>' +
                        '<span class="layui-badge-rim">'+v.createtime+'</span>' +
                        '</div></div></li>';
                });
                $(".platevent").html(plateventHtml);
                $(".platevent li:eq(0) i").html("&#xe756;");
            }else{
                layer.msg(data.msg);
            }
        }
    })
})
