<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>   
                                                              
<jsp:include page="header.jsp"></jsp:include>
<%@ page import="java.util.*" %>
<%@ page import="workorder.WorkorderModel" %>
<%@ page import="workorder.Workorder" %>

<jsp:useBean id="WorkorderModel" scope="application" class="workorder.WorkorderModel"></jsp:useBean> 

<%List <workorder.Workorder> list = WorkorderModel.viewWorkorder();%>

<h1>WorkOrder</h1>
<br>
<table class="table">
     <thead class="thead-light">
    <tr>
    <th>Id</th>
    <th>Staff Id</th>
    <th>Customer Id</th>
    <th>Vehicle Id</th>
    <th>Date</th>
    <th>Problem</th>
    <th>Causes</th>
    <th>Solution</th>
    <th>Payment</th>
    <th colspan="1">Action</th>
    </tr>

<%
    for(workorder.Workorder w : list) {
%>

        <tr>
        <td><%= w.getWorkorderid() %></td>
       	<td><%= w.getStaffid() %></td>
        <td><%= w.getCustomerid() %></td>
       	<td><%= w.getVehicleid() %></td>
        <td><%= w.getDate()%></td>
        <td><%= w.getProblem()%></td>
        <td><%= w.getCauses()%></td>
        <td><%= w.getSolution()%></td>
        <td><%= w.getPayment() %></td>
        <td>
        <form action="workUpdate.jsp" method="POST">
        	<input type="hidden" name="id" value="<%= w.getWorkorderid() %>">
      		<button type="submit" class="btn btn-info">Update</button>
        </form>
   		</td>
        </tr>
<%
    }
%>
</table>

<jsp:include page="footer.jsp"></jsp:include>
