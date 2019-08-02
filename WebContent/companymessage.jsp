<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.etc.entity.Company"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系我们</title>
<style type="text/css">
*{ margin:0px; padding: 0px; } 
a{
 text-transform:none;text-decoration:none;  
}
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
#deletebackground1{
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
<div class="add" align="center">
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
<%Company company = (Company)request.getAttribute("company"); %>
<c:if test="${name != null }"><a href="javascript:void(0);" onclick="update()">修改信息</a></c:if>
             <table>
              <tr>
                    <td>公司名：<%=company.getCompanyname()%></td>
                </tr>
                <tr>
                    <td>公司地址：<%=company.getCompanyaddress()==null ? "":company.getCompanyaddress() %></td>
                </tr>
                <tr>
                    <td><a href="">邮箱：<%=company.getCompanymail()==null ? "":company.getCompanymail() %></a></td>
                </tr>
                <tr>
                    <td>电话：<%=company.getCompanytel()==null ? "":company.getCompanytel()%></td>
                </tr>
                <tr>
                    <td>详细：<%=company.getCompanydetail()==null ? "":company.getCompanydetail() %></td>
                </tr>
            </table>
        </table>
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
    <form action="updatecmessage.action" method="post" id="form1">
       <table>
           <tr>
            <th>填写信息</th>
           </tr>
           <tr>
               <td>【公司名】：<input type="text" name="name" value="<%=company.getCompanyname()%>" id="name" ></td>
           </tr>
            <tr>
               <td>【公司地址】：<input type="text" name="add" value="<%=company.getCompanyaddress()==null ? "":company.getCompanyaddress() %>"></td>
           </tr>
            <tr>
               <td>【公司电话】：<input type="text" name="tel" value="<%=company.getCompanytel()==null ? "":company.getCompanytel()%>"></td>
           </tr>
            <tr>
               <td>【公司邮箱】：<input type="text" name="mail" value="<%=company.getCompanymail()==null ? "":company.getCompanymail() %>"></td>
           </tr>
            <tr>
               <td>【描述】：<input type="text" name="detail" value="<%=company.getCompanydetail()==null ? "":company.getCompanydetail() %>"></td>
           </tr>
            <tr>
               <td><input type="button" value="确定" onclick="deleteOk() " style= "margin-left:20px;margin-right:20px;">
                    <input type="button" value="取消" style= "margin-left:20px;" onclick="deleteNot() ">
               </td>
           </tr>
       </table>
    </form>
</div>
</body>
</html>