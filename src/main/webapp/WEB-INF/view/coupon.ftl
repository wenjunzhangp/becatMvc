<meta charset="utf-8">
<title>BeCat-蓝胖子了解一下（线下交易）</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="keywords" content="becat,豆豆的蓝胖子,蓝胖子,撸猫,豆豆">
<meta name="description" content="豆豆的蓝胖子出售蓝胖子，提供java相关的技术博客，宠物资讯文章，还有各种奇趣百事可在留言墙展示。becat一直努力在成长，做最完美的售猫、技术交流网站。">
<meta name="mobile-agent" content="format=html5; url=https://www.doudoucat.com/">
<meta name="applicable-device" content="pc">
<meta name="robots" content="all">
<meta name="author" content="豆豆的蓝胖子">
<meta name="generator" content="Java">
<link rel="shortcut icon" href="/resource/images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="/resource/js/layui/css/layui.css" media="all">
<link rel="stylesheet" href="/resource/css/public.css" media="all" />

<body class="childrenBody">
<form class="layui-form">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" placeholder="请输入商品名称" />
                </div>
                <a class="layui-btn search_btn" data-type="reload">搜索</a>
            </div>
        </form>
    </blockquote>
    <table id="couponList" lay-filter="couponList"></table>

    <!--领取操作按钮-->
    <script type="text/html" id="couponListBar">
            <a class="layui-btn layui-btn-xs" lay-event="receive">领取</a>
    </script>
</form>
<script type="text/javascript" src="/resource/js/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/view/coupon.js"></script>
</body>
</html>