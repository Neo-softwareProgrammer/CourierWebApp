/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.business.AdministratorFacadeLocal;
import za.ac.tut.business.ClientFacadeLocal;
import za.ac.tut.business.DriverFacadeLocal;
import za.ac.tut.entity.Administrator;
import za.ac.tut.entity.Client;
import za.ac.tut.entity.Driver;

/**
 *
 * @author Linda
 */
public class ViewAll extends HttpServlet {
@EJB
private ClientFacadeLocal clientFacade;
@EJB
private AdministratorFacadeLocal adminFacade;
@EJB
private DriverFacadeLocal driverFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  String userType = request.getParameter("userType");
    if(userType.equals("Client")){
      



        }else if(userType.equals("Driver")){
       

   
    
        }else if(userType.equals("Administrator")){
               

   
        
        }else if(userType.equals("ALL")){

       
    }

}

}
