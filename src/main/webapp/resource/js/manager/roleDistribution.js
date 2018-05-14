layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    var tableIns = table.render({
        id : "roleIds",
        elem: '#userAndRoleList',
        url : '/console/userAndRolePage.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "userListTable",
        cols : [[
            {field: 'username', title: '昵称', minWidth:100, align:"center"},
            {field: 'usercode', title: '账号', align:'center',minWidth:50},
            {field: 'locked', title: '状态', minWidth:100, align:'center',templet:function(d){
                if(d.locked == "0"){
                    return "有效";
                }else if(d.locked == "1"){
                    return "冻结";
                }
            }},
            {field: 'lastLoginTime', title: '最近登录时间', align:'center',minWidth:150},
            {field: 'roleNames', title: '拥有的角色', align:'center',minWidth:200},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    $(".search_btn").on("click",function(){
        table.reload("userListTable",{
            page: {
                curr: 1
            },
            where: {
                content : $(".searchVal").val()
            }
        })
    });

    //列表操作
    table.on('tool(userAndRoleList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'distri'){
            $.ajax({
                url : "/console/selectRoleByUserId.shtml",
                type : "post",
                data: {userId:data.id},
                success : function(data){
                    if(data.status==200){
                        var html = [];
                        $.each(data.data,function(i,v){
                            html.push("<input type='checkbox' id='");
                            html.push(this.id);
                            html.push("'");
                            if(this.check){
                                html.push(" checked='checked'");
                            }
                            html.push("title='");
                            html.push(this.name);
                            html.push("'/>");
                            html.push(this.name);
                        });
                        html.push("<a class='layui-btn search_btn layui-center' lay-submit lay-filter='settingRole'>设置</a>");
                        layer.open({
                            type: 1,
                            area: ['500px', '300px'],
                            title: '设置角色',
                            shade: 0.6,
                            maxmin: true,
                            anim: 1,
                            content: html.join('')
                        });
                    }else{
                        layer.msg(data.msg);
                    }
                }
            })
        }

    });

})