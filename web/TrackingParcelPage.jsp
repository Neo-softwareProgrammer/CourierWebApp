<%-- 
    Document   : TrackingParcelPage
    Created on : 25 Apr 2023, 5:09:39 PM
    Author     : Eddie Shubane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/trackingPageCSS.css">
        <title>Track Package</title>
    </head>
    <body>
        <header>
            <a href="index.html"> <img alt="logo" src="images/pngwing.com.png"></a>
            <div class="links">
                <ol>
                    <li><a href="index.html">HOME</a></li>
                    <li><a href="TrackingParcelPage.jsp">TRACK PARCEL </a></li>
                    <li> <a href="">ABOUT US</a></li>
                    <li> <a href="">CONTACT US</a></li>
                </ol>
            </div>

            <div class="container">
                <h1>TRACK YOUR PACKAGE</h1>
                <img src="images/pngwing.com (18).png" alt="">

                <form action="TrackPackageServlet.do" method="POST">
                    <input type="text" name="packageId" placeholder="Enter tracking code">
                    <button> Submit</button>
                    <table>
                        <tr >
                            <td colspan="2">
                                <span style="color:red;">${error}</span>
                            </td>
                    </table>
                </form>
            </div> 
        </header>  
    </body>
</html>
