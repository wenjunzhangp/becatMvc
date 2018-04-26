layui.use(['form','layer','layedit','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,layedit = layui.layedit,upload = layui.upload;

    layedit.set({
        uploadImage: {
            url: '/open/uploadImg.shtml',
            type: 'post'
        }
    });
    notice = layedit.build('content'),{
        width:600,
        height: 300
    };

    //添加验证规则
    form.verify({
        noticeCategory: function (value, item) {
            if (value == -1) {
                return "不要忘记选公告分类";
            }
        }
    })

    form.on("submit(modifyNotice)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        layedit.sync(notice);
        $.ajax({
            url : "/console/modifyNotice.shtml",
            type : "post",
            data:$(".noticeForm").serialize(),
            dataType : "json",
            success : function(data){
                if(data.status==200){
                    setTimeout(function () {
                        top.layer.close(index);
                        top.layer.msg("操作成功！");
                        layer.closeAll("iframe");
                        parent.location.reload();
                    }, 2000);
                }else{
                    layer.msg(data.msg);
                }
            }
        })
        return false;
    })

})