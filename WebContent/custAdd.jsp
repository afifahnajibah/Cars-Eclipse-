<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>                                                                

<jsp:include page="header.jsp"></jsp:include>
<%@ page import="java.util.*" %>
<%@ page import="customer.CustomerAdd" %>



<jsp:useBean id="CustomerModel" scope="application" class="customer.CustomerModel"></jsp:useBean>

<h1>Add New Customer</h1>
<form action="CustomerAdd" method="POST">

	<div class="form-group">
		<label for="customername">Customer's Name</label>
		<input type="text" class="form-control" name="customername" placeholder="Name" size="150">
	</div>
	<div class="form-group">
		<label for="customeric">Customer's Identification Number</label>
		<input type="text" class="form-control" name="customeric" placeholder="e.g.: 990830-01-5632" size="150">
	</div>
	<div class="form-group">	
		<label for="customerphone">Customer's Phone Number</label>
		<input type="text" class="form-control" name="customerphone" placeholder="e.g.: 011-61442356" size="150">
	</div>
	<div class="form-group">	
		<label for="customeraddress">Customer's Address</label>
		<textarea class="form-control" name="customeraddress" placeholder="Full Address" rows=4 size="100"></textarea>
	</div>
	<div class="form-group">	
		<label for="customeremail">Customer's Email</label>
		<input type="email" class="form-control" name="customeremail" placeholder="Enter Valid Email" cols="150">
	</div>
	
	
	<button type="submit" class="btn btn-success">Add</button>
</form>	

<jsp:include page="footer.jsp"></jsp:include>
