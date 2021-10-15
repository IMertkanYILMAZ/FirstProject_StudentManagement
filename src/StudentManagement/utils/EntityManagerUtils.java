package StudentManagement.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {

    static EntityManagerFactory emf = null;

    public static javax.persistence.EntityManager getEntityManager(String persistenceUnitName){
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        return emf.createEntityManager();
    }

    public static void closeEntityManager(javax.persistence.EntityManager em){
        em.clear();
        em.close();
        emf.close();
    }
}