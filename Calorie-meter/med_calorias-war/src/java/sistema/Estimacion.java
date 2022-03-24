/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import logica_negocio.Grupoalimentos_ln;
import modelo.Grupoalimentos;

/**
 *
 * @author Alvaro
 */
@ManagedBean(name = "Estimacion")
@ApplicationScoped
public class Estimacion {
    
    @EJB
    private Grupoalimentos_ln grupoalimentos_ln; 
    
    private double kcal_D  = 0; 
    private double kcal_CM = 0;
    private double kcal_Co = 0;
    private double kcal_CT = 0;
    private double kcal_Ce = 0;
    private double kcal_To = 0;
    
    /*
    private double cerealSG ; 
    private double cerealCG ; 
    private double verduras ; 
    private double frutas ; 
    private double alimOriAnimMBG ; 
    private double alimOriAnimBG ; 
    private double lecheD ;
    private double lecheE ;
    private double leguminosas ; 
    private double grasasMO ; 
    private double grasasPO ; 
    private double grasasST ;
    private double azucares ;
    private double azucaresG ; 
    */
    
    private int cerealSG_D ;   
    private int cerealSG_CM;
    private int cerealSG_Co;
    private int cerealSG_CT;
    private int cerealSG_Ce;
    
    private int cerealCG_D ;   
    private int cerealCG_CM;
    private int cerealCG_Co;
    private int cerealCG_CT;
    private int cerealCG_Ce;
    
    private int verduras_D ;   
    private int verduras_CM;
    private int verduras_Co;
    private int verduras_CT;
    private int verduras_Ce;
    
    private int frutas_D ;   
    private int frutas_CM;
    private int frutas_Co;
    private int frutas_CT;
    private int frutas_Ce;
    
    private int alimOriAnimMBG_D ;   
    private int alimOriAnimMBG_CM;
    private int alimOriAnimMBG_Co;
    private int alimOriAnimMBG_CT;
    private int alimOriAnimMBG_Ce;
    
    private int alimOriAnimBG_D ;   
    private int alimOriAnimBG_CM;
    private int alimOriAnimBG_Co;
    private int alimOriAnimBG_CT;
    private int alimOriAnimBG_Ce;
    
    private int lecheD_D ;   
    private int lecheD_CM;
    private int lecheD_Co;
    private int lecheD_CT;
    private int lecheD_Ce;
    
    private int lecheE_D ;   
    private int lecheE_CM;
    private int lecheE_Co;
    private int lecheE_CT;
    private int lecheE_Ce;
    
    private int leguminosas_D ;   
    private int leguminosas_CM;
    private int leguminosas_Co;
    private int leguminosas_CT;
    private int leguminosas_Ce;
    
    private int grasasMO_D ;   
    private int grasasMO_CM;
    private int grasasMO_Co;
    private int grasasMO_CT;
    private int grasasMO_Ce;
    
    private int grasasPO_D ;   
    private int grasasPO_CM;
    private int grasasPO_Co;
    private int grasasPO_CT;
    private int grasasPO_Ce;
    
    private int grasasST_D ;   
    private int grasasST_CM;
    private int grasasST_Co;
    private int grasasST_CT;
    private int grasasST_Ce;
    
    private int azucares_D ;   
    private int azucares_CM;
    private int azucares_Co;
    private int azucares_CT;
    private int azucares_Ce;
    
    private int azucaresG_D ;   
    private int azucaresG_CM;
    private int azucaresG_Co;
    private int azucaresG_CT;
    private int azucaresG_Ce;
    
    private ArrayList<String> list_desayuno;
    private ArrayList<String> list_colacionM;
    private ArrayList<String> list_comida;
    private ArrayList<String> list_colacionT;
    private ArrayList<String> list_cena;
    
    private ArrayList<String> lista_nombres;
    private ArrayList<double[]> todosGpos;

