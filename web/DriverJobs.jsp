<%-- 
    Document   : DriverJobs
    Created on : 23-May-2023, 14:08:04
    Author     : User
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
        
         List<Shipment> myJobs=(List<Shipment>) session.getAttribute("listjobs");
         int num=myJobs.size();
        
        %>
        <h1>These are the jobs you have for the day</h1>
        
        
        
        
        <% 
        
        if(myJobs!=null){
          %>  
            
            <table>
            <tr>
                <th style="background: #23a2f6">Shipment ID</th>
                <th style="background: #23a2f6">Service REQ</th>
                <th style="background: #23a2f6">Client Address</th>
                <th style="background: #23a2f6">TO DO</th>
                
                <th style="background: #23a2f6">STATUS</th>
            </tr>
            <%
                for (int idx = 0; idx < myJobs.size(); idx++) {
                        Shipment elem = myJobs.get(idx);
                        
                        String progress="INCOMPLETE";
                        
                        if(elem.getDelivery_date()!=null){
                            progress="COMPLETE";
                        }
              %>
              
            <tr>
                <td><%=elem.getShipment_id()%></td>
                <td><%=elem.getService_req()%></td>
                <td><%=elem.getClient().getAddress()%></td>
                <td><%=elem.getType()%></td>
             
                <td><%=progress%></td>
            </tr>
            <%
                    }
            %>
        </table>
        
        <form action="TakeJob.do" method="POST">
            <table>
                <tr>
                    <td>SELECT JOB</td>
                    <td><input type="number" min="1" max="<%=num%>" name="job"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="TAKE"></td>
                </tr>
            </table>
        </form>

        </table>
         <%   
        }else{

        %>
        NOT JOBS YET
        <%}%>
        
        
    </body>
</html>
