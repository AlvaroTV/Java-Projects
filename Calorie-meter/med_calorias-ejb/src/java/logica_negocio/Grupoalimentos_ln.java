/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import acceso_datos.GrupoalimentosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Grupoalimentos;

/**
 *
 * @author Alvaro
 */
@Stateless
@LocalBean
public class Grupoalimentos_ln {

    @EJB
    private GrupoalimentosFacade grupoalimFacade;
    
    public void creaGrupoA(Grupoalimentos ga) {
        grupoalimFacade.create(ga);
    }
    
    public List<Grupoalimentos> list_ga() {
        return grupoalimFacade.findAll();
    }
    
    public Grupoalimentos recuperGrupo(int id) {
        return grupoalimFacade.find(id);
    }
}
