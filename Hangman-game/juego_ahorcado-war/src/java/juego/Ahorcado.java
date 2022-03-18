/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import logica_negocio.JuegosUsuario_ln;
import logica_negocio.Tipo_p;
import logica_negocio.Palabras_ln;
import logica_negocio.Usuario_ln;
import modelo.JuegosUsuario;
import modelo.Palabras;
import modelo.Tipopalabras;
import modelo.Usuario;



/**
 *
 * @author Alvaro
 */
@ManagedBean(name="ahorcado")
@ApplicationScoped
public class Ahorcado implements Serializable{

    // Llamadas a componentes
    @EJB
    private Palabras_ln palabras_ln;
    
    @EJB
    private Tipo_p tipo_p;
    
    @EJB
    private JuegosUsuario_ln juegosU_ln;
    
    @EJB
    private Usuario_ln usuario_ln;
    
    private Palabras palabras;
    private Tipopalabras tipo;
    private String ida;
    private String texto = "Bienvenido";
    private int idTP = 1;
    
    //###################################################
    private ArrayList<Character> letras;
    //private String palabras[] = {"ACERTASTE", "ARTISTICO", "ARTES" ,"NACIONAL", "EVENTO", "CULTURAL", "OAXACA"};
    private ArrayList<Palabras> palabrass;
    private String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private String palabra = "";
    private String adivina = "";
    private String idLetra = "";
    private String resp[];    
    private ArrayList<Character> abcd = new ArrayList();
    private String aciertos = "";
    private String errados  = "";
    private String respuesta = "";
    private int intentos = 0;
    private int intentosR = 0;
    private int intentosT = 0;
    private int nivel = 1;
    private String fecha;
    private Date fechaR;
    
    private int tipoU;
    private Usuario usuario;
    private Usuario usuarioV;
    private JuegosUsuario jUsuario;
    private int idU;
    
    
      
    public Ahorcado() {
        palabras = new Palabras();
        tipo = new Tipopalabras();
        usuario = new Usuario();
        jUsuario = new JuegosUsuario();
    }
  
    public void guardaConfiguracion( ) {
        ArrayList<Palabras> subPalabras = new ArrayList(); 
        ArrayList<Palabras> palabrasFinal = new ArrayList(); 
        Random pa = new Random();
        palabrass = new ArrayList<Palabras>(lista_p());
        agregar();
        
        // Filtrar palabras por Tipo
        Tipopalabras tipo = tipo_p.recuperarTipo(idTP);
        for(Palabras p: palabrass) {
            if(p.getTipo().getDescripcion().equalsIgnoreCase(tipo.getDescripcion())) subPalabras.add(p);
        }
        
        // Filtrar palabras por Nivel
        for(Palabras pal: subPalabras) {
            if(pal.getNivel() == nivel) palabrasFinal.add(pal);
        }
        
        // Se elige una palabra dentro de las palabras que cumplen el filtro
        palabra = palabrasFinal.get(pa.nextInt(palabrasFinal.size())).getPalabra();
        adivina = palabra;
        respuesta = palabra;
        resp = new String[palabra.length()];
        for(int i=0; i<resp.length; i++) {
            resp[i] = "_" + " ";
        }
        
    }
    
    public int getIdU() {
        return idU;
    }
    
