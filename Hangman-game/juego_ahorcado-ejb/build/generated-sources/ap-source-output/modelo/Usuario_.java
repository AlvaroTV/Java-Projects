package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.JuegosUsuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-03T21:05:38")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> tpersona;
    public static volatile SingularAttribute<Usuario, Date> fechaRegistro;
    public static volatile ListAttribute<Usuario, JuegosUsuario> juegosUsuarioList;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;

}