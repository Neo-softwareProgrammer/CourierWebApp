package za.ac.tut.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.Receipt;

/**
 *
 * @author Sboja
 */
@Stateless
public class ReceiptFacade extends AbstractFacade<Receipt> implements ReceiptFacadeLocal {

    @PersistenceContext(unitName = "Door2DoorCourierPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReceiptFacade() {
        super(Receipt.class);
    }
    
}