    public Estimacion() {
        list_desayuno = new ArrayList<>();
        list_colacionM = new ArrayList<>();
        list_comida = new ArrayList<>();
        list_colacionT = new ArrayList<>();
        list_cena = new ArrayList<>();
        todosGpos = new ArrayList<>();
        lista_nombres = new ArrayList<>();
    }

    public ArrayList<String> getList_desayuno() {
        return list_desayuno;
    }

    public void setList_desayuno(ArrayList<String> list_desayuno) {
        this.list_desayuno = list_desayuno;
    }

    public ArrayList<String> getList_colacionM() {
        return list_colacionM;
    }

    public void setList_colacionM(ArrayList<String> list_colacionM) {
        this.list_colacionM = list_colacionM;
    }

    public ArrayList<String> getList_comida() {
        return list_comida;
    }

    public void setList_comida(ArrayList<String> list_comida) {
        this.list_comida = list_comida;
    }

    public ArrayList<String> getList_colacionT() {
        return list_colacionT;
    }

    public void setList_colacionT(ArrayList<String> list_colacionT) {
        this.list_colacionT = list_colacionT;
    }

    public ArrayList<String> getList_cena() {
        return list_cena;
    }

    public void setList_cena(ArrayList<String> list_cena) {
        this.list_cena = list_cena;
    }

    public double getKcal_D() {
        return kcal_D;
    }

    public void setKcal_D(double kcal_D) {
        this.kcal_D = kcal_D;
    }

    public double getKcal_CM() {
        return kcal_CM;
    }

    public void setKcal_CM(double kcal_CM) {
        this.kcal_CM = kcal_CM;
    }

    public double getKcal_Co() {
        return kcal_Co;
    }

    public void setKcal_Co(double kcal_Co) {
        this.kcal_Co = kcal_Co;
    }

    public double getKcal_CT() {
        return kcal_CT;
    }

    public void setKcal_CT(double kcal_CT) {
        this.kcal_CT = kcal_CT;
    }

    public double getKcal_Ce() {
        return kcal_Ce;
    }

    public void setKcal_Ce(double kcal_Ce) {
        this.kcal_Ce = kcal_Ce;
    }
    
    public double getKcal_To() {
        return kcal_To;
    }

    public void setKcal_To(double kcal_To) {
        this.kcal_To = kcal_To;
    }

    public int getCerealSG_D() {
        return cerealSG_D;
    }

    public void setCerealSG_D(int cerealSG_D) {
        this.cerealSG_D = cerealSG_D;
    }

    public int getCerealSG_CM() {
        return cerealSG_CM;
    }

    public void setCerealSG_CM(int cerealSG_CM) {
        this.cerealSG_CM = cerealSG_CM;
    }

    public int getCerealSG_Co() {
        return cerealSG_Co;
    }

    public void setCerealSG_Co(int cerealSG_Co) {
        this.cerealSG_Co = cerealSG_Co;
    }

    public int getCerealSG_CT() {
        return cerealSG_CT;
    }

    public void setCerealSG_CT(int cerealSG_CT) {
        this.cerealSG_CT = cerealSG_CT;
    }

    public int getCerealSG_Ce() {
        return cerealSG_Ce;
    }

    public void setCerealSG_Ce(int cerealSG_Ce) {
        this.cerealSG_Ce = cerealSG_Ce;
    }

    public int getCerealCG_D() {
        return cerealCG_D;
    }

    public void setCerealCG_D(int cerealCG_D) {
        this.cerealCG_D = cerealCG_D;
    }

    public int getCerealCG_CM() {
        return cerealCG_CM;
    }

    public void setCerealCG_CM(int cerealCG_CM) {
        this.cerealCG_CM = cerealCG_CM;
    }

    public int getCerealCG_Co() {
        return cerealCG_Co;
    }

    public void setCerealCG_Co(int cerealCG_Co) {
        this.cerealCG_Co = cerealCG_Co;
    }

    public int getCerealCG_CT() {
        return cerealCG_CT;
    }

