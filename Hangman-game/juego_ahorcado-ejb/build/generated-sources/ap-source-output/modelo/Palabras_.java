package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.JuegosUsuario;
import modelo.Tipopalabras;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-03T21:05:38")
@StaticMetamodel(Palabras.class)
public class Palabras_ { 

    public static volatile CollectionAttribute<Palabras, JuegosUsuario> juegosUsuarioCollection;
    public static volatile SingularAttribute<Palabras, Tipopalabras> tipo;
    public static volatile SingularAttribute<Palabras, String> palabra;
    public static volatile SingularAttribute<Palabras, Integer> idpalabra;
    public static volatile SingularAttribute<Palabras, Integer> nivel;

}