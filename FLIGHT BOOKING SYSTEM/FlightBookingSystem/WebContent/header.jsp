<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "javax.servlet.http.*" %>
<%
		HttpSession s=request.getSession(false);  
        String email=(String)s.getAttribute("email");
        %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}

.topnav-right {
  float: right;
}
</style>
</head>
<body>

<h2 align="right"><i class="fa fa-user" style="font-size:30px;color:black"></i>
 Welcome <%= email %></h2>
<div class="topnav">
  <a href="admin.jsp">Flights</a>
   <a href="dates.jsp">Flight Dates</a>
  <a href="user.jsp">USer_Details</a>
  <div class="topnav-right">
    <a href="LogoutAdmin">Logout</a>
  </div>
</div>