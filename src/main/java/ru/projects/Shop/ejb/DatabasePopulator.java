package ru.projects.Shop.ejb;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/Shop",
        user = "app",
        password = "app",
        databaseName = "Shop",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {

}
