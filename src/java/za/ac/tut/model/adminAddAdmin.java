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
import javax.servlet.http.HttpSession;
import za.ac.tut.business.AdministratorFacadeLocal;
import za.ac.tut.business.DriverFacadeLocal;
import za.ac.tut.entity.Administrator;
import za.ac.tut.entity.Driver;
import za.ac.tut.logic.ValidateID;

/**
 *
 * @author Linda
 */
public class adminAddAdmin extends HttpServlet {

 
    @EJB
    private AdministratorFacadeLocal adminFacade;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {






String name = request.getParameter("name"); //1
 String id_no = request.getParameter("id_no"); //4
 String password = request.getParameter("password");//7
String optionUser=request.getParameter("access");
        Administrator admin = new Administrator();
       

   
            admin.setEmployee_id(Integer.parseInt(id_no));
            admin.setAccess_level(optionUser);
            admin.setPassword(password);
            admin.setUsername(name);

              adminFacade.create(admin);

            RequestDispatcher disp = request.getRequestDispatcher("adminAddAdmin.jsp");
            disp.forward(request, response);
     

  }

}
