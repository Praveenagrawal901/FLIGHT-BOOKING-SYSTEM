<jsp:include page="header.jsp"/>

<div class="container">
  <h2>Add Flight Dates</h2>
  
  <form class="form-horizontal" action="Insert_Date" method="get">
    <div class="form-group">
      <label class="control-label col-sm-2">Id:</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" id="did" placeholder="Enter Flight Id" name="did">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Date:</label>
      <div class="col-sm-10">          
        <input type="date" class="form-control" id="ddate" placeholder="Enter Date" name="ddate">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-success tx-tfm">Add Flight Date</button>
      </div>
    </div>
  </form>