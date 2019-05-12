package com.conexia.lamejorcocina.negocio;

import com.conexia.lamejorcocina.entities.Factura;
import com.conexia.lamejorcocina.persistence.FacturaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos
 */
@Stateless
public class facturaNegocio implements facturaNegocioLocal {

    @EJB
    private FacturaFacadeLocal facturaFacade;

    @Override
    public List<Factura> getFacturas() {
        return facturaFacade.findAll();
    }

    @Override
    public Factura getFactura(int idFactura) {
        return facturaFacade.find(idFactura);
    }

    @Override
    public List<Object>  consultarSumaTotalFacturadoCamarero() {
        return facturaFacade.consultarSumaTotalFacturadoCamarero();
    }

    @Override
    public List<Object> consultarSumaSuperiorCliente() {
        return facturaFacade.consultarSumaSuperiorCliente();
    }
    
}
