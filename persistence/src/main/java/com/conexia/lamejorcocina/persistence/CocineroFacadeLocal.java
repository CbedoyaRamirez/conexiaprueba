package com.conexia.lamejorcocina.persistence;

import com.conexia.lamejorcocina.entities.Cocinero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos
 */
@Local
public interface CocineroFacadeLocal {

    void create(Cocinero cocinero);

    void edit(Cocinero cocinero);

    void remove(Cocinero cocinero);

    Cocinero find(Object id);

    List<Cocinero> findAll();

    List<Cocinero> findRange(int[] range);

    int count();
    
}
