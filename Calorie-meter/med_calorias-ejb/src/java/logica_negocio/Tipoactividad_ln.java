/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import acceso_datos.TipoactividadFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.Tipoactividad;

/**
 *
 * @author Alvaro
 */
@Stateless
@LocalBean
public class Tipoactividad_ln {
    
    @EJB
    private TipoactividadFacade tipoactividadFacade;
    
    public List<Tipoactividad> list_a() {
        return tipoactividadFacade.findAll();
    }
    
    public Tipoactividad recuperaTipoactividad(int id) {
        return tipoactividadFacade.find(id);
    }
    
    public Tipoactividad findByDescripcion(String desc) {
        return tipoactividadFacade.findByDescription(desc);
    }
}
