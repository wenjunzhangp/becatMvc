<#include "common/source.ftl">
<link rel="stylesheet" href="/resource/css/assets/css/join.min.css" />
<link rel="stylesheet" href="/resource/css/assets/css/news.min.css" />
<link rel="stylesheet" href="/resource/css/assets/css/embed.default.css" />

<#include "common/head.ftl">

    <!--===========layout-container================-->
    <div class="layout-container">
      <div class="page-header">
        <div class="am-container">
            <h1 class="page-header-title">留言墙</h1>
            <p style="font-size: 15px;color: #fff;line-height: 25px;">本功能参照
                <a href="https://www.sojson.com" target="_blank" style="font-size: 15px;color: #fff;">《SoJson工具站》</a>
                实现，再次特别表示感谢!感谢我们的soso站长</p>
            <p style="font-size: 15px;color: #fff;line-height: 25px;">粉丝均可在下方留言，每一个月会抽取幸运粉丝一名，送出飞利浦刮胡刀一个！另外我会不定时回复!</p>
        </div>
      </div>

      <div class="breadcrumb-box">
        <div class="am-container">
          <ol class="am-breadcrumb">
            <li><a href="/product.shtml">首页</a></li>
            <li class="am-active">留言墙</li>
          </ol>
        </div>
      </div>
    </div>

    <div class="section">
      <div class="container">
        <div class="join-container">
          <div class="am-g">
              <div class="am-u-md-9">
                  <div class="row" style="height: 1000px;overflow: auto;">
                  <#--评论输入
                  固定写法：class="ds-thread"  id="ds-thread"
                  data-key= url 这里是用这个URL来做key，你看你自己的业务，因为多说也是这样做，就这样下来了
                  -->
                      <div class="ds-thread"  id="ds-thread" data-key="https://www.doudoucat.com/message"></div>
                  </div>
              </div>
            <#include "common/rightdetail.ftl">
          </div>
        </div>
      </div>
    </div>

<#include "common/footer.ftl">
<script src="/resource/js/view/rightdetail.js" charset="utf-8"></script>
<script src="/resource/js/layer/layer.js" charset="utf-8"></script>
<script src="/resource/js/view/message.js" charset="utf-8"></script>