layui.use(['form','layer','layedit','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,layedit = layui.layedit,upload = layui.upload;

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
                $("#category").append(categoryHtml);
                form.render('select');
            }else{
                layer.msg(data.msg);
            }
        }
    })

    layedit.set({
        uploadImage: {
            url: '/open/uploadImg.shtml',
            type: 'post'
        }
    });
    indus = layedit.build('content'),{
        width:600,
        height: 300
    };

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
            if (res.code==0) {
                layer.msg(res.msg);
                $('#userFace').attr('src',res.data);
                $("#sourceimg").val(res.data);
            } else {
                layer.msg(res.msg);
            }
        },
        error: function(){
            var tryagain = $('#tryagain');
            tryagain.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
            tryagain.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });

    //添加验证规则
    form.verify({
        indusCategory: function (value, item) {
            if (value == -1) {
                return "不要忘记选文章分类";
            }
        }
    })

    form.on("submit(modifyIndus)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        layedit.sync(indus);
        $.ajax({
            url : "/console/modifyIndus.shtml",
            type : "post",
            data:$(".indusForm").serialize(),
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

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

})