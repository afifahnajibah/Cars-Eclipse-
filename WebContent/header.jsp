<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
<head>
<title>CarS Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
 <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.css" rel="stylesheet">
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #DAF7A6;">
  <a class="navbar-brand" href="#">CarS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
      
      <% if(session.getAttribute("status") != null) { %>
        <li class="nav-item"><a class="nav-link" href="account.jsp">Account</a></li>      
      	<li class="nav-item dropdown" >
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Services
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="background-color: #DAF7A6;">
	          <a class="dropdown-item" href="custAdd.jsp">Add New Customer</a>
	        </div>
	     </li>
      	
      	<li class="nav-item"><a class="nav-link" href="staffView.jsp">Staff</a></li>
      	<li class="nav-item"><a class="nav-link" href="custView.jsp">Customer</a></li>
      	<li class="nav-item"><a class="nav-link" href="vehicleView.jsp">Vehicles</a></li>
      	<li class="nav-item"><a class="nav-link" href="workView.jsp">Complaint/Issues</a></li>
      	<li class="nav-item"><a class="nav-link" href="report.jsp">Report</a></li>	
      <% } %>
           
      
    </ul>
    <ul class="navbar-nav navbar-right">
    	<% 	if(session.getAttribute("status") != null) {
    			if(session.getAttribute("status").equals("loggedin")) { %>
    				<li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a></li>
    				<li class="nav-item"><a class="nav-link" href="#"> Welcome, ${username}</a></li>
    	<%		}
    		}
	    	else { %>
	    		<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
	    <%  } %>
    </ul>
    
  </div>
</nav>

<div class="container">
	
	<%
		if(session.getAttribute("success") != null) {	%>
			<div class="alert alert-success alert-dismissible fade show" role="alert">
			  <%=session.getAttribute("success") %>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
	<%		session.removeAttribute("success");
		}
	%>
	
	<%
		if(session.getAttribute("danger") != null) {	%>
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
			  <%=session.getAttribute("danger") %>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
	<%		session.removeAttribute("danger");
		}
	%>