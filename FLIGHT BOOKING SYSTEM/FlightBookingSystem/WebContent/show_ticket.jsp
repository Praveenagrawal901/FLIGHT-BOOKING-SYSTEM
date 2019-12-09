<%@ page import= "java.sql.*" %>
<%@ page import= "com.flight.repository.FlightDao" %>
<%@ page import= "javax.servlet.http.*" %>
<%@ page import= "com.flight.entity.Flight_details" %>


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

<% 

String from = request.getParameter("from");
String to = request.getParameter("to");
String date = request.getParameter("date");

%>

<div class="container">
	<h2>Flights</h2><br/>
           
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Flight Number</th>
        <th>Flight Name</th>
        <th>From</th>
        <th>To</th>
        <th>Time</th>
        <th>Date</th>
        <th>Fare</th>
      
        
        
        
      </tr>
    </thead>
    <tbody>
      
     <% 
		try{
		Flight_details fd= new Flight_details();
		
		fd.setFrom(from);
		fd.setTo(to);
		fd.setDate(date);
		
		fd= FlightDao.flightSearch(fd);
		if(fd.getNumber()!=null){
%>
      <tr> 
        <td><%= fd.getNumber() %></td>
        <td><%= fd.getName() %></td>
        <td><%= fd.getFrom() %></td>
		<td><%= fd.getTo() %></td>
		<td><%= fd.getTime() %></td>
		<td><%= fd.getDate() %></td>
		<td><%= fd.getFare() %></td>
		<td><a class=" btn btn-success tx-tfm" onclick="return confirm('Do you really want to Book Ticket')" href="Book_TicketServlet?flight_number=<%= fd.getNumber()%>&flight_name=<%= fd.getName()%>&from=<%= fd.getFrom() %>&to=<%= fd.getTo() %>&time=<%= fd.getTime() %>&date=<%= fd.getDate() %>&fare=<%= fd.getFare() %>&fid=<%= fd.getId() %>">Book</a></td>    
      </tr>
      
    <%}else{
    	out.print("<script> alert('No Flight Available At that Day')</script>");
    	response.sendRedirect("customer.jsp");
    }
    }catch(Exception e){}%>
   
    </tbody>
  </table>
</div>

<% }
  		else{
  			response.sendRedirect("login.html");
  		}
  			
      %>   