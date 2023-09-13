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
import za.ac.tut.business.DriverFacadeLocal;
import za.ac.tut.entity.Driver;
import za.ac.tut.entity.Shipment;

/**
 *
 * @author User
 */
public class showAllJobs extends HttpServlet {

    @EJB
    private DriverFacadeLocal driverFacade;

   
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session=request.getSession();
        Driver myDriver=(Driver) session.getAttribute("driverUser");
      
        
        
        List<Shipment> myJobs=driverFacade.find(myDriver.getDriver_id()).getJobs();
      
        
        session.setAttribute("listjobs", myJobs);
                
        request.getRequestDispatcher("DriverJobs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
