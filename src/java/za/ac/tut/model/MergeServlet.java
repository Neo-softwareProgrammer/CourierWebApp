package za.ac.tut.model;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.ShipmentFacadeLocal;
import za.ac.tut.entity.Shipment;

/**
 *
 * @author Sboja
 */
public class MergeServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipmentFacade;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Shipment shipment = (Shipment) session.getAttribute("shipment");
        String serviceType = request.getParameter("serviceType");
        String deliveryAddress = request.getParameter("deliveryAddress");
        shipment.setDeliveryAddress(deliveryAddress);
        shipment.setService_req(serviceType);
        
        shipmentFacade.edit(shipment);
        
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
