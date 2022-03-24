/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import logica_negocio.Alimento_ln;
import logica_negocio.Grupoalimentos_ln;
import logica_negocio.Medidasu_ln;
import logica_negocio.Tipoactividad_ln;
import logica_negocio.Usuario_ln;
import modelo.Medidasu;
import modelo.Tipoactividad;
import modelo.Usuario;

/**
 *
 * @author Alvaro
 */
@ManagedBean(name = "Acceso")
@ApplicationScoped
public class Acceso {
    
    //Llamar a los componentes
    @EJB
    private Alimento_ln alimento_ln;
    
    @EJB
    private Grupoalimentos_ln grupoAlimentos_ln;
    
    @EJB
    private Medidasu_ln medidasu_ln;
    
    @EJB
    private Tipoactividad_ln tipoact_ln;
    
    @EJB
    private Usuario_ln usuarios_ln;
    
    private Usuario usuario;
    private String fecha = "";
    private String Validacion = "Bienvenido";
    private int id;
    
    private String nombreU;
    private String fNac;
    private int estatura;
    private char sexo;
    private int idU;
    
    private String fechaBusqueda;
    private Medidasu medidas;
    private Medidasu medidas2;
    
    private double imc = 0;
    private double icc = 0;
    private double tmb = 0;
    private String mensaje1 = "No calculado";
    private String mensaje2 = "No calculado";
    
    private String descBusqueda;
    
    public Acceso() {
        usuario = new Usuario();
        medidas = new Medidasu();
        medidas2 = new Medidasu();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuarios) {
        this.usuario = usuarios;
    }

    public void setfNac(String fNac) {
        this.fNac = fNac;
    }

    public String getfNac() {
        return fNac;
    }

    public void guardarUsuario() {
        usuarios_ln.creaUsuario(usuario);
    }

    public int getId() {
        return id;
    }
    
    public void setfechaString(String fechaString) {
        this.fecha = fechaString;
    }

    public String getfechaString() {
        return fecha;
    }

    public String getValidacion() {
        return Validacion;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }
    
    public String getNombreU() {
        return nombreU;
    }
    
    public void setIdU(int idU) {
        this.idU = idU;
    }
    
    public int getIdU() {
        return idU;
    }
    
    public void setFechaN(String fNac) {
        this.fNac = fNac;
    }
    
