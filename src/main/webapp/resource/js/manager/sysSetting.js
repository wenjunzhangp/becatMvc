layui.use(['form','layer','jquery'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : top.layer,
		$ = layui.jquery;

 	form.on("submit(systemParameter)",function(data){
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            url : "/console/modifySysSetting.shtml",
            type : "post",
            data:$(".systemSettingForm").serialize(),
            dataType : "json",
            success : function(data){
                if(data.status==200){
                    setTimeout(function(){
                        layer.close(index);
                        layer.msg("系统基本参数修改成功！");
                        window.location.reload();
                    },1000);
                }else{
                    layer.msg(data.msg);
                }
            }
        })
 		return false;
 	})
})
