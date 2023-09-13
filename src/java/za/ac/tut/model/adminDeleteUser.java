/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
public class adminDeleteUser extends HttpServlet {

@EJB
private ClientFacadeLocal clientFacade;
@EJB
private AdministratorFacadeLocal adminFacade;
@EJB
private DriverFacadeLocal driverFacade;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userType = request.getParameter("optionUser");
        String id = request.getParameter("id_no");

        if(userType.equals("Client")){
      
        Client client=clientFacade.find(id);

        if(client!=null){
        clientFacade.remove(client);
        }

        }else if(userType.equals("Driver")){
                Driver driver=driverFacade.find(id);

        if(driver!=null){
        driverFacade.remove(driver);
        }
        }else if(userType.equals("Administrator")){
                Administrator admin=adminFacade.find(Integer.parseInt(id));

        if(admin!=null){
        adminFacade.remove(admin);
        
        }

       }

       RequestDispatcher disp=request.getRequestDispatcher("adminDeleteUser.jsp");
       disp.forward(request, response);
    }
}
