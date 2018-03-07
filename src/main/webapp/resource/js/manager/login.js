var isRememberMe=false;//默认记住我为false
layui.use(['form','layer','jquery'],function(){
    var layer = layui.layer, $ = layui.jquery, form = layui.form;
    //监听指定开关
    form.on('switch(switchTest)', function(data){
        isRememberMe=this.checked ? 'true' : 'false';
    });
    form.on('submit(login)',function(data){
        var username=$("#username").val();
        var password=$("#password").val();
        var randomcode=$("#randomcode").val();
        var rememberMe=isRememberMe;
        $.ajax({
            url: "/console/userLogin.shtml",
            dataType : "json",
            async:false,
            data: {username:username,password:password,randomcode:randomcode,rememberMe:rememberMe},
            success: function(data) {
                if(data.status==200){
                    layer.msg("正在为您跳转...");
                    setTimeout(function(){
                        window.location.href= "/console/index.shtml";
                    },1000)
                }else{
                    layer.msg(data.msg);
                }
            }
        });
        return false;
    });
});
//切换验证码
function randomImg() {
    var img = document.getElementById("randomcode_img");
    img.src = "/open/getGifCode.shtml?rnd=" + Math.random();
}
