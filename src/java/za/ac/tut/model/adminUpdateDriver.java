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
import javax.servlet.http.HttpSession;
import za.ac.tut.business.DriverFacadeLocal;
import za.ac.tut.entity.Driver;
import za.ac.tut.logic.ValidateID;

/**
 *
 * @author Linda
 */
public class adminUpdateDriver extends HttpServlet {

     @EJB
    private DriverFacadeLocal driverFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String name = request.getParameter("name"); //1
        String surname = request.getParameter("surname"); //2
        String email = request.getParameter("email"); //      3
        String id_no = request.getParameter("id_no"); //4
        String phone = request.getParameter("phone");//5
        String address = request.getParameter("address");//6
        String password = request.getParameter("password");//7
        String image = request.getParameter("license");

        Driver driver = new Driver();
        ValidateID validateID = new ValidateID();

        if (validateID.validateID(id_no)) {
            driver.setDriver_id(id_no);
            driver.setName(name);
            driver.setDriver_surname(surname);
            driver.setEmail(email);
            driver.setPhone(phone);
            driver.setAddress(address);
            driver.setPassword(password);
            driver.setImage(image.getBytes());

            driverFacade.edit(driver);

            RequestDispatcher disp = request.getRequestDispatcher("adminUpdateDriver.jsp");
            disp.forward(request, response);
          }
        }
}
