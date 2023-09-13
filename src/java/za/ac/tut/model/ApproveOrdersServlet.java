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
import za.ac.tut.business.ShipmentFacadeLocal;
import za.ac.tut.entity.Shipment;

/**
 *
 * @author Eddie Shubane
 */
public class ApproveOrdersServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipmentFacade;

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session= request.getSession();
        
        List<Shipment> shipmentList=new ArrayList<>();
        
        for (int i = 0; i < shipmentFacade.findAll().size(); i++) {
            Shipment get=shipmentFacade.findAll().get(i);
            if(!get.getStatus().equals("approved")){
            shipmentList.add(get);
            }
        }
        session.setAttribute("shipmentlist", shipmentList);
        request.getRequestDispatcher("ApproveOrders.jsp").forward(request, response);
        
        
    }

    

}
