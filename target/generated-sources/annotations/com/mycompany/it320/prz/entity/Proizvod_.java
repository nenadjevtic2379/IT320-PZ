package com.mycompany.it320.prz.entity;

import com.mycompany.it320.prz.entity.Prodavnica;
import com.mycompany.it320.prz.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-26T23:16:08")
@StaticMetamodel(Proizvod.class)
public class Proizvod_ { 

    public static volatile SingularAttribute<Proizvod, User> idUser;
    public static volatile SingularAttribute<Proizvod, Integer> idProizvod;
    public static volatile SingularAttribute<Proizvod, String> nazivProizvod;
    public static volatile SingularAttribute<Proizvod, Date> datummodifikacije;
    public static volatile SingularAttribute<Proizvod, Integer> stanje;
    public static volatile SingularAttribute<Proizvod, Prodavnica> idProdavnica;
    public static volatile SingularAttribute<Proizvod, Date> rokupotrebe;
    public static volatile SingularAttribute<Proizvod, Integer> minimum;
    public static volatile SingularAttribute<Proizvod, Boolean> status;

}