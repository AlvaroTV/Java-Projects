package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Palabras;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-03T21:05:38")
@StaticMetamodel(Tipopalabras.class)
public class Tipopalabras_ { 

    public static volatile SingularAttribute<Tipopalabras, String> descripcion;
    public static volatile SingularAttribute<Tipopalabras, Integer> idtipos;
    public static volatile CollectionAttribute<Tipopalabras, Palabras> palabrasCollection;

}