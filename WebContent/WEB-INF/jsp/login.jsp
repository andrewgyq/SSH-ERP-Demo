<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>雅诺纺织ERP</title>
  <link rel="stylesheet" href="./css/login.css">
  <script type="text/javascript">
   function doLogin(){
	   var loginName = document.getElementById("loginName").value;
	   var password = document.getElementById("password").value;
	   if(loginName&&password){
		   document.getElementById("myform").submit();
	   }else{
		   alert("请输入登录名和密码!");
	   }
   }
  </script>
</head>
<body>
  <form method="post" id="myform" action="/myssh/loginConfim">
    <div id="LoginCircle">
      <div id="LoginDoc">
        <div id="SysName">
          <table border="0" width="220">
            <tr>南通雅诺纺织</tr>
          </table>
        </div>
        <div id="SysInput">
          <table border="0" width="220" align="left">
            <tr>
              <td width="100" class="disName">登陆名:</td>
              <td width="120">
                <input type="text" class="InputStyle" id="loginName" name="id" maxlength=18 />
              </td>
            </tr>
            <tr><td colspan="2" height="5">&nbsp;</td></tr>
            <tr>
              <td class="disName">密&nbsp;&nbsp;码:</td>
              <td>
                <input type="password" class="InputStyle" id="password" name="password" />
              </td>
            </tr>
            <tr><td colspan="2" height="5">&nbsp;</td></tr>
            <tr>
              <td colspan="2" align="center">
                <input type="button" id="login" value="登录" class="button_height20" onClick="doLogin()"/> 
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" id="reset" value="清除" class="button_height20" />
              </td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  </form>
</body>
</html>
