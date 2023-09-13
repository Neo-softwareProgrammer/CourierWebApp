/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.ClientFacadeLocal;
import za.ac.tut.business.EnquiriesFacadeLocal;
import za.ac.tut.entity.Client;
import za.ac.tut.entity.Enquiries;
import za.ac.tut.entity.Shipment;

/**
 *
 * @author Eddie Shubane
 */
public class enquiriesHistoryServlet extends HttpServlet {

    @EJB
    private EnquiriesFacadeLocal enquiriesFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Enquiries> enquiryList = new ArrayList<>();

        Client client = (Client) session.getAttribute("clientUser");

        if (confirmEquires(client.getEmail())) {

            List<Enquiries> allShipments = enquiriesFacade.findAll();
            for (int i = 0; i < allShipments.size(); i++) {
                Enquiries get = allShipments.get(i);
                if (get.getClient_email() == client.getEmail()) {
                    enquiryList.add(get);
                }

            }

            session.setAttribute("enquiries", enquiryList);

            request.getRequestDispatcher("enquiriesHistory.jsp").forward(request, response);
        
        
        }else{
        
        request.getRequestDispatcher("noHistory.jsp").forward(request, response);}
    

    }

    public boolean confirmEquires(String email) {
        boolean valid = false;

        List<Enquiries> myList = enquiriesFacade.findAll();
        for (int i = 0; i < myList.size(); i++) {
            Enquiries get = myList.get(i);
            if (email.equals(get.getClient_email())) {
                valid = true;
            }
        }
        return valid;
    }
}
