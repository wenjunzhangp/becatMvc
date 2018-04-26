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
        url : '/console/platEventPage.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "platEventListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'title', title: '标题', minWidth:100, align:"center"},
            {field: 'content', title: '内容', minWidth:200,align:'center'},
            {field: 'createtime', title: '创建时间', minWidth:100, align:'center'},
            {field: 'status', title: '状态', align:'center',minWidth:100,templet:"#modifyStatus"},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    $(".search_btn").on("click",function(){
        var time = $("#time").val();
        var starttime = time.substring(0,time.indexOf("~"));
        var endtime = time.substring(time.indexOf("~")+1,time.length);
        table.reload("platEventListTable",{
            page: {
                curr: 1
            },
            where: {
                title : $(".searchVal").val(),
                starttime : starttime,
                endtime : endtime
            }
        })
    });

    $(".addNews_btn").click(function(){
        addIndus();
    })

    function addIndus(edit){
        var index = layui.layer.open({
            title : "编辑大事记",
            type : 2,
            content : "/console/addOrUpdatePlatEvent.shtml",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".idval").val(edit.id);
                    body.find(".title").val(edit.title);
                    body.find(".content").text(edit.content);
                    body.find(".status").prop("checked",edit.status==1?'checked':'');
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回大事记列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }

    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('platEventListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].id);
            }
            layer.confirm('确定删除选中的大事记？', {icon: 3, title: '温馨提示'}, function (index) {
                $.ajax({
                    url : "/console/deletePlatEventSingleOrBatch.shtml",
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
            layer.msg("请选择需要删除的大事记");
        }
    })

    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){
            addIndus(data);
        }else if(layEvent === 'usable'){
            var _this=$(this),usableText = "是否确定禁用此大事记？", status=0;
            if(data.status==0){
                usableText = "是否确定启用此大事记？", status=1;
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
                    url : "/console/updatePlatEventStatus.shtml",
                    type : "post",
                    data: {id:data.id,status:status},
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
        }else if(layEvent === 'del'){
            layer.confirm('确定删除此大事记？',{icon:3, title:'温馨提示'},function(index){
                $.ajax({
                    url : "/console/deletePlatEventSingleOrBatch.shtml",
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

})