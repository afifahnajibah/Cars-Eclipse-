
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page import="staff.*" %>
 <%@ page import="staff.StaffUpdate" %>
 <%@ page import = "java.util.*" %>
 
 <jsp:useBean id="StaffModel" scope="application" class="staff.StaffModel" />

 <title>Update Staff</title>
 </head>
 <body>
<jsp:include page="header.jsp"></jsp:include>
 <h2>Update Staff</h2><br>


 <% int id = Integer.parseInt(request.getParameter("id")); %>
 <% Staff s = StaffModel.getStaffById(id);%>

	 <form action="StaffUpdate" method="POST">
	
		<div class="form-group">
			<label for="staffname">Staff Name</label>
			<input type="text" name="staffname" class="form-control" id="staffname" value="<%= s.getStaffname() %>">
		</div>
 
		<div class="form-group">
			<label for="staffic">Staff Identification Number</label>
			<input type="text" name="staffic" class="form-control" id="staffic" value="<%= s.getStaffic() %>">
		</div>
 
		<div class="form-group">
			<label for="staffphone">Staff Phone Number</label>
			<input type="text" name="staffphone" class="form-control" id="staffphone" value="<%= s.getStaffphone() %>">
		</div>
 
 		<div class="form-group">
			<label for="staffemail">Staff Email</label>
			<input type="email" name="staffemail" class="form-control" id="staffemail" value="<%= s.getStaffemail() %>">
        </div>
        
	<input type="hidden" name="staffid" value="<%= s.getStaffid()%>">
	<button type="submit" class="btn btn-primary">Update</button>
	</form>

<jsp:include page="footer.jsp"></jsp:include>