/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.logic;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author User
 */
public class SendMail 
       
        
{
  
    public static void sendMail(String recepient,String subM) throws MessagingException{
        System.out.println("Preparing to send email");
        Properties properties=new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccount="lindajusticesibeko24@gmail.com";
        String password="vzptvrclduzakmqn";
        
        Session session=Session.getInstance(properties,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               
                return new PasswordAuthentication(myAccount, password);
            }
            
        }) ;  
     
        
       
        Message message=new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccount));
        
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
        message.setSubject("Door2DoorCourier");
        message.setText(subM);
                

        
        
        Transport.send(message);
      
        
        System.out.println("Message sent succesfully");

        
    }

}
