package ru.projects.Shop.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Product;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Buy.class)
public class Buy_ { 

    public static volatile ListAttribute<Buy, Product> ProductList;
    public static volatile SingularAttribute<Buy, Date> DateBuy;
    public static volatile SingularAttribute<Buy, Long> Buy_ID;
    public static volatile SingularAttribute<Buy, Double> SumBuy;

}