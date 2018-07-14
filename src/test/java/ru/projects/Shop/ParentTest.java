package ru.projects.Shop;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class ParentTest {
	protected static EJBContainer ec;
	protected static Context ctx;
	
	  @BeforeClass
	  public static void initContainer() throws Exception {
	    Map<String, Object> properties = new HashMap<String, Object>();
	    properties.put(EJBContainer.MODULES, new File("target/classes"));
	    ec = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);
	    ctx = ec.getContext();
	  }

	  @AfterClass
	  public static void closeContainer() throws Exception {
	    if (ctx != null)
	      ctx.close();
	    if (ec != null)
	      ec.close();
	  }

}
