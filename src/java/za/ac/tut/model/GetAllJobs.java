/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import za.ac.tut.business.DriverFacadeLocal;
import za.ac.tut.business.ShipmentFacadeLocal;
import za.ac.tut.entity.Driver;
import za.ac.tut.entity.Shipment;

/**
 *
 * @author User
 */
public class GetAllJobs extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipmentFacade;

    @EJB
    private DriverFacadeLocal driverFacade;

    
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession session=request.getSession();
      
      List<Shipment> shpsAll=shipmentFacade.findAll();
      List<Driver> allDrivers=driverFacade.findAll();
      
     
      
      List<Shipment> jobsnotAllocated=new ArrayList<>();
      
        for (int i = 0; i < shpsAll.size(); i++) {
            Shipment get = shpsAll.get(i);
            if(get.getJobAllocation().equalsIgnoreCase("NOT ALLOCATED")){
                jobsnotAllocated.add(get);
            }
            
        }
        
      session.setAttribute("drivers",allDrivers);
      session.setAttribute("jobsA", jobsnotAllocated);
      
      request.getRequestDispatcher("AllocateJobs.jsp").forward(request, response);
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    

}
