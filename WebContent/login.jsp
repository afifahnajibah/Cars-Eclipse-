<%@ page import="login.*" %>

<jsp:include page="header.jsp"></jsp:include>
<br>

<h3>Login Page</h3><br>

<form method="post" action="LoginController">
  <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-success">Login</button>
</form>

<br>
<jsp:include page="footer.jsp"></jsp:include>