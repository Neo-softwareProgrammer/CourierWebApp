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
import za.ac.tut.entity.Administrator;

/**
 *
 * @author Linda
 */
public class adminUpdateAdmin extends HttpServlet {

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

              adminFacade.edit(admin);

            RequestDispatcher disp = request.getRequestDispatcher("adminUpdateAdmin.jsp");
            disp.forward(request, response);
}
}
