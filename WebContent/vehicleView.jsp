<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>   
                                                              
<jsp:include page="header.jsp"></jsp:include>
<%@ page import="java.util.*" %>
<%@ page import="staff.*" %>
<%@ page import="staff.Staff" %>
<%@ page import="staff.StaffModel" %>
<%@ page import="vehicle.VehicleModel" %>
<%@ page import="vehicle.Vehicle" %>

<jsp:useBean id="StaffModel" scope="application" class="staff.StaffModel"></jsp:useBean> 
<jsp:useBean id="VehicleModel" scope="application" class="vehicle.VehicleModel"></jsp:useBean> 

<%List <staff.Staff> slist = StaffModel.viewStaff();%>
<%List <vehicle.Vehicle> list = VehicleModel.viewVehicle();%>



<h1>Vehicle</h1>
<br>

<table class="table">

     <thead class="thead-light">
    <tr>
    <th>Id</th>
    <th>Customer ID</th>
    <th>Customer Name</th>
    <th>Customer Identification</th>
    <th>Vehicle Model</th>
    <th>Vehicle Brand</th>
    <th>Vehicle Color</th>
    <th>Vehicle Year</th>
    <th colspan="2">Action</th>
    </tr>

<%
    for(vehicle.Vehicle v : list) {
%>

        <tr>
        <td><%= v.getVehicleid() %></td>
        <td><%= v.getCustomerid() %></td>
       	<td><%= v.getCustomername() %></td>
        <td><%= v.getCustomeric() %></td>
       	<td><%= v.getVehiclemodel() %></td>
        <td><%= v.getVehiclebrand()%></td>
        <td><%= v.getVehiclecolor()%></td>
        <td><%= v.getVehicleyear() %></td>
        <td>
        <form action="vehicleUpdate.jsp" method="POST">
        	<input type="hidden" name="id" value="<%= v.getVehicleid() %>">
      		<button type="submit" class="btn btn-info">Update</button>
        </form>
   		</td>
		<td>
		<% for(staff.Staff s : slist) {%>
        <form action="workAdd.jsp" method="POST">
        	<input type="hidden" name="id" value="<%= v.getVehicleid() %>">
        	
        	<input type="hidden" name="staffid" value="<%= s.getStaffid() %>">
        	<% } %>
        	<input type="hidden" name="custid" value="<%= v.getCustomerid() %>">
      		<button type="submit" class="btn btn-info">Add WorkOrder</button>
        </form>
   		</td>

    	<td> 
    	<form action="VehicleDelete" method="POST">
        	<input type="hidden" name="id" value="<%= v.getVehicleid() %>">
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