    public void setCerealCG_CT(int cerealCG_CT) {
        this.cerealCG_CT = cerealCG_CT;
    }

    public int getCerealCG_Ce() {
        return cerealCG_Ce;
    }

    public void setCerealCG_Ce(int cerealCG_Ce) {
        this.cerealCG_Ce = cerealCG_Ce;
    }

    public int getVerduras_D() {
        return verduras_D;
    }

    public void setVerduras_D(int verduras_D) {
        this.verduras_D = verduras_D;
    }

    public int getVerduras_CM() {
        return verduras_CM;
    }

    public void setVerduras_CM(int verduras_CM) {
        this.verduras_CM = verduras_CM;
    }

    public int getVerduras_Co() {
        return verduras_Co;
    }

    public void setVerduras_Co(int verduras_Co) {
        this.verduras_Co = verduras_Co;
    }

    public int getVerduras_CT() {
        return verduras_CT;
    }

    public void setVerduras_CT(int verduras_CT) {
        this.verduras_CT = verduras_CT;
    }

    public int getVerduras_Ce() {
        return verduras_Ce;
    }

    public void setVerduras_Ce(int verduras_Ce) {
        this.verduras_Ce = verduras_Ce;
    }

    public int getFrutas_D() {
        return frutas_D;
    }

    public void setFrutas_D(int frutas_D) {
        this.frutas_D = frutas_D;
    }

    public int getFrutas_CM() {
        return frutas_CM;
    }

    public void setFrutas_CM(int frutas_CM) {
        this.frutas_CM = frutas_CM;
    }

    public int getFrutas_Co() {
        return frutas_Co;
    }

    public void setFrutas_Co(int frutas_Co) {
        this.frutas_Co = frutas_Co;
    }

    public int getFrutas_CT() {
        return frutas_CT;
    }

    public void setFrutas_CT(int frutas_CT) {
        this.frutas_CT = frutas_CT;
    }

    public int getFrutas_Ce() {
        return frutas_Ce;
    }

    public void setFrutas_Ce(int frutas_Ce) {
        this.frutas_Ce = frutas_Ce;
    }

    public int getAlimOriAnimMBG_D() {
        return alimOriAnimMBG_D;
    }

    public void setAlimOriAnimMBG_D(int alimOriAnimMBG_D) {
        this.alimOriAnimMBG_D = alimOriAnimMBG_D;
    }

    public int getAlimOriAnimMBG_CM() {
        return alimOriAnimMBG_CM;
    }

    public void setAlimOriAnimMBG_CM(int alimOriAnimMBG_CM) {
        this.alimOriAnimMBG_CM = alimOriAnimMBG_CM;
    }

    public int getAlimOriAnimMBG_Co() {
        return alimOriAnimMBG_Co;
    }

    public void setAlimOriAnimMBG_Co(int alimOriAnimMBG_Co) {
        this.alimOriAnimMBG_Co = alimOriAnimMBG_Co;
    }

    public int getAlimOriAnimMBG_CT() {
        return alimOriAnimMBG_CT;
    }

    public void setAlimOriAnimMBG_CT(int alimOriAnimMBG_CT) {
        this.alimOriAnimMBG_CT = alimOriAnimMBG_CT;
    }

    public int getAlimOriAnimMBG_Ce() {
        return alimOriAnimMBG_Ce;
    }

    public void setAlimOriAnimMBG_Ce(int alimOriAnimMBG_Ce) {
        this.alimOriAnimMBG_Ce = alimOriAnimMBG_Ce;
    }

    public int getAlimOriAnimBG_D() {
        return alimOriAnimBG_D;
    }

    public void setAlimOriAnimBG_D(int alimOriAnimBG_D) {
        this.alimOriAnimBG_D = alimOriAnimBG_D;
    }

    public int getAlimOriAnimBG_CM() {
        return alimOriAnimBG_CM;
    }

