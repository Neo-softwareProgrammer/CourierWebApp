<%-- 
    Document   : EditUserDetails
    Created on : 26-May-2023, 01:36:39
    Author     : User
--%>

<%@page import="za.ac.tut.entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        
        <p>
            <b><%=client.getName()%>,</b> Please update your details.
        </p>
        <form action="EditUserDetails.do" method="POST">
             <table>
                <tr align="center">
                    <th></th>
                    <th>Change Your Details</th>
                </tr>
                <tr>
                    <td><b>Email: <%=client.getEmail()%></b></td>
                    
                    <td><input type="text" name="email" value="<%=client.getEmail()%>" required=""></td>
                </tr>
                <tr>
                    <td><b>Phone Number: <%=client.getPhone()%></b></td>
                    
                    <td><input type="text" name="phone" value="<%=client.getPhone()%>" required=""></td>
                </tr>
                 <tr>
                    <td><b>Address: <%=client.getAddress()%></b></td>
                    
                    <td><input type="text" name="address" value="<%=client.getAddress()%>" required=""></td>
                </tr>
                <tr>
                    <td><b>Password: <%=client.getPassword()%></b></td>
                    
                    <td><input type="text" name="password" value="<%=client.getPassword()%>" required=""></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="UPDATE"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
