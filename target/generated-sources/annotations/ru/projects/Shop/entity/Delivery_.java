package ru.projects.Shop.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.Provider;
import ru.projects.Shop.entity.Shop;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Delivery.class)
public class Delivery_ { 

    public static volatile ListAttribute<Delivery, Product> ProductList;
    public static volatile SingularAttribute<Delivery, Shop> Shop;
    public static volatile SingularAttribute<Delivery, Long> Delivery_ID;
    public static volatile SingularAttribute<Delivery, Date> DateOfDelivery;
    public static volatile SingularAttribute<Delivery, Provider> Provider;

}