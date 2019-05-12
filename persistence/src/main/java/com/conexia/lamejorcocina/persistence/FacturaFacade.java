package com.conexia.lamejorcocina.persistence;

import com.conexia.lamejorcocina.entities.Factura;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> implements FacturaFacadeLocal {

    private final static Logger LOGGER = Logger.getLogger("FacturaFacade");

    @PersistenceContext(unitName = "lamejorcocinaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }

    @Override
    public List<Object> consultarSumaTotalFacturadoCamarero() {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select  *, sum(importe) from factura f  ");
            sql.append("left outer join detallefactura d on f.idFactura = d.idFactura ");
            sql.append("RIGHT  outer join camarero c on f.idCamarero = c.idCamarero group by (f.idFactura) ");
            Query query = em.createNativeQuery(sql.toString());
            List<Object> listaResultado = query.getResultList();
            return listaResultado;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "No existen datos");
        }

        return new ArrayList<Object>();
    }

    @Override
    public List<Object> consultarSumaSuperiorCliente() {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select  c.nombre,c.apellido1,c.apellido2, importe from factura f ");
            sql.append("left outer join detallefactura d on f.idFactura = d.idFactura  ");
            sql.append("RIGHT  outer join cliente c on f.idCliente = c.idCliente and d.importe > 100000  group by (f.idFactura); ");
            Query query = em.createNativeQuery(sql.toString());
            List<Object> listaResultado = query.getResultList();
            return listaResultado;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "No existen datos");
        }
        return new ArrayList<Object>();
    }

}
