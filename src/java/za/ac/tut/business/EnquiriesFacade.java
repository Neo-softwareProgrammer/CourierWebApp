/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.Enquiries;

/**
 *
 * @author User
 */
@Stateless
public class EnquiriesFacade extends AbstractFacade<Enquiries> implements EnquiriesFacadeLocal {

    @PersistenceContext(unitName = "Door2DoorCourierPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnquiriesFacade() {
        super(Enquiries.class);
    }
    
}
