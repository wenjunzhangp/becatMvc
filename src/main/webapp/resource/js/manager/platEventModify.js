layui.use(['form','layer','layedit','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,layedit = layui.layedit,upload = layui.upload;

    layedit.build('content'),{
        width:600,
        height: 180
    };

    form.on("submit(modifyPlatEvent)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            url : "/console/modifyPlatEvent.shtml",
            type : "post",
            data:$(".platEventForm").serialize(),
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