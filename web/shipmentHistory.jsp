<%-- 
    Document   : shipmentHistory
    Created on : 24 May 2023, 1:17:40 AM
    Author     : Eddie Shubane
--%>

<%@page import="za.ac.tut.entity.Shipment"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Shipment> shipment=(List) session.getAttribute("ship");
        
        
        %>
        <h1>Shipment history</h1>
        <table>
            <% for (int i = 0; i < shipment.size(); i++) {
                        Shipment ship=shipment.get(i);
    %>
            <tr>
                <td>
                    Shipment ID:
                </td>
                <td><%=ship.getId()%></td>
                </tr>
                <tr>
                    <td>
                   Description
                </td>
                <td><%=ship.getDescription()%></td>
                </tr>
                <tr>
                    <td>Collection date</td>
                    <td><%=ship.getCollection_date()%></td>
                </tr>
                <tr>
                    <td>Delivery date</td>
                    <td><%=ship.getDelivery_date()%></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td><%=ship.getStatus()%></td>
                    
                </tr>
                <tr>
                    <td>_____________</td> 
                    <td>__________________________________________________________</td>
                </tr>
                
                <%}%>  
                
                <tr>
                    <td>
                        <a href='welcome.jsp'>HOME</a>
                    </td>
                </tr>
        </table>
    </body>
</html>
