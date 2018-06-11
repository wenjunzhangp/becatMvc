layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    var tableIns = table.render({
        id : "id",
        elem: '#userList',
        url : '/console/blogPage.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "blogListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'title', title: '标题', minWidth:100, align:"center"},
            {field: 'author', title: '作者', minWidth:100, align:'center'},
            {field: 'fabulous', title: '点赞数', align:'center'},
            {field: 'looknum', title: '阅读数',  minWidth:200, align:'center'},
            {field: 'source', title: '来源', align:'center',minWidth:150},
            {field: 'type', title: '类型', align:'center',minWidth:100,templet:function(d){
                if(d.type == "0"){
                    return "未知来源";
                }else if(d.type == "1"){
                    return "原创";
                }else if(d.type == "2"){
                    return "转载";
                }else{
                    return "未知来源";
                }
            }},
            {field: 'status', title: '状态', align:'center',minWidth:100,templet:"#modifyStatus"},
            {field: 'stick', title: '是否置顶', align:'center',minWidth:100,templet:"#modifyStick"},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    $(".search_btn").on("click",function(){
        table.reload("blogListTable",{
            page: {
                curr: 1
            },
            where: {
                title : $(".searchVal").val(),
                category : $("#category").val(),
                type : $("#type").val()
            }
        })
    });

    $(".addNews_btn").click(function(){
        addIndus();
    })

    function addIndus(edit){
        var index = layui.layer.open({
            title : "编辑技术博客",
            type : 2,
            content : "/console/addOrUpdateBlog.shtml",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".idval").val(edit.id);
                    body.find(".title").val(edit.title);
                    body.find(".source").val(edit.source);
                    body.find(".author").val(edit.author);
                    body.find(".content").text(edit.content);
                    body.find(".abstractremark").text(edit.abstractremark);
                    body.find(".type input[value="+edit.type+"]").prop("checked","checked");
                    body.find(".stick input[value="+edit.stick+"]").prop("checked","checked");
                    body.find(".status input[value="+edit.status+"]").prop("checked","checked");
                    body.find(".category").val(edit.category);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回技术博客列表', '.layui-layer-setwin .layui-layer-close', {
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
        var checkStatus = table.checkStatus('blogListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].id);
            }
            layer.confirm('确定删除选中的技术博客？', {icon: 3, title: '温馨提示'}, function (index) {
                $.ajax({
                    url : "/console/deleteBlogSingleOrBatch.shtml",
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
            layer.msg("请选择需要删除的技术博客");
        }
    })

    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){
            addIndus(data);
        }else if(layEvent === 'usable'){
            var _this=$(this),usableText = "是否确定禁用此技术博客？", status=0;
            if(data.status==0){
                usableText = "是否确定启用此技术博客？", status=1;
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
                    url : "/console/updateBlogStatus.shtml",
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
        } else if(layEvent === 'pullstick'){
            var _this=$(this),usableText = "是否确定下顶此技术博客？", status=0;
            if(data.stick==0){
                usableText = "是否确定置顶此技术博客？", status=1;
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
                    url : "/console/updateBlogStick.shtml",
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
        } else if(layEvent === 'del'){
            layer.confirm('确定删除此技术博客？',{icon:3, title:'温馨提示'},function(index){
                $.ajax({
                    url : "/console/deleteBlogSingleOrBatch.shtml",
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