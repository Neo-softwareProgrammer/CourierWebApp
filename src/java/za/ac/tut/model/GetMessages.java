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
import javax.servlet.http.HttpSession;
import za.ac.tut.business.EnquiriesFacadeLocal;
import za.ac.tut.entity.Enquiries;

/**
 *
 * @author Linda
 */
public class GetMessages extends HttpServlet {

@EJB
private EnquiriesFacadeLocal enquiriesFacade;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Enquiries> msgListAll=( List<Enquiries>)enquiriesFacade.findAll();
        List<Enquiries> msgListRead= new ArrayList<Enquiries>();
       List<Enquiries> msgListUnRead=new ArrayList<Enquiries>();
        session.setAttribute("msgListAll", msgListAll);
        for (int i = 0; i < msgListAll.size(); i++) {
            if(msgListAll.get(i).getStatus().equals("unread")){
            msgListUnRead.add(msgListAll.get(i));
            }else{
            msgListRead.add(msgListAll.get(i));
            }
            
        }
          session.setAttribute("msgListRead", msgListRead);
          session.setAttribute("msgListUnRead", msgListUnRead);

           RequestDispatcher disp = request.getRequestDispatcher("UnReadMsgsPage.jsp");
           disp.forward(request, response);

 
    }

  

}
