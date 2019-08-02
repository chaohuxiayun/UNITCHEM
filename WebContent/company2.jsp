<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shanghai Unitchem Co.,ltd</title>

<style type="text/css">
*{ margin:0px; padding: 0px; } 
body {
    font-family: "Microsoft Yahei",Arial, Helvetica, sans-serif;
    width: 100%;
}
body, td, th {
    font-size: 14px;
}
.wrap {width: 1000px; margin: 0 auto;}
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
color:#ffffff; 
width: 110px; 
text-align: center; 
border-bottom: 1px solid #f2f2f2; 
border-right: none; 
} 
#nav ul li:hover ul li a:hover { 
background:#6dc7ec; 
color:#fff; 
} 

#nav {
    background: #FFF url("/images/HituxCMSBold/top_bg1.gif") repeat-x center 25px;
   
    height: 80px;
    font-size: 12px;
    border-bottom: 1px solid #cbcaca;
   
}
li {list-style: none;}
.left{  width: 220px;
    float: left;}
.right {
margin-top:40px;
    width: 780px;
    float: right;
}
</style>

</head>
<body>
<div class="head" style="float:right;margin-top:10px;margin-right:20px;">
<c:if test="${name == null }"><a href="login.jsp">登录</a>|<a href="Http://mail.unitchem.net/">邮箱</a></c:if>
<c:if test="${name != null }"><a href="logout.action">注销</a>|<a href="updatepassword.jsp">修改密码</a>|<a href="Http://mail.unitchem.net/">邮箱</a></c:if>
</div>
<div class="wrap">

<div id="nav"> 
<img alt="logo" src="image/logo.png">

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

<div class="left">
<div class="topic"><img src="image/about.png"></div>
<div class="blank"><ul><li ><A href="companyhistory.jsp"><img src="image/cs1.png"></A></li> <li><A href="companydevelopment.jsp"><img src="image/cs2.png"></A></li> </ul></div>
<div>
    <ul>
        <li><a ><img src="image/cproduct.PNG"></a></li>
        <li><a href="product.action?type=pesticide"><img src="image/1.PNG"></a></li>
        <li><a href="product.action?type=formulations"><img src="image/2.png"></a></li>
        <li><a href="product.action?type=intermediates"><img src="image/3.PNG"></a></li>
        <li><a href="product.action?type=chemicals"><img src="image/4.PNG"></a></li>
        <li><a href="product.action?type=intermediatebase"><img src="image/5.PNG"></a></li>
    </ul>
</div>
</div>

<div class="right">

<div><b>Wuxi Lab</b>
200M2 well-equipped lab, 6 experienced chemists/engineers, 2 innovative bench teams, 1 scale-up teams<br>
Mission: Process development, Cost-effective manufacturing process establishment, Chemical engineering design,  AI & Impurity analysis.<br>
Add: No. 1619 Huishang Road, Huishan District, Wuxi City, Jiangsu Province, P.R.China. <br></div>
<img src="image/wcom1.png"><img src="image/wcom2.png"><img src="image/wcom3.png"><img src="image/wcom4.png"><img src="image/wcom5.png"><img src="image/wcom6.png">

</div>

</div>


</body>
</html>