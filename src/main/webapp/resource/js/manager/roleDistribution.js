layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = layui.layer ,
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
                            html.push("<input type='checkbox' value='");
                            html.push(this.id);
                            html.push("'");
                            if(this.check){
                                html.push(" checked='checked'");
                            }
                            html.push("title='");
                            html.push(this.name+"'");
                            html.push("name='roles'");
                            html.push("/>");
                        });
                        $(".checkboxdiv").html(html.join(''));
                        var index = layer.open({
                            title: '设置角色',
                            type : 1,
                            area : ["466px","500px"],
                            closeBtn: 1,
                            btn: ['设置', '关闭'],
                            content:$(".platEventForm"),
                            success : function(layero, index){
                                form.render();
                            },
                            yes: function(index,layero){
                                $("input[name='roles']:checked").each(function() {
                                   console.log($(this).val());
                                });
                                layer.close(index);
                            },
                            cancel: function(index){
                                layer.close(index);
                            }
                        });
                        layui.layer.full(index);
                        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
                        $(window).on("resize",function(){
                            layui.layer.full(index);
                        })
                    }else{
                        layer.msg(data.msg);
                    }
                }
            })
        }
    });



})