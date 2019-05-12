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
@Table(name = "camarero")
@NamedQueries({
    @NamedQuery(name = "Camarero.findAll", query = "SELECT c FROM Camarero c")})
public class Camarero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCamarero")
    private Integer idCamarero;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido1")
    private String apellido1;
    
    @Column(name = "apellido2")
    private String apellido2;

    public Camarero() {
    }

    public Camarero(Integer idCamarero) {
        this.idCamarero = idCamarero;
    }

    public Integer getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(Integer idCamarero) {
        this.idCamarero = idCamarero;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCamarero != null ? idCamarero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camarero)) {
            return false;
        }
        Camarero other = (Camarero) object;
        if ((this.idCamarero == null && other.idCamarero != null) || (this.idCamarero != null && !this.idCamarero.equals(other.idCamarero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.lamejorcocina.entities.Camarero[ idCamarero=" + idCamarero + " ]";
    }
    
}
