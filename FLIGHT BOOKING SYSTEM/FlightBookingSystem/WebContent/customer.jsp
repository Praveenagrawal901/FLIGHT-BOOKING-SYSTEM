<%@ page import= "javax.servlet.http.*" %>


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
    <div class="container" style="padding-left: 175px;">
        <div class="row">
			<div class="col-md-50 mx-auto">
			<div>
				<div class="myform form ">
					 <div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<h1>Book Ticket</h1>
						 </div>
					</div>
		 <script>	
				function setDate(){				
	 				var selectedDate = document.getElementById('date').value;
						 function format(date) {
		   					 var d = date.getDate();
		    				 var m = date.getMonth() + 1;
		    				 var y = date.getFullYear();
		    				return '' + y + '-' + (m<=9 ? '0' + m : m) + '-' + (d <= 9 ? '0' + d : d);
				}
				var today = new Date();
				var dateString = format(today);
					if (Date.parse(selectedDate) < Date.parse(dateString)) {
						alert("Date must be in the future");
					}
				}
		</script>

                   <form action="show_ticket.jsp" method="get" name="showflight" > 
                           
						   <div class="form-group">
  							<label>From:</label>
  							<select class="form-control"  name="from" required>
    						<option>Select</option>
    						<option>Pune</option>
   							 <option>Dehli</option>
    						<option>Mumbai</option>
    						<option>Jaipur</option>
    						<option>Jalna</option>
    						<option>nashik</option>
    						<option>hyderabad</option>
    						<option>nagpur</option>
    						<option>kolkata</option>
    						<option>kanpur</option>
    						<option>surat</option>
    						<option>Indore</option>
    						<option>amritsar</option>		
  							</select>
							</div>
                           
						   <div class="form-group">
  							<label>To:</label>
  							<select class="form-control"  name="to" required>
    						<option>Select</option>
    						<option>Pune</option>
   							 <option>Dehli</option>
    						<option>Mumbai</option>
    						<option>Jaipur</option>
    						<option>Jalna</option>
    						<option>nashik</option>
    						<option>hyderabad</option>
    						<option>nagpur</option>
    						<option>kolkata</option>
    						<option>kanpur</option>
    						<option>surat</option>
    						<option>Indore</option>
    						<option>amritsar</option>		
  							</select>
							</div>
						   
						   <div class="form-group">						    
						      <label>Date</label>
						      <div class="input-group">
						      <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
							<input id="date" type="date" onchange="setDate();" class="form-control" name="date" placeholder="dd\mm\yyyy" required>
						   </div>
						   </div>
						   <div class="col-md-12 text-center ">
                              <button type="submit" class=" btn btn-success tx-tfm">Search</button>
                           </div>
						   <br/>
						   <br/>
						   <br/>
                        </form>
                 
				</div>
			</div>
			  
		</div>
      </div>  
      <% }
  		else{
  			response.sendRedirect("login.html");
  		}%> 
  		
  <% %>>		
  		
  		
  		  