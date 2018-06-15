<#include "common/source.ftl">
<link rel="stylesheet" href="/resource/css/assets/css/news.min.css" />
<link rel="stylesheet" href="/resource/css/assets/css/embed.default.css" />

<#include "common/head.ftl">

  <div class="layout">
    <!--===========layout-container================-->
    <div class="layout-container">
      <div class="page-header">
        <div class="am-container">
          <h1 class="page-header-title">博客详情</h1>
        </div>
      </div>

      <div class="breadcrumb-box">
        <div class="am-container">
          <ol class="am-breadcrumb">
            <li><a href="/product.shtml">首页</a></li>
            <li class="am-active">博客详情</li>
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
              <h2 class="article--title"><a href="javascript:void(0)" rel="">${blogObject.title}</a></h2>
              <ul class="article--meta">
                <#setting date_format="yyyy-MM-dd HH:mm:ss">
                <li class="article--meta_item"><i class="am-icon-calendar"></i>${blogObject.createtime?date}</li>
                <li class="article--meta_item"><i class="am-icon-user"></i>${blogObject.author}</li>
                <li class="article--meta_item"><i class="am-icon-commenting-o"></i>${blogObject.looknum}</li>
              </ul>
            </header>
            <div class="article--content">
                ${blogObject.content}
            </div>
          </div>

          <div class="row">
              <#--评论输入
              固定写法：class="ds-thread"  id="ds-thread"
              data-key= url 这里是用这个URL来做key，你看你自己的业务，因为多说也是这样做，就这样下来了
              -->
              <div class="ds-thread"  id="ds-thread" data-key="http://www.becat.shop"></div>
          </div>

        </div>
        <!--news-section left end-->

      <#include "common/rightdetail.ftl">
      </div>
    </div>
  </div>

<#include "common/footer.ftl">
<script src="/resource/js/view/rightdetail.js" charset="utf-8"></script>
<script src="/resource/js/view/message.js" charset="utf-8"></script>