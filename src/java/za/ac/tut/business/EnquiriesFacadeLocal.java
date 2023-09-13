/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.business;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Enquiries;

/**
 *
 * @author User
 */
@Local
public interface EnquiriesFacadeLocal {

    void create(Enquiries enquiries);

    void edit(Enquiries enquiries);

    void remove(Enquiries enquiries);

    Enquiries find(Object id);

    List<Enquiries> findAll();

    List<Enquiries> findRange(int[] range);

    int count();
    
}
