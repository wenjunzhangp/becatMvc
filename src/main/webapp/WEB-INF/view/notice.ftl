<#include "common/source.ftl">
<link rel="stylesheet" href="/resource/css/assets/css/notice.min.css"/>

<#include "common/head.ftl">

<!--===========layout-container================-->
<div class="layout-container">
    <div class="page-header">
        <div class="am-container">
            <h1 class="page-header-title">平台公告</h1>
        </div>
    </div>

    <div class="breadcrumb-box">
        <div class="am-container">
            <ol class="am-breadcrumb">
                <li><a href="/product.shtml">首页</a></li>
                <li class="am-breave">平台公告</li>
            </ol>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="am-g am-g-fixed qing-fixed qing-container">
            <div class="am-u-md-8 am-u-sm-12">
                <div class="blog-list">

                    <#--<div class="qing-entry-text">
                        <div class="qing-list-title"><span class="qing-category">技术<i></i></span><a
                                href="/B20170925151005.html"> 青菜萝卜博客系统V2.0发布啦，欢迎围观～</a></div>
                        <div class="qing-list-hint"><span><i class="am-icon-user qing-color-author" title="作者"></i> 胡建洪 &nbsp;</span>
                            <span><i class="am-icon-clock-o qing-color-clock" title="时间"></i> 2017-09-25</span> <span><i
                                    class="am-icon-eye-slash qing-color-eye" title="阅读"></i> 阅读(596)</span> <span><i
                                    class="am-icon-comments-o qing-color-comment" title="评论"></i> 评论(5)</span> <span><i
                                    class="am-icon-heart-o qing-color-heart" title="点赞"></i> 点赞(171)</span></div>
                        <p class="qing-list-content">
                            在2017年2月份开源了青菜萝卜博客系统V1.0，开源后不久陆续有同学向我反馈问题，主要集中在项目部署、项目构建等方面，这次趁着空闲时间，将原先的博客系统进行升级，降低部署难度和学习成本。这次的修改在代码方面没有太多的改进，主要是在项目构建方式以及目录结构修改上。</p>
                        <div class="qing-list-foot"><i class="am-icon-tags"></i> <span class="am-radius">#Java</span>
                            <span class="am-radius">#Blog</span> <a href="/B20170925151005.html" class="qing-read-more">阅读全文&gt;&gt;</a>
                        </div>
                    </div>-->
                </div>

                <!-- pagination-->
                <ul id="paginator" class="am-pagination"></ul>
            </div>

            <#include "common/right.ftl">
        </div>
    </div>
</div>

<#include "common/footer.ftl">
<script>
    var total = "${total}";
</script>
<script src="/resource/js/view/page.js" charset="utf-8"></script>
<script src="/resource/js/view/notice.js" charset="utf-8"></script>
<script src="/resource/js/view/right.js" charset="utf-8"></script>