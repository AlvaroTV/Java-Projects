/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Tipopalabras;

/**
 *
 * @author Alvaro
 */
@Stateless
public class TipopalabrasFacade extends AbstractFacade<Tipopalabras> {

    @PersistenceContext(unitName = "juego_ahorcado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipopalabrasFacade() {
        super(Tipopalabras.class);
    }
    
}
