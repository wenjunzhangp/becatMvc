var treeData = "";
layui.use(['layer','tree'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    $.ajax({
        url : "/console/myPermissionTree.shtml",
        type : "post",
        cache:true,
        dataType : "json",
        success : function(data){
            $(".authcCount").html(data.data.length);
            treeData = data.data;
            layui.tree({
                elem: '#authcTree',
                skin: 'as',
                drag: true,
                nodes:treeData
            });
        }
    })

})