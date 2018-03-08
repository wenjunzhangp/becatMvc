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
<form class="layui-form layui-row" id="userForm">
	<input type="hidden" id="<shiro:principal property="userid"/>" name="id" value="<shiro:principal property="userid"/>">
	<input type="hidden" id="genderhidden" value="${userInfo.gender}">
	<input type="hidden" id="hobbyhidden" value="${userInfo.hobby}">
	<input type="hidden" id="hobby" name="hobby">
	<div class="layui-col-md3 layui-col-xs12 user_right">
		<div class="layui-upload-list">
			<img class="layui-upload-img layhobbyhiddenui-circle userFaceBtn userAvatar" id="userFace">
		</div>
		<button type="button" class="layui-btn layui-btn-primary userFaceBtn"><i class="layui-icon">&#xe67c;</i> 掐指一算，我要换一个头像了</button>
	</div>
	<div class="layui-col-md6 layui-col-xs12">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input id="usercode" name="usercode" type="text" value="<shiro:principal property="username"/>" disabled class="layui-input layui-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">我的角色</label>
			<div class="layui-input-block">
				<input type="text" value="<shiro:hasRole name='超级管理员'>超级管理员</shiro:hasRole><shiro:hasRole name='系统维护员'>系统维护员</shiro:hasRole>" disabled class="layui-input layui-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">真实姓名</label>
			<div class="layui-input-block">
				<input id="realname" name="realname" type="text" value="${userInfo.realname}" placeholder="请输入真实姓名" lay-verify="required" class="layui-input realName">
			</div>
		</div>
		<div class="layui-form-item" pane="">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block userSex">
				<input type="radio" name="gender" value="1" title="男">
				<input type="radio" name="gender" value="0" title="女">
				<input type="radio" name="gender" value="2" title="保密">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号码</label>
			<div class="layui-input-block">
				<input id="phone" name="phone" value="${userInfo.phone}" type="tel" placeholder="请输入手机号码" lay-verify="phone" class="layui-input userPhone">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">出生年月</label>
			<div class="layui-input-block">
				<input id="birthday" name="birthday" value="${userInfo.birthday}" type="text" placeholder="请输入出生年月" lay-verify="userBirthday" readonly class="layui-input userBirthday">
			</div>
		</div>
		<div class="layui-form-item userAddress">
			<label class="layui-form-label">家庭住址</label>
			<div class="layui-input-inline">
				<select name="province" lay-filter="province" class="province">
					<option value="">请选择市</option>
				</select>
			</div>
			<div class="layui-input-inline">
				<select name="city" lay-filter="city" disabled>
					<option value="">请选择市</option>
				</select>
			</div>
			<div class="layui-input-inline">
				<select name="area" lay-filter="area" disabled>
					<option value="">请选择县/区</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">兴趣爱好</label>
			<div class="layui-input-block userHobby">
				<input type="checkbox" data-like="like[看电影]" title="看电影">
				<input type="checkbox" data-like="like[玩游戏]" title="玩游戏">
				<input type="checkbox" data-like="like[撸猫]" title="撸猫">
				<input type="checkbox" data-like="like[撸代码]" title="撸代码">
				<input type="checkbox" data-like="like[听歌]" title="听歌">
				<input type="checkbox" data-like="like[吃好吃的]" title="吃好吃的">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-block">
				<input id="email" name="email" value="${userInfo.email}" type="text" placeholder="请输入邮箱" lay-verify="email" class="layui-input userEmail">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">自我评价</label>
			<div class="layui-input-block">
				<textarea id="myself" name="myself" placeholder="请输入内容" class="layui-textarea myself">${userInfo.myself}</textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="changeUser">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript" src="/resource/js/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/manager/userInfo.js"></script>
</body>
</html>