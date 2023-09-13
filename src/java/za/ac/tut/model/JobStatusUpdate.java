/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import za.ac.tut.business.ReportsFacadeLocal;
import za.ac.tut.business.ShipmentFacadeLocal;
import za.ac.tut.entity.Driver;
//import za.ac.tut.entity.Reports;
import za.ac.tut.entity.Shipment;
import za.ac.tut.logic.SendMail;

/**
 *
 * @author User
 */
public class JobStatusUpdate extends HttpServlet {

       @EJB
    private ShipmentFacadeLocal shipmentFacade;
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try {
            HttpSession session=request.getSession();
            String jobID=request.getParameter("job_id");
            String status=request.getParameter("status");
            
            Shipment shipMent=(Shipment) session.getAttribute("jobTaken");
            String reciept=shipMent.getClient().getEmail();
           
            String message="";
            
            if(status.equalsIgnoreCase("Collectd")){
                shipMent.setCollection_date(Date.from(Instant.now()));
                message="Order number "+ shipMent.getShipment_id()+" Collected";
            }else{
                shipMent.setDelivery_date(Date.from(Instant.now()));
                message="Order number "+ shipMent.getShipment_id()+" Deliverd";
            }
            
            
            
            
            SendMail.sendMail(reciept,message);
            shipMent.setStatus(status);
            shipMent.setType(status);
            
            shipmentFacade.edit(shipMent);
            
            Driver myDriver=(Driver) session.getAttribute("driverUser");
            
            
            
            
            
            request.getRequestDispatcher("JobUpdate.jsp").forward(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(JobStatusUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
   
    }


}
