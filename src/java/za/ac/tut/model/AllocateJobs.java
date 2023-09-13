/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class AllocateJobs extends HttpServlet {


    @EJB
    private ShipmentFacadeLocal shipmentFacade;

    @EJB
    private DriverFacadeLocal driverFacade;
    
    
    
    
    
    

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        
        String driverID=request.getParameter("driverID");
        String jobID=request.getParameter("jobID");
        
        List<Shipment> jobsnotAllocated=(List<Shipment>) session.getAttribute("jobsA");
        List<Driver> allDrivers=(List<Driver>) session.getAttribute("drivers");
        
        Driver myDriver=allDrivers.get(Integer.parseInt(driverID));
        List<Shipment> myShips=myDriver.getJobs();
      
      myShips.add(jobsnotAllocated.get(Integer.parseInt(jobID)));
      myDriver.setJobs(myShips);
      
      Shipment allocateJob=jobsnotAllocated.get(Integer.parseInt(jobID));
      allocateJob.setJobAllocation("ALLOCATED");
      shipmentFacade.edit(allocateJob);
      
      driverFacade.edit(myDriver);
      
      
      request.getRequestDispatcher("JobAllocationOutcome.jsp").forward(request, response);
        
        
        
        
    
    }


}
