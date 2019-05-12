package com.conexia.lamejorcocina.web;

import com.conexia.lamejorcocina.entities.Camarero;
import com.conexia.lamejorcocina.entities.Cliente;
import com.conexia.lamejorcocina.entities.Cocinero;
import com.conexia.lamejorcocina.entities.Detallefactura;
import com.conexia.lamejorcocina.entities.Factura;
import com.conexia.lamejorcocina.entities.Mesa;
import com.conexia.lamejorcocina.persistence.CamareroFacadeLocal;
import com.conexia.lamejorcocina.persistence.CocineroFacadeLocal;
import com.conexia.lamejorcocina.persistence.DetallefacturaFacadeLocal;
import com.conexia.lamejorcocina.persistence.FacturaFacadeLocal;
import com.conexia.lamejorcocina.persistence.MesaFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Carlos
 */
@Named(value = "facturaMB")
@RequestScoped
public class FacturaMB {

    //Seccion EJB

    @EJB
    private DetallefacturaFacadeLocal detallefacturaFacade;

    @EJB
    private CocineroFacadeLocal cocineroFacade;

    @EJB
    private MesaFacadeLocal mesaFacade;

    @EJB
    private CamareroFacadeLocal camareroFacade;

    @EJB
    private FacturaFacadeLocal facturaFacade;

    //Seccion atributos pagina
    private Integer numeroFactura;

    private Integer numeroIdCliente;

    private String nombre;

    private String apellido1;

    private String apellido2;

    private String observacion;

    private String detallePlato;

    private List<Camarero> listaCamareros;

    private List<Cocinero> listaCocineros;

    private List<Mesa> listaMesas;

    private Camarero camarero;

    private Cocinero cocinero;

    private Mesa mesa;

    private String msgNumeroFacturaGuardada;

    private String descripcionPlato;

    private Double costoPlato;

    @PostConstruct
    public void init() {
        inicializarVariables();
    }

    private void inicializarVariables() {
        listaCamareros = new ArrayList<>();
        listaMesas = new ArrayList<>();
        listaCocineros = new ArrayList<>();
        listaCamareros = camareroFacade.findAll();
        listaMesas = mesaFacade.findAll();
        listaCocineros = cocineroFacade.findAll();
    }

    public void guardarFactura() {
        if (validarEntrada()) {
            try {
                Factura factura = crearObj();
                Cliente cliente = new Cliente();
                Detallefactura detalleFactura = new Detallefactura();
                detalleFactura.setIdCocinero(cocinero);
                detalleFactura.setIdDetalleFactura(numeroFactura);
                detalleFactura.setImporte(costoPlato);
                detalleFactura.setPlato(detallePlato);
                detalleFactura.setIdFactura(numeroFactura.toString());
                cliente.setApellido1(apellido1);
                cliente.setApellido2(apellido2);
                cliente.setIdCliente(numeroIdCliente);
                cliente.setNombre(nombre);
                cliente.setObservaciones(observacion);
                factura.setIdCliente(cliente);
                factura.setIdCamarero(camarero);
                factura.setFechaFactura(new Date());
                factura.setIdMesa(mesa);
                facturaFacade.create(factura);
                detallefacturaFacade.create(detalleFactura);
                msgNumeroFacturaGuardada = numeroFactura.toString();
                reiniciarVariables();
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogFacturaGuardada').show()");
            } catch (Exception e) {
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogErrorFacturaGuardada').show()");
            }
        }
    }

    private Factura crearObj() {
        Factura factura = new Factura();
        factura.setIdFactura(numeroFactura);

        return factura;
    }

    private Boolean validarEntrada() {
        if (Objects.isNull(numeroFactura)) {
            return false;
        }
        if (nombre.trim().equals("")) {
            return false;
        }
        if (apellido1.trim().equals("")) {
            return false;
        }
        if (apellido2.trim().equals("")) {
            return false;
        }
        if (observacion.trim().equals("")) {
            return false;
        }

        return true;
    }

    public void irPaginaReporte() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/faces/reportes.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(FacturaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void reiniciarVariables() {
        numeroFactura = null;
        nombre = "";
        apellido1 = "";
        apellido2 = "";
        observacion = "";
        detallePlato = "";
        numeroIdCliente = null;
        descripcionPlato = "";
        costoPlato = null;
    }

    //SECCION GETTER - SETTERS
    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDetallePlato() {
        return detallePlato;
    }

    public void setDetallePlato(String detallePlato) {
        this.detallePlato = detallePlato;
    }

    public Integer getNumeroIdCliente() {
        return numeroIdCliente;
    }

    public void setNumeroIdCliente(Integer numeroIdCliente) {
        this.numeroIdCliente = numeroIdCliente;
    }

    public List<Camarero> getListaCamareros() {
        return listaCamareros;
    }

    public void setListaCamareros(List<Camarero> listaCamareros) {
        this.listaCamareros = listaCamareros;
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }

    public List<Mesa> getListaMesas() {
        return listaMesas;
    }

    public void setListaMesas(List<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public String getMsgNumeroFacturaGuardada() {
        return msgNumeroFacturaGuardada;
    }

    public void setMsgNumeroFacturaGuardada(String msgNumeroFacturaGuardada) {
        this.msgNumeroFacturaGuardada = msgNumeroFacturaGuardada;
    }

    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }

    public Double getCostoPlato() {
        return costoPlato;
    }

    public void setCostoPlato(Double costoPlato) {
        this.costoPlato = costoPlato;
    }

    public List<Cocinero> getListaCocineros() {
        return listaCocineros;
    }

    public void setListaCocineros(List<Cocinero> listaCocineros) {
        this.listaCocineros = listaCocineros;
    }

    public Cocinero getCocinero() {
        return cocinero;
    }

    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
    }

}
