package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Country;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Provider.class)
public class Provider_ { 

    public static volatile SingularAttribute<Provider, String> NameOfProvider;
    public static volatile SingularAttribute<Provider, Long> Provider_ID;
    public static volatile SingularAttribute<Provider, String> Email;
    public static volatile SingularAttribute<Provider, String> Phone;
    public static volatile SingularAttribute<Provider, String> Adress;
    public static volatile SingularAttribute<Provider, Country> Country;
    public static volatile SingularAttribute<Provider, City> City;

}