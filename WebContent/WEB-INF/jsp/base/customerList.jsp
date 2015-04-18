<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="UTF-8">
 <title>人情管理系统</title>
 <link rel="stylesheet" type="text/css" href="../css/easyui.css">
 <link rel="stylesheet" type="text/css" href="../css/icon.css">
 <link rel="stylesheet" type="text/css" href="../css/demo.css">
 <script type="text/javascript" src="../js/jquery.min.js"></script>
 <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
 <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
 <style type="text/css">
	#fm{
	margin:0;
	padding:10px 30px;
	}
	.ftitle{
	font-size:14px;
	font-weight:bold;
	padding:5px 0;
	margin-bottom:10px;
	border-bottom:1px solid #ccc;
	}
	.fitem{
	margin-bottom:5px;
	}
	.fitem label{
	display:inline-block;
	width:80px;
	}
</style>
 <script type="text/javascript">
    var url;
	var toolbar = [{
		text:'录入',
		iconCls:'icon-add',
		handler:function(){
			 $('#dlg').dialog('open').dialog('setTitle','录入客户'); 
			 $('#fm').form('clear');
			 url = '/myssh/base/saveCustomer';
			
		}
	},
	{
		text:'编辑',
		iconCls:'icon-edit',
		handler:function(){
			 var row = $('#customerList').datagrid('getSelected');
			 if (row){
			 $('#dlg').dialog('open').dialog('setTitle','编辑客户');  
			 $('#fm').form('load',row);
			 url = '/myssh/base/saveCustomer?id='+row.id;
			 }
			
		}
	},
	{
		text:'删除', 
		iconCls:'icon-remove',
		handler:function(){
			 var row = $('#customerList').datagrid('getSelected');
			 if (row){
			    $.messager.confirm('Confirm','你确定删除该客户?',function(r){ 
			      if (r){
			          $.post('/myssh/base/deleteCustomer',{id:row.id},function(result){
			            if (result.info=="success"){
			              $('#customerList').datagrid('reload'); // reload the user data
			            } else {
			              $.messager.show({ // show error message
			              title: '错误',
			              msg: '删除错误!'
			              });
			            } 
			          },'json');
			      }
			  });
			} 
			
		}
		}];
	// 保存人情 
    function save(){
		 $('#fm').form('submit',{
		    url: url,
		    onSubmit: function(){
		        return $(this).form('validate');
		    },
		    success: function(result){
		        var result = eval('('+result+')');
		        if (result.info!="success"){
		           $.messager.show({
		               title: '错误',
		               msg:'保存失败!'
		          });
		        }else {
				   $('#dlg').dialog('close'); // close the dialog
				   $('#customerList').datagrid('reload'); // reload the user data
				}
			}
		});
    }
</script>
</head>
<body >
	<table id="customerList" class="easyui-datagrid" title="客户列表" 
	 data-options="singleSelect:true,rownumbers:true,
	               url:'/myssh/base/getCustomerList',method:'get',
	               pagination:true, toolbar:toolbar,pageSize:50,
	               showFooter:true, fit:true">
	<thead>
	<tr>
	<th data-options="field:'CUSTOMERID',hidden:true"></th>
	<th data-options="field:'CUSTOMERNAME',width:80">客户名称</th>
	<th data-options="field:'REMARK',width:100,align:'right'">客户类型</th>
	<th data-options="field:'CREATEDATE',width:80,align:'right'">创建时间</th>
	<th data-options="field:'CUSTOMERTYPE',width:80,align:'right'">备注</th>
	</tr>
	</thead>
	</table>
	
	
   <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
	<div class="ftitle">人情信息</div>
	<form id="fm" method="post" novalidate>
	 <div class="fitem">
	 <label>姓名:</label>
	   <input name="name" class="easyui-validatebox" required="true">
	 </div>
	 <div class="fitem">
	   <label>金额:</label>
	   <input name="price" class="easyui-validatebox" required="true">
	 </div>
	 <div class="fitem">
	  <label>时间:</label>
	   <input type="text" class="easyui-datebox" id="date" name="date" />
	 </div>
	 <div class="fitem">
	   <label>原因:</label>
	   <input type="text" class="InputStyle" id="reason" name="reason" />
	 </div>
    </form>
  </div>
  <div id="dlg-buttons">
   <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">保存</a>
   <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
  </div>
</body>
</html>