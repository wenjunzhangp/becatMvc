layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    var tableIns = table.render({
        id : 'id',
        elem: '#userList',
        url : '/console/sysPermissionData.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "userListTable",
        cols : [[
            {field: 'name', title: '权限名称', minWidth:100, align:"center"},
            {field: 'type', title: '类型', align:'center',minWidth:50},
            {field: 'url', title: '路径', minWidth:100, align:'center'},
            {field: 'percode', title: '权限代码', align:'center',minWidth:50},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    $(".search_btn").on("click",function(){
        table.reload("userListTable",{
            page: {
                curr: 1
            },
            where: {
                name : $(".searchVal").val(),
                type : $(".type").val()
            }
        })
    });

    $(".addNews_btn").click(function(){
        addIndus();
    })

    function addIndus(edit){
        var index = layer.open({
            title : "编辑权限",
            type : 2,
            area : ["466px","350px"],
            content : "/console/addOrUpdateSysPermission.shtml",
            success : function(layero, index){
                form.render();
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }

    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].id);
            }
            layer.confirm('确定删除选中的权限？', {icon: 3, title: '温馨提示'}, function (index) {
                $.ajax({
                    url : "/console/deleteSysPermissionSingleOrBatch.shtml",
                    type : "post",
                    data: {ids:newsId.toString()},
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
            })
        }else{
            layer.msg("请选择需要删除的权限");
        }
    })

    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){
            addIndus(data);
        }else if(layEvent === 'del'){
            layer.confirm('确定删除此权限？',{icon:3, title:'温馨提示'},function(index){
                $.ajax({
                    url : "/console/deleteSysPermissionSingleOrBatch.shtml",
                    type : "post",
                    data: {ids:data.id},
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
            });
        }

    });

    form.on("submit(modifyAuthc)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            url : "/console/modifySysPermission.shtml",
            type : "post",
            data:$(".authcForm").serialize(),
            dataType : "json",
            success : function(data){
                if(data.status==200){
                    setTimeout(function(){
                        top.layer.close(index);
                        top.layer.msg("操作成功！");
                        layer.closeAll("iframe");
                        $(".layui-tab-item.layui-show",parent.document).find("iframe")[0].contentWindow.location.reload();
                    },1000);
                }else{
                    layer.msg(data.msg);
                }
            }
        })
        return false;
    })

})