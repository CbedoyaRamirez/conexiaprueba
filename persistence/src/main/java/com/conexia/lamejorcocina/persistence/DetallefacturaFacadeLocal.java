package com.conexia.lamejorcocina.persistence;

import com.conexia.lamejorcocina.entities.Detallefactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos
 */
@Local
public interface DetallefacturaFacadeLocal {

    void create(Detallefactura detallefactura);

    void edit(Detallefactura detallefactura);

    void remove(Detallefactura detallefactura);

    Detallefactura find(Object id);

    List<Detallefactura> findAll();

    List<Detallefactura> findRange(int[] range);

    int count();
    
}
