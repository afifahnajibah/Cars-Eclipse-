<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>                                                                

<jsp:include page="header.jsp"></jsp:include>
<%@ page import="java.util.*" %>
<%@ page import="customer.*" %>
<%@ page import="customer.CustomerModel" %>
<%@ page import="vehicle.*" %>
<%@ page import="vehicle.VehicleAdd" %>

<jsp:useBean id="CustomerModel" scope="application" class="customer.CustomerModel"></jsp:useBean>
<jsp:useBean id="VehicleModel" scope="application" class="vehicle.VehicleModel"></jsp:useBean>

<h1>Add New Vehicle</h1>

<% int id = Integer.parseInt(request.getParameter("custid")); %>
 <% Customer c = CustomerModel.getCustomerById(id);%>
 
<form action="VehicleAdd" method="POST">
    
    <div class="form-group">
		<label for="customername">Customer's ID</label>
		<input type="text" class="form-control" name="customerid" value="<%= c.getCustomerid() %>" size="150" readonly>
	</div>
	<div class="form-group">
		<label for="customername">Customer's Name</label>
		<input type="text" class="form-control" name="customername" value="<%= c.getCustomername() %>" size="150" readonly>
	</div>
	<div class="form-group">
		<label for="customeric">Customer's Identification Number</label>
		<input type="text" class="form-control" name="customeric" value="<%= c.getCustomeric() %>" size="150" readonly>
	</div>
	<div class="form-group">	
		<label for="vehiclemodel">Vehicle Model</label>
		<input type="text" class="form-control" name="vehiclemodel" placeholder="e.g.: Myvi hybrid" size="150">
	</div>
	<div class="form-group">	
		<label for="vehiclebrand">Vehicle Brand</label>
		<input type="text" class="form-control" name="vehiclebrand" placeholder="e.g: Perodua" size="100">
	</div>
	<div class="form-group">	
		<label for="vehiclecolor">Vehicle Color</label>
		<input type="text" class="form-control" name="vehiclecolor" placeholder="e.g.: metallic grey" cols="150">
	</div>
	<div class="form-group">	
	<label for="vehicleyear">Vehicle Year</label>
     <input class="date-own form-control" style="width: 300px;" name="vehicleyear" type="text">

	  <script type="text/javascript">
	      $('.date-own').datepicker({
	         minViewMode: 2,
	         format: 'yyyy'
	       });
	  </script>

	</div>
	
	
	<button type="submit" class="btn btn-success">Add</button>
</form>	

<jsp:include page="footer.jsp"></jsp:include>
