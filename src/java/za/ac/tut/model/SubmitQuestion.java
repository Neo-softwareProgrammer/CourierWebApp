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
import za.ac.tut.business.EnquiriesFacade;
import za.ac.tut.business.EnquiriesFacadeLocal;
import za.ac.tut.entity.Enquiries;

/**
 *
 * @author Linda
 */
public class SubmitQuestion extends HttpServlet {
@EJB
private EnquiriesFacadeLocal efl;



   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String message= request.getParameter("message");
       String email= request.getParameter("email");
       String fullname=request.getParameter("fname");
       String status="unread";


        Enquiries enquiries= new Enquiries();
        enquiries.setClient_email(email);
        enquiries.setFullname(fullname);
        enquiries.setMessage(message);
        enquiries.setStatus(status);

        efl.create(enquiries);
        RequestDispatcher disp =  request.getRequestDispatcher("index.html");
        disp.forward(request, response);




         

        
    }

  

}
