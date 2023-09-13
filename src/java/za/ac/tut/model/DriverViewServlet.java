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
import za.ac.tut.business.DriverFacadeLocal;
import za.ac.tut.entity.Driver;

/**
 *
 * @author Linda
 */
public class DriverViewServlet extends HttpServlet {
@EJB
private DriverFacadeLocal driverFacade;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

           List<Driver> driverList=driverFacade.findAll();
           request.setAttribute("driverList", driverList);

           RequestDispatcher disp = request.getRequestDispatcher("DriverView.jsp");
           disp.forward(request, response);
     
    }



}
