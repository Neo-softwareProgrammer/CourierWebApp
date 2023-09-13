<%-- 
    Document   : seeJobTaken
    Created on : 23-May-2023, 20:15:12
    Author     : User
--%>

<%@page import="za.ac.tut.entity.Shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Shipment jobTaken=(Shipment) session.getAttribute("jobTaken");
        
        %>
        <h1>Job Taken!</h1>
        
        <table>
            <tr>
                <td>JOB ID</td>
                <td><%=jobTaken.getShipment_id()%></td>
            </tr>
            <tr>
                <td>Service Req</td>
                <td><%=jobTaken.getService_req()%></td>
            </tr>
            <tr>
                <td>Task</td>
                <td><%=jobTaken.getType()%></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><%=jobTaken.getClient().getAddress()%></td>
            </tr>
            <tr>
                <td>Customer Phone</td>
                <td><%=jobTaken.getClient().getPhone()%></td>
            </tr>
            <tr>
                <td></td>
                <td><a href="DriverWelcomePage.jsp">Done</a></td>
            </tr>
        </table>
            
        
    </body>
</html>
