<%-- 
    Document   : suadmin
    Created on : 25 Apr 2023, 11:26:22 PM
    Author     : Linda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="adminHome.css">
        <title>Supper User Admin Page</title>
    </head>
       
    <body>
         <ul>
             <li><a class="active"href="suadmin.jsp">Super System Admin</a></li>
             <li><a   href="adminAddUser.jsp">Add Users</a></li>
            <li><a href="#">Delete Users</a></li>
            <li><a href="#" >Update Users</a></li>
            <li><a href="#">Shipment</a></li>
            <li><a href="#">Delete Users</a><li>
            <li><a href="ApproveOrdersServlet">Approve Orders</a></li>
            <li><a href="GetAllJobs.do">Allocate Driver</a></li>
            <li><a href="GetReportsServlet.do">Reports</a><li>
            <li><a  href="LogoutServlet.do" >Logout</a></li>
        </ul>
    <div>
        <h1>Hello Supper User Admin</h1>
        <p> You are currently logged in as the Super Admin user and have Full access and control of 
            all the data.</p>
    </div>
    </body>
</html>
