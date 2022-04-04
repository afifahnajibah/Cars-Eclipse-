
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page import="customer.*" %>
 <%@ page import="customer.CustomerUpdate" %>
 <%@ page import = "java.util.*" %>
 
 <jsp:useBean id="CustomerModel" scope="application" class="customer.CustomerModel" />

 <title>Update Customer</title>
 </head>
 <body>
<jsp:include page="header.jsp"></jsp:include>
 <h2>Update Customer</h2><br>


 <% int id = Integer.parseInt(request.getParameter("id")); %>
 <% Customer c = CustomerModel.getCustomerById(id);%>

	 <form action="CustomerUpdate" method="POST">
	
		<div class="form-group">
			<label for="customername">Customer Name</label>
			<input type="text" name="customername" class="form-control" id="customername" value="<%= c.getCustomername() %>">
		</div>
 
		<div class="form-group">
			<label for="customeric">Customer Identification Number</label>
			<input type="text" name="customeric" class="form-control" id="customeric" value="<%= c.getCustomeric() %>">
		</div>
 
		<div class="form-group">
			<label for="customerphone">Customer Phone Number</label>
			<input type="text" name="customerphone" class="form-control" id="customerphone" value="<%= c.getCustomerphone() %>">
		</div>
 
		<div class="form-group">
			<label for="customeraddress">Customer Address</label>
			<textarea class="form-control" name="customeraddress" id="customeraddress" rows="4" ><%= c.getCustomeraddress() %></textarea>
		</div>
 
 		<div class="form-group">
			<label for="customeremail">Customer Email</label>
			<input type="email" name="customeremail" class="form-control" id="customeremail" value="<%= c.getCustomeremail() %>">
        </div>
        
	<input type="hidden" name="customerid" value="<%= c.getCustomerid()%>">
	<button type="submit" class="btn btn-primary">Update</button>
	</form>

<jsp:include page="footer.jsp"></jsp:include>