<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>                                                                

<jsp:include page="header.jsp"></jsp:include>
<%@ page import="java.util.*" %>
<%@ page import="staff.*" %>
<%@ page import="staff.StaffModel" %>
<%@ page import="vehicle.*" %>
<%@ page import="vehicle.VehicleModel" %>
<%@ page import="workorder.*" %>
<%@ page import="workorder.WorkorderAdd" %>

<jsp:useBean id="StaffModel" scope="application" class="staff.StaffModel"></jsp:useBean>
<jsp:useBean id="VehicleModel" scope="application" class="vehicle.VehicleModel"></jsp:useBean>
<jsp:useBean id="WorkorderModel" scope="application" class="workorder.WorkorderModel"></jsp:useBean>


<h1>Add New WorkOrder</h1>

<% int staffid = Integer.parseInt(request.getParameter("staffid")); %>
<% Staff s = StaffModel.getStaffById(staffid);%>
 
<% int vehicleid = Integer.parseInt(request.getParameter("id")); %>
 <% Vehicle v = VehicleModel.getVehicleById(vehicleid);%>
 
<% int custid = Integer.parseInt(request.getParameter("custid")); %>
 <% Vehicle c = VehicleModel.getVehicleById(custid);%> 

<form action="WorkorderAdd" method="POST">
    
    <div class="dropdown form-group" >
            <select name="staffid" class="form-control">
	          <option value="<%= s.getStaffid() %>"><%= s.getStaffid() %></option>
	        </select>
	</div>
	<div class="form-group">
		<label for="customerid">Customer Id</label>
		<input type="text" class="form-control" name="customerid" value="<%= v.getCustomerid() %>">
	</div>
	<div class="form-group">
		<label for="vehicleid">Vehicle Id</label>
		<input type="text" class="form-control" name="vehicleid" value="<%= v.getVehicleid() %>">
	</div>
	<div class="form-group">	
		<label for="date">Date</label>
		<input type="date" class="form-control" name="date" >
	</div>
	<div class="form-group">	
		<label for="problem">Problem</label>
		<textarea class="form-control" name="problem" placeholder="State problems" rows=4></textarea>
	</div>
	<div class="form-group">	
		<label for="causes">Causes</label>
		<textarea class="form-control" name="causes" placeholder="State causes" rows=4></textarea>
	</div>
	<div class="form-group">	
		<label for="solution">Solution</label>
		<textarea class="form-control" name="solution" placeholder="State solution" rows=4></textarea>
	</div>
	<div class="form-group">	
		<label for="payment">Payment</label>
		<input class="form-control" name="payment" placeholder="How much in RM">
	</div>
	
	<button type="submit" class="btn btn-success">Add</button>
</form>	

<jsp:include page="footer.jsp"></jsp:include>