    public void setAlimOriAnimBG_CM(int alimOriAnimBG_CM) {
        this.alimOriAnimBG_CM = alimOriAnimBG_CM;
    }

    public int getAlimOriAnimBG_Co() {
        return alimOriAnimBG_Co;
    }

    public void setAlimOriAnimBG_Co(int alimOriAnimBG_Co) {
        this.alimOriAnimBG_Co = alimOriAnimBG_Co;
    }

    public int getAlimOriAnimBG_CT() {
        return alimOriAnimBG_CT;
    }

    public void setAlimOriAnimBG_CT(int alimOriAnimBG_CT) {
        this.alimOriAnimBG_CT = alimOriAnimBG_CT;
    }

    public int getAlimOriAnimBG_Ce() {
        return alimOriAnimBG_Ce;
    }

    public void setAlimOriAnimBG_Ce(int alimOriAnimBG_Ce) {
        this.alimOriAnimBG_Ce = alimOriAnimBG_Ce;
    }

    public int getLecheD_D() {
        return lecheD_D;
    }

    public void setLecheD_D(int lecheD_D) {
        this.lecheD_D = lecheD_D;
    }

    public int getLecheD_CM() {
        return lecheD_CM;
    }

    public void setLecheD_CM(int lecheD_CM) {
        this.lecheD_CM = lecheD_CM;
    }

    public int getLecheD_Co() {
        return lecheD_Co;
    }

    public void setLecheD_Co(int lecheD_Co) {
        this.lecheD_Co = lecheD_Co;
    }

    public int getLecheD_CT() {
        return lecheD_CT;
    }

    public void setLecheD_CT(int lecheD_CT) {
        this.lecheD_CT = lecheD_CT;
    }

    public int getLecheD_Ce() {
        return lecheD_Ce;
    }

    public void setLecheD_Ce(int lecheD_Ce) {
        this.lecheD_Ce = lecheD_Ce;
    }

    public int getLecheE_D() {
        return lecheE_D;
    }

    public void setLecheE_D(int lecheE_D) {
        this.lecheE_D = lecheE_D;
    }

    public int getLecheE_CM() {
        return lecheE_CM;
    }

    public void setLecheE_CM(int lecheE_CM) {
        this.lecheE_CM = lecheE_CM;
    }

    public int getLecheE_Co() {
        return lecheE_Co;
    }

    public void setLecheE_Co(int lecheE_Co) {
        this.lecheE_Co = lecheE_Co;
    }

    public int getLecheE_CT() {
        return lecheE_CT;
    }

    public void setLecheE_CT(int lecheE_CT) {
        this.lecheE_CT = lecheE_CT;
    }

    public int getLecheE_Ce() {
        return lecheE_Ce;
    }

    public void setLecheE_Ce(int lecheE_Ce) {
        this.lecheE_Ce = lecheE_Ce;
    }

    public int getLeguminosas_D() {
        return leguminosas_D;
    }

    public void setLeguminosas_D(int leguminosas_D) {
        this.leguminosas_D = leguminosas_D;
    }

    public int getLeguminosas_CM() {
        return leguminosas_CM;
    }

    public void setLeguminosas_CM(int leguminosas_CM) {
        this.leguminosas_CM = leguminosas_CM;
    }

    public int getLeguminosas_Co() {
        return leguminosas_Co;
    }

    public void setLeguminosas_Co(int leguminosas_Co) {
        this.leguminosas_Co = leguminosas_Co;
    }

    public int getLeguminosas_CT() {
        return leguminosas_CT;
    }

    public void setLeguminosas_CT(int leguminosas_CT) {
        this.leguminosas_CT = leguminosas_CT;
    }

    public int getLeguminosas_Ce() {
        return leguminosas_Ce;
    }

    public void setLeguminosas_Ce(int leguminosas_Ce) {
        this.leguminosas_Ce = leguminosas_Ce;
    }

    public int getGrasasMO_D() {
        return grasasMO_D;
    }

