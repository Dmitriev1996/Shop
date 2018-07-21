package ru.projects.Shop.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Sex;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:37")
@StaticMetamodel(Worker.class)
public class Worker_ { 

    public static volatile SingularAttribute<Worker, Date> DateOfBirth;
    public static volatile SingularAttribute<Worker, Sex> Sex;
    public static volatile SingularAttribute<Worker, Long> Worker_ID;
    public static volatile SingularAttribute<Worker, String> Patronymic;
    public static volatile SingularAttribute<Worker, String> Surname;
    public static volatile SingularAttribute<Worker, String> Name;

}