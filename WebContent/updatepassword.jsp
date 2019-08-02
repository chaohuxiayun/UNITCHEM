<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
*{ margin:0px; padding: 0px; } 
body {
    font-family: "Microsoft Yahei",Arial, Helvetica, sans-serif;
    width: 100%;
}
#nav { 
font-family: arial, sans-serif; 
position: relative; 
width: 1000px; 
height:56px; 
font-size:14px; 
color:#999; 
margin: 0 auto; 
} 
#nav ul { 
list-style-type: none; 
float: right;
margin-right:100px;
} 
#nav ul li { 
float: left; 
position: relative; 
} 
#nav ul li a { 
text-align: center; 
border-right:1px solid #e9e9e9; 
padding:20px; 
display:block; 
text-decoration:none; 
color:#999; 
} 
#nav ul li ul { 
display: none 
} 
#nav ul li:hover ul { 
display: block; 
position: absolute; 
} 
#nav ul li:hover ul li a { 
display:block; 
background:#12aeef; 
color:#f2f2f2; 
width: 110px; 
text-align: center; 
border-bottom: 1px solid #f2f2f2; 
border-right: none; 
} 
#nav ul li:hover ul li a:hover { 
background:#6dc7ec; 
color:#abc; 
} 

#nav {
    background: #FFF url("/images/HituxCMSBold/top_bg1.gif") repeat-x center 25px;
   
    height: 80px;
    font-size: 12px;
    border-bottom: 1px solid #cbcaca;
    list-style: 
}
li:hover{ color: #f2f2f2;}
.add td{
    padding:10px;
}

</style>
</head>

<body>
<div class="wrap">

<div id="nav"> 
<img alt="欢迎" src="image/logo.png">

<ul> 
<li class="first"><a href="index.jsp">网站首页</a></li> 
<li><a href="#">关于公司</a>
<ul> 
<li><a href="companyhistory.jsp">公司历史</a></li> 
<li><a href="companydevelopment.jsp">公司概况</a></li> 
</ul> 
</li> 
<li><a href="#">产品中心</a> 
<ul> 
<li><a href="product.action?type=pesticide">农药原药</a></li>
<li><a href="product.action?type=formulations">农药制剂</a></li>
<li><a href="product.action?type=intermediates">农药中间体</a></li>
<li><a href="product.action?type=chemicals">基础化工品</a></li> 
<li><a href="product.action?type=intermediatebase">基础中间体</a></li> 
</ul> 
</li> 
<li><a href="organization.jsp">运营组织</a></li> 
<li><a href="aboutReactions.jsp">相关专业</a></li> 

<li><a href="companymessage.action">联系我们</a></li> 
</ul> 
</div> 
<div align="center">
<img alt="欢迎" src="image/company.png">
</div>
<%
    String message = (String)request.getAttribute("message");
    if(message != null && !message.equals("")) {
        %>
            <script type="text/javascript">
            alert("<%=message%>");
            </script>
        <%
    }
%>
<div class="add" align="center">
<form action="updatepassword.action" method="POST">
        <table>
            <tr>
                <td>登录名：<input type="text"  name="name"  id="name"/></td>
            </tr>
            <tr>
                <td>原密码：<input type="password"  name="password1" /></td>
            </tr>
            <tr>
                <td>新密码：<input type="password"  name="password2" /></td>
            </tr>
            <tr>
                <td>新密码确定：<input type="password"  name="password3" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="确定"  style= "margin-right:20px;">
                    <input type="reset" value="取消" style= "margin-left:20px; ">
               </td>
            </tr>
            
        </table>
</form>
</div>
</body>
</html>