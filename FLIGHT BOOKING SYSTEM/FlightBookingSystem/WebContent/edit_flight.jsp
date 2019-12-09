<%@page import="com.flight.repository.FlightDao"%>
<%@ page import= "com.flight.repository.*, com.flight.entity.*" %>

<jsp:include page="header.jsp"/>
<%
				String fid=request.getParameter("id");  
		        int id=Integer.parseInt(fid);  
		        Flight_details fd=null;
		        try {
					fd= FlightDao.getFlightById(id);
				
		        %>
<div class="container">
  <h2>Add New Flight</h2>
  <form class="form-horizontal" action="Edit_flight" method="get">
    <div class="form-group">
      <label class="control-label col-sm-2">Number:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="number" value="<%= fd.getNumber() %>" name="number">
      </div>
    </div>
    
    <input type="hidden" class="form-control" id="id" value="<%= fd.getId() %>" name="id">
    
    <div class="form-group">
      <label class="control-label col-sm-2">Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="name" value="<%= fd.getName() %>" name="name">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">From:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="from" value="<%= fd.getFrom() %>" name="from">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">To:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="to" value="<%= fd.getTo() %>" name="to">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Fare:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="fare" value="<%= fd.getFare() %>" name="fare">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Time:</label>
      <div class="col-sm-10">          
        <input type="time" class="form-control" id="time" value="<%= fd.getTime() %>" name="time">
      </div>
    </div><%
    } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} %>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Update</button>
      </div>
    </div>
  </form>
</div> 
</body>
</html>