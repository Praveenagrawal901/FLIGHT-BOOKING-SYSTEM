<%@ page import= "com.flight.repository.*" %>
<%@ page import= "javax.servlet.http.*" %>
<%@ page import= "java.sql.*" %>



<%
	HttpSession s=request.getSession();  
	int n=0;    
	try{
        	 n=(int)s.getAttribute("id");
        }catch(Exception e){
        	
        }
  if(n!=0){
        %>

<jsp:include page="userheader.jsp"/>


<div class="container">
	<h2>Book Ticket</h2><br/>
           
  <table class="table table-striped">
    <thead>
      <tr>
      	<th>Booking Id</th>
        <th>User Name</th>
        <th>Flight Number</th>
        <th>Flight Name</th>
        <th>Seat No</th>
        <th>From</th>
        <th>To</th>
        <th>Date</th>
        <th>Time</th>
        <th>Fare</th>
        
        
        
        
      </tr>
    </thead>
    <tbody>
<%

HttpSession session1=request.getSession(false);

int id=(int)session1.getAttribute("id");

%>

<% 
ResultSet rs= Book_FlightDao.select(id);

while(rs.next()){
%>

<tr> 
        <td><%= rs.getInt(1) %></td>
        <td><%= rs.getString(2) %></td>
        <td><%= rs.getString(3) %></td>
		<td><%= rs.getString(4) %></td>
		<td>A1</td>
		<td><%= rs.getString(5)%></td>
		<td><%= rs.getString(6) %></td>
		<td><%= rs.getString(7) %></td>
		<td><%= rs.getString(8) %></td>
		<td><%= rs.getString(9) %></td>
		<td><a class=" btn btn-danger tx-tfm" onclick="return confirm('Do you really want to cancel Ticket')" href="Cancel_TicketServlet?book_id=<%= rs.getInt(1) %>&user_name=<%= rs.getString(2)%>&flight_number=<%= rs.getString(3)%>&flight_name=<%= rs.getString(4)%>&from=<%= rs.getString(5) %>&to=<%= rs.getString(6) %>&date=<%= rs.getString(7) %>&time=<%= rs.getString(8) %>&fare=<%= rs.getString(9) %>"> Cancel</a></td>
</tr>
<%} 
  }
else{
  			response.sendRedirect("login.html");
  		}
  			%>


