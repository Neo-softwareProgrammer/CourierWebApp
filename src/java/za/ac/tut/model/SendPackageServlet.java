package za.ac.tut.model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import za.ac.tut.business.ShipmentFacadeLocal;
import za.ac.tut.entity.Client;
import za.ac.tut.entity.Shipment;
import za.ac.tut.logic.OrderDetail;

/**
 *
 * @author Sboja
 */
public class SendPackageServlet extends HttpServlet {

 

    @EJB
    private ShipmentFacadeLocal shipmentFacade;
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        int idInc = idInc();
        String packageID = "DTD" + idInc;

        List<Shipment> shpmntList = shipmentFacade.findAll();

        if (!clientExiShipment(packageID, shpmntList)) {

            String desc = request.getParameter("desc");
            int size=Integer.parseInt(request.getParameter("size"));
            int weight=Integer.parseInt(request.getParameter("weight"));
            
            String packageDesc=desc+","+size+","+weight;
            
            String serviceType = request.getParameter("serviceType");
            String status = "waiting approval";
            Shipment shp = new Shipment();

            try {
                Date collection_date = new SimpleDateFormat("yyyy-MM-dd")
                        .parse(request.getParameter("collection_date"));

                shp.setId(packageID);
                shp.setClient((Client) session.getAttribute("clientUser"));
                shp.setDescription(packageDesc);
                shp.setService_req(serviceType);
                shp.setStatus(status);
                shp.setCollection_date(collection_date);
                shp.setType("Collection");
                shp.setJobAllocation("NOT ALLOCATED");

                shipmentFacade.create(shp);
                
               
                double totalAmount;
                String[] data = new String[3];
                data = packageDesc.split(",");
                if (Double.parseDouble(data[1]) > 50.0) {
                    totalAmount = Double.parseDouble(data[1]) + 500.0 + (500.0 * 0.14);
                } else {
                    totalAmount = Double.parseDouble(data[1]) + 200.0 + (200.0 * 0.14);
                }

                Client client = (Client) session.getAttribute("clientUser");

                OrderDetail order = new OrderDetail(packageID, client.getId(),
                        String.valueOf(totalAmount));
                
                
                session.setAttribute("order", order);
                session.setAttribute("package", shp);

                request.getRequestDispatcher("new_order.jsp").forward(request, response);

            } catch (ParseException ex) {

            }

        } else {
            response.sendRedirect("SendPackageServlet.do");
        }
    }

    public boolean clientExiShipment(String shipID, List<Shipment> myList) {
        boolean valid = false;
        for (int i = 0; i < myList.size(); i++) {

            Shipment get = myList.get(i);

            if (shipID.equalsIgnoreCase(get.getId())) {
                valid = true;
            }
        }
        return valid;
    }

    public int idInc() {
        return (int) Math.floor(Math.random() * (99999));
    }
}
