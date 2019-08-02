<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.util.Map , java.util.HashMap , java.util.Set , java.util.Iterator , java.util.List , java.util.ArrayList , com.etc.entity.Intermediates"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品列表</title>
<style type="text/css">
*{ margin:0px; padding: 0px; } 
body {
    font-family: "Microsoft Yahei",Arial, Helvetica, sans-serif;
    width: 100%;
}
body, td, th {
    font-size: 14px;
}
b{
    font-size: 18px;
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
.right li {
    margin-bottom:15px;
    padding:5px;
}
.left{  width: 220px;
    float: left;}
.right {
margin-top:40px;
    width: 780px;
    float: right;
}#deletebackground1{
display:none;
position: absolute;
z-index: 1000;
opacity: 0.2;
background-color: #000;
width: 100%;
height: 100%;
left: 0px;
top: 0px;
}
#deletebackground2{
color:#000;
display:none;
position: absolute;
z-index: 10000;
background-color: #fff;
width: 600px;
height: 400px;
left: 50%;
top: 50%;
margin-top: -200px;
margin-left: -300px;
}

.add td{
    padding:10px;
}
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
<%
        Intermediates intermediates = (Intermediates)request.getAttribute("intermediates");
        List<Intermediates> list = (List)request.getAttribute("list");
    %>
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
<c:if test="${name != null }">
<div style="float:right;margin-top:10px;color:#000;">
    <a href="javascript:void(0);" onclick="update()">修改信息</a>|<a href="delete.action?type=<%=intermediates.getType()%>&id=<%=intermediates.getId()%>">删除该项</a>
</div>
</c:if>
<div class="right">
	
	<div align="center"><B><%=intermediates.getName()%></B></div>
	<ul>
	    <li>【名称】：<%=intermediates.getName()%></li>
	    <li>【Cas no】：<%=intermediates.getCasno()==null ? "暂无信息":intermediates.getCasno()%></li>
	    <li>【中文名称】：<%=intermediates.getChinaName()==null ? "暂无信息":intermediates.getChinaName()%></li>
	    <li>【市场】：<%=intermediates.getMarket()==null ? "暂无信息":intermediates.getMarket()%></li>
	    <li>【缩写】：<%=intermediates.getAbbreciation()==null ? "暂无信息":intermediates.getAbbreciation()%></li>
	    <li>【有效成分】：<%=intermediates.getActiveIngredient()==null ? "暂无信息":intermediates.getActiveIngredient()%></li>
	</ul>
	<div>
		<ul>
		    <li>上一篇：<a href="productdetail.action?id=<%=list.get(0).getLine()==0 ? intermediates.getId():list.get(0).getId()%>&type=<%=intermediates.getType()%>">
		    <%=list.get(0).getName()==null ? "无上一篇":list.get(0).getName()%></a></li>
		    <li>下一篇：<a href="productdetail.action?id=<%=list.get(1).getLine()==0 ? intermediates.getId():list.get(1).getId()%>&type=<%=intermediates.getType()%>">
		    <%=list.get(1).getName()==null ? "无下一篇":list.get(1).getName()%></a></li>
		</ul>
	</div>
	<div align="center"><a href="product.action?currentPage=1&type=<%=intermediates.getType()%>"><input type="button" value="返回" /></a></div>
</div>

</div>

<script type="text/javascript">
 function update(){
     var a = document.getElementById("deletebackground1");
     var b = document.getElementById("deletebackground2");
     a.style.display = "block";
     b.style.display = "block";

 }
 function deleteOk(){
     var form1 = document.getElementById("form1");
     var name = document.getElementById("name").value;
     
     if(name == null || name == ""){
         alert("名称不能为空");
     }else {
        
             form1.submit();
        
         
     }
 }
function deleteNot(){
     var a = document.getElementById("deletebackground1");
     var b = document.getElementById("deletebackground2");
     a.style.display = "none";
     b.style.display = "none";
 }
</script>
<div id="deletebackground1"></div>
<div class="add" id="deletebackground2" align="center">
    <form action="updateproduct.action?type=<%=intermediates.getType()%>&id=<%=intermediates.getId()%>" method="post" id="form1">
       <table>
           <tr>
            <th>填写信息</th>
           </tr>
           <tr>
               <td>【名称】：<input type="text" name="name" id="name" value="<%=intermediates.getName()%>"></td>
           </tr>
            <tr>
               <td>【Cas no】：<input type="text" name="casno" id="casno" value="<%=intermediates.getCasno()==null ? "":intermediates.getCasno()%>"></td>
           </tr>
            <tr>
               <td>【中文名称】：<input type="text" name="chinaname" value="<%=intermediates.getChinaName()==null ? "":intermediates.getChinaName()%>"> </td>
           </tr>
            <tr>
               <td>【市场】：<input type="text" name="market" value="<%=intermediates.getMarket()==null ? "":intermediates.getMarket()%>"></td>
           </tr>
            <tr>
               <td>【缩写】：<input type="text" name="abbreciation" value="<%=intermediates.getAbbreciation()==null ? "":intermediates.getAbbreciation()%>"></td>
           </tr>
            <tr>
               <td>【有效成分】：<input type="text" name="activeIngredient" value="<%=intermediates.getActiveIngredient()==null ? "":intermediates.getActiveIngredient()%>"></td>
           </tr>
            <tr>
               <td><input type="button" value="确定" onclick="deleteOk() " style= "margin-right:20px;">
                    <input type="button" value="取消" style= "margin-left:20px;" onclick="deleteNot() ">
               </td>
           </tr>
       </table>
    </form>
    </div>

</body>
</html>