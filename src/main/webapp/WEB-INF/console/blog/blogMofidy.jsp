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
	<div class="layui-col-md12 layui-col-xs12">
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
			<label class="layui-form-label">作者</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input author" name="author" lay-verify="required" placeholder="请输入文章作者">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">摘要</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入文章摘要" class="layui-textarea abstractremark" lay-verify="required" name="abstractremark"></textarea>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">内容</label>
			<div class="layui-input-block">
				<textarea name="content" id="content" class="content" lay-verify="required"></textarea>
			</div>
		</div>
		<div class="layui-row">
			<div class="magb15 layui-col-md3 layui-col-xs12">
				<label class="layui-form-label">是否原创</label>
				<div class="layui-input-block type">
					<input type="radio" name="type" value="1" title="是" checked>
					<input type="radio" name="type" value="0" title="否" >
				</div>
			</div>
			<div class="magb15 layui-col-md3 layui-col-xs12">
				<label class="layui-form-label">是否置顶</label>
				<div class="layui-input-block stick">
					<input type="radio" name="stick" value="1" title="是" >
					<input type="radio" name="stick" value="0" title="否" checked>
				</div>
			</div>
			<div class="magb15 layui-col-md3 layui-col-xs12">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-block status">
					<input type="radio" name="status" value="1" title="启用" checked>
					<input type="radio" name="status" value="0" title="禁用" >
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="magb15 layui-col-md12 layui-col-xs12">
				<label class="layui-form-label">分类</label>
				<div class="layui-input-block">
					<select name="category" id="category" lay-search lay-filter="searchPage" lay-verify="required|blogCategory">
						<option value="-1">全部</option>
						<option value="0">未知来源</option>
						<option value="1">Java</option>
						<option value="2">技术</option>
						<option value="3">Linux</option>
						<option value="4">c#</option>
						<option value="5">Python</option>
						<option value="6">Php</option>
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
<script type="text/javascript" src="/resource/js/manager/blogModify.js"></script>
</body>
</html>