
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page import="workorder.*" %>
 <%@ page import="workorder.WorkorderUpdate" %> 
 <%@ page import = "java.util.*" %>
 
 <jsp:useBean id="WorkorderModel" scope="application" class="workorder.WorkorderModel" />

 <title>Update WorkOrder</title>
 </head>
 <body>
<jsp:include page="header.jsp"></jsp:include>
 <h2>Update WorkOrder</h2>


 <% int id = Integer.parseInt(request.getParameter("id")); %>
 <% Workorder w = WorkorderModel.getWorkorderById(id);%>

	 <form action="WorkorderUpdate" method="POST">

	 <div class="dropdown form-group" >
          <select name="staffid" class="form-control">
	          <option value="<%= w.getStaffid() %>"><%= w.getStaffid() %></option>
	      </select>
	</div>
	
	<div class="form-group">
		<label for="customerid">Customer Id</label>
		<input type="text" class="form-control" name="customerid" value="<%= w.getCustomerid() %>">
	</div>
	
	<div class="form-group">
		<label for="vehicleid">Vehicle Id</label>
		<input type="text" class="form-control" name="vehicleid" value="<%= w.getVehicleid() %>">
	</div>
	
	<div class="form-group">	
		<label for="date">Date</label>
		<input type="date" class="form-control" name="date" value="<%= w.getDate() %>">
	</div>
	
	<div class="form-group">	
		<label for="problem">Problem</label>
		<input class="form-control" name="problem" value="<%= w.getProblem() %>">
	</div>
	
	<div class="form-group">	
		<label for="causes">Causes</label>
		<input class="form-control" name="causes" value="<%= w.getCauses() %>">
	</div>
	
	<div class="form-group">	
		<label for="solution">Solution</label>
		<input class="form-control" name="solution" value="<%= w.getSolution() %>">
	</div>
	
	<div class="form-group">	
		<label for="payment">Payment</label>
		<input class="form-control" name="payment" value="<%= w.getPayment() %>">
	</div>
	
	<input type="hidden" name="workorderid" value="<%= w.getWorkorderid()%>">
	<button type="submit" class="btn btn-primary">Update</button>
	</form>

<jsp:include page="footer.jsp"></jsp:include>