/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class AdminViewServlet extends HttpServlet {

 @EJB
private AdministratorFacadeLocal administratorFacade;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Administrator> adminList =(List<Administrator>) administratorFacade.findAll();
        request.setAttribute("adminList", adminList);

       RequestDispatcher disp=request.getRequestDispatcher("AdminView.jsp");
       disp.forward(request, response);
    }


}
