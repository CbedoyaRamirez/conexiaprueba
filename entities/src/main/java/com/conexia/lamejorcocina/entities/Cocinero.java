
package com.conexia.lamejorcocina.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "cocinero")
@NamedQueries({
    @NamedQuery(name = "Cocinero.findAll", query = "SELECT c FROM Cocinero c")})
public class Cocinero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCocinero")
    private Integer idCocinero;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @OneToMany(mappedBy = "idCocinero", fetch = FetchType.LAZY)
    private List<Detallefactura> detallefacturaList;

    public Cocinero() {
    }

    public Cocinero(Integer idCocinero) {
        this.idCocinero = idCocinero;
    }

    public Integer getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(Integer idCocinero) {
        this.idCocinero = idCocinero;
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

    public List<Detallefactura> getDetallefacturaList() {
        return detallefacturaList;
    }

    public void setDetallefacturaList(List<Detallefactura> detallefacturaList) {
        this.detallefacturaList = detallefacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCocinero != null ? idCocinero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cocinero)) {
            return false;
        }
        Cocinero other = (Cocinero) object;
        if ((this.idCocinero == null && other.idCocinero != null) || (this.idCocinero != null && !this.idCocinero.equals(other.idCocinero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.lamejorcocina.entities.Cocinero[ idCocinero=" + idCocinero + " ]";
    }
    
}
