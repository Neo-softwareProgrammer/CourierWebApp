<%-- 
    Document   : DriverWelcomePage
    Created on : 25 Apr 2023, 12:55:25 PM
    Author     : Eddie Shubane
--%>

<%@page import="za.ac.tut.entity.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/driverWelcomeSttyle.css">
    </head>
    <body>
        <%
        Driver myDriver=(Driver) session.getAttribute("driverUser");
        String name=myDriver.getName();
        
        %>
        
  
        <header>
            <div class="logo">
                <img src="images/pngwing.com.png">
            </div>
            <input type="checkbox" id="nav_check" hidden>
            <nav>
                <div class="logo">
                    <img src="images/pngwing.com.png">
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

        <div class="message">
        
            <h1 class="title">
                Hellow Driver
            </h1>
            <p>
                Welcome <%=name%> see your jobs for the day and complete the jobs
            </p>
        </div>

        
        
     <div class="content">
         <a href="showAllJobs.do"><div class="task1">
            <h1>  See your jobs</h1>
        </div></a>
         
         <a href="SelectJJob.jsp">
        <div class="task2">
              <h1>Taken Job</h1>
        </div>
         </a>    
      
     </div>
            
            
    </body>
</html>
