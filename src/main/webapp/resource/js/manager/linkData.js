var show=1,status=1;
layui.use(['form','layer','laydate','table','upload'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;

    laydate.render({
        elem: '#time',
        range: '~',
        format:'yyyy-MM-dd'
    });

    var tableIns = table.render({
        id : "id",
        elem: '#linkList',
        url : '/console/sysLinkPage.shtml',
        page : true,
        cellMinWidth : 104,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "linkListTab",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'logo', title: 'LOGO', width:180, align:"center",templet:function(d){
                return '<a href="'+d.logo+'" target="_blank"><img src="'+d.logo+'" height="26" /></a>';
            }},
            {field: 'domainName', title: '网站名称', width:200,align:"center"},
            {field: 'domainUrl', title: '网站地址',width:200,align:"center",templet:function(d){
                return '<a class="layui-blue" href="'+d.domainUrl+'" target="_blank">'+d.domainUrl+'</a>';
            }},
            {field: 'contact', title: '站长联系方式',width:150, align:'center'},
            {field: 'show', title: '展示位置',width:100, align:'center',templet:function(d){
                return d.show == "1" ? "首页" : "子页";
            }},
            {field: 'createtime', title: '创建时间', align:'center',minWidth:50},
            {field: 'status', title: '状态', align:'center',width:110,templet:"#modifyStatus"},
            {title: '操作', width:130,fixed:"right",align:"center",templet:'#sysLinkListBar'}
        ]]
    });

    $(".search_btn").on("click",function(){
        var time = $("#time").val();
        var starttime = time.substring(0,time.indexOf("~"));
        var endtime = time.substring(time.indexOf("~")+1,time.length);
        table.reload("linkListTab",{
            page: {
                curr: 1
            },
            where: {
                domainName : $(".domainName").val(),
                starttime : starttime,
                endtime : endtime
            }
        })
    });

    function addLink(edit){
        var index = layer.open({
            title : "编辑友链",
            type : 2,
            area : ["466px","500px"],
            content : "/console/linkadd.shtml",
            success : function(layero, index){
                var body = $($(".layui-layer-iframe",parent.document).find("iframe")[0].contentWindow.document.body);
                if(edit){
                    body.find(".idval").val(edit.id);
                    body.find(".linkLogo").css("background","#fff");
                    body.find("#logo").val(edit.logo);
                    body.find(".userFaceBtn").attr('src',edit.logo);
                    body.find(".domainName").val(edit.domainName);
                    body.find(".domainUrl").val(edit.domainUrl);
                    body.find(".contact").val(edit.contact);
                    body.find(".display").val(edit.display);
                    body.find(".show").prop("checked",edit.show==1?'checked':'');
                    body.find(".status").prop("checked",edit.status==1?'checked':'');
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回友链列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
    }
    $(".addLink_btn").click(function(){
        addLink();
    })

    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('linkListTab'),
            data = checkStatus.data,
            linkId = [];
        if(data.length > 0) {
            for (var i in data) {
                linkId.push(data[i].id);
            }
            layer.confirm('确定删除选中的友链？', {icon: 3, title: '温馨提示'}, function (index) {
                $.ajax({
                    url : "/console/deleteSysLinkSingleOrBatch.shtml",
                    type : "post",
                    data: {ids:linkId.toString()},
                    success : function(data){
                        if(data.status==200){
                            layer.msg(data.msg);
                            tableIns.reload();
                            layer.close(index);
                        }else{
                            layer.msg(data.msg);
                        }
                    }
                })
            })
        }else{
            layer.msg("请选择需要删除的友链");
        }
    })

    table.on('tool(linkList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){
            addLink(data);
        }else if(layEvent === 'usable'){
            var _this=$(this),usableText = "是否确定禁用此友链？", status=0;
            if(data.status==0){
                usableText = "是否确定启用此友链？", status=1;
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
                    url : "/console/updateSysLinkStatus.shtml",
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
            layer.confirm('确定删除此友链？',{icon:3, title:'温馨提示'},function(index){
                $.ajax({
                    url : "/console/deleteSysLinkSingleOrBatch.shtml",
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

    var uploadInst = upload.render({
        elem: '.userFaceBtn',
        url: '/open/uploadImg.shtml',
        method : "post",
        ext: 'jpg|png|gif',
        before: function(obj){
            obj.preview(function(index, file, result){
                $('#userFace').attr('src', result);
            });
        },
        done: function(res, index, upload){
            if (res.status==200) {
                layer.msg("缩略图上传成功!");
                $('#userFace').attr('src',res.data);
                $("#logo").val(res.data);
                $('.linkLogo').css("background","#fff");
            } else {
                layer.msg("缩略图上传失败请稍后再试!");
            }
        },
        error: function(){
            layer.msg("缩略图上传失败请稍后再试!");
        }
    });

    form.on('switch(show)', function(data){
        show=this.checked ? 1 : 0;
        var body = $($(".layui-layer-iframe",parent.document).find("iframe")[0].contentWindow.document.body);
        body.find(".showval").val(show);
        form.render();
    });

    form.on('switch(status)', function(data){
        status=this.checked ? 1 : 0;
        var body = $($(".layui-layer-iframe",parent.document).find("iframe")[0].contentWindow.document.body);
        body.find(".statusval").val(status);
        form.render();
    });

    form.on("submit(modifyLink)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            url : "/console/modifySysLink.shtml",
            type : "post",
            data:$(".linkForm").serialize(),
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