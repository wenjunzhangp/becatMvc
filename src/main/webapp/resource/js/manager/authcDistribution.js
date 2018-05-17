layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = layui.layer ,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    var tableIns = table.render({
        id : "id",
        elem: '#userAndRoleList',
        url : '/console/rolePermissionAllocationPage.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "userListTable",
        cols : [[
            {field: 'name', title: '角色名称', minWidth:50, align:"center"},
            {field: 'permissionNames', title: '拥有的权限', align:'center',minWidth:400},
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
        var permissionId = data.id;
        if(layEvent === 'distri'){
            $.ajax({
                url : "/console/selectPermissionById.shtml",
                type : "post",
                data: {permissionId:permissionId},
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
                            html.push("name='permission'");
                            html.push("/>");
                        });
                        $(".checkboxdiv").removeClass("hideCustom");
                        $(".checkboxdiv").html(html.join(''));
                        var index = layer.open({
                            title: '设置权限',
                            type : 1,
                            area : ["466px","500px"],
                            closeBtn: 1,
                            btn: ['设置'],
                            content:$(".platEventForm"),
                            success : function(layero, index){
                                form.render();
                            },
                            yes: function(index,layero){
                                var load = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
                                var ids = [];
                                $("input[name='permission']:checked").each(function() {
                                    ids.push($(this).val());
                                });
                                $.ajax({
                                    url : "/console/addPermissionToRole.shtml",
                                    type : "post",
                                    data: {roleId:permissionId,ids:ids.join(",")},
                                    success : function(data){
                                        if(data.status==200){
                                            top.layer.close(load);
                                            top.layer.msg(data.msg);
                                            layer.close(index);
                                            tableIns.reload();
                                            parent.location.reload();
                                        }else{
                                            layer.msg(data.msg);
                                        }
                                    }
                                })
                                $(".checkboxdiv").addClass("hideCustom");
                            },
                            cancel: function(index){
                                layer.close(index);
                                $(".checkboxdiv").addClass("hideCustom");
                            }
                        });
                        layui.layer.full(index);
                        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
                        $(window).on("resize",function(){
                            layui.layer.full(index);
                        });
                    }else{
                        layer.msg(data.msg);
                    }
                }
            })
        }
    });



})