    public void setIdU(int idU) {
        this.idU = idU;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public int getTipoU() {
        return tipoU;
    }
    
    public void setTipoU(int tipoU) {
        this.tipoU = tipoU;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public int getNivel() {
        return nivel;
    }
    
    public String getRespuesta() {
        return respuesta;
    }
    
    public int getIntentos() {
        return intentos;
    }
    
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
    
    public void reiniciar() {
        abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        idLetra="";
    }
    
    public String getTexto() {
        return texto;
    }
    
    
    public void setTexto(String texto) {
       this.texto = texto;
    }
    
    public void mostrar_texto(ActionEvent e) {
        ida = e.getComponent().getId();
        texto = ida;
    }
    
    public Palabras getPalabras() {
        return palabras;
    }
    
    public void setPalabras(Palabras palabras) {
        this.palabras = palabras;
    }
    
    public int getIdTP() {
        return idTP;
    }
    
    public void setIdTP(int idTP) {
        this.idTP = idTP;
    }
    
    public void guardarPalabra() {
        tipo = tipo_p.recuperarTipo(idTP);
        if(tipo!=null){
            palabras.setTipo(tipo);
            palabras_ln.addPalabras(palabras);
        }
    }
    
    public void guardarUsuario() {
        DateTimeFormatter datef = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        fecha = datef.format(LocalDateTime.now());
        fechaR = StringToDate(fecha);
        usuario.setFechaRegistro(fechaR);
        
        usuario_ln.addUsuario(usuario);
    }
    
    public void actualizaJuegosU() {
        DateTimeFormatter datef = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        fecha = datef.format(LocalDateTime.now());
        fechaR = StringToDate(fecha);
        
        jUsuario.setIntentosr(intentosR);
        jUsuario.setIntentost(intentos);
        jUsuario.setFechaHora(fechaR);
        //jUsuario.setIdusuario(usuario.getIdusuario());
        //jUsuario.setPalabra(palabras.getIdpalabra());
        jUsuario.setIdusuario(usuario);
        jUsuario.setPalabra(palabras);
        
        juegosU_ln.addJuegosU(jUsuario);
    }
    
    public String validaUsuario() {
        usuarioV = usuario_ln.recuperarUsuario(idU);
        
        if(usuarioV!=null && usuarioV.getNombre().equalsIgnoreCase(usuario.getNombre()) ) {
            texto="Bienvenido";
            return "configurar.xhtml";
        } else {
            texto = "Verifique sus Datos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nombre o ID incorrecto", "Verifique sus datos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "";
        }
    }
    
    public Date StringToDate(String cad) {
        Date fecha = null;
        try {
            SimpleDateFormat dateF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            fecha = (Date)dateF.parse(cad);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return fecha;
    }
    
    public List<Palabras> lista_p() {
        return palabras_ln.lista_p();
    }
    
    public Tipopalabras getTipo() {
        return tipo;
    }
    
    public void setTipo(Tipopalabras tipo) {
        this.tipo = tipo;
    }
    
    public List<Tipopalabras> lista_t() {
        return tipo_p.lista_t();
    }
    
    public List<JuegosUsuario> list_ju() {
        return juegosU_ln.lista_ju();
    }
    
    public void guarda_p(ActionEvent e) {
        palabras.setTipo(tipo);
        palabras_ln.addPalabras(palabras);
        palabras = new Palabras();
    }

    public String getIdLetra() {
        return idLetra;
    }
    
    public String getAdivina() {
        String respuesta="";
        for(String i: resp) {
            respuesta += i;
        }
        return respuesta;
    }
    
    public ArrayList<Character> getLetras() {
        return letras;
    }
    
    public void agregar() {
        letras = new ArrayList();
        for(int i=0; i<abecedario.length(); i++) {
            letras.add(abecedario.charAt(i));
        }
    }
    
    public String getIda() {
        return ida;
    }
    
    public void setIda(String ida) {
        this.ida = ida;
    }
    
    public void setLetras(ArrayList<Character> letras) {
        this.letras = letras;
    }
    
    public String getPalabra() {
        return palabra;
    }
    
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
    
    public ArrayList<Character> getAbcd() {
        return abcd;
    }
    
    public void setAbcd(ArrayList<Character> abcd) {
        this.abcd = abcd;
    }
    
    public String getAbecedario() {
        return abecedario;
    }
    
    public void setAbcedario(String abecedario) {
        this.abecedario = abecedario;
    }
    
    public void actualiza(ActionEvent e) {
        idLetra = String.valueOf(e.getComponent().getAttributes().get("value"));
        //Quitar la letra del abecedario si es parte de la palabra
        if(palabra.contains(idLetra)) {
            abecedario = abecedario.replace(idLetra, " _ ");
            actualizaPalabra(idLetra);
            palabra = palabra.replace(idLetra, "");
            agregar();
        } else {
            intentos--;
            intentosR++;
        }
    }
    
    public void actualizaPalabra(String letra) {
        for(int i=0; i<adivina.length(); i++) {
            if(adivina.charAt(i) == letra.charAt(0)){
                resp[i] = letra + " - ";
            }
        }
    }
    
    public List<Niveles> niveles() {
        String nvs[] = {"FACIL", "REGULAR", "DIFICIL", "MUY DIFICIL"};
        List<Niveles> lnvs = new ArrayList<Niveles>();
        for(int n=0; n<nvs.length; n++) {
            lnvs.add(new Niveles(n+1, nvs[n]));
        }
        return lnvs;
    }
    
    public List<Tipos> tipos() {
        String nvs[] = {"NIÑO", "JOVEN", "ADULTO"};
        List<Tipos> tipos = new ArrayList<Tipos>();
        for(int n=0; n<nvs.length; n++) {
            tipos.add(new Tipos(n+1, nvs[n]));
        }
        return tipos;
    }
    
    public class Niveles {
        private int gnivel;
        private String descripcion;
        
        public Niveles(int n, String d) {
            gnivel = n;
            descripcion = d;
        }
        
        public int getGnivel() {
            return gnivel;
        }
        
        public void setGnivel(int g) {
            gnivel = g;
        }
        
        public String getDesc() {
            return descripcion;
        }
        
        public void setDesc(String d) {
            descripcion = d;
        }
    }
    
    public class Tipos {
        private int gTipo;
        private String descripcion;
        
        public Tipos(int n, String d) {
            gTipo = n;
            descripcion = d;
        }
        
        public int getGtipo() {
            return gTipo;
        }
        
        public void setGtipo(int g) {
            gTipo = g;
        }
        
        public String getDesc() {
            return descripcion;
        }
        
        public void setDesc(String d) {
            descripcion = d;
        }
    }
    
    
}