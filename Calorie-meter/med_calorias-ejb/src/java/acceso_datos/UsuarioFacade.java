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
import modelo.Usuario;

/**
 *
 * @author Alvaro
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "med_calorias-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findByUserName(String nombreUsuario){
        try {
            Query consulta = em.createNamedQuery("Usuario.findByNombre");
            consulta.setParameter("nombre", nombreUsuario);
            
            return (Usuario)consulta.getSingleResult();
        }catch(Exception e) {
            return null;
        }
    }
    
    public Usuario findByPassword(String password) {
        try {
            Query consulta = em.createNamedQuery("Usuario.findByPassword");
            consulta.setParameter("password", password);

            return (Usuario)consulta.getSingleResult();
        }catch(Exception e) {
            return null;
        }
    }
    
}
