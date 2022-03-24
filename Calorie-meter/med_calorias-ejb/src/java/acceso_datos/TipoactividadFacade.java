/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Tipoactividad;

/**
 *
 * @author Alvaro
 */
@Stateless
public class TipoactividadFacade extends AbstractFacade<Tipoactividad> {

    @PersistenceContext(unitName = "med_calorias-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoactividadFacade() {
        super(Tipoactividad.class);
    }
    
    public Tipoactividad findByDescription(String description) {
        try{
            Query consulta = em.createNamedQuery("Tipoactividad.findByDescripcion");
            consulta.setParameter("descripcion", description);
            
            return (Tipoactividad)consulta.getSingleResult();
        }catch(Exception e) {
            return null;
        }
    }
    
}
