/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.model;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.DriverFacadeLocal;
import za.ac.tut.entity.Driver;
import za.ac.tut.logic.ValidateID;

/**
 *
 * @author Eddie Shubane
 */
public class Register_driver extends HttpServlet {

    @EJB
    private DriverFacadeLocal driverFacade;


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
    
        String name= request.getParameter("name"); //1
        String surname=request.getParameter("surname"); //2
        String email=request.getParameter("email"); //      3
        String id_no=request.getParameter("id_no"); //4
        String phone=request.getParameter("phone");//5
        String address=request.getParameter("address");//6
        String password=request.getParameter("password");//7
       String image =request.getParameter("license");
       
       Driver driver=new Driver();
       ValidateID validateID=new ValidateID();
       
       
       if(validateID.validateID(id_no)){
     
           //check if the id number exists in  the database
           if(!checkForAvail(id_no)){
              
               //check if someone has the same password
               if(!emailInUse(email)){
                  driver.setDriver_id(id_no);
            driver.setName(name);
            driver.setDriver_surname(surname);
            driver.setEmail(email);
            driver.setPhone(phone);
            driver.setAddress(address);
            driver.setPassword(password);
             driver.setImage(image.getBytes());
             
             driverFacade.create(driver);
           String user="Driver";
           session.setAttribute("driverUser", driver);
            session.setAttribute("user", user);
   request.getRequestDispatcher("DriverWelcomePage.jsp").forward(request, response);
               
               
               }else{
                   //tell user email already in use
                request.setAttribute("errorEmailFound", "EMAIL ALREADY IN USE");
                RequestDispatcher rd= request.getRequestDispatcher("register_driver.jsp");
                rd.include(request, response);
               }
               
               
               
               
           }else{
               //Tell user he/she already has an account
                request.setAttribute("errorAccountFound", "ACCOUNT ALREADY EXISTS");
                RequestDispatcher rd= request.getRequestDispatcher("register_driver.jsp");
                rd.include(request, response);
                       
 
               
           }
           
           
                   }else{
            request.setAttribute("errorID", "INVAILD ID NUMBER");
                RequestDispatcher rd= request.getRequestDispatcher("register_driver.jsp");
                       rd.include(request, response);
                       
 
       }
       
       
       
       
       
     
        
        
        
        
    }
    
    public boolean checkForAvail(String id_no){
        boolean valid=false;
        List<Driver> myDriverList=driverFacade.findAll();
        
        
        for (int i = 0; i < myDriverList.size(); i++) {
            Driver get = myDriverList.get(i);
            if(id_no.equals(get.getId())){
                valid=true;
            }
        }
        
        return valid;
        
    }
     public boolean emailInUse(String email){
        boolean valid=false;
        List<Driver> myDriverList=driverFacade.findAll();
        
        
        for (int i = 0; i < myDriverList.size(); i++) {
            Driver get = myDriverList.get(i);
            if(email.equals(get.getEmail())){
                valid=true;
            }
        }
        
        return valid;
        
    }
    

    

}
