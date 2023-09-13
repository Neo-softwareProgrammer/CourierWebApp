<%-- 
    Document   : History
    Created on : 23 May 2023, 11:27:53 PM
    Author     : Eddie Shubane
--%>

<%@page import="za.ac.tut.entity.Enquiries"%>
<%@page import="za.ac.tut.entity.Shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>

        <div  align="center" >
        <h1>History</h1>
        
        <div class="items">
        <div class="Shipment">
                <a href="HistoryServlet.do">Shipment</a> 
             </div>
        <div class="Shipment">
            <a href="enquiriesHistoryServlet.do">Enquiries</a> 
            </div>
        
        </div>
        </div>
        
    </body>
    <style>
        
        .items{
            display: flex;
            align-items: center;
        }
        .Shipment{
            width: 15%;
            height: 40px;
            margin-left: 20px;
            margin-top: 20px;
            background: #04AA6D;
            color: white;
            border-radius: 15px;
            text-align: center;
            padding: 10px 10px 10px 10px;
        }
        .Shipment a{
            text-decoration: none;
            font-size: 30px;
            color: white;
        }
        
    </style>
        
</html>
