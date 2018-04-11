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
<form class="layui-form layui-row indusForm">
	<input type="hidden" class="idval" name="id" value="">
	<div class="layui-col-md3 layui-col-xs12 user_right">
		<div class="layui-upload-list">
			<img class="layui-upload-img layhobbyhiddenui-circle userFaceBtn userAvatar" src="" id="userFace">
			<p id="tryagain"></p>
			<input type="hidden" name="userFaceImg" id="userFaceImg" value="">
		</div>
		<button type="button" class="layui-btn layui-btn-primary userFaceBtn"><i class="layui-icon">&#xe67c;</i>上传一张缩略图</button>
	</div>
	<div class="layui-col-md6 layui-col-xs12">
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">标题</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input title" name="title" lay-verify="required" placeholder="请输入文章标题">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">来源</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input source" name="source" lay-verify="required" placeholder="请输入文章来源">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">内容</label>
			<div class="layui-input-block">
				<textarea name="content" id="content" class="content" ></textarea>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入文章备注" class="layui-textarea remark" name="remark"></textarea>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">描述</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入文章描述" class="layui-textarea description" lay-verify="required" name="description"></textarea>
			</div>
		</div>
		<div class="layui-row">
			<div class="magb15 layui-col-md4 layui-col-xs12">
				<label class="layui-form-label">是否热点</label>
				<div class="layui-input-block hot">
					<input type="radio" name="hot" value="1" title="是" >
					<input type="radio" name="hot" value="0" title="否" checked>
				</div>
			</div>
			<div class="magb15 layui-col-md4 layui-col-xs12">
				<label class="layui-form-label">分类</label>
				<div class="layui-input-block">
					<select name="category" id="category" class="category" lay-filter="category"></select>
				</div>
			</div>
			<div class="magb15 layui-col-md4 layui-col-xs12">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-block">
					<select name="status" class="status" lay-filter="status">
						<option value="1">启用<option>
						<option value="0">禁用</option>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="modifyIndus">发布</button>
				<button type="reset" class="layui-btn layui-btn-primary">取消</button>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript" src="/resource/js/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/manager/indusModify.js"></script>
</body>
</html>