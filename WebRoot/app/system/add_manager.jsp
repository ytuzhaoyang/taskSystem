<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">

</style>

</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[系统管理]-[添加管理员]</td>
              </tr>
            </table></td>
            <td width="54%">
            </td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
    <form action="manager?method=add" method="post">
    <table width="80%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="14%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">用户名</span></div></td>
             <td height="22" background="images/bg.gif"><div align="center">
             	<input type="text" name="managerName" width="100">
             </td>
          </tr>
          <tr>
            <td width="14%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">密码</span></div></td>
             <td height="22" background="images/bg.gif"><div align="center">
             	<input type="password" name="managerPwd" width="100">
             </td>
          </tr>
          <tr>
            <td width="14%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">确认密码</span></div></td>
             <td height="22" background="images/bg.gif"><div align="center">
             	<input type="password" name="password2" width="100">
             </td>
          </tr>
          <tr>
            <td width="14%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">电话号码</span></div></td>
             <td height="22" background="images/bg.gif"><div align="center">
             	<input type="text" name="managerPhone" width="100">
             </td>
          </tr>
          <tr>
            <td colspan="2" height="22" background="images/bg.gif" bgcolor="#FFFFFF" align="center">
            	<input type="submit" value="提交"/><input type="reset" value="取消"/>
            </td>
          </tr>
        </table>
        </form>
        </td>
      </tr>
    </table></td>
  </tr>

    </table></td>
  </tr>
</table>
</body>
</html>