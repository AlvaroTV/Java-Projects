/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import acceso_datos.PalabrasFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Palabras;

/**
 *
 * @author Alvaro
 */
@Stateless
@LocalBean
public class Palabras_ln {

    // Llamando a un componente, en este caso es de acceso a datos 
    @EJB
    private PalabrasFacade palabras;
    
    public void addPalabras(Palabras p) {
        palabras.create(p);
    }
    
    public List<Palabras> lista_p() {
        return palabras.findAll();
    }
    
    
}
