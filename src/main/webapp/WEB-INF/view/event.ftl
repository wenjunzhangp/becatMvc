<#include "common/source.ftl">
<link rel="stylesheet" href="/resource/css/assets/css/notice.min.css" />

<#include "common/head.ftl">

    <!--===========layout-container================-->
    <div class="layout-container">
      <div class="page-header">
        <div class="am-container">
          <h1 class="page-header-title">平台大事记</h1>
        </div>
      </div>

      <div class="breadcrumb-box">
        <div class="am-container">
          <ol class="am-breadcrumb">
            <li><a href="/product.shtml">首页</a></li>
            <li class="am-active">平台大事记</li>
          </ol>
        </div>
      </div>
    </div>

    <div class="section">
      <div class="container">
          <div class="am-g am-g-fixed qing-fixed qing-container">
              <div class="am-u-md-8 am-u-sm-12">
                  <div class="event-list"></div>

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
<script src="/resource/js/view/event.js" charset="utf-8"></script>
<script src="/resource/js/view/right.js" charset="utf-8"></script>