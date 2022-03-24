/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import acceso_datos.AlimentoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Alimento;

/**
 *
 * @author Alvaro
 */
@Stateless
@LocalBean
public class Alimento_ln {

    @EJB
    private AlimentoFacade alimentoFacade;
    
    public void creaAlimento(Alimento a) {
        alimentoFacade.create(a);
    }
    
    public List<Alimento> list_a() {
        return alimentoFacade.findAll();
    }
    
    public Alimento recuperaAlimento(int id) {
        return alimentoFacade.find(id);
    }
}
