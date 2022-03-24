/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import acceso_datos.MedidasuFacade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.Medidasu;

/**
 *
 * @author Alvaro
 */
@Stateless
@LocalBean
public class Medidasu_ln {
    @EJB
    private MedidasuFacade medidasFacade;
    
    public void creaMedidasu(Medidasu m) {
        medidasFacade.create(m);
    }
    
    public List<Medidasu> list_m() {
        return medidasFacade.findAll();
    }
    
    public Medidasu recuperaMedidasu(int id) {
        return medidasFacade.find(id);
    }
    
    public List<Medidasu> listById(int id) {
        List<Medidasu> lista  = new ArrayList<>();
        List<Medidasu> lista2 = new ArrayList<>();
        lista2 = medidasFacade.findAll();
        
        for(Medidasu m: lista2) {
            if(m.getUsuario().getIdusu() == id) lista.add(m);
        }
        
        return lista;
    }
    
    public Medidasu findByDate(Date fecha) {
        return medidasFacade.findByDate(fecha);
    }
}
