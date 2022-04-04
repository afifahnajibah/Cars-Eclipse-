<%
	if(session.getAttribute("status") != null){
		session.removeAttribute("status");
		session.removeAttribute("username");
		response.sendRedirect("index.jsp");
	}
%>