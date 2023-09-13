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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.business.ClientFacadeLocal;
import za.ac.tut.business.DriverFacadeLocal;
import za.ac.tut.entity.Client;
import za.ac.tut.entity.Driver;

/**
 *
 * @author Linda
 */
public class SearchDriver extends HttpServlet {
@EJB
private DriverFacadeLocal driverFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String id= request.getParameter("driverId");
            Driver driver=driverFacade.find(id);
          
           if(driver!=null){
               List<Driver>drivertList= new ArrayList<Driver>();
        
               drivertList.add(driver);
               request.setAttribute("drivertList", drivertList);
               request.getRequestDispatcher("DriverView.jsp").forward(request, response);
              
              }else{
    request.setAttribute("error",id+": driver id does not exist");
                RequestDispatcher rd= request.getRequestDispatcher("adminViewUsers.jsp");
                rd.include(request, response);

             }

            
            
    }

}
