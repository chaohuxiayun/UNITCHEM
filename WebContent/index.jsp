<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UNITCHEM</title>
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
a{ text-transform:none;text-decoration:none;  }
</style>
</head>
<body>
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
<div class="head" style="float:right;margin-top:10px;margin-right:20px;">
<c:if test="${name == null }"><a href="login.jsp">登录</a>|<a href="Http://mail.unitchem.net/">邮箱</a></c:if>
<c:if test="${name != null }"><a href="logout.action">注销</a>|<a href="updatepassword.jsp">修改密码</a>|<a href="Http://mail.unitchem.net/">邮箱</a></c:if>
</div>
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
<div style="width:1000px;margin:0 auto;border-top:1px solid #000">
    <div style="width:850px; margin-top:20px;">
	    <a style="margin-right:65px;" href="product.action?type=pesticide"><img src="image/p1.png" alt="产品" align="center"><span style="margin-top:-20px;">农药原药</span></a>
	    <a style="margin-right:65px;" href="product.action?type=formulations"><img src="image/p2.png" alt="产品" align="center"><span>农药制剂</span></a>
	    <a style="margin-right:65px;" href="product.action?type=intermediates"><img src="image/p3.png" alt="产品" align="center"><span>农药中间体</span></a>
	    <a href="product.action?type=chemicals"><img src="image/p4.png" alt="产品"  align="center"><span>基础化工品</span></a>
    </div>

</div>

<div>

</div>
<div class="center_foot" style="width:100%;height:200px;"></div>
</div>
<div class="foot" align="center" style="width:100%;background-color: #2e2e2e;color:#999;position: absolute;">
    <div style="width:1000px;margin: 10px auto;">
	    <div style="width:500px;">
	      
        </div>
    </div>

</div>
</body>
</html>