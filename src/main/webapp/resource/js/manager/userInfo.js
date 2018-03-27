var form, $,areaData;
layui.config({
    base : "/resource/js/manager/"
}).extend({
    "address" : "address"
})
layui.use(['form','layer','upload','laydate',"address"],function(){
    form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        upload = layui.upload,
        laydate = layui.laydate,
        address = layui.address;

    $("#userFace").attr("src",$("#userimg").val());
    $(".userAvatar").attr("src",$("#userimg").val());

    //上传头像
    var uploadInst = upload.render({
        elem: '.userFaceBtn',
        url: '/console/uploadUserFaceImg.shtml',
        method : "post",
        ext: 'jpg|png|gif',
        before: function(obj){
            obj.preview(function(index, file, result){
                $('#userFace').attr('src', result);
            });
        },
        done: function(res, index, upload){
            if (res.status==200) {
                layer.msg("头像更新成功!");
                $('#userFace').attr('src',res.data);
                $(".userAvatar").attr("src",res.data);
                window.sessionStorage.setItem('userFace',res.data);
            } else {
                layer.msg("头像更新失败!");
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
        userBirthday : function(value){
            if(!/^(\d{4})[\u4e00-\u9fa5]|[-\/](\d{1}|0\d{1}|1[0-2])([\u4e00-\u9fa5]|[-\/](\d{1}|0\d{1}|[1-2][0-9]|3[0-1]))*$/.test(value)){
                return "出生日期格式不正确！";
            }
        }
    })
    //选择出生日期
    laydate.render({
        elem: '.userBirthday',
        format: 'yyyy年MM月dd日',
        trigger: 'click',
        max : 0,
        mark : {"0-03-14":"生日"},
        done: function(value, date){
            if(date.month === 03 && date.date === 14){ //点击每年12月15日，弹出提示语
                layer.msg('今天是张文君的生日,快来送上祝福吧！');
            }
        }
    });

    //获取省信息
    address.provinces();
    var gender = $("#genderhidden").val();
    var hobby = $("#hobbyhidden").val();
    var hobbyarr = hobby.split(",");
    $(".userSex input[value="+gender+"]").attr("checked","checked"); //性别
    //爱好兴趣
    for(j = 0,len=hobbyarr.length; j < len; j++) {
        $(".userHobby input[data-like='like["+hobbyarr[j]+"]']").attr("checked","checked");
    }
    /*$.get("/resource/json/address.json", function (addressData) {
        $(".userAddress select[name='province']").val(userInfo.province); //省
        var value = userInfo.province;
        if (value > 0) {
            address.citys(addressData[$(".userAddress select[name='province'] option[value='"+userInfo.province+"']").index()-1].childs);
            citys = addressData[$(".userAddress select[name='province'] option[value='"+userInfo.province+"']").index()-1].childs;
        } else {
            $('.userAddress select[name=city]').attr("disabled","disabled");
        }
        $(".userAddress select[name='city']").val(userInfo.city); //市
        //填充市级信息，同时调取区县信息列表
        var value = userInfo.city;
        if (value > 0) {
            address.areas(citys[$(".userAddress select[name=city] option[value='"+userInfo.city+"']").index()-1].childs);
        } else {
            $('.userAddress select[name=area]').attr("disabled","disabled");
        }
        $(".userAddress select[name='area']").val(userInfo.area); //区
        form.render();
    })*/

    //提交个人资料
    form.on("submit(changeUser)",function(data){
        var index = layer.load();
        var standardsName='';
        $("input:checkbox[data-like]:checked").each(function() {
            standardsName += ',' + $(this).attr('title');
        });
        $("#hobby").val(standardsName);
        $.ajax({
            url: "/console/updateper.shtml",
            dataType : "json",
            async:false,
            data: $("#userForm").serialize(),
            success: function(resp) {
                layer.close(index);
                if(resp.status==200){
                    setTimeout(function(){
                        layer.msg("提交成功！");
                    },2000);
                }else{
                    layer.msg(resp.msg);
                }
            }
        });
    })

})