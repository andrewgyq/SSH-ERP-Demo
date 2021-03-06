<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>人情录入</title>
  <link rel="stylesheet" type="text/css" href="../css/easyui.css">
  <link rel="stylesheet" type="text/css" href="../css/icon.css">
  <link rel="stylesheet" type="text/css" href="../css/demo.css">
  <script type="text/javascript" src="../js/jquery.min.js"></script>
  <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript">$(document).ready(function(){  
   $("#date").datebox({  
        required:true,  
        onSelect: function(date){  
            $("#date").val(date);  
        }  
    });  
   });  
   
   function save(){
	   var name = document.getElementById("name").value;
	   var price = document.getElementById("price").value;
	   if(name&&price){
		   document.getElementById("myform").submit();
	   }else{
		   alert("请输入姓名和金额!");
	   }
   }
  </script>
</head>
<body>
  <form method="post" id="myform" action="/myssh/pay/savePay">
        <div id="SysInput">
          <table border="0" width="220" align="left">
            <tr>
              <td width="100" class="disName">姓&nbsp;&nbsp;名:</td>
              <td width="120">
                <input type="text" class="InputStyle" id="name" name="name" maxlength=18 />
              </td>
            </tr>
            <tr><td colspan="2" height="5">&nbsp;</td></tr>
            <tr>
              <td class="disName">金&nbsp;&nbsp;额:</td>
              <td>
                <input type="text" class="InputStyle" id="price" name="price" />
              </td>
            </tr>
             <tr><td colspan="2" height="5">&nbsp;</td></tr>
             <tr>
              <td class="disName">时&nbsp;&nbsp;间:</td>
              <td>
                <input type="text" class="easyui-datebox" id="date" name="date" />
              </td>
            </tr>
             <tr><td colspan="2" height="5">&nbsp;</td></tr>
             <tr>
              <td class="disName">原&nbsp;&nbsp;因:</td>
              <td>
                <input type="text" class="InputStyle" id="reason" name="reason" />
              </td>
            </tr>
            <tr><td colspan="2" height="5">&nbsp;</td></tr>
            <tr>
              <td colspan="2" align="center">
                <input type="button" id="login" value="保存" class="button_height20" onClick="save()"/> 
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" id="reset" value="清除" class="button_height20" />
              </td>
            </tr>
          </table>
        </div>
  </form>
</body>
</html>
