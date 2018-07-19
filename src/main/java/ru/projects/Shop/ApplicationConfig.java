package ru.projects.Shop;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ru.projects.Shop.rest.AdressRestService;
import ru.projects.Shop.rest.BonusCardRestService;
import ru.projects.Shop.rest.BuyRestService;
import ru.projects.Shop.rest.CityRestService;
import ru.projects.Shop.rest.ClientRestService;
import ru.projects.Shop.rest.CommentRestService;

@ApplicationPath("api")
public class ApplicationConfig extends Application {
	private final Set<Class<?>> classes;
	
	public ApplicationConfig() {
		HashSet<Class<?>> c=new HashSet();
		c.add(AdressRestService.class);
		c.add(BonusCardRestService.class);
		c.add(BuyRestService.class);
		c.add(CityRestService.class);
		c.add(ClientRestService.class);
		c.add(CommentRestService.class);
		classes=Collections.unmodifiableSet(c);
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}
