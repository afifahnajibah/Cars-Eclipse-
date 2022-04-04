<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>   
                                                              
<jsp:include page="header.jsp"></jsp:include>
<%@ page import="java.util.*" %>
<%@ page import="customer.CustomerModel" %>
<%@ page import="customer.Customer" %>

<jsp:useBean id="CustomerModel" scope="application" class="customer.CustomerModel"></jsp:useBean> 

<%List <customer.Customer> list = CustomerModel.viewCustomer();%>

<h1>Customer</h1>
<br>
<table class="table">
     <thead class="thead-light">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Phone Number</th>
    <th>Address</th>
    <th>Email</th>
    <th colspan="2">Action</th>
    </tr>

<%
    for(customer.Customer c : list) {
%>

        <tr>
        <td><%= c.getCustomerid() %></td>
       	<td><%= c.getCustomername() %></td>
        <td><%= c.getCustomerphone() %></td>
       	<td><%= c.getCustomeraddress() %></td>
        <td><%= c.getCustomeremail()%></td>
        <td>
        <form action="custUpdate.jsp" method="POST">
        	<input type="hidden" name="id" value="<%= c.getCustomerid() %>">
      		<button type="submit" class="btn btn-info">Update</button>
        </form>
   		</td>
        
        <td>
        <form action="vehicleAdd.jsp" method="POST">
        	<input type="hidden" name="custid" value="<%= c.getCustomerid() %>">
      		<button type="submit" class="btn btn-info">New Vehicle</button>
        </form>
   		</td>

    	<td> 
    	<form action="CustomerDelete" method="POST">
        	<input type="hidden" name="id" value="<%= c.getCustomerid() %>">
        	<button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure to delete this record?')">Delete</button> 
        </form>
    	</td>
        
        <br>
        </tr>
<%
    }
%>
</table>

<jsp:include page="footer.jsp"></jsp:include>
