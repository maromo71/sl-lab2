package net.maromo.web06time.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(
            "jogadorJSTL"
    );

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