    public void setGrasasMO_D(int grasasMO_D) {
        this.grasasMO_D = grasasMO_D;
    }

    public int getGrasasMO_CM() {
        return grasasMO_CM;
    }

    public void setGrasasMO_CM(int grasasMO_CM) {
        this.grasasMO_CM = grasasMO_CM;
    }

    public int getGrasasMO_Co() {
        return grasasMO_Co;
    }

    public void setGrasasMO_Co(int grasasMO_Co) {
        this.grasasMO_Co = grasasMO_Co;
    }

    public int getGrasasMO_CT() {
        return grasasMO_CT;
    }

    public void setGrasasMO_CT(int grasasMO_CT) {
        this.grasasMO_CT = grasasMO_CT;
    }

    public int getGrasasMO_Ce() {
        return grasasMO_Ce;
    }

    public void setGrasasMO_Ce(int grasasMO_Ce) {
        this.grasasMO_Ce = grasasMO_Ce;
    }

    public int getGrasasPO_D() {
        return grasasPO_D;
    }

    public void setGrasasPO_D(int grasasPO_D) {
        this.grasasPO_D = grasasPO_D;
    }

    public int getGrasasPO_CM() {
        return grasasPO_CM;
    }

    public void setGrasasPO_CM(int grasasPO_CM) {
        this.grasasPO_CM = grasasPO_CM;
    }

    public int getGrasasPO_Co() {
        return grasasPO_Co;
    }

    public void setGrasasPO_Co(int grasasPO_Co) {
        this.grasasPO_Co = grasasPO_Co;
    }

    public int getGrasasPO_CT() {
        return grasasPO_CT;
    }

    public void setGrasasPO_CT(int grasasPO_CT) {
        this.grasasPO_CT = grasasPO_CT;
    }

    public int getGrasasPO_Ce() {
        return grasasPO_Ce;
    }

    public void setGrasasPO_Ce(int grasasPO_Ce) {
        this.grasasPO_Ce = grasasPO_Ce;
    }

    public int getGrasasST_D() {
        return grasasST_D;
    }

    public void setGrasasST_D(int grasasST_D) {
        this.grasasST_D = grasasST_D;
    }

    public int getGrasasST_CM() {
        return grasasST_CM;
    }

    public void setGrasasST_CM(int grasasST_CM) {
        this.grasasST_CM = grasasST_CM;
    }

    public int getGrasasST_Co() {
        return grasasST_Co;
    }

    public void setGrasasST_Co(int grasasST_Co) {
        this.grasasST_Co = grasasST_Co;
    }

    public int getGrasasST_CT() {
        return grasasST_CT;
    }

    public void setGrasasST_CT(int grasasST_CT) {
        this.grasasST_CT = grasasST_CT;
    }

    public int getGrasasST_Ce() {
        return grasasST_Ce;
    }

    public void setGrasasST_Ce(int grasasST_Ce) {
        this.grasasST_Ce = grasasST_Ce;
    }

    public int getAzucares_D() {
        return azucares_D;
    }

    public void setAzucares_D(int azucares_D) {
        this.azucares_D = azucares_D;
    }

    public int getAzucares_CM() {
        return azucares_CM;
    }

    public void setAzucares_CM(int azucares_CM) {
        this.azucares_CM = azucares_CM;
    }

    public int getAzucares_Co() {
        return azucares_Co;
    }

    public void setAzucares_Co(int azucares_Co) {
        this.azucares_Co = azucares_Co;
    }

    public int getAzucares_CT() {
        return azucares_CT;
    }

    public void setAzucares_CT(int azucares_CT) {
        this.azucares_CT = azucares_CT;
    }

    public int getAzucares_Ce() {
        return azucares_Ce;
    }

    public void setAzucares_Ce(int azucares_Ce) {
        this.azucares_Ce = azucares_Ce;
    }

    public int getAzucaresG_D() {
        return azucaresG_D;
    }

