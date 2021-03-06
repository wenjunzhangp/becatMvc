<link href="https://cdn.bootcss.com/amazeui/2.7.2/css/amazeui.min.css" rel="stylesheet">
<link rel="stylesheet" href="/resource/css/assets/css/common.min.css" />
<link rel="stylesheet" href="/resource/css/assets/css/index.min.css" />

<!--===========layout-header================-->
<div class="layout-header am-hide-sm-only">
    <!--topbar start-->
    <div class="topbar">
        <div class="container">
            <div class="am-g">
                <div class="am-u-md-3">
                    <div class="topbar-left">
                        <i class="am-icon-globe"></i>
                        <div class="am-dropdown" data-am-dropdown>
                            <button class="am-btn am-btn-primary am-dropdown-toggle" data-am-dropdown-toggle>Language <span class="am-icon-caret-down"></span></button>
                            <ul class="am-dropdown-content">
                                <li><a href="javascript:void(0)">Chinese</a></li>
                                <li class="am-divider"></li>
                                <li><a href="javascript:void(0)">English</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="am-u-md-9">
                    <div class="topbar-right am-text-right am-fr">
                        <#if (token.nickname)??>
                            <span>${(token.nickname)!'未登陆'}</span>
                        <#else>
                            <a href="/login.shtml" title="QQ快速登录" class="am-icon-qq am-icon-fw am-icon-sm am-animation-shake" ></a>QQ快速登录
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--topbar end-->


    <div class="header-box" data-am-sticky>
        <!--header start-->
        <div class="container">
            <div class="header">
                <div class="am-g">
                    <div class="am-u-lg-2 am-u-sm-12">
                        <div class="logo">
                            <a href="/product.shtml"><img src="/resource/images/logo.png" alt="" /></a>
                        </div>
                    </div>
                    <div class="am-u-md-10">
                        <div class="header-right am-fr">
                            <div class="header-contact">
                                <div class="header_contacts--item">
                                    <div class="contact_mini">
                                        <i style="color:#7c6aa6" class="contact-icon am-icon-phone"></i>
                                        <strong>18811359094 17611597978</strong>
                                        <span>周六~周日, 8:00 - 20:00</span>
                                    </div>
                                </div>
                                <div class="header_contacts--item">
                                    <div class="contact_mini">
                                        <i style="color:#7c6aa6" class="contact-icon am-icon-envelope-o"></i>
                                        <strong>zhangwenjunp@126.com</strong>
                                        <span>看猫随时欢迎您的来信！</span>
                                    </div>
                                </div>
                                <div class="header_contacts--item">
                                    <div class="contact_mini">
                                        <i style="color:#7c6aa6" class="contact-icon am-icon-map-marker"></i>
                                        <strong>某互联网公司端茶倒水</strong>
                                        <span>北京市昌平区</span>
                                    </div>
                                </div>
                            </div>
                            <a href="/contact.shtml" class="contact-btn">
                                <button type="button" class="am-btn am-btn-secondary am-radius">联系站长</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--header end-->


        <!--nav start-->
        <div class="nav-contain">
            <div class="nav-inner">
                <ul class="am-nav am-nav-pills am-nav-justify">
                    <li class=""><a href="/product.shtml">首页</a></li>
                    <li><a href="/pet.shtml">在售宠物</a></li>
                    <li><a href="/taobao/coupon.shtml" target="_blank">领取淘宝优惠券</a></li>
                    <li>
                        <a href="javascript:void(0);">博文趣事</a>
                        <ul class="sub-menu">
                            <li class="menu-item"><a href="/blog.shtml">技术博客</a></li>
                            <li class="menu-item"><a href="/news.shtml">文章趣事</a></li>
                            <li class="menu-item"><a href="/event.shtml">平台大事记</a></li>
                            <li class="menu-item"><a href="/notice.shtml">平台公告</a></li>
                        </ul>
                    </li>
                    <li><a href="/about.shtml">关于站长</a></li>
                    <li><a href="/joinus.shtml">留言墙</a></li>
                    <li><a href="/contact.shtml">联系站长</a></li>
                </ul>
            </div>
        </div>
        <!--nav end-->
    </div>
</div>

<!--mobile header start-->
<div class="m-header">
    <div class="am-g am-show-sm-only">
        <div class="am-u-sm-2">
            <div class="menu-bars">
                <a href="#doc-oc-demo1" data-am-offcanvas="{effect: 'push'}"><i class="am-menu-toggle-icon am-icon-bars"></i></a>
                <!-- 侧边栏内容 -->
                <nav data-am-widget="menu" class="am-menu  am-menu-offcanvas1" data-am-menu-offcanvas >
                    <a href="javascript: void(0)" class="am-menu-toggle"></a>

                    <div class="am-offcanvas" >
                        <div class="am-offcanvas-bar">
                            <ul class="am-menu-nav am-avg-sm-1">
                                <li><a href="/product.shtml" class="" >首页</a></li>
                                <li class="am-parent"><a href="/pet.shtml" class="" >在售宠物</a></li>
                                <li class="am-parent"><a href="/taobao/coupon.shtml" class="" >领取淘宝优惠券</a></li>
                                <li class="am-parent">
                                    <a href="javascript:void(0);" class="" >博文趣事</a>
                                    <ul class="am-menu-sub am-collapse  ">
                                        <li class="">
                                            <a href="/blog.shtml" class="" >技术博客</a>
                                        </li>
                                        <li class="">
                                            <a href="/event.shtml" class="" >平台大事记</a>
                                        </li>
                                        <li class="">
                                            <a href="/notice.shtml" class="" >平台公告</a>
                                        </li>
                                        <li class="">
                                            <a href="/news.shtml" class="" >文章趣事</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class=""><a href="/about.shtml" class="" >关于站长</a></li>
                                <li class=""><a href="/joinus.shtml" class="" >留言墙</a></li>
                                <li class=""><a href="/contact.shtml" class="" >联系站长</a></li>
                                <li class="am-parent">
                                    <a href="javascript:void(0)" class="nav-icon nav-icon-globe" >Language</a>
                                    <ul class="am-menu-sub am-collapse  ">
                                        <li>
                                            <a href="javascript:void(0)" >English</a>
                                        </li>
                                        <li class="">
                                            <a href="javascript:void(0)" >Chinese</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class=""><a href="/pclogin.shtml" class="" >登录</a></li>
                                <li class=""><a href="/pcregister.shtml" class="" >注册</a></li>
                            </ul>

                        </div>
                    </div>
                </nav>

            </div>
        </div>
        <div class="am-u-sm-5 am-u-end">
            <div class="m-logo">
                <a href="/product.shtml"><img src="/resource/images/logo.png" alt=""></a>
            </div>
        </div>
    </div>
    <!--mobile header end-->
</div>