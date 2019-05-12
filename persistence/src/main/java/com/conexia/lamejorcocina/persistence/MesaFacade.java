package com.conexia.lamejorcocina.persistence;

import com.conexia.lamejorcocina.entities.Mesa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Stateless
public class MesaFacade extends AbstractFacade<Mesa> implements MesaFacadeLocal {

    @PersistenceContext(unitName = "lamejorcocinaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MesaFacade() {
        super(Mesa.class);
    }
    
}
