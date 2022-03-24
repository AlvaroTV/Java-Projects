package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Medidasu;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-23T03:11:19")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Date> fechanac;
    public static volatile SingularAttribute<Usuario, Integer> estatura;
    public static volatile ListAttribute<Usuario, Medidasu> medidasuList;
    public static volatile SingularAttribute<Usuario, Integer> idusu;
    public static volatile SingularAttribute<Usuario, Character> sexo;
    public static volatile SingularAttribute<Usuario, String> nombre;

}