/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import acceso_datos.TipopalabrasFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Tipopalabras;

/**
 *
 * @author Alvaro
 */
@Stateless
@LocalBean
public class Tipo_p {

    @EJB
    private TipopalabrasFacade tiposFacade;
    
    public List<Tipopalabras> lista_t() {
        return tiposFacade.findAll();
    }

    public Tipopalabras recuperarTipo(int it) {
        return tiposFacade.find(it);
    }
}
