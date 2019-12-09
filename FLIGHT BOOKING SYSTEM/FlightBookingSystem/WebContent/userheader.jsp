<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "javax.servlet.http.*" %>
   
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script type="text/javascript" src="js/validation.js"></script>

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

<% HttpSession session1=request.getSession(false);

	String name=(String)session1.getAttribute("name");
%>

<h2 align="right"><i class="fa fa-user" style="font-size:30px;color:black"></i>
 Welcome <%= name %></h2>
<div class="topnav">
  <a href="customer.jsp">Plan My Journey</a>
  <a href="upcoming.jsp">Upcoming Journey</a>
  <a href="past.jsp">Past Journey</a>
  <a href="cancelticket.jsp">Cancle Ticket</a>
  <div class="topnav-right">
    <a href="LogoutUser">Logout</a>
  </div>
</div>   