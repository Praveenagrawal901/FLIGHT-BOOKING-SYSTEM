<%@ page import= "java.sql.*" %>
<%@ page import= "com.flight.repository.FlightDao" %>

<jsp:include page="header.jsp"/>


<div class="container">
<h2> Dates_Details </h2>
<br/>
<h4><a href="add_dates.jsp">Add Flight Date</a><h4>

<%
ResultSet rs= FlightDao.getFlightDateDetails();
%>

<table class="table table-striped">
    <thead>
      <tr>
        <th>id</th>
        <th>Number</th>
        <th>Name</th>
        <th>Date</th>
           
      </tr>
    </thead>
    <tbody>
	
	<% 
     while(rs.next()){%>
	<tr>
        <td><%= rs.getInt(1) %></td>
        <td><%= rs.getString(2) %></td>
        <td><%= rs.getString(3) %></td>
		<td><%= rs.getString(4) %></td> 
		<td><a class=" btn btn-danger tx-tfm" onclick="return confirm('Do you really want to Delete')" href="Delete_Date?id=<%= rs.getInt(1) %>&date=<%= rs.getString(4) %>">Delete</a></td>    
      </tr>
      <%}%>
      </tbody>
  </table>
</div>
