package za.ac.tut.model;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
public class RemoveOrderServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipmentFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Shipment shipment = (Shipment) session.getAttribute("shipment");
        
        shipmentFacade.remove(shipment);

        request.setAttribute("outcome", "Order Successfully Cancelled. "
                + "For any Queries regarding refunds, please use queries box.");

        RequestDispatcher rd = request.getRequestDispatcher("ConfirmCancel.jsp");
        rd.include(request, response);

    }
}
