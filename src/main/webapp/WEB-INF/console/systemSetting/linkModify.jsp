<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>BeCat-我喜欢撸猫喜欢宁静的生活</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="shortcut icon" href="/resource/images/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="/resource/js/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="/resource/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form linkForm">
	<input type="hidden" class="idval" name="id" value="">
	<input type="hidden" class="showval" name="show" value="1">
	<input type="hidden" class="statusval" name="status" value="1">
	<input type="hidden" class="display" name="display" value="">
	<div class="layui-form-item">
		<div class="layui-upload-list linkLogo">
			<img class="layui-upload-img layhobbyhiddenui-circle userFaceBtn userAvatar" style="width: 300px;height: 100px;" src="" id="userFace">
			<button type="button" class="layui-btn layui-btn-primary userFaceBtn"><i class="layui-icon">&#xe67c;</i>上传一张LOGO图</button>
			<input type="hidden" name="logo" id="logo" value="">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">网站名称</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input domainName" name="domainName" lay-verify="required" placeholder="请输入网站名称" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">网站地址</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input domainUrl" name="domainUrl" lay-verify="required|url" placeholder="请输入网站地址" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">站长邮箱</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input contact" name="contact" lay-verify="required" placeholder="请输入站长联系方式（QQ、WECHAT、手机）" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">展示位置</label>
		<div class="layui-input-block">
			<input type="checkbox" class="layui-input show" lay-text="首页|子页" lay-filter="show" lay-skin="switch" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">状态</label>
		<div class="layui-input-block">
			<input type="checkbox" class="layui-input status" lay-text="启用|禁用" lay-filter="status" lay-skin="switch" />
		</div>
	</div>
	<div class="layui-form-item">
		<button class="layui-btn layui-block" lay-filter="modifyLink" lay-submit>提交</button>
	</div>
</form>
<script type="text/javascript" src="/resource/js/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/manager/linkData.js"></script>
</body>
</html>