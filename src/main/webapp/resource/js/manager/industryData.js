layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    var tableIns = table.render({
        id : "id",
        elem: '#userList',
        url : '/console/indusPage.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "indusListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'title', title: '标题', minWidth:100, align:"center"},
            {field: 'createtime', title: '创建时间', minWidth:100, align:'center'},
            {field: 'major', title: '优化词', align:'center'},
            {field: 'remark', title: '备注',  minWidth:200, align:'center'},
            {field: 'name', title: '所属分类', align:'center'},
            {field: 'source', title: '来源', align:'center',minWidth:150},
            {field: 'hot', title: '热点文章', align:'center',minWidth:100,templet:function(d){
                return d.hot == 0 ? "否" : "是";
            }},
            {field: 'status', title: '状态', align:'center',minWidth:100,templet:"#modifyStatus"},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    $(".search_btn").on("click",function(){
        table.reload("indusListTable",{
            page: {
                curr: 1
            },
            where: {
                title : $(".searchVal").val(),
                category : $("#search").val()
            }
        })
    });

    $.ajax({
        url : "/console/initIndusAllCategory.shtml",
        type : "get",
        cache:true,
        dataType : "json",
        success : function(data){
            if(data.status==200){
                var categoryHtml = '<option value="-1">全部</option>';
                $.each(data.data,function(i,v){
                    categoryHtml += '<option value="'+v.id+'">'+v.title+'</option>';
                });
                $("#search").append(categoryHtml);
                form.render('select');
            }else{
                layer.msg(data.msg);
            }
        }
    })

    $(".addNews_btn").click(function(){
        addIndus();
    })

    function addIndus(edit){
        var index = layui.layer.open({
            title : "编辑文章",
            type : 2,
            content : "/console/addOrUpdateIndus.shtml",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".idval").val(edit.id);
                    body.find(".title").val(edit.title);
                    body.find(".source").val(edit.source);
                    body.find(".content").text(edit.content);
                    body.find(".remark").text(edit.remark);
                    body.find(".description").text(edit.description);
                    body.find(".hot input[value="+edit.hot+"]").prop("checked","checked");
                    body.find(".category").val(edit.category);
                    body.find(".status").val(edit.status);
                    body.find(".userFaceBtn").attr('src',edit.sourceimg);
                    body.find("#sourceimg").val(edit.sourceimg);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
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
        var checkStatus = table.checkStatus('indusListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].id);
            }
            layer.confirm('确定删除选中的文章？', {icon: 3, title: '温馨提示'}, function (index) {
                $.ajax({
                    url : "/console/deleteIndusSingleOrBatch.shtml",
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
            layer.msg("请选择需要删除的文章");
        }
    })

    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){
            addIndus(data);
        }else if(layEvent === 'usable'){
            var _this=$(this),usableText = "是否确定禁用此文章？", status=0;
            if(data.status==0){
                usableText = "是否确定启用此文章？", status=1;
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
                    url : "/console/updateIndusStatus.shtml",
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
            layer.confirm('确定删除此文章？',{icon:3, title:'温馨提示'},function(index){
                $.ajax({
                    url : "/console/deleteIndusSingleOrBatch.shtml",
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