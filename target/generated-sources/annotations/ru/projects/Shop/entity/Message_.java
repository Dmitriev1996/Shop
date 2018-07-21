package ru.projects.Shop.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Client;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, Date> DateOfMessage;
    public static volatile SingularAttribute<Message, String> Message;
    public static volatile SingularAttribute<Message, Long> Message_ID;
    public static volatile SingularAttribute<Message, Client> Client;

}