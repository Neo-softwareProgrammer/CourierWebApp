<%-- 
    Document   : adminAddUser
    Created on : 26 Apr 2023, 2:27:17 AM
    Author     : Linda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="adminAdd.css">
        <title>Add User Page</title>
    </head>
    <body>
         <ul>
             <li><a href="suadmin.jsp">Super System Admin</a></li>
            <li><a  class="active" "#">Add Users</a></li>
            <li><a href="Enquire.html">Delete Users</a></li>
            <li><a href="register.jsp" >Update Users</a></li>
            <li><a ref="login.jsp">Shipment</a></li>
            <li><a href="">Delete Users</a><li>
            <li><a calss="logout" href="register.jsp" >Logout</a></li>
        </ul>
        <div class="form">
            <form action="method=adminAddDriver.do" method="POST">
            <table>

                <thead>
                     <td>
                         <a href="adminAddUser.jsp"> Client  </a>
                     </td>
                     <td>
                         <a  class="active" href="#">Driver   </a>
                    </td>
                    <td>
                         <a href="adminAddAdmin.jsp" href="#">Admin</a>
                    </td>
                  </thead>
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
                    
                    <td></td>
                    <td><input type="submit" value="ADD"></td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
