<%-- 
    Document   : receipt_cash
    Created on : May 24, 2023, 9:16:06 PM
    Author     : Sboja
--%>

<%@page import="za.ac.tut.entity.Receipt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt</title>
    </head>
    <body>
        <%
            Receipt receipt = (Receipt) request.getAttribute("receipt");
            String deliveryAddress = request.getAttribute("deliveryAddress").toString();
        %>
        <div align="center">
        <h2>Transaction Receipt</h2>
        </div>
        <br><br><br>
        
        <div align="center">
            <table>
                <tr align="center">
                    <td colspan="2"><b>Transaction Details:</b></td>
                </tr>
                <tr>
                    <td><b>Merchant:</b></td>
                    <td>Door2Door Couriers</td>
                </tr>
                <tr>
                    <td><b>Payment Type:</b></td>
                    <td>Cash On Collection</td>
                </tr>
                <tr>
                    <td><b>Total Amount: ZAR</b></td>
                    <td><%=receipt.getAmountPaid()%></td>
                </tr>
                <tr><td><br/></td></tr>
                <tr align="center">
                    <td colspan="2"><b>Payer Information:</b></td>
                </tr>
                <tr>
                    <td><b>Name:</b></td>
                    <td><%=receipt.getClient().getName()%></td>      
                </tr>
                <tr>
                    <td><b>Surname:</b></td>
                    <td><%=receipt.getClient().getSurname()%></td>      
                </tr>
                <tr>
                    <td><b>Address:</b></td>
                    <td><%=receipt.getClient().getAddress()%></td>      
                </tr>
                <tr>
                    <td><b>Email:</b></td>
                    <td><%=receipt.getClient().getEmail()%></td>      
                </tr>
                <tr>
                    <td><b>Phone:</b></td>
                    <td><%=receipt.getClient().getPhone()%></td>      
                </tr>
                <tr><td><br/></td></tr>
                <tr align="center">
                    <td colspan="2"><b>Order Details:</b></td>
                </tr>
                <tr>
                    <td><b>Order ID:</b></td>
                    <td><%=receipt.getShipment().getShipment_id()%></td>
                </tr>
                <tr>
                    <td><b>Description:</b></td>
                    <td><%=receipt.getShipment().getDescription()%></td>
                </tr>
                <tr>
                    <td><b>Service Required:</b></td>
                    <td><%=receipt.getShipment().getService_req()%></td>
                </tr>
                <tr>
                    <td><b>Collection Date:</b></td>
                    <td><%=receipt.getShipment().getCollection_date()%></td>
                </tr>
                <tr>
                    <td><b>Delivery Date:</b></td>
                    <td><%=receipt.getShipment().getDelivery_date()%></td>
                </tr>
                <tr>
                    <td><b>Delivery Address:</b></td>
                    <td><%=deliveryAddress%></td>
                </tr>
            </table>
        </div>
    </body>
</html>
