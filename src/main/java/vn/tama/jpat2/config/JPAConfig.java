package vn.tama.jpat2.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serializable;

public class JPAConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dataSource");
        return factory.createEntityManager();
    }
}
