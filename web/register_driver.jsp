<%-- 
    Document   : register_driver
    Created on : 25 Apr 2023, 12:04:44 PM
    Author     : Eddie Shubane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleDriver.css">
    </head>
    <body>
       
          <form action="Register_driver.do" method="POST">
               <h3>Driver Registration</h3>
            <table

                
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id_no" placeholder="Enter ID" required="required" ></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <span style="color:red;">${errorAccountFound}</span>
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" placeholder="Enter name" required="required"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" placeholder="Enter email" required="required"></td>
                </tr>
                  <tr>
                    <td colspan="2">
                        <span style="color:red;">${errorEmailFound}</span>
                    </td>
                </tr>
                <tr>
                    <td>Surname</td>
                    <td><input type="text" name="surname" placeholder="Enter surname" required="required"></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="tel" name="phone" placeholder="Enter phone" required="required"></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" placeholder="Enter address" required="required"></td>
                </tr>
                   <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" placeholder="Enter password" required="required"></td>
                </tr>
                <tr>
                    <td>License</td>
                    <td><input type="file" name="license" placeholder="Put in your license" id="image" accept="image/*" capture></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <span style="color:red;">${errorID}</span>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <a href="register.jsp" style="text-decoration: none">
                            Driver Client
                        </a>
                    </td>
                </tr>
                
                <tr>
                    
                    <td></td>
                    <td><input type="submit" value="Register"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
