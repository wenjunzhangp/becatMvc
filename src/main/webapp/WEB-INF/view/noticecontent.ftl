<#include "common/source.ftl">
<link rel="stylesheet" href="/resource/css/assets/css/news.min.css" />

<#include "common/head.ftl">

<div class="layout">
    <!--===========layout-container================-->
    <div class="layout-container">
        <div class="page-header">
            <div class="am-container">
                <h1 class="page-header-title">公告详情</h1>
            </div>
        </div>

        <div class="breadcrumb-box">
            <div class="am-container">
                <ol class="am-breadcrumb">
                    <li><a href="/product.shtml">首页</a></li>
                    <li class="am-active">公告详情</li>
                </ol>
            </div>
        </div>
    </div>

    <div class="section news-section">
        <div class="container">
            <!--news-section left start-->
            <div class="am-u-md-9">
                <div class="article">
                    <header class="article--header">
                        <h2 class="article--title"><a href="href="javascript:void(0)" rel="">${noticeObject.title}</a></h2>
                        <ul class="article--meta">
                        <#setting date_format="yyyy-MM-dd HH:mm:ss">
                            <li class="article--meta_item"><i class="am-icon-calendar"></i>${noticeObject.publictime?date}</li>
                            <li class="article--meta_item"><i class="am-icon-user"></i>BeCat</li>
                            <li class="article--meta_item"><i class="am-icon-commenting-o"></i>${noticeCategory}</li>
                        </ul>
                    </header>
                    <div class="article--content">
                    ${noticeObject.content}
                    </div>
                </div>
            </div>
            <!--news-section left end-->

        <#include "common/rightdetail.ftl">
        </div>
    </div>
</div>

<#include "common/footer.ftl">
<script src="/resource/js/view/rightdetail.js" charset="utf-8"></script>