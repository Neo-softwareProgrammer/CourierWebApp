/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author User
 */
public class TakeJob extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipmentFacade;

   

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      HttpSession session =request.getSession();
      int jobNumber = Integer.parseInt(request.getParameter("job").toString())-1;
      
          
       List<Shipment> myJobs=(List<Shipment>) session.getAttribute("listjobs");
       
       String iDdate=myJobs.get(jobNumber).getCollection_date().toString();
        System.out.println(iDdate);
       
       if(!iDdate.isEmpty()){
       Shipment jobTaken=new Shipment();
             jobTaken=myJobs.get(jobNumber);
       session.setAttribute("jobTaken",jobTaken);
       request.getRequestDispatcher("seeJobTaken.jsp").forward(request, response);    
       }
       
    }


}
