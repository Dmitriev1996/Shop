package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Country;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Region.class)
public class Region_ { 

    public static volatile ListAttribute<Region, City> CityList;
    public static volatile SingularAttribute<Region, Long> Region_ID;
    public static volatile SingularAttribute<Region, String> Region;
    public static volatile SingularAttribute<Region, Country> Country;

}