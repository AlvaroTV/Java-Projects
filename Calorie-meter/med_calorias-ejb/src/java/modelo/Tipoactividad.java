/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "TIPOACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoactividad.findAll", query = "SELECT t FROM Tipoactividad t"),
    @NamedQuery(name = "Tipoactividad.findByIdactividad", query = "SELECT t FROM Tipoactividad t WHERE t.idactividad = :idactividad"),
    @NamedQuery(name = "Tipoactividad.findByDescripcion", query = "SELECT t FROM Tipoactividad t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tipoactividad.findByFactorh", query = "SELECT t FROM Tipoactividad t WHERE t.factorh = :factorh"),
    @NamedQuery(name = "Tipoactividad.findByFactorm", query = "SELECT t FROM Tipoactividad t WHERE t.factorm = :factorm")})
public class Tipoactividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDACTIVIDAD")
    private Integer idactividad;
    @Size(max = 40)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FACTORH")
    private Double factorh;
    @Column(name = "FACTORM")
    private Double factorm;

    public Tipoactividad() {
    }

    public Tipoactividad(Integer idactividad) {
        this.idactividad = idactividad;
    }

    public Integer getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Integer idactividad) {
        this.idactividad = idactividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getFactorh() {
        return factorh;
    }

    public void setFactorh(Double factorh) {
        this.factorh = factorh;
    }

    public Double getFactorm() {
        return factorm;
    }

    public void setFactorm(Double factorm) {
        this.factorm = factorm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactividad != null ? idactividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoactividad)) {
            return false;
        }
        Tipoactividad other = (Tipoactividad) object;
        if ((this.idactividad == null && other.idactividad != null) || (this.idactividad != null && !this.idactividad.equals(other.idactividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipoactividad[ idactividad=" + idactividad + " ]";
    }
    
}
