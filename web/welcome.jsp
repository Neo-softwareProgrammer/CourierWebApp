<%-- 
    Document   : welcome
    Created on : 25-Apr-2023, 00:59:49
    Author     : User
--%>

<%@page import="za.ac.tut.entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
         <link rel="stylesheet" href="css/homepageStyle.css">
      
    </head>
    <body>
        
        
        <%
            Client client =(Client) session.getAttribute("clientUser");
        %>
        
         <header>
             <img alt="logo" src="images/pngwing.com.png">
           
            
            <div class="links">
                <ol>
                    <li><a href="welcome.jsp">HOME</a></li>
                    <li><a href="TrackingParcelPage.jsp">TRACK PARCEL </a></li>
                    <li> <a href="underConstruction.html">ABOUT US</a></li>
                   
                    <li> <a href="Enquire.html">CONTACT US</a></li>
                    <li><a href="LogoutServlet.do">LOGOUT</a></li>
                </ol>
                
            </div>
        </header>
        
        <h3>Welcome <%=client.getName()%></h3>
        <ul>
            <li><a href="sendPackage.jsp">SEND PACKAGE</a></li>
            <li><a href="EditPackageDetails.jsp">EDIT PACKAGE DETAILS</a></li>
            <li><a href="EditUserDetails.jsp">EDIT USER DETAILS</a></li>
            <li><a href="TrackingParcelPage.jsp">TRACK PACKAGE</a></li>
            <li><a href="History.jsp">HISTORY</a></li>
            
        </ul>
    </body>
</html>
