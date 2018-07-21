package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Region;
import ru.projects.Shop.entity.TypeShop;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Shop.class)
public class Shop_ { 

    public static volatile SingularAttribute<Shop, String> Email;
    public static volatile SingularAttribute<Shop, String> Phone;
    public static volatile SingularAttribute<Shop, String> Adress;
    public static volatile SingularAttribute<Shop, Long> Shop_ID;
    public static volatile SingularAttribute<Shop, Country> Country;
    public static volatile SingularAttribute<Shop, Region> Region;
    public static volatile SingularAttribute<Shop, TypeShop> TypeShop;
    public static volatile SingularAttribute<Shop, City> City;

}