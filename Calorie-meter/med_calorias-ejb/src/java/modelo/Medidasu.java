/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "MEDIDASU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medidasu.findAll", query = "SELECT m FROM Medidasu m"),
    @NamedQuery(name = "Medidasu.findByIddant", query = "SELECT m FROM Medidasu m WHERE m.iddant = :iddant"),
    @NamedQuery(name = "Medidasu.findByFecha", query = "SELECT m FROM Medidasu m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "Medidasu.findByPeso", query = "SELECT m FROM Medidasu m WHERE m.peso = :peso"),
    @NamedQuery(name = "Medidasu.findByCintura", query = "SELECT m FROM Medidasu m WHERE m.cintura = :cintura"),
    @NamedQuery(name = "Medidasu.findByCadera", query = "SELECT m FROM Medidasu m WHERE m.cadera = :cadera")})
public class Medidasu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDANT")
    private Integer iddant;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "PESO")
    private Integer peso;
    @Column(name = "CINTURA")
    private Integer cintura;
    @Column(name = "CADERA")
    private Integer cadera;
    @JoinColumn(name = "USUARIO", referencedColumnName = "IDUSU")
    @ManyToOne
    private Usuario usuario;

    public Medidasu() {
    }

    public Medidasu(Integer iddant) {
        this.iddant = iddant;
    }

    public Integer getIddant() {
        return iddant;
    }

    public void setIddant(Integer iddant) {
        this.iddant = iddant;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getCintura() {
        return cintura;
    }

    public void setCintura(Integer cintura) {
        this.cintura = cintura;
    }

    public Integer getCadera() {
        return cadera;
    }

    public void setCadera(Integer cadera) {
        this.cadera = cadera;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddant != null ? iddant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medidasu)) {
            return false;
        }
        Medidasu other = (Medidasu) object;
        if ((this.iddant == null && other.iddant != null) || (this.iddant != null && !this.iddant.equals(other.iddant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Medidasu[ iddant=" + iddant + " ]";
    }
    
}
