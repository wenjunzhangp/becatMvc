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
	<link rel="stylesheet" type="text/css" href="/resource/css/login.css" media="all">
</head>
<body>
<video class="video-player" preload="auto" autoplay="autoplay" loop="loop" data-height="1080" data-width="1920" height="1080" width="1920" style="width: 1920px; height: auto; left: 0px;">
	<source src="/resource/video/login.mp4" type="video/mp4">
	<!-- 此视频文件为支付宝所有，在此仅供样式参考，如用到商业用途，请自行更换为其他视频或图片，否则造成的任何问题使用者本人承担，谢谢 -->
</video>
<div class="video_mask"></div>
<div class="login">
	<div class="beg-login-main">
		<form action="" class="layui-form" id="form_login" method="post">
			<div class="layui-form-item">
				<label class="beg-login-icon">
					<i class="layui-icon">&#xe612;</i>
				</label>
				<input type="text" id="username" name="username" lay-verify="username" autocomplete="off" placeholder="登录名" class="layui-input">
			</div>
			<div class="layui-form-item">
				<label class="beg-login-icon">
					<i class="layui-icon">&#xe642;</i>
				</label>
				<input type="password" id="password"  name="password" lay-verify="password" autocomplete="off" placeholder="密码" class="layui-input">
			</div>

			<div class="layui-form-item">
				<input style="float: left;width: 50%" type="text" id="randomcode" name="randomcode" placeholder="验证码" class="layui-input">
				<img title="看不清？换一张" style="height: 38px;line-height: 38px;width: 50%;" id="randomcode_img" src="/console/getGifCode" onClick="randomImg();" alt="看不清？换一张"/>
			</div>

			<div class="layui-form-item">
				<div class="beg-pull-left beg-login-remember">
					<label style="color: white">记住帐号？</label>
					<input type="checkbox" name="rememberMe"  id="rememberMe" lay-filter="switchTest" lay-skin="switch">
				</div>
				<div class="beg-pull-right">
					<button class="layui-btn layui-btn-primary" lay-submit lay-filter="login">
						<i class="layui-icon">&#xe650;</i> 登录
					</button>
				</div>
				<div class="beg-clear"></div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="/resource/js/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/resource/js/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/manager/login.js"></script>
</body>
</html>