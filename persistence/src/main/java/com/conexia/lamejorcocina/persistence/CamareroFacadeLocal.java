package com.conexia.lamejorcocina.persistence;

import com.conexia.lamejorcocina.entities.Camarero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos
 */
@Local
public interface CamareroFacadeLocal {

    void create(Camarero camarero);

    void edit(Camarero camarero);

    void remove(Camarero camarero);

    Camarero find(Object id);

    List<Camarero> findAll();

    List<Camarero> findRange(int[] range);

    int count();
    
}
