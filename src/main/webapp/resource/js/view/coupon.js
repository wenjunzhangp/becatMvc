layui.use(['form','layer','table'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tableIns = table.render({
        id : "id",
        elem: '#couponList',
        url : '/taobao/coupondata.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "couponListTable",
        cols : [[
            {field: 'goodsname', title: '商品名称', minWidth:100, align:"center"},
            {field: 'goodsremark', title: '商品卖点', minWidth:100, align:'center'},
            {field: 'buynum', title: '购买人数', minWidth:100, align:'center'},
            {field: 'onlineprice', title: '在售价格', minWidth:100, align:'center'},
            {field: 'onlineprice', title: '折后价',minWidth:100, align:'center'},
            {field: 'url', title: '领取地址', align:'center',minWidth:200,templet:"#modifyNotice"},
            {title: '操作', minWidth:100, templet:'#couponListBar',fixed:"right",align:"center"}
        ]]
    });

    $(".search_btn").on("click",function(){
        table.reload("couponListTable",{
            page: {
                curr: 1
            },
            where: {
                goodsname : $(".searchVal").val(),
            }
        })
    });

    table.on('tool(couponList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'receive'){
            window.location.href = data.url;
        }
    });

})