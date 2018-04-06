package se.simpleshop.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// En singleton, för enkelhetens skull som demonstration
public class PersistenceManager {

    private EntityManagerFactory emFactory;
    private static PersistenceManager instance;

    // Förhindrar att man kan skapa instanser
    private PersistenceManager() {
        emFactory = Persistence.createEntityManagerFactory("simple-shop");
    }

    public static PersistenceManager getInstance() {
        if(instance == null) {
            instance = new PersistenceManager();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public void close() {
        emFactory.close();
    }
}