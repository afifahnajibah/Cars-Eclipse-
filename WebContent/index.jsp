<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:include page="header.jsp"></jsp:include>
<br>

<div class="container" style="background-color: #DAF7A6;">
    
    
  	<img src="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.autocar.co.uk%2Fcar-news%2Fbest-cars%2Ftop-10-best-sports-cars&psig=AOvVaw2rM8WgJOLidUcz3Ru-zlGY&ust=1612954176014000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMjUzODQ3O4CFQAAAAAdAAAAABAF" width="100" height="100">

	<h3>Index page here</h3>
	<p>
		content for index page should be here <br>
		Welcome!  
		<% if(session.getAttribute("username") != null) {
				if(session.getAttribute("username").equals("sam")) {
		%>
					Manager ${username}.
		<% 
				}
				else if(session.getAttribute("role").equals("user")){ %>
					user.
		<%		}
			} %>
	</p>
</div>	
	<br>
<jsp:include page="footer.jsp"></jsp:include>