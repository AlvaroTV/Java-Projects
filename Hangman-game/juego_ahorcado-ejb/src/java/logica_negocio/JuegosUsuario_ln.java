/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import acceso_datos.JuegosUsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.JuegosUsuario;

/**
 *
 * @author Alvaro
 */
@Stateless
@LocalBean
public class JuegosUsuario_ln {
    
    @EJB
    private JuegosUsuarioFacade juegosUFacade;
    
    public List<JuegosUsuario> lista_ju() {
        return juegosUFacade.findAll();
    }
    
    public JuegosUsuario recuperJU(int iju) {
        return juegosUFacade.find(iju);
    }
    
    public void addJuegosU(JuegosUsuario j) {
        juegosUFacade.create(j);
    }
}
