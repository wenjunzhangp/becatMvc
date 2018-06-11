<#include "common/source.ftl">
<link rel="stylesheet" href="/resource/css/assets/css/news.min.css" />

<#include "common/head.ftl">

    <!--===========layout-container================-->
    <div class="layout-container">
      <div class="page-header">
        <div class="am-container">
          <h1 class="page-header-title">文章趣事</h1>
        </div>
      </div>

      <div class="breadcrumb-box">
        <div class="am-container">
          <ol class="am-breadcrumb">
            <li><a href="/product.shtml">首页</a></li>
            <li class="am-active">文章趣事</li>
          </ol>
        </div>
      </div>
    </div>

    <div class="section">
      <div class="container">
          <div class="am-g am-g-fixed blog-fixed">
              <div class="am-u-md-12 am-u-sm-12 articledata">
              </div>

              <!-- pagination-->
              <ul id="paginator" class="am-pagination"></ul>
          </div>
          <!-- content end -->
      </div>
    </div>

<#include "common/footer.ftl">
<script>
    var total = "${total}";
</script>
<script src="/resource/js/view/page.js" charset="utf-8"></script>
<script src="/resource/js/view/news.js" charset="utf-8"></script>
