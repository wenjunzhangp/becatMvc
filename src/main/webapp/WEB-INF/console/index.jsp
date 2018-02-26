<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>BECAT-我喜欢撸猫喜欢宁静的生活</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">
	<link rel="shortcut icon" href="/resource/images/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="/resource/js/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="/resource/css/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="/resource/css/adminstyle.css" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin" id="layui_layout">
	<!-- 顶部区域 -->
	<div class="layui-header header header-demo">
		<div class="layui-main">
		    <!-- logo区域 -->
			<div class="admin-logo-box">
				<a class="logo" href="/console/index" title="logo">BECAT</a>
				<div class="larry-side-menu">
					<i class="fa fa-bars" aria-hidden="true"></i>
				</div>
			</div>
            <!-- 顶级菜单区域 -->
            <div class="layui-larry-menu">
                 <ul class="layui-nav clearfix">
                       <li class="layui-nav-item layui-this">
                 	   	   <a href="https://github.com/wenjunzhangp/" target="_blank"><i class="iconfont icon-wangzhanguanli"></i>GitHub</a>
                 	   </li>
                 	   <li class="layui-nav-item">
                 	   	   <a href="http://www.iconfont.cn/" target="_blank"><i class="iconfont icon-ht_expand"></i>阿里矢量图标</a>
                 	   </li>
                 	   <li class="layui-nav-item">
                 	   	   <a href="http://www.sojson.com/" target="_blank"><i class="iconfont icon-weixin3"></i>SOJSON工具站</a>
                 	   </li>
                 	   <li class="layui-nav-item">
                 	   	   <a href="http://www.sojson.com/blog/" target="_blank"><i class="iconfont icon-caidan"></i>SOJSON博客</a>
                 	   </li>
                 </ul>
            </div>
            <!-- 右侧导航 -->
            <ul class="layui-nav larry-header-item">
        		<li class="layui-nav-item">
        			欢迎您：${activeUser.username}
        		</li>
				<li class="layui-nav-item">
					<a href="javascript:void(0);" id="lock"><i class="iconfont icon-diannao1"></i>锁屏</a>
				</li>
				<li class="layui-nav-item">
					<a href="/logout"><i class="iconfont icon-exit"></i>退出</a>
				</li>
            </ul>
		</div>
	</div>
	<!-- 左侧侧边导航开始 -->
	<div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
        <div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">
		
		<!-- 左侧菜单 -->
		<ul class="layui-nav layui-nav-tree">
			<li class="layui-nav-item layui-this">
				<a href="javascript:;" data-url="main.html">
				    <i class="iconfont icon-home1" data-icon='icon-home1'></i>
					<span>首页</span>
				</a>
			</li>
			<!-- 个人信息 -->
			<li class="layui-nav-item">
				<a href="javascript:;">
					<i class="iconfont icon-jiaoseguanli" ></i>
					<span>我的面板</span>
					<em class="layui-nav-more"></em>
				</a>
				<dl class="layui-nav-child">
                    <dd>
                        <a href="javascript:;" data-url="personInfo.html">
                            <i class="iconfont icon-geren1" data-icon='icon-geren1'></i>
                            <span>个人信息</span>
                        </a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-url="changepwd.html">
                            <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
                            <span>修改密码</span>
                        </a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-url="myloginfo.html">
                            <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                            <span>日志信息</span>
                        </a>
                    </dd>
                </dl>
			</li>
			<!-- 用户管理 -->
			<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-jiaoseguanli2" ></i>
					   <span>表格表单</span>
					   <em class="layui-nav-more"></em>
					</a>
					    <dl class="layui-nav-child">
					    	<dd>
					    		<a href="javascript:;" data-url="table.html">
					    		   <i class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i>
					    		   <span>有线条表格</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;"  data-url="table_1.html">
					    		   <i class="iconfont icon-jiaoseguanli4" data-icon='icon-jiaoseguanli4'></i>
					    		   <span>增加内容框</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;" data-url="myloginfo.html">
					    		   <i class="iconfont icon-quanxian2" data-icon='icon-quanxian2'></i>
					    		   <span>无线条表格</span>
					    		</a>
					    	</dd>
					    </dl>
			    </li>
			<!-- 内容管理 -->
			<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-wenzhang1" ></i>
					   <span>内容管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					   <dl class="layui-nav-child">
					   	   <dd>
					    		<a href="javascript:;" data-url="404.html">
					    		   <i class="iconfont icon-lanmuguanli" data-icon='icon-lanmuguanli'></i>
					    		   <span>404页面</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-wenzhang2" data-icon='icon-wenzhang2'></i>
					    		   <span>所有档案列表</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-icon1" data-icon='icon-icon1'></i>
					    		   <span>待审核的档案</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-word" data-icon='icon-word'></i>
					    		   <span>我发布的文档</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-pinglun1" data-icon='icon-pinglun1'></i>
					    		   <span>评论管理</span>
					    		</a>
					    	</dd>
					    	
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-tags1" data-icon='icon-tags1'></i>
					    		   <span>TAGS管理</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-huishouzhan1" data-icon='icon-huishouzhan1'></i>
					    		   <span>内容回收站</span>
					    		</a>
					    	</dd>
					   </dl>
			   </li>
			
                 <!-- 会员管理 -->
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-m-members" ></i>
					   <span>单页面</span>
					   <em class="layui-nav-more"></em>
					</a>
					<dl class="layui-nav-child">
                           <dd>
                           	   <a href="javascript:;" data-url="404.html">
					              <i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
					              <span>404提示页面</span>
					           </a>
                           </dd>
                           <dd>
                           	   <a href="javascript:;" data-url="tab.html">
					              <i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
					              <span>选项卡页面</span>
					           </a>
                           </dd>
                    </dl>
				</li>
				
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-shengchengbaogao" ></i>
					   <span>网站维护</span>
					   <em class="layui-nav-more"></em>
					</a>
					   <dl class="layui-nav-child">
                           <dd>
                           	   <a href="javascript:;">
					              <i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
					              <span>网站主题</span>
					           </a>
                           </dd>
                           <dd>
					    		<a href="">
					    		   <i class="iconfont icon-database" data-icon='icon-database'></i>
					    		   <span>数据库管理</span>
					    		</a>
					    	</dd>
					   	    <dd>
					    		<a href="">
					    		   <i class="iconfont icon-shengchengbaogao" data-icon='icon-shengchengbaogao'></i>
					    		   <span>生成页面</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="">
					    		   <i class="iconfont icon-qingchuhuancun" data-icon='icon-qingchuhuancun'></i>
					    		   <span>更新缓存</span>
					    		</a>
					    	</dd>
					    	
					   </dl>
				</li>
				
			<!-- 系统设置 -->
			<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-xitong" ></i>
					   <span>系统设置</span>
					   <em class="layui-nav-more"></em>
					</a>
					    <dl class="layui-nav-child">
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-zhandianpeizhi" data-icon='icon-zhandianpeizhi'></i>
					    		   <span>基本参数设置</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-zhandianguanli1" data-icon='icon-zhandianguanli1'></i>
					    		   <span>多站点管理</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-anquanshezhi" data-icon='icon-anquanshezhi'></i>
					    		   <span>安全设置</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-sms" data-icon='icon-sms'></i>
					    		   <span>短信接口设置</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    		   <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
					    		   <span>系统日志管理</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    			<i class='iconfont icon-SQLServershujuku' data-icon='icon-SQLServershujuku'></i>
					    			<span>SQL命令行工具</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;">
					    			<i class='iconfont icon-xinxicaiji' data-icon='icon-xinxicaiji'></i>
					    			<span>防采集管理</span>
					    		</a>
					    	</dd>
					    </dl>
				</li>
				<!-- 友链设置 -->
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-youqinglianjie"  data-icon='icon-youqinglianjie'></i>
					   <span>友情链接</span>
					</a>
				</li>
		</ul>
	    </div>
	</div>

	<!-- 左侧侧边导航结束 -->
	<!-- 右侧主体内容 -->
	<div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee;">
		<div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
			<div class="go-left key-press pressKey" id="titleLeft" title="滚动至最右侧"><i class="larry-icon larry-weibiaoti6-copy"></i> </div>
			<ul class="layui-tab-title">
				<li class="layui-this" id="admin-home"><i class="iconfont icon-diannao1"></i><em>后台首页</em></li>
			</ul>
			<div class="go-right key-press pressKey" id="titleRight" title="滚动至最左侧"><i class="larry-icon larry-right"></i></div>
			<%--<ul class="layui-nav closeBox">
				<li class="layui-nav-item">
					<a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作<span class="layui-nav-more"></span></a>
					<dl class="layui-nav-child layui-anim layui-anim-upbit">
						<dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">ဂ</i> 刷新当前</a></dd>
						<dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i> 关闭其他</a></dd>
						<dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i> 关闭全部</a></dd>
					</dl>
				</li>
				<span class="layui-nav-bar" style="left: 0px; top: 33px; width: 0px; opacity: 0;"></span>
			</ul>--%>
			<div class="layui-tab-content" style="min-height: 150px; ">
				<div class="layui-tab-item layui-show">
					<iframe class="larry-iframe" data-id='0' src="/console/main"></iframe>
				</div>
			</div>
		</div>
	</div>
	<!-- 底部区域 -->
	<div class="layui-footer layui-larry-foot" id="larry-footer">
		<div class="layui-mian">  
		    <p class="p-admin">
		    	<span>2018 &copy; Copyright</span>
		    	 becatShop版权所有
		    </p>
		</div>
	</div>
</div>
<!-- 锁屏 -->
<div class="lock-screen" style="display: none;">
	<div id="locker" class="lock-wrapper">
		<div id="time"></div>
		<div class="lock-box center">
			<img src="/resource/images/userimg.jpg" alt="logo">
			<h1>BECAT</h1>
			<div class="input_btn">
				<input type="password" class="admin-header-lock-input layui-input" autocomplete="off" placeholder="锁屏状态，请输入密码解锁" autofocus name="lockPwd" id="lockPwd">
				<button class="layui-btn" id="unlock">解锁</button>
			</div>
		</div>
	</div>
</div>
<!-- 加载js文件-->
<script type="text/javascript" src="/resource/js/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/manager/larry.js"></script>
<script type="text/javascript" src="/resource/js/manager/index.js"></script>
</body>
</html>