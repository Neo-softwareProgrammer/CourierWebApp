<%-- 
    Document   : AccountDetails
    Created on : 25 Apr 2023, 12:59:20 PM
    Author     : Eddie Shubane
--%>

<%@page import="za.ac.tut.entity.Client"%>
<%@page import="za.ac.tut.entity.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Details Page</title>
    </head>
    <body>
        <h1>Account Details</h1>
          <%
                String user=session.getAttribute("user").toString();
                String name="";
                String surname="";
                String email="";
                String id_no="";
           
            if(user.equals("Client")){
            
                Client myClient=(Client) session.getAttribute("clientUser");
                
            }else{
            
                Driver myDriver=(Driver) session.getAttribute("driverUser");
                name=myDriver.getDriver_name();
                surname=myDriver.getDriver_surname();
                email=myDriver.getDriver_email();
                id_no=myDriver.getDriver_id();
            }
        %>
        
        <table>
            <tr>
                <td>ID number</td>
                <td><%=id_no%></td>
            </tr>
           <tr>
                <td>Name</td>
                <td><%=name%></td>
            </tr>
           <tr>
                <td>Surname</td>
                <td><%=surname%></td>
            </tr> 
            <tr>
                <td>Email</td>
                <td><%=email%></td>
            </tr>
          
        </table>
        
    </body>
</html>
