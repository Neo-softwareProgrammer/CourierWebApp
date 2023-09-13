package za.ac.tut.model;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.ClientFacadeLocal;
import za.ac.tut.entity.Client;

/**
 *
 * @author User
 */
public class EditUserDetails extends HttpServlet {

    @EJB
    private ClientFacadeLocal clientFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Client client = (Client)session.getAttribute("clientUser");
        
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        
        
        client.setEmail(email);
        client.setPhone(phone);
        client.setAddress(address);
        client.setPassword(password);
        
        clientFacade.edit(client);
      
        session.setAttribute("clientUser", clientFacade.find(client.getId()));
    
        
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
        
    }
}
