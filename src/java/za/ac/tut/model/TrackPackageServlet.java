package za.ac.tut.model;

import java.io.IOException;
import java.util.List;
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
public class TrackPackageServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipmentFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String packageID = request.getParameter("packageId");

        if (found(packageID)) {

            Shipment shipment = shipmentFacade.find(packageID);

            session.setAttribute("shipment", shipment);
            request.getRequestDispatcher("PackageFound.jsp").forward(request, response);
            
        } else {
            request.setAttribute("error", "Package Not Found. Check Package ID sent to you and try again");
            RequestDispatcher rd = request.getRequestDispatcher("TrackingParcelPage.jsp");
            rd.include(request, response);
        }
    }
    public boolean found(String pId) {
        boolean found = false;
        List<Shipment> list = shipmentFacade.findAll();
        for (int i = 0; i < list.size(); i++) {
            Shipment sh = list.get(i);
            if (pId.equalsIgnoreCase(sh.getId())) {
                found = true;
            }
        }
        return found;
    }
}
