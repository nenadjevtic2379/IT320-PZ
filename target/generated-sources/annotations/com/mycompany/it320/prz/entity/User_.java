package com.mycompany.it320.prz.entity;

import com.mycompany.it320.prz.entity.User;
import com.mycompany.it320.prz.entity.Userrole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-26T23:16:08")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile SingularAttribute<User, String> ime;
    public static volatile SingularAttribute<User, String> prezime;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, User> useIdUser;
    public static volatile SingularAttribute<User, Userrole> idRole;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}