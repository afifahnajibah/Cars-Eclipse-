<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>   
                                                              
<jsp:include page="header.jsp"></jsp:include>
<%@ page import="java.util.*" %>
<%@ page import="staff.StaffModel" %>
<%@ page import="staff.Staff" %>

<jsp:useBean id="StaffModel" scope="application" class="staff.StaffModel"></jsp:useBean> 

<%List <staff.Staff> list = StaffModel.viewStaff();%>

<h1>Staff</h1>
<a href="staffAdd.jsp"><button class="btn btn-info"> Add New Staff</button></a>
<table class="table">
    <thead class="thead-light">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Phone Number</th>
    <th>Email</th>
    <th colspan="2">Action</th>
    </tr>
   
<%
    for(staff.Staff s : list) {
%>
        <tr>
        <td><%= s.getStaffid() %></td>
       	<td><%= s.getStaffname() %></td>
        <td><%= s.getStaffphone() %></td>
        <td><%= s.getStaffemail()%></td>
        <td>
        <form action="staffUpdate.jsp" method="POST">
        	<input type="hidden" name="id" value="<%= s.getStaffid() %>">
      		<button type="submit" class="btn btn-info">Update</button>
        </form>
   		</td>
        
        <br>
        </tr>
<%
    }
%>
</table>

<jsp:include page="footer.jsp"></jsp:include>
