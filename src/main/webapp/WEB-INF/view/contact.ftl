<#include "common/source.ftl">
<link rel="stylesheet" href="/resource/css/assets/css/contact.min.css" />

<#include "common/head.ftl">

    <!--===========layout-container================-->
    <div class="layout-container">
      <div class="page-header">
        <div class="am-container">
          <h1 class="page-header-title">联系我们</h1>
        </div>
      </div>

      <div class="breadcrumb-box">
        <div class="am-container">
          <ol class="am-breadcrumb">
            <li><a href="/product.shtml">首页</a></li>
            <li class="am-active">联系我们</li>
          </ol>
        </div>
      </div>
    </div>

    <div class="section">
      <div class="container">
        <div class="section--header">
            <div style="width:100%;height:400px" id="address"></div>
        </div>

        <div class="section-container">
          <div class="am-g">
            <!--contact-left start-->
            <div class="am-u-md-5">
              <ul class="contact-left">
                <li class="contact-box-item">
                  <div class="contact_item">
										<i class="contact_item--icon am-icon-phone"></i>
										<h3 class="contact_item--title">欢迎来电</h3>
										<p class="contact_item--text">
											联系电话： <strong>18811359094</strong>,
											<br> 周六 - 周日, 8am - 7pm
										</p>
									</div>
                </li>
                <li class="contact-item">
                  <div class="contact_item">
                      <i class="contact_item--icon am-icon-envelope-o"></i>
                      <h3 class="contact_item--title">您的宝贵意见</h3>
                      <p class="contact_item--text">zhangwenjunp@126.com, <br/>期待您的来信...</p>
                  </div>
                </li>
                <li class="contact-item">
                  <div class="contact_item">
                      <i class="contact_item--icon am-icon-map-marker"></i>
                      <h3 class="contact_item--title">拜访我们</h3>
                      <p class="contact_item--text">
                          北京市朝阳区北苑东路中国铁建广场B座12层
                      </p>
                  </div>
                </li>
              </ul>
            </div>
            <!--contact-left end-->

            <!--contact-right start-->
              <div class="am-u-md-7">
                <div class="contact-form">
                  <h3 class="contact-form_title">您有什么想说的？</h3>
                  <form class="am-form">
                    <div class="am-g">
                      <div class="am-u-md-6">
                        <input type="email" class="" id="doc-ipt-email-1" placeholder="姓名">
                      </div>
                      <div class="am-u-md-6">
                        <input type="email" class="" id="doc-ipt-email-2" placeholder="Email">
                      </div>
                    </div>

                    <div class="am-g">
                      <div class="am-u-md-6">
                        <input type="email" class="" id="doc-ipt-email-3" placeholder="电话">
                      </div>
                      <div class="am-u-md-6">
                        <div class="am-form-group" style="background: #fcfcfc;">
                          <select id="doc-select-1" style="width: 100%;font-size: 16px;line-height: 20px;padding: 15px 20px;border-radius: 3px;color: #262626;border: 2px solid #e9e9e9;">
                            <option value="0">商务合作</option>
                            <option value="1">业务恰谈</option>
                            <option value="2">广告位招商</option>
                          </select>
                          <span class="am-form-caret"></span>
                        </div>
                      </div>
                    </div>

                    <div class=am-g>
                      <div class="am-u-md-12">
                        <div class="am-form-group">
                          <textarea class="" rows="5" id="doc-ta-1" placeholder="写下你想说的..."></textarea>
                        </div>
                      </div>
                    </div>

                    <div class="am-g">
                      <div class="am-u-md-9">
                        <div class="am-form-group am-form-file">
                          <button type="button" class="am-btn am-btn-default am-btn-sm btn-change">
                            <i class="am-icon-cloud-upload"></i> 上传文件</button>
                          <input type="file" multiple>
                        </div>
                      </div>
                      <div class="am-u-md-3">
                        <p><button type="submit" class="am-btn am-btn-default btn-reguest am-fr btn-fl">提交</button></p>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            <!--contact-right end-->
          </div>
        </div>
      </div>
    </div>
  </div>

<#include "common/footer.ftl">

<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.5&ak=0Df96f73881592202c64c32522550ca0"></script>
<script>
    var map = new BMap.Map("address");
    var point = new BMap.Point(116.447438,40.047844);
    map.centerAndZoom(point,19);
    var marker = new BMap.Marker(point);
    map.addOverlay(marker);
    map.enableScrollWheelZoom(true);
</script>
