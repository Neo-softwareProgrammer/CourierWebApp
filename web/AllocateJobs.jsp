<%-- 
    Document   : AllocateJobs
    Created on : 25-May-2023, 23:29:26
    Author     : User
--%>

<%@page import="za.ac.tut.entity.Driver"%>
<%@page import="za.ac.tut.entity.Shipment"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="adminHome.css">
    </head>
    <body>
        <%
        List<Shipment> jobsnotAllocated=(List<Shipment>) session.getAttribute("jobsA");
        List<Driver> allDrivers=(List<Driver>) session.getAttribute("drivers");
        %>
        
         <ul>
             <li><a class="active"href="suadmin.jsp">Super System Admin</a></li>
             <li><a href="adminAddUser.jsp">Add Users</a></li>
            <li><a href="#">Delete Users</a></li>
            <li><a href="#" >Update Users</a></li>
            <li><a href="#">Shipment</a></li>
            <li><a href="#">Delete Users</a><li>
            <li><a>Approve Orders</a></li>
            <li><a href="GetAllJobs.do">Allocate Driver</a></li>
            <li><a href="LogoutServlet.do" >Logout</a></li>
        </ul>
        <p>
        <h2>Allocate Jobs</h2>
        </p>
        
        
        <form action="AllocateJobs.do" method="POST">
            
            <table>
                
                <tr>
                    <th>Driver</th>
                    <th>JOB</th>
                </tr>
                
                <tr>
                    <td>
                        <select name="driverID">
                            
                            <%
                            
                            for (int idx = 0; idx < allDrivers.size(); idx++) {
                                    Driver driver = allDrivers.get(idx);
                                    
                              
                                %>
                                <option value="<%=idx%>">
                                <%=driver.getDriver_id()%>
                            </option>
                            
                            <%      
                                }
                            %> 
                        </select>
                        
                    </td>
                    
                    <td>
                        <select name="jobID">
                            <%
                            
                            for (int i = 0; i < jobsnotAllocated.size(); i++) {
                                    Shipment shipment = jobsnotAllocated.get(i);
                                    
                                 
                                 
                             %>
                             
                             <option value="<%=i%>">
                                 <%=shipment.getShipment_id()%>
                             </option>
                             
                             <%
                                }

                            %>
                       
                        </select>
                        
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Allocate"></td>
                </tr>
                
            </table>
        </form>
                            
        
    </body>
</html>
