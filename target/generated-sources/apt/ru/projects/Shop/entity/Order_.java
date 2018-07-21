package ru.projects.Shop.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.StatusOfOrder;
import ru.projects.Shop.entity.Transportation;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:35")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Long> Order_ID;
    public static volatile ListAttribute<Order, Product> ProductList;
    public static volatile SingularAttribute<Order, Double> SumOfOrder;
    public static volatile SingularAttribute<Order, StatusOfOrder> StatusOfOrder;
    public static volatile SingularAttribute<Order, Transportation> Transportation;
    public static volatile SingularAttribute<Order, Client> Client;
    public static volatile SingularAttribute<Order, Date> DateOfOrder;

}