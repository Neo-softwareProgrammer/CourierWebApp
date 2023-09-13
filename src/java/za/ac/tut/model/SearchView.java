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
import javax.security.auth.message.callback.PrivateKeyCallback;
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
public class SearchView extends HttpServlet {

    @EJB
    private ClientFacadeLocal clientFacade;
    @EJB
    private AdministratorFacadeLocal adminFacade;
    @EJB
    private DriverFacadeLocal driverFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userLevel = request.getParameter("accessLVL");
        String id = request.getParameter("id_no");
        String url = "";

        if (userLevel.equals("Client")) {
            Client client = clientFacade.find(id);
            List<Client> clients = new ArrayList<>();
            clients.add(client);
            request.setAttribute("clients", clients);
            url="ClientView.jsp";

        } else if (userLevel.equals("Driver")) {
            Driver driver = driverFacade.find(id);
            List<Driver> drivers = new ArrayList<>();
            drivers.add(driver);
            request.setAttribute("drivers", drivers);
            url="DriverView.jsp";

        } else if (userLevel.equals("Administrator")) {

            Administrator admin = adminFacade.find(Integer.parseInt(id));
            List<Administrator> admins = new ArrayList<>();
            admins.add(admin);
            request.setAttribute("admins", admins);
            url="AdminsView.jsp";

        } 
 RequestDispatcher dispatcher = request.getRequestDispatcher(url);
dispatcher.forward(request, response);
    }
   

}
