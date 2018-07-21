package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Adress;
import ru.projects.Shop.entity.Order;
import ru.projects.Shop.entity.TransportationType;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Transportation.class)
public class Transportation_ { 

    public static volatile SingularAttribute<Transportation, Order> Order;
    public static volatile SingularAttribute<Transportation, Adress> Adress;
    public static volatile SingularAttribute<Transportation, TransportationType> TransportationType;
    public static volatile SingularAttribute<Transportation, Long> Transportation_ID;

}