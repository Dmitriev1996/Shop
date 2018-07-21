package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Comment;
import ru.projects.Shop.entity.TypeProduct;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:35")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Double> Mass;
    public static volatile SingularAttribute<Product, String> Description;
    public static volatile SingularAttribute<Product, Long> Product_ID;
    public static volatile SingularAttribute<Product, String> Articul;
    public static volatile SingularAttribute<Product, Double> Price;
    public static volatile ListAttribute<Product, Comment> CommentList;
    public static volatile SingularAttribute<Product, TypeProduct> TypeProduct;
    public static volatile SingularAttribute<Product, String> NameOfProduct;

}