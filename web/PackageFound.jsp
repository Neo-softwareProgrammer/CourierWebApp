<%-- 
    Document   : PackageFound
    Created on : May 24, 2023, 12:56:05 AM
    Author     : Thethwayo96
--%>

<%@page import="za.ac.tut.entity.Client"%>
<%@page import="za.ac.tut.entity.Shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Driver Welcome Page</title>
        <link rel="stylesheet" href="css/driverWelcomeSttyle_1.css">
    </head>
    
    <body>
         <%
            Shipment shipment = (Shipment) session.getAttribute("shipment");
             Client client =(Client) session.getAttribute("clientUser");
             String url="index.html";
             if(client!=null){
                 url="welcome.jsp";
             }
            
            int widthmove=0;
            if(shipment.getStatus().equalsIgnoreCase("waiting approval")){
                widthmove=5;
            }else if(shipment.getStatus().equalsIgnoreCase("approved")){
                widthmove=40;
            }else if(shipment.getType().equalsIgnoreCase("Collectd")){
                widthmove=70;
            }else{
                widthmove=100;
            }

        %>
     
        
        <header>
            <div class="logo">
                
            </div>
            <input type="checkbox" id="nav_check" hidden>
            <nav>
                <div class="logo">
                    <img src="Images/logo.png">
                </div>
                <ul>
                    <li>
                        <a href="#home" class="active">Home</a>
                    </li>
                    <li>
                        <a href="#about">About</a>
                    </li>
                    <li>
                        <a href="">Projects</a>
                    </li>
                    <li>
                        <a href="">Experience</a>
                    </li>
                    <li>
                        <a href="#contactMe">Contact</a>

                    </li>
                </ul>
            </nav>
    

            <label for="nav_check" class="humburger">
                <div></div>
                <div></div>
                <div></div>
            </label>
        </header>


        <style>
            .track-container{
    background-color: white;
    height: 40vh;
    width: 50%;
    margin-top: 190px;
    margin-left: 470px;
    padding: 15px 15px 15px 15px;
    
}
.track-container .btn{
    margin-top: 10px;
    background-color: #C2FBD7;
border-radius: 50px;
border-width: 0;
box-shadow: rgba(25, 25, 25, 0.04) 0 0 1px 0, rgba(0, 0, 0, 0.1) 0 3px 4px 0;
color: #008000;
cursor: pointer;
display: inline-block;
font-family: Arial, sans-serif;
font-size: 1em;
height: 50px;
padding: 0 25px;
transition: all 200ms;
}
.track-container .btn:hover{
    background-color: #AFE6C3;
transform: scale(1.05);
}
.track-container p{
    margin: 20px;
}
.showBar{
    margin-top: 25px;
    width: 90%;
    height: 9px;
    background-color: #b1af37;
    border-radius: 15px;
 
    
}
.greenBar{
    position: relative;
    width: <%=widthmove%>%;
    height: 95%;
    left: 0;
    top: 0;
    background-color: aqua;
    border-bottom: 10px solid red;
    animation: move  3s;
    border-radius: 15px;
}

.Trackpictures{
   
    margin-top: 20px;
}
.Trackpictures ol{
    list-style: none;
    display: flex;
    gap: 175px;
}
.Trackpictures img{
height: 50px;
width: 50px;

}

.item{
    display: inline-table;
} 
@keyframes move{
    from  {width: 0}
    to {width: <%=widthmove%>%}
}
.formDd tr td:first-child{
    padding-right: 20px;
}

        </style>

        <div class="track-container">
            <h1>Track Parcel</h1>

            <p>
                <div class="formD">
                    <table class="formDd">
                        <tr>
                            <td><b>Package id: </b></td>
                            <td><%=shipment.getShipment_id()%></td>
                        </tr>
                        <tr>
                            <td><b>Package Description: </b></td>
                            <td><%=shipment.getDescription()%></td>
                        </tr>
                        <tr>
                            <td><b>Service Required: </b></td>
                            <td><%=shipment.getService_req()%></td>
                        </tr>
                    </table>
                </div>
            </p>


            <div class="showBar">
                <div class="greenBar">

                </div>
            </div>

    

            <div class="Trackpictures">
                <ol>
                    <div class="item">
                        <li>
                            <table>
                                <tr>
                                    <td><img src="images/fast-delivery.png" alt=""></td>
                                </tr>
                                <tr>
                                    <td>Awaiting Approval</td></tr>
                            </table>
                            
                            
                        </li>    
                    </div>
                    <div class="item">
                        <li>
                            <table>
                                <tr>
                                    <td><img src="images/delivery.png" alt=""></td>
                                </tr>
                                <tr>
                                    <td>Approved</td></tr>
                            </table>
                            
                            
                        </li>    
                    </div>
                    <div class="item">
                        <li>
                            <table>
                                <tr>
                                    <td><img src="images/shipping.png" alt=""></td>
                                </tr>
                                <tr>
                                    <td>Colleced</td></tr>
                            </table>
                            
                            
                        </li>    
                    </div>
                    <div class="item">
                        <li>
                            <table>
                                <tr>
                                    <td><img src="images/shipped.png" alt=""></td>
                                </tr>
                                <tr>
                                    <td>Delivered</td></tr>
                            </table>
                            
                            
                        </li>    
                    </div>
                    

                  
                    
                </ol>
            </div>
            <a href="<%=url%>">  <button class="btn" >Done</button></a>
        </div>
 
        
    </body>
</html>
