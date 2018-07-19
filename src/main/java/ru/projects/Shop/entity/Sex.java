package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="sexes")
@NamedQuery(name="findAllSex", query="SELECT s FROM Sex s"
		+ " ORDER BY s.Sex_ID DESC")
public class Sex implements Serializable {
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
