<%-- 
    Document   : Edit_Package
    Created on : May 19, 2023, 8:22:20 PM
    Author     : Thethwayo96
--%>

<%@page import="za.ac.tut.entity.Shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Package Details</title>
    </head>
    <body>
        <%
            Shipment shipment = (Shipment) session.getAttribute("shipment");
        %>
        <h3>Change Details Of Your Package </h3>
        <form action="MergeServlet.do" method="POST">
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
                    <td>
                        <select name="serviceType">
                            <option value="over_night">OVER NIGHT DELIVERY </option>
                            <option value="same_day">SAME DAY DELIVERY</option>
                            <option value="normal">NORMAL/BUDGET CARGO</option>
                            <option value="early">EARLY/SUNRISE DELIVERY</option>
                            <option value="international">INTERNATIONAL IMPORT/EXPORT</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><b>Delivery Address:</b></td>
                    <td><%=shipment.getDeliveryAddress() %></td>
                    <td><b>New Address:</b><input type="text" name="deliveryAddress" required=""></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="EDIT"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
