package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Product;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, String> Comment;
    public static volatile SingularAttribute<Comment, Long> Comment_ID;
    public static volatile SingularAttribute<Comment, Product> Product;
    public static volatile SingularAttribute<Comment, Client> Client;

}