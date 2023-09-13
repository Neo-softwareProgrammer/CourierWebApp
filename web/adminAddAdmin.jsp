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
            <li><a href="#">Delete Users</a></li>
            <li><a href="#" >Update Users</a></li>
            <li><a ref="#">Shipment</a></li>
            <li><a ">Delete Users</a><"li>
            <li><a calss="logout" href="#" >Logout</a></li>
        </ul>
        <div class="form">
            <form action="addminAddAdmin.do" method="POST" enctype="multipart/form-data">
            <table>

                <thead>
                     <td>
                         <a href="adminAddUser.jsp"> Client  </a>
                     </td>
                     <td>
                         <a  href="adminAddDriver.jsp">Driver   </a>
                    </td>
                    <td>
                         <a class="active" href="#">Admin</a>
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
                    <td>User Name</td>
                    <td><input type="text" name="name" placeholder="Enter name" required="required"></td>
                </tr>
                  <tr>
                    <td colspan="2">
                        <span style="color:red;">${errorEmailFound}</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        Access Level
                    <td>
                    <select name="access">
                     <option value="enqadmin">Enquiries Admin</option>
                     <option value="hradmin">HR Admin</option>
                    <option value="suadmin">Super User</option>
                         </select>
                    </td>
                </tr>
                
                   <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" placeholder="Enter password" required="required"></td>
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
