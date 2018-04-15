layui.use(['table','laydate'],function(){
	var table = layui.table, $ = layui.jquery,laydate = layui.laydate;

    laydate.render({
        elem: '#time',
        range: '~',
        format:'yyyy-MM-dd'
    });

    var userLogTable =  table.render({
        elem: '#userLog',
        url : '/console/userLogPage.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [10,15,20,25],
        id : "userLog",
        cols : [[
            {field: 'username', title: '用户名', minWidth:50, align:"center"},
            {field: 'opermodule', title: '操作内容',align:"center", minWidth:100},
            {field: 'opertime', title: '时间',  align:'center',minWidth:50},
            {field: 'remark',title: '备注', minWidth:100,align:"center"},
            {field: 'host', title: 'IP主机地址', align:'center', minWidth:50}
        ]]
    });

    $(".search_userlog_btn").on("click",function(){
        var time = $("#time").val();
        var starttime = time.substring(0,time.indexOf("~"));
        var endtime = time.substring(time.indexOf("~")+1,time.length);
        table.reload("userLog",{
            page: {
                curr: 1
            },
            where: {
                username : $(".username_user").val(),
                starttime : starttime,
                endtime : endtime
            }
        })
    });

    var sysLogTable = table.render({
        elem: '#sysLog',
        url : '/console/sysLogPage.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [10,15,20,25],
        id : "sysLog",
        cols : [[
            {field: 'username', title: '用户名', minWidth:50, align:"center"},
            {field: 'opermodule', title: '操作内容',align:"center", minWidth:100},
            {field: 'opertime', title: '时间',  align:'center',minWidth:50},
            {field: 'remark',title: '备注', minWidth:100,align:"center"},
            {field: 'host', title: 'IP主机地址', align:'center', minWidth:50}
        ]]
    });

    $(".search_syslog_btn").on("click",function(){
        var time = $("#time").val();
        var starttime = time.substring(0,time.indexOf("~"));
        var endtime = time.substring(time.indexOf("~")+1,time.length);
        table.reload("sysLog",{
            page: {
                curr: 1
            },
            where: {
                username : $(".username_sys").val(),
                starttime : starttime,
                endtime : endtime
            }
        })
    });

})
