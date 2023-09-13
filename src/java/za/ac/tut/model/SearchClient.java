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
import za.ac.tut.entity.Client;

/**
 *
 * @author Linda
 */
public class SearchClient extends HttpServlet {

@EJB
private ClientFacadeLocal clientFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String id= request.getParameter("clientId");
            Client client=clientFacade.find(id);
          
           if(client!=null){
               List<Client>clientList= new ArrayList<Client>();
        
               clientList.add(client);
               request.setAttribute("clientList", clientList);
               request.getRequestDispatcher("ClientView.jsp").forward(request, response);
              
              }else{
    request.setAttribute("error",id+": client id does not exist");
                RequestDispatcher rd= request.getRequestDispatcher("adminViewUsers.jsp");
                rd.include(request, response);

             }

            
            
    }

   
}
