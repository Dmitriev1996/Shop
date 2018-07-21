package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.Shop;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:35")
@StaticMetamodel(Warehouse.class)
public class Warehouse_ { 

    public static volatile SingularAttribute<Warehouse, Shop> Shop;
    public static volatile SingularAttribute<Warehouse, Long> Warehouse_ID;
    public static volatile SingularAttribute<Warehouse, Long> Value;
    public static volatile SingularAttribute<Warehouse, Product> Product;

}