
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page import="workorder.*" %>
 <%@ page import="workorder.WorkorderUpdate" %> 
 <%@ page import = "java.util.*" %>
 
 <jsp:useBean id="WorkorderModel" scope="application" class="workorder.WorkorderModel" />

 <title>Receipt</title>
 </head>
 <body>
<jsp:include page="header.jsp"></jsp:include>
 <h2>Receipt</h2>
 <h4>Thank you for trusting CarS workshop ! </h4>
 <br><br>

 <% int id = Integer.parseInt(request.getParameter("id")); %>
 <% Workorder w = WorkorderModel.getWorkorderById(id);%>

	<div class="container">
	
	<div class="form-control">
	<label>Staff Id : </label> <%= w.getStaffid() %> 
	</div><br>
	
	<div class="form-control">
	<label>Customer Id : </label> <%= w.getCustomerid() %>
	</div><br>
	
	<div class="form-control">
	<label>Vehicle Id : </label> <%= w.getVehicleid() %>
	</div><br>
	
	<div class="form-control">	
		<label>Date : </label> <%= w.getDate() %>
	</div><br>
	
	<div class="form-control">	
		<label>Problem : </label> <%= w.getProblem() %>
	</div><br>
	
	<div class="form-control">	
		<label>Causes : </label> <%= w.getCauses() %>
	</div><br>
	
	<div class="form-control">	
		<label>Solution : </label> <%= w.getSolution() %>
	</div><br>
	
	<div class="form-control">	
		<label>Payment : </label> <%= w.getPayment() %>
	</div>
	<br><br>
	</div>
	<button class="btn btn-primary" onclick="window.print()">Print</button>

<jsp:include page="footer.jsp"></jsp:include>