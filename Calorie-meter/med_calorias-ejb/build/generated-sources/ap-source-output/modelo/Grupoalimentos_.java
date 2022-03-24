package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Alimento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-23T03:11:19")
@StaticMetamodel(Grupoalimentos.class)
public class Grupoalimentos_ { 

    public static volatile SingularAttribute<Grupoalimentos, String> uniazucares;
    public static volatile SingularAttribute<Grupoalimentos, Integer> energia;
    public static volatile SingularAttribute<Grupoalimentos, Integer> hidratos;
    public static volatile SingularAttribute<Grupoalimentos, Integer> proteinas;
    public static volatile SingularAttribute<Grupoalimentos, String> nombre;
    public static volatile SingularAttribute<Grupoalimentos, Integer> sales;
    public static volatile SingularAttribute<Grupoalimentos, String> unihidratos;
    public static volatile SingularAttribute<Grupoalimentos, String> unigrasas;
    public static volatile SingularAttribute<Grupoalimentos, String> uniproteinas;
    public static volatile SingularAttribute<Grupoalimentos, Integer> azucares;
    public static volatile ListAttribute<Grupoalimentos, Alimento> alimentoList;
    public static volatile SingularAttribute<Grupoalimentos, Integer> grasas;
    public static volatile SingularAttribute<Grupoalimentos, String> unisales;
    public static volatile SingularAttribute<Grupoalimentos, String> unienergia;
    public static volatile SingularAttribute<Grupoalimentos, Integer> idgpo;

}