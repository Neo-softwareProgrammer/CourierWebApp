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
import za.ac.tut.business.AdministratorFacadeLocal;
import za.ac.tut.business.ClientFacadeLocal;
import za.ac.tut.entity.Administrator;
import za.ac.tut.entity.Client;

/**
 *
 * @author Linda
 */
public class SearchAdmin extends HttpServlet {

 @EJB
private AdministratorFacadeLocal adminFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String id= request.getParameter("adminId");
            Administrator admin=adminFacade.find(Integer.parseInt(id));
          
           if(admin!=null){
               List<Administrator>adminList= new ArrayList<Administrator>();
        
               adminList.add(admin);
               request.setAttribute("adminList", adminList);
               request.getRequestDispatcher("AdminView.jsp").forward(request, response);
              
              }else{
                request.setAttribute("error",id+": admin id does not exist");
                RequestDispatcher rd= request.getRequestDispatcher("adminViewUsers.jsp");
                rd.include(request, response);

             }

            
            
    }

}
