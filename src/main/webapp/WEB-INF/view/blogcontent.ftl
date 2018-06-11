<#include "common/source.ftl">
<link rel="stylesheet" href="/resource/css/assets/css/news.min.css" />

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

          <#--<div class="comments">
            <div class="comments">
							<h2 class="comments--title">Comments (2)</h2>
							<ul class="comments_list">
								<li class="comment">
									<header class="comment--header">
										<figure class="comment--userpic"><img src="../assets/images/news/av01.jpg" alt=""></figure>
										<strong class="comment--username"><a href="href="javascript:void(0)">Brad Bukovsky</a></strong>
										<time datetime="2001-05-15T19:00" class="comment--date">30th of January, 2016</time>
									</header>
									<div class="comment--content">
										<p>
                      评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论
										</p>
										<a href="href="javascript:void(0)" class="comment--reply">回复</a>
									</div>
									<ul class="comments_list">
										<li class="comment">
											<header class="comment--header">
												<figure class="comment--userpic"><img src="../assets/images/news/av02.jpg" alt=""></figure>
												<strong class="comment--username"><a href="href="javascript:void(0)">Brad Bukovsky</a></strong>
												<time datetime="2001-05-15T19:00" class="comment--date">30th of January, 2016</time>
											</header>
											<div class="comment--content">
												<p>
                          评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评
												</p>
												<a href="href="javascript:void(0)" class="comment--reply">回复</a>
											</div>
										</li>
									</ul>
								</li>
								<li class="comment">
									<header class="comment--header">
										<figure class="comment--userpic"><img src="../assets/images/news/av01.jpg" alt=""></figure>
										<strong class="comment--username"><a href="href="javascript:void(0)">Brad Bukovsky</a></strong>
										<time datetime="2001-05-15T19:00" class="comment--date">30th of January, 2016</time>
									</header>
									<div class="comment--content">
										<p>
                      评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论
										</p>
										<a href="href="javascript:void(0)" class="comment--reply">回复</a>
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
          </div>-->
        </div>
        <!--news-section left end-->

      <#include "common/rightdetail.ftl">
      </div>
    </div>
  </div>

<#include "common/footer.ftl">
<script src="/resource/js/view/rightdetail.js" charset="utf-8"></script>