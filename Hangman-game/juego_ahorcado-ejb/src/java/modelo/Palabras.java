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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PALABRAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palabras.findAll", query = "SELECT p FROM Palabras p"),
    @NamedQuery(name = "Palabras.findByIdpalabra", query = "SELECT p FROM Palabras p WHERE p.idpalabra = :idpalabra"),
    @NamedQuery(name = "Palabras.findByPalabra", query = "SELECT p FROM Palabras p WHERE p.palabra = :palabra"),
    @NamedQuery(name = "Palabras.findByNivel", query = "SELECT p FROM Palabras p WHERE p.nivel = :nivel")})
public class Palabras implements Serializable {

    @OneToMany(mappedBy = "palabra")
    private Collection<JuegosUsuario> juegosUsuarioCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPALABRA")
    private Integer idpalabra;
    @Size(max = 40)
    @Column(name = "PALABRA")
    private String palabra;
    @Column(name = "NIVEL")
    private Integer nivel;
    @JoinColumn(name = "TIPO", referencedColumnName = "IDTIPOS")
    @ManyToOne
    private Tipopalabras tipo;

    public Palabras() {
    }

    public Palabras(Integer idpalabra) {
        this.idpalabra = idpalabra;
    }

    public Integer getIdpalabra() {
        return idpalabra;
    }

    public void setIdpalabra(Integer idpalabra) {
        this.idpalabra = idpalabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Tipopalabras getTipo() {
        return tipo;
    }

    public void setTipo(Tipopalabras tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpalabra != null ? idpalabra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palabras)) {
            return false;
        }
        Palabras other = (Palabras) object;
        if ((this.idpalabra == null && other.idpalabra != null) || (this.idpalabra != null && !this.idpalabra.equals(other.idpalabra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Palabras[ idpalabra=" + idpalabra + " ]";
    }

    @XmlTransient
    public Collection<JuegosUsuario> getJuegosUsuarioCollection() {
        return juegosUsuarioCollection;
    }

    public void setJuegosUsuarioCollection(Collection<JuegosUsuario> juegosUsuarioCollection) {
        this.juegosUsuarioCollection = juegosUsuarioCollection;
    }
    
}
