package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Message;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:35")
@StaticMetamodel(Forum.class)
public class Forum_ { 

    public static volatile SingularAttribute<Forum, String> NameOfForum;
    public static volatile SingularAttribute<Forum, Long> Forum_ID;
    public static volatile SingularAttribute<Forum, Client> Client;
    public static volatile ListAttribute<Forum, Message> MessageList;

}