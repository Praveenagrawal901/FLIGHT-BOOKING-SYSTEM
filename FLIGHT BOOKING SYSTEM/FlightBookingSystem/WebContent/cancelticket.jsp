<%@ page import= "com.flight.repository.*" %>
<%@ page import= "javax.servlet.http.*" %>
<%@ page import= "java.sql.*" %>


<jsp:include page="userheader.jsp"/>


<div class="container">
	<h2>Canceled Ticket</h2><br/>
           
  <table class="table table-striped">
    <thead>
      <tr>
      	<th>Booking Id</th>
        <th>User Name</th>
        <th>Flight Number</th>
        <th>Flight Name</th>
        <th>From</th>
        <th>To</th>
        <th>Date</th>
        <th>Time</th>
        <th>Fare</th>
        
      </tr>
    </thead>
    <tbody>
    
<%HttpSession session1=request.getSession(false);

	int id=(int)session1.getAttribute("id");
%>

<%

ResultSet rs= Book_FlightDao.selectCancel(id);

while(rs.next()){
%>  
    
    <tr> 
        <td><%= rs.getInt(1) %></td>
        <td><%= rs.getString(2) %></td>
        <td><%= rs.getString(3) %></td>
		<td><%= rs.getString(4) %></td>
		<td><%= rs.getString(5)%></td>
		<td><%= rs.getString(6) %></td>
		<td><%= rs.getString(7) %></td>
		<td><%= rs.getString(8) %></td>
		<td><%= rs.getString(9) %></td>
		<td><h3><font color="red">Canceld Ticket</h3></td>
	</tr>
    
<%} %>      