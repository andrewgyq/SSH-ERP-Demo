<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>雅诺纺织ERP</title>
    <link rel="stylesheet" type="text/css" href="./css/easyui.css">
    <link rel="stylesheet" type="text/css" href="./css/icon.css">
    <link rel="stylesheet" type="text/css" href="./css/demo.css">
    <script type="text/javascript" src="./js/jquery.min.js"></script>
    <script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="./js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
			$(function(){
				$('#tt').tabs({
					onLoad:function(panel){
						var plugin = panel.panel('options').title;
						panel.find('textarea[name="code-'+plugin+'"]').each(function(){
							var data = $(this).val();
							data = data.replace(/(\r\n|\r|\n)/g, '\n');
							if (data.indexOf('\t') == 0){
								data = data.replace(/^\t/, '');
								data = data.replace(/\n\t/g, '\n');
							}
							data = data.replace(/\t/g, '    ');
							var pre = $('<pre name="code" class="prettyprint linenums"></pre>').insertAfter(this);
							pre.text(data);
							$(this).remove();
						});
						prettyPrint();
					}
				});
			});
			function open1(plugin){
				if ($('#tt').tabs('exists',plugin)){
					$('#tt').tabs('select', plugin);
				} 
				else {
					var content = '';
					if(plugin == '人情管理')
						content = '<iframe scrolling="auto" frameborder="0" src="/myssh/pay/payList" style="width:100%; height:100%"></iframe>';
					if(plugin == '客户管理') 
						content = '<iframe scrolling="auto" frameborder="0" src="/myssh/base/customerList" style="width:100%; height:100%"></iframe>'; 
					$('#tt').tabs('add',{
						title:plugin,
						content :content,
						closable:true,
						extractor:function(data){
							data = $.fn.panel.defaults.extractor(data);
							var tmp = $('<div></div>').html(data);
							data = tmp.find('#content').html();
							tmp.remove();
							return data;
						}
					});
				}
			}
		</script>
	</head>
	<body class="easyui-layout" style="text-align:left">
		<div region="west" split="true" title="菜单" style="width:250px;padding:5px;">
          <ul class="easyui-tree">
          <li iconCls="icon-base"><span>基础信息</span>
          <ul><li iconCls="icon-gears"><a class="e-link" href="#" onclick="open1('客户管理')">客户管理</a></li>
          </ul>
          </li>
          <li iconCls="icon-base"><span>销售管理</span>
          <ul><li iconCls="icon-gears"><a class="e-link" href="#" onclick="open1('parser')">parser</a></li>
          </ul>
          </li>
          <li iconCls="icon-base"><span>回款管理</span>
          <ul><li iconCls="icon-gears"><a class="e-link" href="#" onclick="open1('parser')">parser</a></li>
          </ul>
          </li>
          <li iconCls="icon-base"><span>支出管理</span>
          <ul>
          <li iconCls="icon-gears"><a class="e-link" href="#" onclick="open1('人情管理')">人情管理</a></li>
          </ul>
          </li>
		</div>
		<div region="center">
			<div id="tt" class="easyui-tabs" fit="true" border="false" plain="true">
			</div>
		</div>
	</body>
</html>


