<%-- 
    Document   : ApproveOrders
    Created on : 25 May 2023, 11:02:41 PM
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
            List<Shipment> shipmentList=(List<Shipment>) session.getAttribute("shipmentlist");
        
        
        %>
        
        
        <h1>Approve Orders</h1>
        <form action="StatusOrdersServlet.do" method="post">
        <table>
            
            <tr>
                <td>
                    <select name="shipID">
                        <%for (int i = 0; i < shipmentList.size(); i++) {
                    String shipID=shipmentList.get(i).getId();%>
                
            
                        <option value= "<%=shipID%>"><%=shipID%></option>
                        <%}%>
                    </select>
                    
                </td>
                <td>
                    <select name="status">
                        <option value="approved">approved</option>
                        <option value="decline">decline</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Validate Status"> </td>
            </tr>
        </table>
        </form>
    </body>
</html>
