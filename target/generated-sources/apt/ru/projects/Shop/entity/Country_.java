package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Region;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:35")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, Long> Country_ID;
    public static volatile SingularAttribute<Country, String> Country;
    public static volatile ListAttribute<Country, Region> RegionList;

}