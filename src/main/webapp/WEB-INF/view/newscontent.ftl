<#include "common/source.ftl">
<link rel="stylesheet" href="/resource/css/assets/css/news.min.css" />

<#include "common/head.ftl">

  <div class="layout">
    <!--===========layout-container================-->
    <div class="layout-container">
      <div class="page-header">
        <div class="am-container">
          <h1 class="page-header-title">文章详情</h1>
        </div>
      </div>

      <div class="breadcrumb-box">
        <div class="am-container">
          <ol class="am-breadcrumb">
            <li><a href="/product.shtml">首页</a></li>
            <li class="am-active">文章详情</li>
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
              <h2 class="article--title"><a href="#" rel="">${indusObject.title}</a></h2>
              <ul class="article--meta">
                <li class="article--meta_item"><i class="am-icon-calendar"></i>${indusObject.publictime}</li>
                <li class="article--meta_item"><i class="am-icon-user"></i>BeCat</li>
                <li class="article--meta_item"><i class="am-icon-commenting-o"></i>${indusObject.looknumber}</li>
              </ul>
            </header>
            <div class="article--content">
                ${indusObject.content}
            </div>
          </div>

          <div class="comments">
            <div class="comments">
							<h2 class="comments--title">Comments (2)</h2>
							<ul class="comments_list">
								<li class="comment">
									<header class="comment--header">
										<figure class="comment--userpic"><img src="../assets/images/news/av01.jpg" alt=""></figure>
										<strong class="comment--username"><a href="#">Brad Bukovsky</a></strong>
										<time datetime="2001-05-15T19:00" class="comment--date">30th of January, 2016</time>
									</header>
									<div class="comment--content">
										<p>
                      评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论
										</p>
										<a href="#" class="comment--reply">回复</a>
									</div>
									<ul class="comments_list">
										<li class="comment">
											<header class="comment--header">
												<figure class="comment--userpic"><img src="../assets/images/news/av02.jpg" alt=""></figure>
												<strong class="comment--username"><a href="#">Brad Bukovsky</a></strong>
												<time datetime="2001-05-15T19:00" class="comment--date">30th of January, 2016</time>
											</header>
											<div class="comment--content">
												<p>
                          评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评
												</p>
												<a href="#" class="comment--reply">回复</a>
											</div>
										</li>
									</ul>
								</li>
								<li class="comment">
									<header class="comment--header">
										<figure class="comment--userpic"><img src="../assets/images/news/av01.jpg" alt=""></figure>
										<strong class="comment--username"><a href="#">Brad Bukovsky</a></strong>
										<time datetime="2001-05-15T19:00" class="comment--date">30th of January, 2016</time>
									</header>
									<div class="comment--content">
										<p>
                      评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论
										</p>
										<a href="#" class="comment--reply">回复</a>
									</div>
								</li>
							</ul>
							<div class="comment_form">
								<h2 class="comment_form--title">Leave Comment</h2>
                <form class="am-form am-form-horizontal">
                  <div class="am-form-group">
                    <div class="am-g">
                      <div class="am-u-md-4">
                        <input type="text"   placeholder="Full Name">
                      </div>
                      <div class="am-u-md-4">
                        <input type="Email"  placeholder="Email" >
                      </div>
                      <div class="am-u-md-4">
                        <input type="url" placeholder="Website URL">
                      </div>
                    </div>
                    <div class="am-g">
                      <textarea name="comment" cols="30" rows="10" placeholder="Type in here..."></textarea>
                    </div>
                    <div class="comment-form-footer">
                      <button type="button" class="am-btn am-btn-secondary">确认提交</button>
                    </div>
                  </div>
                </form>

							</div>
						</div>
          </div>
        </div>
        <!--news-section left end-->

        <!--news-section right start-->
        <div class="am-u-md-3">
          <div class="blog_sidebar">
            <div class="widget">
              <h2 class="widget--title"><i class="am-icon-file-text-o"></i>最新资讯</h2>
              <ul>
								<li><a href="#">公司报道</a></li>
								<li><a href="#">行业资讯</a></li>
								<li><a href="#">云适配观点</a></li>
							</ul>
            </div>
            <div class="widget">
              <h2 class="widget--title"><i class="am-icon-comments-o"></i>热门动态</h2>
              <ul>
								<li><a href="#">科大讯飞严峻：借力HTML5 推进“智能语音技术”应用普及</a></li>
								<li><a href="#">金山万勇：打破信息孤岛 HTML5优势凸显将成核心</a></li>
								<li><a href="#">阿里吴志华：基于HTML5技术开发Native体验应用</a></li>
							</ul>
            </div>
            <div class="widget">
              <h2 class="widget--title"><i class="am-icon-rss"></i>站内公告</h2>
              <ul>
								<li><a href="#">今天的应用号只是用了HTML技术中无需下载安装、跨平台的功能， 并没有用到HTML开发互联的精髓。 它只是一个...</a><span class="rss-date">November 10, 2015</span></li>
								<li><a href="#">云适配带来了一个全新的“互联网+政务”解决方案，我们可以非常好的利用你现有的IT系统，就是你还是用原来的PC网站一套系统，只要安装一下云适配的产品Xcloud网站跨屏...</a><span class="rss-date">November 10, 2015</span></li>
							</ul>
            </div>
          </div>
        </div>
        <!--news-section right end-->
      </div>
    </div>
  </div>

<#include "common/footer.ftl">