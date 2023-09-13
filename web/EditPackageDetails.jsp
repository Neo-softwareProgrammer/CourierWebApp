<%-- 
    Document   : EditPackageDetails
    Created on : May 19, 2023, 5:27:51 PM
    Author     : Thethwayo96
--%>

<%@page import="za.ac.tut.entity.Shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipment Details</title>
    </head>
    <body>
        <h1>Find Your Package</h1>
        <form action="EditPackageDetailsServlet.do" method="POST">
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
