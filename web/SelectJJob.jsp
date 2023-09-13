<%-- 
    Document   : SelectJJob
    Created on : 23-May-2023, 19:37:18
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
        Shipment shipMent=(Shipment) session.getAttribute("jobTaken");
        %>
        <h1>UPDATE JOB STATUS</h1>
        
        <%
        if (shipMent!=null) {
                
         %>
           <form action="JobStatusUpdate.do" method="POST">
            <table>
                <tr>
                    <td>JOB ID</td>
                    <td><%=shipMent.getId()%></td>
                </tr>
                <tr>
                    <td>STATUS</td>
                    <td>
                        <select name="status">
                            <option value="Collectd">Collected</option>
                            <option value="Delivered">Delivered</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="submit"></td>
                </tr>
            </table>
        </form>
         
         <%
            
            
            }else{
        %>
      
        <h3>JOB NOT YET SELECTED</h3>
        <%}%>
        
        <a href="DriverWelcomePage.jsp">Back</a>
    </body>
</html>
