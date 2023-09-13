<%-- 
    Document   : JobAllocationOutcome
    Created on : 26-May-2023, 00:18:27
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="adminHome.css">
    </head>
    <body>
         <ul>
             <li><a class="active"href="suadmin.jsp">Super System Admin</a></li>
             <li><a   href="adminAddUser.jsp">Add Users</a></li>
            <li><a href="#">Delete Users</a></li>
            <li><a href="#" >Update Users</a></li>
            <li><a href="#">Shipment</a></li>
            <li><a href="#">Delete Users</a><li>
            <li><a href="#">Approve Orders</a></li>
            <li><a href="GetAllJobs.do">Allocate Driver</a></li>
            <li><a  href="LogoutServlet.do" >Logout</a></li>
        </ul>
        
        <h1>Job Allocation Approved</h1>
        <a href="GetAllJobs.do">Done</a>
    </body>
</html>
