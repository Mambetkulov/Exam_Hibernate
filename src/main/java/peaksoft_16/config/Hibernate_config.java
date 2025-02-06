package peaksoft_16.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft_16.models.UserDetail;
import peaksoft_16.models.UserProfile;

import java.util.Properties;

public class Hibernate_config {

    public static EntityManagerFactory entityManagerFactory() {

        Properties prop = new Properties();

        try{
            prop.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/postgres");
            prop.put(Environment.JAKARTA_JDBC_USER, "postgres");
            prop.put(Environment.JAKARTA_JDBC_PASSWORD, "muha2004");
            prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            prop.put(Environment.HBM2DDL_AUTO,"update");
            prop.put(Environment.SHOW_SQL,"true");

            Configuration con = new Configuration().addProperties(prop);
            con.addAnnotatedClass(UserProfile.class);
            con.addAnnotatedClass(UserDetail.class);
            return con.buildSessionFactory().unwrap(EntityManagerFactory.class);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
