package za.ac.tut.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


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
import javax.servlet.http.HttpSession;
import za.ac.tut.business.ClientFacadeLocal;

import za.ac.tut.entity.Client;


/**
 *
 * @author Linda
 */
public class AllClientsView extends HttpServlet {


    

    @EJB
    private ClientFacadeLocal clientFacade;
 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
      
        HttpSession session = request.getSession(true);


            List<Client> clients = clientFacade.findAll();
      
            session.setAttribute("clients", clients);
            String url="ClientView.jsp";

 RequestDispatcher dispatcher = request.getRequestDispatcher(url);
dispatcher.forward(request, response);
    }

}
