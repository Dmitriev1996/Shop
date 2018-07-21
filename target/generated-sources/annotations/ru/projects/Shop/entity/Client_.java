package ru.projects.Shop.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Buy;
import ru.projects.Shop.entity.Comment;
import ru.projects.Shop.entity.Order;
import ru.projects.Shop.entity.Sex;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Date> DateOfBirth;
    public static volatile SingularAttribute<Client, Sex> Sex;
    public static volatile ListAttribute<Client, Comment> CommentList;
    public static volatile SingularAttribute<Client, Long> Client_ID;
    public static volatile ListAttribute<Client, Buy> BuyList;
    public static volatile ListAttribute<Client, Order> OrderList;
    public static volatile SingularAttribute<Client, String> Patronymic;
    public static volatile SingularAttribute<Client, String> Surname;
    public static volatile SingularAttribute<Client, String> Name;

}