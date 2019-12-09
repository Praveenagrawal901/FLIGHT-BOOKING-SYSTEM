<%@ page import= "java.sql.*" %>
<%@ page import= "com.flight.repository.FlightDao" %>
<%@ page import= "javax.servlet.http.*" %>
<%
		HttpSession s=request.getSession(false);  
        String n=(String)s.getAttribute("email");
  if(n!=null){
        %>
<jsp:include page="header.jsp"/>

<%

ResultSet rs= FlightDao.getFlightDetails();

%>
<div class="container">
	<h2>Flight_Details</h2><br/>
  <h4><a href="add_flight.jsp">Add New Flight</a></h4>
  
  <%int cnt=0; try{cnt = FlightDao.total(); } catch(Exception e){}%>
  <h3>Total Flights <%= cnt %></h3>
           
  <table class="table table-striped">
    <thead>
      <tr>
        <th>id</th>
        <th>Number</th>
        <th>Name</th>
        <th>From</th>
        <th>To</th>
        <th>Fare</th>
        <th>Time</th>
       
        
        
        
        
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
		<td><%= rs.getString(5) %></td>
		<td><%= rs.getInt(6) %></td>
		<td><%= rs.getString(7) %></td> 
		<td><a class=" btn btn-primary tx-tfm" href="edit_flight.jsp?id=<%= rs.getInt(1) %>">Edit</a></td>
		<td><a class=" btn btn-danger tx-tfm" onclick="return confirm('Do you really want to Delete')" href="Delete_flight?id=<%= rs.getInt(1) %>">Delete</a></td>    
      </tr>
      <tr>
    <%}%>
    </tbody>
  </table>
</div>
<%}else{
	response.sendRedirect("admin_login.html");
	}%>
}
