package com.conexia.lamejorcocina.persistence;

import com.conexia.lamejorcocina.entities.Cocinero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Stateless
public class CocineroFacade extends AbstractFacade<Cocinero> implements CocineroFacadeLocal {

    @PersistenceContext(unitName = "lamejorcocinaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CocineroFacade() {
        super(Cocinero.class);
    }
    
}
