package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Region;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Adress.class)
public class Adress_ { 

    public static volatile SingularAttribute<Adress, Integer> NumberOfHouse;
    public static volatile SingularAttribute<Adress, Integer> NumberOfEntrance;
    public static volatile SingularAttribute<Adress, Country> Country;
    public static volatile SingularAttribute<Adress, Region> Region;
    public static volatile SingularAttribute<Adress, String> Street;
    public static volatile SingularAttribute<Adress, Long> NumberOfAppartament;
    public static volatile SingularAttribute<Adress, Long> Adress_ID;
    public static volatile SingularAttribute<Adress, City> City;
    public static volatile SingularAttribute<Adress, String> Corpus;

}