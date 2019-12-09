<jsp:include page="header.jsp"/>


<div class="container">
  <h2>Add New Flight</h2>
  <form class="form-horizontal" action="Insert_Flight" method="get">
    <div class="form-group">
      <label class="control-label col-sm-2">Number:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="number" placeholder="Enter Flight Number" name="number">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="name" placeholder="Enter Flight Name" name="name">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">From:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="from" placeholder="From City" name="from">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">To:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="to" placeholder="To City" name="to">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Fare:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="fare" placeholder="Fare" name="fare">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Time:</label>
      <div class="col-sm-10">          
        <input type="time" class="form-control" id="time" placeholder="Time" name="time">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-success tx-tfm">Add Flight</button>
      </div>
    </div>
  </form>
</div> 
</body>
</html>