    public void setAzucaresG_D(int azucaresG_D) {
        this.azucaresG_D = azucaresG_D;
    }

    public int getAzucaresG_CM() {
        return azucaresG_CM;
    }

    public void setAzucaresG_CM(int azucaresG_CM) {
        this.azucaresG_CM = azucaresG_CM;
    }

    public int getAzucaresG_Co() {
        return azucaresG_Co;
    }

    public void setAzucaresG_Co(int azucaresG_Co) {
        this.azucaresG_Co = azucaresG_Co;
    }

    public int getAzucaresG_CT() {
        return azucaresG_CT;
    }

    public void setAzucaresG_CT(int azucaresG_CT) {
        this.azucaresG_CT = azucaresG_CT;
    }

    public int getAzucaresG_Ce() {
        return azucaresG_Ce;
    }

    public void setAzucaresG_Ce(int azucaresG_Ce) {
        this.azucaresG_Ce = azucaresG_Ce;
    }
    
    public List<Grupoalimentos> getListaGrupoAlimentos() {
        return grupoalimentos_ln.list_ga();
    }
    
    public void calcularKcal() {
        List<Grupoalimentos> lista = grupoalimentos_ln.list_ga();
        ArrayList<Integer> lista_energia = new ArrayList<>(); 
        double[] cerealesSG = {cerealSG_D, cerealSG_CM, cerealSG_Co, cerealSG_CT, cerealSG_Ce};
        double[] cerealesCG = {cerealCG_D, cerealCG_CM, cerealCG_Co, cerealCG_CT, cerealCG_Ce};
        double[] verduras = {verduras_D, verduras_CM, verduras_Co, verduras_CT, verduras_Ce};
        double[] frutas = {frutas_D, frutas_CM, frutas_Co, frutas_CT, frutas_Ce};
        double[] alimAnimalMBG = {alimOriAnimMBG_D, alimOriAnimMBG_CM, alimOriAnimMBG_Co, alimOriAnimMBG_CT, alimOriAnimMBG_Ce};
        double[] alimAnimalBG = {alimOriAnimBG_D, alimOriAnimBG_CM, alimOriAnimBG_Co, alimOriAnimBG_CT, alimOriAnimBG_Ce};
        double[] lecheD = {lecheD_D, lecheD_CM, lecheD_Co, lecheD_CT, lecheD_Ce};
        double[] lecheE = {lecheE_D, lecheE_CM, lecheE_Co, lecheE_CT, lecheE_Ce};
        double[] leguminosas = {leguminosas_D, leguminosas_CM, leguminosas_Co, leguminosas_CT, leguminosas_Ce};
        double[] grasasMO = {grasasMO_D, grasasMO_CM, grasasMO_Co, grasasMO_CT, grasasMO_Ce};
        double[] grasasPO = {grasasPO_D, grasasPO_CM, grasasPO_Co, grasasPO_CT, grasasPO_Ce};
        double[] grasasST = {grasasST_D, grasasST_CM, grasasST_Co, grasasST_CT, grasasST_Ce};
        double[] azucares = {azucares_D, azucares_CM, azucares_Co, azucares_CT, azucares_Ce};
        double[] azucaresG = {azucaresG_D, azucaresG_CM, azucaresG_Co, azucaresG_CT, azucaresG_Ce};
        
        double[] desayuno = {cerealesSG[0], cerealesCG[0], verduras[0], frutas[0], alimAnimalMBG[0], alimAnimalBG[0], lecheD[0], lecheE[0], leguminosas[0], grasasMO[0], grasasPO[0], grasasST[0], azucares[0], azucaresG[0]};
        double[] colacion_M = {cerealesSG[1], cerealesCG[1], verduras[1], frutas[1], alimAnimalMBG[1], alimAnimalBG[1], lecheD[1], lecheE[1], leguminosas[1], grasasMO[1], grasasPO[1], grasasST[1], azucares[1], azucaresG[1]};
        double[] comida = {cerealesSG[2], cerealesCG[2], verduras[2], frutas[2], alimAnimalMBG[2], alimAnimalBG[2], lecheD[2], lecheE[2], leguminosas[2], grasasMO[2], grasasPO[2], grasasST[2], azucares[2], azucaresG[2]};
        double[] colacion_T = {cerealesSG[3], cerealesCG[3], verduras[3], frutas[3], alimAnimalMBG[3], alimAnimalBG[3], lecheD[3], lecheE[3], leguminosas[3], grasasMO[3], grasasPO[3], grasasST[3], azucares[3], azucaresG[3]};
        double[] cena = {cerealesSG[4], cerealesCG[4], verduras[4], frutas[4], alimAnimalMBG[4], alimAnimalBG[4], lecheD[4], lecheE[4], leguminosas[4], grasasMO[4], grasasPO[4], grasasST[4], azucares[4], azucaresG[4]};
        
        todosGpos.add(desayuno);
        todosGpos.add(colacion_M);
        todosGpos.add(comida);
        todosGpos.add(colacion_T);
        todosGpos.add(cena);
        
        for(Grupoalimentos ga: lista) {
            lista_energia.add(ga.getEnergia());
            lista_nombres.add(ga.getNombre());
        }
        
        for(int i=0; i<cerealesSG.length; i++)    cerealesSG[i]    = cerealesSG[i]    * lista_energia.get(0);
        for(int i=0; i<cerealesCG.length; i++)    cerealesCG[i]    = cerealesCG[i]    * lista_energia.get(1);
        for(int i=0; i<verduras.length; i++)      verduras[i]      = verduras[i]      * lista_energia.get(2);
        for(int i=0; i<frutas.length; i++)        frutas[i]        = frutas[i]        * lista_energia.get(3);
        for(int i=0; i<alimAnimalMBG.length; i++) alimAnimalMBG[i] = alimAnimalMBG[i] * lista_energia.get(4);
        for(int i=0; i<alimAnimalBG.length; i++)  alimAnimalBG[i]  = alimAnimalBG[i]  * lista_energia.get(5);
        for(int i=0; i<lecheD.length; i++)        lecheD[i]        = lecheD[i]        * lista_energia.get(6);
        for(int i=0; i<lecheE.length; i++)        lecheE[i]        = lecheE[i]        * lista_energia.get(7);
        for(int i=0; i<leguminosas.length; i++)   leguminosas[i]   = leguminosas[i]   * lista_energia.get(8);
        for(int i=0; i<grasasMO.length; i++)      grasasMO[i]      = grasasMO[i]      * lista_energia.get(9);
        for(int i=0; i<grasasPO.length; i++)      grasasPO[i]      = grasasPO[i]      * lista_energia.get(10);
        for(int i=0; i<grasasST.length; i++)      grasasST[i]      = grasasST[i]      * lista_energia.get(11);
        for(int i=0; i<azucares.length; i++)      azucares[i]      = azucares[i]      * lista_energia.get(12);
        for(int i=0; i<azucaresG.length; i++)     azucaresG[i]     = azucaresG[i]     * lista_energia.get(13);
            
        /*
        kcal_D  = cerealSG_D + cerealCG_D + verduras_D + frutas_D + alimOriAnimMBG_D + alimOriAnimBG_D + lecheD_D + lecheE_D + leguminosas_D + grasasMO_D + grasasPO_D + grasasST_D + azucares_D + azucaresG_D; 
        kcal_CM = cerealSG_CM + cerealCG_CM + verduras_CM + frutas_CM + alimOriAnimMBG_CM + alimOriAnimBG_CM + lecheD_CM + lecheE_CM + leguminosas_CM + grasasMO_CM + grasasPO_CM + grasasST_CM + azucares_CM + azucaresG_CM;
        kcal_Co = cerealSG_Co + cerealCG_Co + verduras_Co + frutas_Co + alimOriAnimMBG_Co + alimOriAnimBG_Co + lecheD_Co + lecheE_Co + leguminosas_Co + grasasMO_Co + grasasPO_Co + grasasST_Co + azucares_Co + azucaresG_Co;
        kcal_CT = cerealSG_CT + cerealCG_CT + verduras_CT + frutas_CT + alimOriAnimMBG_CT + alimOriAnimBG_CT + lecheD_CT + lecheE_CT + leguminosas_CT + grasasMO_CT + grasasPO_CT + grasasST_CT + azucares_CT + azucaresG_CT;
        kcal_Ce = cerealSG_Ce + cerealCG_Ce + verduras_Ce + frutas_Ce + alimOriAnimMBG_Ce + alimOriAnimBG_Ce + lecheD_Ce + lecheE_Ce + leguminosas_Ce + grasasMO_Ce + grasasPO_Ce + grasasST_Ce + azucares_Ce + azucaresG_Ce;
        */
        kcal_D   = cerealesSG[0] + cerealesCG[0] + verduras[0] + frutas[0] + alimAnimalMBG[0] + alimAnimalBG[0] + lecheD[0] + lecheE[0] + leguminosas[0] + grasasMO[0] + grasasPO[0] + grasasST[0] + azucares[0] + azucaresG[0]; 
        kcal_CM  = cerealesSG[1] + cerealesCG[1] + verduras[1] + frutas[1] + alimAnimalMBG[1] + alimAnimalBG[1] + lecheD[1] + lecheE[1] + leguminosas[1] + grasasMO[1] + grasasPO[1] + grasasST[1] + azucares[1] + azucaresG[1]; 
        kcal_Co  = cerealesSG[2] + cerealesCG[2] + verduras[2] + frutas[2] + alimAnimalMBG[2] + alimAnimalBG[2] + lecheD[2] + lecheE[2] + leguminosas[2] + grasasMO[2] + grasasPO[2] + grasasST[2] + azucares[2] + azucaresG[2]; 
        kcal_CT  = cerealesSG[3] + cerealesCG[3] + verduras[3] + frutas[3] + alimAnimalMBG[3] + alimAnimalBG[3] + lecheD[3] + lecheE[3] + leguminosas[3] + grasasMO[3] + grasasPO[3] + grasasST[3] + azucares[3] + azucaresG[3]; 
        kcal_Ce  = cerealesSG[4] + cerealesCG[4] + verduras[4] + frutas[4] + alimAnimalMBG[4] + alimAnimalBG[4] + lecheD[4] + lecheE[4] + leguminosas[4] + grasasMO[4] + grasasPO[4] + grasasST[4] + azucares[4] + azucaresG[4]; 
        
        kcal_To = kcal_D + kcal_CM + kcal_Co + kcal_CT + kcal_Ce;
    }
    
    public void enviarMenu() {
        for (int i = 0; i < todosGpos.size(); i++) {
            for (int j = 0; j < 14; j++) {
                if (todosGpos.get(i)[j] > 0) {
                    switch (i) {
                        case 0:
                            list_desayuno.add((int) todosGpos.get(i)[j] + " Porcion(es) de " + lista_nombres.get(j) + " ");
                            break;
                        case 1:
                            list_colacionM.add((int) todosGpos.get(i)[j] + " Porcion(es) de " + lista_nombres.get(j) + " ");
                            break;
                        case 2:
                            list_comida.add((int) todosGpos.get(i)[j] + " Porcion(es) de " + lista_nombres.get(j) + " ");
                            break;
                        case 3:
                            list_colacionT.add((int) todosGpos.get(i)[j] + " Porcion(es) de " + lista_nombres.get(j) + " ");
                            break;
                        case 4:
                            list_cena.add((int) todosGpos.get(i)[j] + " Porcion(es) de " + lista_nombres.get(j) + " ");
                            break;
                    }
                }
            }
        }
    }
}
