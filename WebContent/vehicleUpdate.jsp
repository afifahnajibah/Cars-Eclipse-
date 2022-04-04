
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page import="vehicle.*" %>
 <%@ page import="vehicle.VehicleUpdate" %> 
 <%@ page import = "java.util.*" %>
 
 <jsp:useBean id="VehicleModel" scope="application" class="vehicle.VehicleModel" />

 <title>Update Vehicle</title>
 </head>
 <body>
<jsp:include page="header.jsp"></jsp:include>
 <h2>Update Vehicle</h2>


 <% int id = Integer.parseInt(request.getParameter("id")); %>
 <% Vehicle v = VehicleModel.getVehicleById(id);%>

	 <form action="VehicleUpdate" method="POST">

	    <div class="form-group">
			<label for="customerid">Customer Id</label>
			<input type="text" name="customerid" class="form-control" id="customerid" value="<%= v.getCustomerid() %>" readonly>
		</div>
 
		<div class="form-group">
			<label for="customername">Customer Name</label>
			<input type="text" name="customername" class="form-control" id="customername" value="<%= v.getCustomername() %>" readonly>
		</div>
 
		<div class="form-group">
			<label for="customeric">Customer Identification Number</label>
			<input type="text" name="customeric" class="form-control" id="customeric" value="<%= v.getCustomeric() %>" readonly>
		</div>
 
		<div class="form-group">
			<label for="vehiclemodel">Vehicle Model</label>
			<input type="text" name="vehiclemodel" class="form-control" id="vehiclemodel" value="<%= v.getVehiclemodel() %>">
		</div>
 
		<div class="form-group">
			<label for="vehiclebrand">Vehicle Brand</label>
			<input type="text" class="form-control" name="vehiclebrand" id="vehiclebrand" value="<%= v.getVehiclebrand() %>">
		</div>
 
		<div class="form-group">
			<label for="vehiclecolor">Vehicle Color</label>
			<input type="text" class="form-control" name="vehiclecolor" id="vehiclecolor" value="<%= v.getVehiclecolor() %>">
		</div> 
 
 		<div class="form-group">	
 		<label for="vehicleyear">Vehicle Year</label>
	     <input class="date-own form-control" style="width: 300px;" name="vehicleyear" type="text" value="<%= v.getVehicleyear() %>">
	
		  <script type="text/javascript">
		      $('.date-own').datepicker({
		         minViewMode: 2,
		         format: 'yyyy'
		       });
		  </script>
		</div>
        
	<input type="hidden" name="id" value="<%= v.getVehicleid()%>">
	<button type="submit" class="btn btn-primary">Update</button>
	</form>

<jsp:include page="footer.jsp"></jsp:include>