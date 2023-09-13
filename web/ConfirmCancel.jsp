<%-- 
    Document   : ConfirmCancel
    Created on : May 19, 2023, 8:54:55 PM
    Author     : Thethwayo96
--%>

<%@page import="za.ac.tut.entity.Shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancel Order</title>
    </head>
    <body>
        <h1>Please Confirm Order Cancellation</h1>
        
        <%
            Shipment shipment = (Shipment)session.getAttribute("shipment");
        %>
        <form action="RemoveOrderServlet.do" method="POST">
            <table>
                <tr>
                    <th></th>
                    <th>Package Details</th>
                </tr>
                <tr>
                    <td><b>Package ID:</b></td>
                    <td><%=shipment.getShipment_id()%></td>
                </tr>
                <tr>
                    <td><b>Package Description:</b></td>
                    <td><%=shipment.getDescription()%></td>
                </tr>
                <tr>
                    <td><b>Service Required:</b></td>
                    <td><%=shipment.getService_req()%></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Cancel"></td>
                </tr>
                <tr >
                    <td colspan="2">
                        <span style="color:red;">${outcome}</span>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href="welcome.jsp">Go Back</a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
