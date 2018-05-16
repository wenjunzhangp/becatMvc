<%@ page import="java.util.Date" %>
<%@ page import="com.baozi.util.DateUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
<form class="layui-form">
	<blockquote class="layui-elem-quote quoteBox">
		<form class="layui-form">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" class="layui-input searchVal" placeholder="昵称/账号" />
				</div>
				<a class="layui-btn search_btn" data-type="reload">搜索</a>
			</div>
		</form>
	</blockquote>
	<table id="userAndRoleList" lay-filter="userAndRoleList"></table>

	<!--分配角色操作-->
	<script type="text/html" id="userListBar">
		<shiro:hasPermission name="console:userRoleDistribution">
			<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="distri">分配角色</a>
		</shiro:hasPermission>
	</script>
</form>
<script type="text/javascript" src="/resource/js/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/manager/roleDistribution.js"></script>
<form class="layui-form layui-row platEventForm">
	<div class="layui-col-xs12">
		<div class="layui-form-item layui-row layui-col-xs12 hideCustom checkboxdiv">

		</div>
	</div>
</form>
</body>
</html>