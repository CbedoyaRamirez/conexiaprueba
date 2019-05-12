package com.conexia.lamejorcocina.persistence;

import com.conexia.lamejorcocina.entities.Camarero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Stateless
public class CamareroFacade extends AbstractFacade<Camarero> implements CamareroFacadeLocal {

    @PersistenceContext(unitName = "lamejorcocinaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CamareroFacade() {
        super(Camarero.class);
    }
    
}
