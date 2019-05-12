package com.conexia.lamejorcocina.persistence;

import com.conexia.lamejorcocina.entities.Mesa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos
 */
@Local
public interface MesaFacadeLocal {

    void create(Mesa mesa);

    void edit(Mesa mesa);

    void remove(Mesa mesa);

    Mesa find(Object id);

    List<Mesa> findAll();

    List<Mesa> findRange(int[] range);

    int count();
    
}
