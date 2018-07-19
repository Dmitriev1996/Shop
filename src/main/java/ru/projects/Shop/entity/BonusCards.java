package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(BonusCard.class)
public class BonusCards extends ArrayList<BonusCard>{
	public BonusCards() {
		super();
	}
	
	public BonusCards(Collection<? extends BonusCard> c ) {
		super(c);
	}
	
	@XmlElement(name="bonuscard")
	public List<BonusCard> getBonusCard() {
		return this;
	}
	
	public void setBonusCardsList(List<BonusCard> bonuscards) {
		this.addAll(bonuscards);
	}

}
