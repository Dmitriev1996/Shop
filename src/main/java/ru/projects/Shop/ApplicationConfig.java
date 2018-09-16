package ru.projects.Shop;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.jersey.jackson.JacksonFeature;

import ru.projects.Shop.rest.AdressRestService;
import ru.projects.Shop.rest.BonusCardRestService;
import ru.projects.Shop.rest.BuyRestService;
import ru.projects.Shop.rest.CityRestService;
import ru.projects.Shop.rest.ClientRestService;
import ru.projects.Shop.rest.CommentRestService;
import ru.projects.Shop.rest.CountryRestService;
import ru.projects.Shop.rest.CredentialRestService;
import ru.projects.Shop.rest.DeliveryRestService;
import ru.projects.Shop.rest.ForumRestService;
import ru.projects.Shop.rest.MessageRestService;
import ru.projects.Shop.rest.OrderRestService;
import ru.projects.Shop.rest.ProductRestService;
import ru.projects.Shop.rest.ProductUnitRestService;
import ru.projects.Shop.rest.ProviderRestService;
import ru.projects.Shop.rest.RegionRestService;
import ru.projects.Shop.rest.SexRestService;
import ru.projects.Shop.rest.ShopRestService;
import ru.projects.Shop.rest.StatusOfOrderRestService;
import ru.projects.Shop.rest.TransportationRestService;
import ru.projects.Shop.rest.TransportationTypeRestService;
import ru.projects.Shop.rest.TypeProductRestService;
import ru.projects.Shop.rest.TypeShopRestService;
import ru.projects.Shop.rest.WarehouseRestService;
import ru.projects.Shop.rest.WorkerRestService;

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
		c.add(CountryRestService.class);
		c.add(DeliveryRestService.class);
		c.add(ForumRestService.class);
		c.add(MessageRestService.class);
		c.add(OrderRestService.class);
		c.add(ProductRestService.class);
		c.add(ProductUnitRestService.class);
		c.add(ProviderRestService.class);
		c.add(RegionRestService.class);
		c.add(SexRestService.class);
		c.add(ShopRestService.class);
		c.add(StatusOfOrderRestService.class);
		c.add(TransportationRestService.class);
		c.add(TransportationTypeRestService.class);
		c.add(TypeProductRestService.class);
		c.add(TypeShopRestService.class);
		c.add(WarehouseRestService.class);
		c.add(WorkerRestService.class);
		c.add(CredentialRestService.class);
		//c.add(MOXyJsonProvider.class);
		c.add(JacksonFeature.class);
		classes=Collections.unmodifiableSet(c);
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}
