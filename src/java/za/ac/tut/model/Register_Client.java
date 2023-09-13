package za.ac.tut.model;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.ClientFacadeLocal;
//import za.ac.tut.business.DriverFacadeLocal;
import za.ac.tut.entity.Client;
import za.ac.tut.logic.ValidateID;

/**
 *
 * @author User
 */
public class Register_Client extends HttpServlet {

    @EJB
    private ClientFacadeLocal clientFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        String name= request.getParameter("name"); //1
        String surname=request.getParameter("surname"); //2
        String email=request.getParameter("email"); //      3
        String id_no=request.getParameter("id_no"); //4
        String phone=request.getParameter("phone");//5
        String address=request.getParameter("address");//6
        String password=request.getParameter("password");//7
       
        ValidateID validate=new ValidateID();
        
        Client client=new Client();
       
        
        if(validate.validateID(id_no)){
            
            client.setName(name);
            client.setSurname(surname);
            client.setAddress(address);
            client.setPhone(phone);
            client.setId(id_no);
            client.setPassword(id_no);
            client.setPassword(password);
            client.setEmail(email);
        
            clientFacade.create(client);
        
            session.setAttribute("clientUser",client);

            RequestDispatcher disp=request.getRequestDispatcher("welcome.jsp");
            disp.forward(request, response);
        }
        else{
            request.setAttribute("errorID", "INVAILD ID NUMBER");
            
            RequestDispatcher rd= request.getRequestDispatcher("register.jsp");
            rd.include(request, response);
                       
        }   
    }
}
