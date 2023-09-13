/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.ClientFacadeLocal;
import za.ac.tut.business.ReceiptFacadeLocal;
import za.ac.tut.business.ShipmentFacadeLocal;
import za.ac.tut.entity.Client;
import za.ac.tut.entity.Receipt;
import za.ac.tut.entity.Shipment;
import za.ac.tut.logic.OrderDetail;

/**
 *
 * @author User
 */
public class CashPayment extends HttpServlet {
    @EJB
    private ShipmentFacadeLocal shipmentFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private ReceiptFacadeLocal receiptFacade;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession();

        Shipment shpmnt = (Shipment) session.getAttribute("package");
        OrderDetail order = (OrderDetail) session.getAttribute("order");
        Date dateFilled = new Date();
        String deliveryAddress = request.getParameter("deliveryAddress");
        
        Client client = clientFacade.find(order.getClientID());
        
        Receipt receipt = generateReceipt(shpmnt,Double.parseDouble(order.getTotalAmount()),dateFilled,client);
        receiptFacade.create(receipt);
        
        shpmnt.setDeliveryAddress(deliveryAddress);
        shipmentFacade.edit(shpmnt);
        
        request.setAttribute("receipt", receipt);
        request.setAttribute("deliveryAddress", deliveryAddress);
        request.getRequestDispatcher("receipt_cash.jsp").forward(request, response);
       
    }
        private Receipt generateReceipt(Shipment shpmnt, double totalAmount, Date dateFilled,
            Client client) {
        
        Receipt receipt = new Receipt();
        receipt.setShipment(shpmnt);
        receipt.setAmountPaid(totalAmount);
        receipt.setDateFiled(dateFilled);
        receipt.setClient(client);
        
        return receipt;
    }


}
