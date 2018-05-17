layui.config({
    base : "/resource/js/manager/"
}).use(['flow','form','layer','upload'],function(){
    var flow = layui.flow,
        form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        upload = layui.upload,
        $ = layui.jquery;

    var imgNums = 15;//单页显示图片数量
    flow.load({
        elem: '#Images',
        done: function(page, next){
            $.get("/resource/json/images.json",function(res){
                var imgList = [],data = res.data;
                var maxPage = imgNums*page < data.length ? imgNums*page : data.length;
                setTimeout(function(){
                    for(var i=imgNums*(page-1); i<maxPage; i++){
                        imgList.push('<li><img layer-src="/resource/'+ data[i].src +'" src="/resource/'+ data[i].thumb +'" alt="'+data[i].alt+'"><div class="operate"><div class="check"><input type="checkbox" name="belle" lay-filter="choose" lay-skin="primary" title="'+data[i].alt+'"></div><i class="layui-icon img_del">&#xe640;</i></div></li>');
                    }
                    next(imgList.join(''), page < (data.length/imgNums));
                    form.render();
                }, 500);
            });
        }
    });

    //设置图片的高度
    $(window).resize(function(){
        $("#Images li img").height($("#Images li img").width());
    })

    upload.render({
        elem: '.uploadNewImg',
        url: '/open/uploadImg.shtml',
        method : "post",
        ext: 'jpg|png|gif',
        before: function(obj){
            obj.preview(function(index, file, result){

            });
        },
        done: function(res){
            if (res.code==0) {
                layer.msg(res.msg);
                $('#Images').prepend('<li><img layer-src="'+ res.data.src +'" src="'+ res.data.src +'" alt="'+ res.data.filename +'" class="layui-upload-img"><div class="operate"><div class="check"><input type="checkbox" name="belle" lay-filter="choose" lay-skin="primary" title="'+res.data.filename+'"></div><i class="layui-icon img_del">&#xe640;</i></div></li>')
                $("#Images li img").height($("#Images li img").width());
                form.render("checkbox");
            } else {
                layer.msg(res.msg);
            }
        },
        error: function(){
            layer.msg("图片上传接口异常，请稍后再试");
        }
    });

    $("body").on("click","#Images img",function(){
        parent.showImg();
    })

    $("body").on("click",".img_del",function(){
        var _this = $(this);
        layer.confirm('确定删除图片"'+_this.siblings().find("input").attr("title")+'"吗？',{icon:3, title:'温馨提示'},function(index){
            _this.parents("li").hide(1000);
            setTimeout(function(){_this.parents("li").remove();},950);
            layer.close(index);
        });
    })

    form.on('checkbox(selectAll)', function(data){
        var child = $("#Images li input[type='checkbox']");
        child.each(function(index, item){
            item.checked = data.elem.checked;
        });
        form.render('checkbox');
    });

    form.on("checkbox(choose)",function(data){
        var child = $(data.elem).parents('#Images').find('li input[type="checkbox"]');
        var childChecked = $(data.elem).parents('#Images').find('li input[type="checkbox"]:checked');
        if(childChecked.length == child.length){
            $(data.elem).parents('#Images').siblings("blockquote").find('input#selectAll').get(0).checked = true;
        }else{
            $(data.elem).parents('#Images').siblings("blockquote").find('input#selectAll').get(0).checked = false;
        }
        form.render('checkbox');
    })

    $(".batchDel").click(function(){
        var $checkbox = $('#Images li input[type="checkbox"]');
        var $checked = $('#Images li input[type="checkbox"]:checked');
        if($checkbox.is(":checked")){
            layer.confirm('确定删除选中的图片？',{icon:3, title:'温馨提示'},function(index){
                var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
                setTimeout(function(){
                    $checked.each(function(){
                        $(this).parents("li").hide(1000);
                        setTimeout(function(){$(this).parents("li").remove();},950);
                    })
                    $('#Images li input[type="checkbox"],#selectAll').prop("checked",false);
                    form.render();
                    layer.close(index);
                    layer.msg("删除服务器图片成功");
                },2000);
            })
        }else{
            layer.msg("请选择需要删除的图片");
        }
    })

})