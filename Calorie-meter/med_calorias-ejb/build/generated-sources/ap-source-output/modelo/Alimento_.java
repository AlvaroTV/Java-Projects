package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Grupoalimentos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-23T03:11:19")
@StaticMetamodel(Alimento.class)
public class Alimento_ { 

    public static volatile SingularAttribute<Alimento, String> unidad;
    public static volatile SingularAttribute<Alimento, Integer> idalimento;
    public static volatile SingularAttribute<Alimento, Double> racion;
    public static volatile SingularAttribute<Alimento, String> nombre;
    public static volatile SingularAttribute<Alimento, Grupoalimentos> idgpo;

}