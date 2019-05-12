package com.conexia.lamejorcocina.negocio;

import com.conexia.lamejorcocina.entities.Factura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos
 */
@Local
public interface facturaNegocioLocal {

    List<Factura> getFacturas();

    Factura getFactura(int idFactura);
 
    public List<Object> consultarSumaTotalFacturadoCamarero();
    
    public List<Object> consultarSumaSuperiorCliente();
    
}