    public String getFechaN() {
        return fNac;
    }
    
    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }
    
    public int getEstatura() {
        return estatura;
    }
    
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public char getSexo() {
        return sexo;
    }
    
    public void setIMC(double imc) {
        this.imc = imc;
    }
    
    public double getIMC() {
        return imc;
    }
    
    public void setICC(double icc) {
        this.icc = icc;
    }
    
    public double getICC() {
        return icc;
    }
    
    public void setTMB(double tmb) {
        this.tmb = tmb;
    }
    
    public double getTMB() {
        return tmb;
    }
    
    public void setMensaje1(String mensaje1) {
        this.mensaje1 = mensaje1;
    }
    
    public String getMensaje1() {
        return mensaje1;
    }
    
    public void setMensaje2(String mensaje2) {
        this.mensaje2 = mensaje2;
    }
    
    public String getMensaje2() {
        return mensaje2;
    }
    
    public void setFechaBusqueda(String fechaBusqueda) {
        this.fechaBusqueda = fechaBusqueda;
    } 
    
    public String getFechaBusqueda() {
        return fechaBusqueda;
    }
    
    public void setMedidas(Medidasu medidas) {
        this.medidas = medidas;
    }
    
    public Medidasu getMedidas() {
        return medidas;
    }
    
    public void setDescBusqueda(String descBusqueda) {
        this.descBusqueda = descBusqueda;
    }
    
    public String getDescBusqueda() {
        return descBusqueda;
    }
    
    public String autenticarse() {
        String nombreVal = usuario.getNombre();
        String passwordVal = usuario.getPassword();
        
        if(nombreVal.isEmpty() || passwordVal.isEmpty()) {
            Validacion = "Verifique sus datos";
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensaje = new FacesMessage("Casilla vacia");
            contexto.addMessage(null, mensaje);
            return "";
        }
        
        Usuario u1 = usuarios_ln.findByUserName(nombreVal);
        Usuario u2 = usuarios_ln.findByPassword(passwordVal);

        if(u1.equals(u2)) {
            //return "registra_medidas.xhtml";
            DateFormat dateF = new SimpleDateFormat("MM/dd/yyyy");
            Date date = u1.getFechanac();
            String dateStr = dateF.format(date);
            
            nombreU = u1.getNombre();
            idU = u1.getIdusu();
            estatura = u1.getEstatura();
            fNac = dateStr;
            sexo = u1.getSexo();
            
            return "menu.xhtml";
        } else {
            Validacion = "Verifique sus datos";
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensaje = new FacesMessage("Usuario no encontrado");
            contexto.addMessage(null, mensaje);
            return "";
        }
    }
    
    public void registrarMedidas(){
        Usuario user = usuarios_ln.recuperarUsuario(idU);
        medidas.setUsuario(user);
        medidasu_ln.creaMedidasu(medidas);
    }
    
    public List<Medidasu> getListaDantrop() {
        return medidasu_ln.list_m();
    }
    
    public List<Medidasu> getListaDantropById() {
        return medidasu_ln.listById(idU);
    }
    
    public List<String> getListaFechas() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
        List<Medidasu> lista = medidasu_ln.listById(idU);
        List<String> result = new ArrayList<>();
        
        for(Medidasu d: lista) {
            result.add(sdf.format(d.getFecha()));
        }
        
        return result;
    }
    
    public List<String> getListaDescripcionAct() {
        List<String> lista = new ArrayList<>();
        List<Tipoactividad> lista2 = tipoact_ln.list_a();
        
        for(Tipoactividad ta: lista2) {
            lista.add(ta.getDescripcion());
        }
        
        return lista;
    }
    
    public Date parseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        }catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    public void calcularIndice() {
        String fDouble;
        Date fech = parseFecha(fechaBusqueda);
        Usuario u = usuarios_ln.recuperarUsuario(idU);
        Medidasu d = medidasu_ln.findByDate(fech);
        
        double pes = d.getPeso();
        double est = u.getEstatura();
        double cin = d.getCintura();
        double cad = d.getCadera();
        
        imc = pes/((est/100)*(est/100));
        icc = cin / cad;
        
        String pattern = "#.###";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        
        fDouble = decimalFormat.format(imc);        
        imc = Double.parseDouble(fDouble);
        
        fDouble = decimalFormat.format(icc);
        icc = Double.parseDouble(fDouble);
        
        if(imc < 18.5) {
            mensaje1 = "Bajo de Peso";
        } else if(imc>=18.5 && imc<=24.9) {
            mensaje1 = "Peso Normal";
        } else if(imc>=25 && imc<=29.9) {
            mensaje1 = "Sobrepeso";
        } else {
            mensaje1 = "Obeso";
        }
        
        if(u.getSexo() == 'H') {
            if(icc < 0.80) {
                mensaje2 = "Riesgo de salud BAJO";
            }else if(icc>=0.81 && icc<=0.85) {
                mensaje2 = "Riesgo de salud MODERADO";
            } else {
                mensaje2 = "Riesgo de salud ALTO";
            }
        }else {
            if(icc < 0.95) {
                mensaje2 = "Riesgo de salud BAJO";
            }else if(icc>=0.96 && icc<=1) {
                mensaje2 = "Riesgo de salud MODERADO";
            } else {
                mensaje2 = "Riesgo de salud ALTO";
            }
        }
    }
    
    public void calcularCalorias() {
        String fDouble;
        Date fech = parseFecha(fechaBusqueda);
        Usuario u = usuarios_ln.recuperarUsuario(idU);
        Medidasu d = medidasu_ln.findByDate(fech);
        Tipoactividad a = tipoact_ln.findByDescripcion(descBusqueda);
        
        double peso = d.getPeso();
        double altura = u.getEstatura();
        Date fechaN = u.getFechanac();
        char sexP = u.getSexo();
        double vAct = a.getFactorh();
        
        // Calcular la edad
        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        fechaNacimiento.setTime(fechaN);
        
        int edad = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        
        if(sexP == 'H') {
            tmb = ( (10 * peso) + (6.25 * altura) - (5 * edad) + 5   ) * vAct;
        }else {
            tmb = ( (10 * peso) + (6.25 * altura) - (5 * edad) - 161 ) * vAct;
        }
    }
}
