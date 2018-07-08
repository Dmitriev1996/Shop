package ru.projects.Shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sexes")
public class Sex {
	@Id @GeneratedValue
	private Long Sex_ID;
	private String Sex;
	
	public Sex() {}

	public Long getSex_ID() {
		return Sex_ID;
	}

	public void setSex_ID(Long sex_ID) {
		Sex_ID = sex_ID;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}
	
	

}
