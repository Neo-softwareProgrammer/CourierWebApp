<%-- 
    Document   : CancelOrder
    Created on : May 19, 2023, 8:42:08 PM
    Author     : Thethwayo96
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancel Order</title>
    </head>
    <body>
        <h3>We're Sorry To See You Go.</h3>
        <h5>Please Help Us Improve Our Services In The Queries Section.</h5>
        
        <form action="CancelOrderServlet.do" method="POST">
            <table>
                <tr>
                    <th></th>
                    <th>Enter Package Tracking ID</th>
                </tr>
                <tr>
                    <td><b>Package ID: </b></td>
                    <td><input type="text" name="shipmentId" required=""></td>
                </tr>
                <tr >
                    <td colspan="2">
                        <span style="color:red;">${error}</span>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Find Package"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
