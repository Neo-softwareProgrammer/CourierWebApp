package za.ac.tut.business;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Receipt;

/**
 *
 * @author Sboja
 */
@Local
public interface ReceiptFacadeLocal {

    void create(Receipt receipt);

    void edit(Receipt receipt);

    void remove(Receipt receipt);

    Receipt find(Object id);

    List<Receipt> findAll();

    List<Receipt> findRange(int[] range);

    int count();
    
}
