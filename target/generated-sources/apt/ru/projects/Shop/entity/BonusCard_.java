package ru.projects.Shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.projects.Shop.entity.Client;

@Generated(value="EclipseLink-2.6.2.v20160113-rNA", date="2018-07-21T18:51:35")
@StaticMetamodel(BonusCard.class)
public class BonusCard_ { 

    public static volatile SingularAttribute<BonusCard, Long> Card_ID;
    public static volatile SingularAttribute<BonusCard, Double> SumOfBonus;
    public static volatile SingularAttribute<BonusCard, Client> Client;

}