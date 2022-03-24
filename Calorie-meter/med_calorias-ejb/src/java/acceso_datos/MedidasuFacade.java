/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso_datos;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Medidasu;

/**
 *
 * @author Alvaro
 */
@Stateless
public class MedidasuFacade extends AbstractFacade<Medidasu> {

    @PersistenceContext(unitName = "med_calorias-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedidasuFacade() {
        super(Medidasu.class);
    }
    
    public Medidasu findByDate(Date fecha) {
        try {
            Query consulta = em.createNamedQuery("Medidasu.findByFecha");
            consulta.setParameter("fecha", fecha);
            return (Medidasu)consulta.getSingleResult();
        }catch(Exception e) {
            return null;
        }
    }
    
}
