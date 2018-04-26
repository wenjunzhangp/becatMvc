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
					<input type="text" class="layui-input searchVal" placeholder="请输入标志性事件" />
				</div>
				<div class="layui-input-inline " style="width: 260px;">
					<input id="time" name="time" type="text" placeholder="时间筛选" readonly class="layui-input">
				</div>
				<a class="layui-btn search_btn" data-type="reload">搜索</a>
			</div>
			<shiro:hasPermission name="console:addPlatEvent">
			<div class="layui-inline">
				<a class="layui-btn layui-btn-normal addNews_btn">添加大事记</a>
			</div>
			</shiro:hasPermission>
			<shiro:hasPermission name="console:deletePlatEventSingleOrBatch">
			<div class="layui-inline">
				<a class="layui-btn layui-btn-danger layui-btn-normal delAll_btn">批量删除</a>
			</div>
			</shiro:hasPermission>
		</form>
	</blockquote>
	<table id="userList" lay-filter="userList"></table>

	<!--操作-->
	<script type="text/html" id="userListBar">
		<shiro:hasPermission name="console:updatePlatEvent">
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="console:deletePlatEventSingleOrBatch">
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
		</shiro:hasPermission>
	</script>

	<!--操作-->
	<script type="text/html" id="modifyStatus">
		{{#  if(d.status == "0"){ }}
			<shiro:hasPermission name="console:updatePlatEventStatus">
				<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="usable">启用</a>
			</shiro:hasPermission>
		{{#  } else { }}
			<shiro:hasPermission name="console:updatePlatEventStatus">
				<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="usable">禁用</a>
			</shiro:hasPermission>
		{{#  }}}
	</script>
</form>
<script type="text/javascript" src="/resource/js/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/manager/platEventData.js"></script>
</body>
</html>