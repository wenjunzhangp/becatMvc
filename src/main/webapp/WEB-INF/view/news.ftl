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
        <div class="news-contaier">
          <div class="blog">
            <div class="am-g datalist">
              <div class="am-u-lg-4 am-u-md-6">
                <div class="article">
                  <div class="article-img">
                    <img src="/resource/images/news/b01.jpg" alt="" />
                  </div>
                  <div class="article-header">
                    <h2><a href="#" rel="">云适配：价值驱动是占有市场的关键</a></h2>
                    <ul class="article--meta">
											<li class="article--meta_item -date">December 28, 2015</li>
											<li class="article--meta_item comments">33 Comments</li>
										</ul>
                  </div>
                  <div class="article--content">
										<p>作为一家技术创新型企业，技术的先进性和创新型是构建企业核心竞争力的根本。但是要想占领市场并获得持续增长，需要从服务市场的角度出发，为用户输出价值，也是云适配的发展宗旨。</p>
									</div>
                  <div class="article--footer">
  									<a href="#" class="link">Read More</a>
  								</div>
                </div>
              </div>

            </div>

            <!-- pagination-->
            <ul id="paginator" class="am-pagination"></ul>
          </div>

        </div>
      </div>
    </div>

<#include "common/footer.ftl">
<script>
    var total = "${total}";
</script>
<script src="/resource/js/view/page.js" charset="utf-8"></script>
<script src="/resource/js/view/news.js" charset="utf-8"></script>
