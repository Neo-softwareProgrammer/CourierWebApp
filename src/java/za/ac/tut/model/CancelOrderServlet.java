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
public class CancelOrderServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipmentFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String shipmentId = request.getParameter("shipmentId");

        Shipment shipment = shipmentFacade.find(shipmentId);

        if (shipment != null) {
            session.setAttribute("shipment", shipment);
            request.getRequestDispatcher("ConfirmCancel.jsp").forward(request, response);

        } else {
            request.setAttribute("error", "Package Not Found! Enter a valid package id.");
            RequestDispatcher rd = request.getRequestDispatcher("CancelOrder.jsp");
            rd.include(request, response);
        }
    }
}
