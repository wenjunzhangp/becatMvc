layui.use(['form','layer','table','laytpl','laydate'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        laydate = layui.laydate,
        table = layui.table;

    laydate.render({
        elem: '#time',
        range: '~',
        format:'yyyy-MM-dd'
    });

    var tableIns = table.render({
        id : "id",
        elem: '#userList',
        url : '/console/userPage.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "userListTable",
        cols : [[
            {field: 'username', title: '昵称', minWidth:100, align:"center"},
            {field: 'usercode', title: '账号', align:'center',minWidth:50},
            {field: 'gender', title: '性别', minWidth:100, align:'center',templet:function(d){
                if(d.gender == "0"){
                    return "美女";
                }else if(d.gender == "1"){
                    return "帅哥";
                }else if(d.gender == "2"){
                    return "保密";
                }else{
                    return "未知";
                }
            }},
            {field: 'phone', title: '联系方式', align:'center',minWidth:50},
            {field: 'createTime', title: '加入平台时间', align:'center',minWidth:150},
            {field: 'lastLoginTime', title: '最近登录时间', align:'center',minWidth:150},
            {field: 'sourceimg', title: '头像', width:180, align:"center",templet:function(d){
                return '<a href="'+d.sourceimg+'" target="_blank"><img src="'+d.sourceimg+'" height="30" /></a>';
            }},
            {field: 'locked', title: '状态', align:'center',minWidth:100,templet:"#modifySysUserLock"}
        ]]
    });

    $(".search_btn").on("click",function(){
        var time = $("#time").val();
        var starttime = time.substring(0,time.indexOf("~"));
        var endtime = time.substring(time.indexOf("~")+1,time.length);
        table.reload("userListTable",{
            page: {
                curr: 1
            },
            where: {
                filter : $(".searchVal").val(),
                starttime : starttime,
                endtime : endtime
            }
        })
    });

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'usable'){
            var _this=$(this),usableText = "是否确定解锁此用户？", status=0;
            if(data.locked==0){
                usableText = "是否确定冻结此用户？", status=1;
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'温馨提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                layer.close(index);
                $.ajax({
                    url : "/console/updateSysUserLock.shtml",
                    type : "post",
                    data: {lock:status},
                    success : function(data){
                        if(data.status==200){
                            layer.msg(data.msg);
                            layer.close(index);
                            tableIns.reload();
                        }else{
                            layer.msg(data.msg);
                        }
                    }
                })
            },function(index){
                layer.close(index);
            });
        }

    });

})