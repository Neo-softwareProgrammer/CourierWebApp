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
import za.ac.tut.business.ClientFacadeLocal;
import za.ac.tut.entity.Client;

/**
 *
 * @author Linda
 */
public class ClientViewServlet extends HttpServlet {

@EJB
private ClientFacadeLocal clientFacade;  

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Client> clientList=(List<Client>) clientFacade.findAll();
        request.setAttribute("clientList", clientList);

        RequestDispatcher disp=request.getRequestDispatcher("ClientView.jsp");
        disp.forward(request, response);
    }


}
