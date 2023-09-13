<%-- 
    Document   : new_order
    Created on : Apr 25, 2023, 6:41:21 PM
    Author     : Thethwayo96
--%>

<%@page import="za.ac.tut.logic.OrderDetail"%>
<%@page import="za.ac.tut.entity.Shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Order</title>
           <link rel="stylesheet" href="css/homepageStyle.css">
    </head>
    <body>
        
        
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
        
        
        
        <%
            Shipment shpmnt = (Shipment) session.getAttribute("package");
            OrderDetail order = (OrderDetail) session.getAttribute("order");
        %>
        <h4>Shipment Request Logged, Use TRACK PACKAGE to see your package</h4>

        <ul>
            <li><a href="EditPackageDetails.jsp">EDIT PACKAGE DETAILS</a></li>
           
        </ul>
        <div align="center">
           
                <table>
                    <tr>
                        <th>PACKAGE DETAILS</th>
                        <th></th>
                    </tr>
                    <tr>
                        <td><b>Package ID: </b></td>
                        <td><%=shpmnt.getId()%></td>
                    </tr>
                    <tr>
                        <td><b>Service Type: </b></td>
                        <td><%=shpmnt.getService_req()%></td>
                    </tr>
                    <tr>
                        <td><b>Package Description: </b></td>
                        <td><%=shpmnt.getDescription()%></td>
                    </tr>
                    <tr>
                        <td><b>Date of collection: </b></td>
                        <td><%=shpmnt.getCollection_date()%></td>
                    </tr>
                    <tr>
                        <td><b>Status: </b></td>
                        <td><%=shpmnt.getStatus()%></td>
                    </tr>
                    <tr>
                        <td><b>Amount Due: ZAR</b></td>
                        <td><%=order.getTotalAmount()%></td>
                    </tr>
                    
                </table>
            
        </div>
        <div align="center">
            <form action="CashPayment.do" method="POST">
                <table>
                    <tr>
                        <th></th>
                        <th>Pay Upon Collection</th>
                    </tr>
                    <tr>
                        <th>Delivery Address:</th>
                        <th><input type="text" name="deliveryAddress" required=""></th>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Get Receipt" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
