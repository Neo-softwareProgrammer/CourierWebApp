<%-- 
    Document   : sendPackage
    Created on : Apr 25, 2023, 5:25:06 PM
    Author     : Sboja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Package</title>
           <link rel="stylesheet" href="css/homepageStyle.css">
    </head>
    <body>
        
              <header>
             <img alt="logo" src="images/pngwing.com.png">
           
            
            <div class="links">
                <ol>
                    <li><a href="welcome.jsp">HOME</a></li>
                    <li><a href="TrackingParcelPage.jsp">TRACK PARCEL </a></li>
                    <li> <a href="underConstruction.html">ABOUT US</a></li>
                   
                    <li> <a href="Enquire.html">CONTACT US</a></li>
                    <li><a href="LogoutServlet.do">LOGOUT</a></li>
                </ol>
                
            </div>
        </header>
        
        
        
        
        
        
        
       
            <h3>Send Packages To Anyone Around The World, EASILY!</h3>
            <form action="SendPackageServlet.do" method="POST">
                <table>
                    <tr>
                        <th></th>
                        <th>PACKAGE DETAILS</th>
                    </tr>
                    <tr>
                        <td><b>Package Description: </b></td>
                        <td><input type="text" name="desc" placeholder="ENTER DESCRIPTION" required="required"></td>
                    </tr>
                    <tr>
                        <td><b>Package Size: </b></td>
                        <td><input type="number" name="size" min="1" placeholder="enter size" required="required"></td>
                    </tr>
                    <tr>
                        <td><b>Package Weight : </b></td>
                        <td><input type="number" name="weight" placeholder="ENTER WEIGHT" required="required"></td>
                    </tr>
                    <tr>
                        <td><b>Type of Service: </b></td>
                        <td><select name="serviceType">
                                <option value="over_night">OVER NIGHT DELIVERY </option>
                                <option value="same_day">SAME DAY DELIVERY</option>
                                <option value="normal">NORMAL/BUDGET CARGO</option>
                                <option value="early">EARLY/SUNRISE DELIVERY</option>
                                <option value="international">INTERNATIONAL IMPORT/EXPORT</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><b>Date of collection: </b></td>
                        <td><input type="date" name="collection_date" required=""></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="GET QOUTE"></td>
                    </tr>
                </table>
            </form>
    </body>
</html>
