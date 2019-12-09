<%@ page import= "java.sql.*" %>
<%@ page import= "com.flight.repository.FlightDao" %>
<%@ page import="com.flight.repository.User_DetailsDao" %>
<jsp:include page="header.jsp"/>

<%

ResultSet rs= User_DetailsDao.getUserDetails();



%>
<div class="container">
  <h2>USer_Details</h2>
  
<%int cnt=0; try{cnt = User_DetailsDao.user(); } catch(Exception e){}%>  
  <h3>Total Users <%= cnt %></h3>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        
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
      </tr>
      <tr>
    <%}%>
    </tbody>
  </table>
</div>
