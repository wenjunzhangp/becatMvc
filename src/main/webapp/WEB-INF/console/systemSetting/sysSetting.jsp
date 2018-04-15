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
	<form class="layui-form systemSettingForm">
		<input type="hidden" name="id" value="${sysSetting.id}">
		<table class="layui-table mag0">
			<colgroup>
				<col width="25%">
				<col width="45%">
				<col>
		    </colgroup>
		    <thead>
		    	<tr>
		    		<th>参数说明</th>
		    		<th>参数值</th>
		    		<th pc>变量名</th>
		    	</tr>
		    </thead>
		    <tbody>
		    	<tr>
		    		<td>网站名称</td>
		    		<td><input type="text" class="layui-input cmsName" name="domainName"  lay-verify="required" placeholder="请输入网站名称"></td>
		    		<td pc>${sysSetting.domainName}</td>
		    	</tr>
		    	<tr>
		    		<td>当前版本</td>
		    		<td><input type="text" class="layui-input version" name="currentVersion" lay-verify="required" placeholder="请输入当前网站版本"></td>
		    		<td pc>${sysSetting.currentVersion}</td>
		    	</tr>
		    	<tr>
		    		<td>开发作者</td>
		    		<td><input type="text" class="layui-input author" name="author" lay-verify="required" placeholder="请输入开发作者"></td>
		    		<td pc>${sysSetting.author}</td>
		    	</tr>
		    	<tr>
		    		<td>网站首页</td>
		    		<td><input type="text" class="layui-input homePage" name="domainUrl"  lay-verify="required" placeholder="请输入网站首页"></td>
		    		<td pc>${sysSetting.domainUrl}</td>
		    	</tr>
		    	<tr>
		    		<td>服务器环境</td>
		    		<td><input type="text" class="layui-input server" name="serverConfig" lay-verify="required" placeholder="请输入服务器环境"></td>
		    		<td pc>${sysSetting.serverConfig}</td>
		    	</tr>
		    	<tr>
		    		<td>数据库版本</td>
		    		<td><input type="text" class="layui-input dataBase" name="databaseVersion" lay-verify="required" placeholder="请输入数据库版本"></td>
		    		<td pc>${sysSetting.databaseVersion}</td>
		    	</tr>
		    	<tr>
		    		<td>最大上传限制</td>
		    		<td><input type="text" class="layui-input maxUpload" name="maxFile" lay-verify="required" placeholder="请输入最大上传限制"></td>
		    		<td pc>${sysSetting.maxFile}</td>
		    	</tr>
		    	<tr>
		    		<td>SEO关键字</td>
		    		<td><input type="text" class="layui-input keywords" name="keywords"  lay-verify="required" placeholder="请输入SEO关键字"></td>
		    		<td pc>${sysSetting.keywords}</td>
		    	</tr>
		    	<tr>
		    		<td>版权信息</td>
		    		<td><input type="text" class="layui-input powerby" name="copyright" lay-verify="required" placeholder="请输入网站版权信息"></td>
		    		<td pc>${sysSetting.copyright}</td>
		    	</tr>
				<tr>
					<td>网站备案号</td>
					<td><input type="text" class="layui-input record" name="icpcard"  lay-verify="required" placeholder="请输入网站备案号"></td>
					<td pc>${sysSetting.icpcard}</td>
				</tr>
		    	<tr>
		    		<td>网站描述</td>
		    		<td><textarea placeholder="请输入网站描述" name="description"  class="layui-textarea description" lay-verify="required"></textarea></td>
		    		<td pc>${sysSetting.description}</td>
		    	</tr>
		    </tbody>
		</table>
		<div class="magt10 layui-right">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="systemParameter">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="/resource/js/layui/layui.js"></script>
	<script type="text/javascript" src="/resource/js/manager/sysSetting.js"></script>
</body>
</html>