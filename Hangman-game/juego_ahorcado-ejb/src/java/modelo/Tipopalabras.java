/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "TIPOPALABRAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopalabras.findAll", query = "SELECT t FROM Tipopalabras t"),
    @NamedQuery(name = "Tipopalabras.findByIdtipos", query = "SELECT t FROM Tipopalabras t WHERE t.idtipos = :idtipos"),
    @NamedQuery(name = "Tipopalabras.findByDescripcion", query = "SELECT t FROM Tipopalabras t WHERE t.descripcion = :descripcion")})
public class Tipopalabras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPOS")
    private Integer idtipos;
    @Size(max = 40)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "tipo")
    private Collection<Palabras> palabrasCollection;

    public Tipopalabras() {
    }

    public Tipopalabras(Integer idtipos) {
        this.idtipos = idtipos;
    }

    public Integer getIdtipos() {
        return idtipos;
    }

    public void setIdtipos(Integer idtipos) {
        this.idtipos = idtipos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Palabras> getPalabrasCollection() {
        return palabrasCollection;
    }

    public void setPalabrasCollection(Collection<Palabras> palabrasCollection) {
        this.palabrasCollection = palabrasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipos != null ? idtipos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopalabras)) {
            return false;
        }
        Tipopalabras other = (Tipopalabras) object;
        if ((this.idtipos == null && other.idtipos != null) || (this.idtipos != null && !this.idtipos.equals(other.idtipos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipopalabras[ idtipos=" + idtipos + " ]";
    }
    
}
