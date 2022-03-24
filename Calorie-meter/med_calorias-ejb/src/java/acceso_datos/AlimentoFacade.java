/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Alimento;

/**
 *
 * @author Alvaro
 */
@Stateless
public class AlimentoFacade extends AbstractFacade<Alimento> {

    @PersistenceContext(unitName = "med_calorias-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlimentoFacade() {
        super(Alimento.class);
    }
    
}
