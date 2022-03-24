/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "GRUPOALIMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupoalimentos.findAll", query = "SELECT g FROM Grupoalimentos g"),
    @NamedQuery(name = "Grupoalimentos.findByIdgpo", query = "SELECT g FROM Grupoalimentos g WHERE g.idgpo = :idgpo"),
    @NamedQuery(name = "Grupoalimentos.findByNombre", query = "SELECT g FROM Grupoalimentos g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Grupoalimentos.findByEnergia", query = "SELECT g FROM Grupoalimentos g WHERE g.energia = :energia"),
    @NamedQuery(name = "Grupoalimentos.findByUnienergia", query = "SELECT g FROM Grupoalimentos g WHERE g.unienergia = :unienergia"),
    @NamedQuery(name = "Grupoalimentos.findByHidratos", query = "SELECT g FROM Grupoalimentos g WHERE g.hidratos = :hidratos"),
    @NamedQuery(name = "Grupoalimentos.findByUnihidratos", query = "SELECT g FROM Grupoalimentos g WHERE g.unihidratos = :unihidratos"),
    @NamedQuery(name = "Grupoalimentos.findByGrasas", query = "SELECT g FROM Grupoalimentos g WHERE g.grasas = :grasas"),
    @NamedQuery(name = "Grupoalimentos.findByUnigrasas", query = "SELECT g FROM Grupoalimentos g WHERE g.unigrasas = :unigrasas"),
    @NamedQuery(name = "Grupoalimentos.findByProteinas", query = "SELECT g FROM Grupoalimentos g WHERE g.proteinas = :proteinas"),
    @NamedQuery(name = "Grupoalimentos.findByUniproteinas", query = "SELECT g FROM Grupoalimentos g WHERE g.uniproteinas = :uniproteinas"),
    @NamedQuery(name = "Grupoalimentos.findBySales", query = "SELECT g FROM Grupoalimentos g WHERE g.sales = :sales"),
    @NamedQuery(name = "Grupoalimentos.findByUnisales", query = "SELECT g FROM Grupoalimentos g WHERE g.unisales = :unisales"),
    @NamedQuery(name = "Grupoalimentos.findByAzucares", query = "SELECT g FROM Grupoalimentos g WHERE g.azucares = :azucares"),
    @NamedQuery(name = "Grupoalimentos.findByUniazucares", query = "SELECT g FROM Grupoalimentos g WHERE g.uniazucares = :uniazucares")})
public class Grupoalimentos implements Serializable {

    @OneToMany(mappedBy = "idgpo")
    private List<Alimento> alimentoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDGPO")
    private Integer idgpo;
    @Size(max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ENERGIA")
    private Integer energia;
    @Size(max = 40)
    @Column(name = "UNIENERGIA")
    private String unienergia;
    @Column(name = "HIDRATOS")
    private Integer hidratos;
    @Size(max = 40)
    @Column(name = "UNIHIDRATOS")
    private String unihidratos;
    @Column(name = "GRASAS")
    private Integer grasas;
    @Size(max = 40)
    @Column(name = "UNIGRASAS")
    private String unigrasas;
    @Column(name = "PROTEINAS")
    private Integer proteinas;
    @Size(max = 40)
    @Column(name = "UNIPROTEINAS")
    private String uniproteinas;
    @Column(name = "SALES")
    private Integer sales;
    @Size(max = 40)
    @Column(name = "UNISALES")
    private String unisales;
    @Column(name = "AZUCARES")
    private Integer azucares;
    @Size(max = 40)
    @Column(name = "UNIAZUCARES")
    private String uniazucares;

    public Grupoalimentos() {
    }

    public Grupoalimentos(Integer idgpo) {
        this.idgpo = idgpo;
    }

    public Integer getIdgpo() {
        return idgpo;
    }

    public void setIdgpo(Integer idgpo) {
        this.idgpo = idgpo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public String getUnienergia() {
        return unienergia;
    }

    public void setUnienergia(String unienergia) {
        this.unienergia = unienergia;
    }

    public Integer getHidratos() {
        return hidratos;
    }

    public void setHidratos(Integer hidratos) {
        this.hidratos = hidratos;
    }

    public String getUnihidratos() {
        return unihidratos;
    }

    public void setUnihidratos(String unihidratos) {
        this.unihidratos = unihidratos;
    }

    public Integer getGrasas() {
        return grasas;
    }

    public void setGrasas(Integer grasas) {
        this.grasas = grasas;
    }

    public String getUnigrasas() {
        return unigrasas;
    }

    public void setUnigrasas(String unigrasas) {
        this.unigrasas = unigrasas;
    }

    public Integer getProteinas() {
        return proteinas;
    }

    public void setProteinas(Integer proteinas) {
        this.proteinas = proteinas;
    }

    public String getUniproteinas() {
        return uniproteinas;
    }

    public void setUniproteinas(String uniproteinas) {
        this.uniproteinas = uniproteinas;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getUnisales() {
        return unisales;
    }

    public void setUnisales(String unisales) {
        this.unisales = unisales;
    }

    public Integer getAzucares() {
        return azucares;
    }

    public void setAzucares(Integer azucares) {
        this.azucares = azucares;
    }

    public String getUniazucares() {
        return uniazucares;
    }

    public void setUniazucares(String uniazucares) {
        this.uniazucares = uniazucares;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgpo != null ? idgpo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoalimentos)) {
            return false;
        }
        Grupoalimentos other = (Grupoalimentos) object;
        if ((this.idgpo == null && other.idgpo != null) || (this.idgpo != null && !this.idgpo.equals(other.idgpo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Grupoalimentos[ idgpo=" + idgpo + " ]";
    }

    @XmlTransient
    public List<Alimento> getAlimentoList() {
        return alimentoList;
    }

    public void setAlimentoList(List<Alimento> alimentoList) {
        this.alimentoList = alimentoList;
    }
    
}
