/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.ShipmentFacadeLocal;
import za.ac.tut.entity.Shipment;
import za.ac.tut.logic.SendMail;

/**
 *
 * @author Eddie Shubane
 */
public class StatusOrdersServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipmentFacade;

    

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session=request.getSession();
            String status=request.getParameter("status");
            
            String shipmentOrder=request.getParameter("shipID");
            System.out.println("here");
            Shipment shipment=shipmentFacade.find(shipmentOrder);
            shipment.setStatus(status);
            shipmentFacade.edit(shipment);
            String statusMessage="Order "+shipment.getShipment_id()+" Has been approved \nCollection Date "+shipment.getCollection_date().getDate()+"/"+shipment.getCollection_date().getMonth()+"/"+2023;
            
            
            SendMail.sendMail(shipment.getClient().getEmail(), statusMessage);
            
            request.getRequestDispatcher("validatedStatus.jsp").forward(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(StatusOrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

   

}
