/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.servlet.http.HttpSession;
import za.ac.tut.business.AdministratorFacadeLocal;
import za.ac.tut.business.ClientFacadeLocal;
import za.ac.tut.business.DriverFacadeLocal;
import za.ac.tut.entity.Administrator;
import za.ac.tut.entity.Client;
import za.ac.tut.entity.Driver;


/**
 *
 * @author User
 */
public class login_servlet extends HttpServlet {

    @EJB
    private AdministratorFacadeLocal administratorFacade;

    @EJB
    private DriverFacadeLocal driverFacade;

    @EJB
    private ClientFacadeLocal clientFacade;
    
    


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        
        String id_no= request.getParameter("id_no");
        String password=request.getParameter("password");
        String optionUser=request.getParameter("optionUser");
        
        
       //List<Client> myClientList= clientFacade.findAll();
        
       
       if(optionUser.equals("Client")){
          
           if(clientExi(id_no, password)){
               Client myClinet=clientFacade.find(id_no);
               session.setAttribute("clientUser", myClinet);
               request.getRequestDispatcher("welcome.jsp").forward(request, response);
           }else{
                request.setAttribute("error", "invalid username or password");
                RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
           }
           
           
       }else if(optionUser.equals("Driver")){
            System.out.println("Driver");
           if(driverExi(id_no, password)){
               Driver myDriver=driverFacade.find(id_no);
               session.setAttribute("driverUser", myDriver);
               request.getRequestDispatcher("DriverWelcomePage.jsp").forward(request, response);
           }else{
            request.setAttribute("error", "invalid username or password");
                RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
       }
      }else if(optionUser.equals("Administrator")){

           
               Administrator myAdmin=administratorFacade.find(Integer.parseInt(id_no));
               if(myAdmin!=null){
               session.setAttribute("adminUser",myAdmin);
               String url ="";
               if("suadmin".equals(myAdmin.getAccess_level())){
                 url="suadmin.jsp";
               }else if("enqadmin".equals(myAdmin.getAccess_level())){
               url="enqadmin.jsp";
               }
                request.getRequestDispatcher(url).forward(request, response);
           }else{
               
                request.setAttribute("error", "INVAILD CREDENTIALS");
                RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
           }
      }
    }
    public boolean clientExi(String id_no,String password){
        boolean valid=false;
        
        List<Client> myList=clientFacade.findAll();
         for (int i = 0; i < myList.size(); i++) {
            Client get = myList.get(i);
            if(id_no.equals(get.getId())&&password.equals(get.getPassword())){
                valid=true;
            }
         }
        return valid;
    }
        public boolean driverExi(String id_no,String password){
        boolean valid=false;
        
        List<Driver> myList=driverFacade.findAll();
         for (int i = 0; i < myList.size(); i++) {
            Driver get = myList.get(i);
            if(id_no.equals(get.getId())&&password.equals(get.getPassword())){
                valid=true;
            }
         }
        return valid;
    }

  

}
