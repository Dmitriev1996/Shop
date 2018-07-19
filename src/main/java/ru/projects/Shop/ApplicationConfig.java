package ru.projects.Shop;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class ApplicationConfig extends Application {
	private final Set<Class<?>> classes;
	
	public ApplicationConfig() {
		HashSet<Class<?>> c=new HashSet();
		classes=Collections.unmodifiableSet(c);
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}
