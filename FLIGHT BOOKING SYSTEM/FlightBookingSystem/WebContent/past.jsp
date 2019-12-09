<%@ page import= "com.flight.repository.*" %>
<%@ page import= "javax.servlet.http.*" %>
<%@ page import= "java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import ="java.text.SimpleDateFormat"%>
<%@ page import ="java.util.Date"%>

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

SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
Date date = new Date();  
//SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
//Date date1 = new Date()

%>
<sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/flight" user="root" password="password@123"/>

<sql:query var="rs" dataSource="${conn}">

select b.book_id, b.user_name, f.flight_number, f.flight_name, f.from_city, f.to_city, b.date, f.time, f.fare from book_ticket b join flight_details f on b.flight_id=f.flight_id where b.user_id=<%=id%> and b.date<'<%=formatter.format(date)%>' ;

</sql:query>

<c:forEach var= "result" items="${rs.rows}">
<c:out value="${result.flight_id}"/>

<tr> 
        <td><c:out value="${result.book_id}"/>
        <td><c:out value="${result.user_name}"/>
        <td><c:out value="${result.flight_number}"/>
        <td><c:out value="${result.flight_name}"/>
        <th>A1</th>
        <td><c:out value="${result.from_city}"/>
        <td><c:out value="${result.to_city}"/>
        <td><c:out value="${result.date}"/>
        <td><c:out value="${result.time}"/>
        <td><c:out value="${result.fare}"/>
        <td><h3><font color="blue">Journey Complited</h3></td>
        
</tr>
</c:forEach>

<% }
  		else{
  			response.sendRedirect("login.html");
  		}
  			
      %>   

