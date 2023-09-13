<%-- 
    Document   : enquiriesHistory
    Created on : 24 May 2023, 10:03:54 PM
    Author     : Eddie Shubane
--%>

<%@page import="za.ac.tut.entity.Enquiries"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><%
            List<Enquiries> eqList=(List) session.getAttribute("enquiries");
        
        
        %>
        <h1>Shipment history</h1>
        <table>
            <% for (int i = 0; i < eqList.size(); i++) {
                        Enquiries enquiries=eqList.get(i);
    %>
            <tr>
                <td>
                    Shipment ID:
                </td>
                <td><%=enquiries.getId()%></td>
                </tr>
                <tr>
                    <td>
                   Message
                </td>
                <td><%=enquiries.getMessage()%></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td><%=enquiries.getStatus()%></td>
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
