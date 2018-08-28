layui.use(['form','layer','laydate','table','upload'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;

    var tableIns = table.render({
        id : "id",
        elem: '#userList',
        url : '/console/rolePage.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "roleListTable",
        cols : [[
            {field: 'name', title: '角色名称', minWidth:100, align:"center"},
            {field: 'available', title: '是否生效', minWidth:200,align:'center',templet:function(d){
                if(d.available == "0"){
                    return "已删除";
                }else if(d.available == "1"){
                    return "启用";
                }else{
                    return "未知";
                }
            }},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    $(".search_btn").on("click",function(){
        table.reload("roleListTable",{
            page: {
                curr: 1
            },
            where: {
                name : $(".searchVal").val()
            }
        })
    });

    function addIndus(edit){
        var index = layui.layer.open({
            title : "编辑大事记",
            type : 2,
            content : "/console/addOrUpdateSysRole.shtml",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".idval").val(edit.id);
                    body.find(".nameval").val(edit.name);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },1000)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }

    $(".addNews_btn").click(function(){
        addIndus();
    })

    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){
            addIndus(data);
        }else if(layEvent === 'del'){
            layer.confirm('确定删除此角色？',{icon:3, title:'温馨提示'},function(index){
                $.ajax({
                    url : "/console/deleteSysRole.shtml",
                    type : "post",
                    data: {id:data.id},
                    dataType : "json",
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

    form.on("submit(modifySysRole)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            url : "/console/modifySysRole.shtml",
            type : "post",
            data:$(".roleForm").serialize(),
            dataType : "json",
            success : function(data){
                if(data.status==200){
                    setTimeout(function () {
                        top.layer.close(index);
                        top.layer.msg("操作成功！");
                        layer.closeAll("iframe");
                        parent.location.reload();
                    }, 1000);
                }else{
                    layer.msg(data.msg);
                }
            }
        })
        return false;
    })

})