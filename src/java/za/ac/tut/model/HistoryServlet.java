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
import za.ac.tut.business.ShipmentFacadeLocal;
import za.ac.tut.entity.Client;
import za.ac.tut.entity.Enquiries;
import za.ac.tut.entity.Shipment;

/**
 *
 * @author Eddie Shubane
 */
public class HistoryServlet extends HttpServlet {

    @EJB
    private EnquiriesFacadeLocal enquiriesFacade;

    @EJB
    private ShipmentFacadeLocal shipmentFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Shipment> shiplist=new ArrayList<>();

        Client client = (Client) session.getAttribute("clientUser");
        
 
        
        if (confirmShipment(client.getId())) {
            
            

            
            List<Shipment> allShipments=shipmentFacade.findAll();
        
            for (int i = 0; i < allShipments.size(); i++) {
                Shipment get = allShipments.get(i);
                if(get.getClient().getId()==client.getId()){
                    shiplist.add(get);
                }
                
            }
            
            session.setAttribute("ship", shiplist);
            
        
    
        request.getRequestDispatcher("shipmentHistory.jsp").forward(request, response);
        }else{
        
        request.getRequestDispatcher("noHistory.jsp").forward(request, response);
        
        }
    }
    

    public boolean confirmShipment(String id) {
        boolean valid = false;

        List<Shipment> myList = shipmentFacade.findAll();
        for (int i = 0; i < myList.size(); i++) {
            Shipment get = myList.get(i);
            if (id.equals(get.getClient().getId())) {
                valid = true;
            }
        }
        return valid;
    }

    public Shipment getShipment(String id) {

        Shipment shipment = new Shipment();
        List<Shipment> myList = shipmentFacade.findAll();
        for (int i = 0; i < myList.size(); i++) {
            Shipment get = myList.get(i);
            if (id.equals(get.getClient().getId())) {
                shipment = get;
                break;
            }
        }
        return shipment;
    }

}
