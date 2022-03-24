/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import acceso_datos.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.Usuario;

/**
 *
 * @author Alvaro
 */
@Stateless
@LocalBean
public class Usuario_ln {
    
    @EJB
    private UsuarioFacade usuariosFacade;
    
    public void creaUsuario(Usuario u){
        usuariosFacade.create(u);
    }
    
    public List<Usuario> lista_u(){
        return usuariosFacade.findAll();
    }
    
    public Usuario recuperarUsuario(int id){
        return usuariosFacade.find(id);
    }
    
    public Usuario findByUserName(String nombreUsuario){
        return usuariosFacade.findByUserName(nombreUsuario);
    }
    
    public Usuario findByPassword(String password) {
        return usuariosFacade.findByPassword(password);
    }
}
