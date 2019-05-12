package com.conexia.lamejorcocina.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFactura")
    private Integer idFactura;
    
    @Column(name = "fechaFactura")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cliente idCliente;
    
    @JoinColumn(name = "idMesa", referencedColumnName = "idMesa")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mesa idMesa;
    
    @JoinColumn(name = "idCamarero", referencedColumnName = "idCamarero")
    @ManyToOne(fetch = FetchType.LAZY)
    private Camarero idCamarero;
    
    @JoinColumn(name = "idDetalleFactura", referencedColumnName = "detallefactura")
    @ManyToOne(fetch = FetchType.LAZY)
    private Detallefactura detallefactura;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Mesa getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Mesa idMesa) {
        this.idMesa = idMesa;
    }

    public Camarero getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(Camarero idCamarero) {
        this.idCamarero = idCamarero;
    }

    public Detallefactura getDetallefactura() {
        return detallefactura;
    }

    public void setDetallefactura(Detallefactura detallefactura) {
        this.detallefactura = detallefactura;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.lamejorcocina.entities.Factura[ idFactura=" + idFactura + " ]";
    }

}
