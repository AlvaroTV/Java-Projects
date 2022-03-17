package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Palabras;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-03T21:05:38")
@StaticMetamodel(JuegosUsuario.class)
public class JuegosUsuario_ { 

    public static volatile SingularAttribute<JuegosUsuario, Integer> intentosr;
    public static volatile SingularAttribute<JuegosUsuario, Palabras> palabra;
    public static volatile SingularAttribute<JuegosUsuario, Date> fechaHora;
    public static volatile SingularAttribute<JuegosUsuario, Integer> intentost;
    public static volatile SingularAttribute<JuegosUsuario, Integer> idjuegousu;
    public static volatile SingularAttribute<JuegosUsuario, Usuario> idusuario;

}