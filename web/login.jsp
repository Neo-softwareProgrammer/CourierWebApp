<%-- 
    Document   : login
    Created on : 24-Apr-2023, 12:55:55
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/loginPageStyle.css">
    </head>
    <body>
        
        
        
        <form action="login_servlet.do" method="POST">
        <h3>Login Here</h3>
        <label for="optionUser">User</label>
        <select id="optionUser" name="optionUser">
            <option value="Client">Client</option>
            <option value="Driver">Driver</option>
            <option value="Administrator">Administrator</option>
        </select>

        <label for="id_no">Username</label>
        <input type="text" placeholder="Enter id" id="id_no" name="id_no" required="required">

        <label for="password">Password</label>
        <input type="password" placeholder="Password" id="password" name="password" required="required">

        <a href="register.jsp">Register</a>
        <button>Log In</button>
      
    </form>
        
        
        
    </body>
</html>
