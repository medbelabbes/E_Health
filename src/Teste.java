

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Teste {

    public static void main(String... args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("E_HealthPersistenceUnit");
        EntityManager em = emf.createEntityManager();

    }

}
