package com.mycompany.it320.prz.entity;

import com.mycompany.it320.prz.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-26T23:16:08")
@StaticMetamodel(Prodavnica.class)
public class Prodavnica_ { 

    public static volatile SingularAttribute<Prodavnica, User> idUser;
    public static volatile SingularAttribute<Prodavnica, Date> datummodifikacije;
    public static volatile SingularAttribute<Prodavnica, Integer> idProdavnica;
    public static volatile SingularAttribute<Prodavnica, String> nazivProdavnica;
    public static volatile SingularAttribute<Prodavnica, Boolean> status;

}