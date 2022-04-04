<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>                                                                

<jsp:include page="header.jsp"></jsp:include>
<%@ page import="java.util.*" %>
<%@ page import="staff.StaffAdd" %>



<jsp:useBean id="StaffModel" scope="application" class="staff.StaffModel"></jsp:useBean>

<h1>Add New Staff</h1>
<form action="StaffAdd" method="POST">

	<div class="form-group">
		<label for="staffname">Customer's Name</label>
		<input type="text" class="form-control" name="staffname" placeholder="Name" size="150">
	</div>
	<div class="form-group">
		<label for="staffic">Customer's Identification Number</label>
		<input type="text" class="form-control" name="staffic" placeholder="e.g.: 990830-01-5632" size="150">
	</div>
	<div class="form-group">	
		<label for="staffphone">Customer's Phone Number</label>
		<input type="text" class="form-control" name="staffphone" placeholder="e.g.: 011-61442356" size="150">
	</div>
	<div class="form-group">	
		<label for="staffemail">Customer's Email</label>
		<input type="email" class="form-control" name="staffemail" placeholder="Enter Valid Email" cols="150">
	</div>
	
	
	<button type="submit" class="btn btn-success">Add</button>
</form>	

<jsp:include page="footer.jsp"></jsp:include>
