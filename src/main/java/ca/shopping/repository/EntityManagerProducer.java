package ca.shopping.repository;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	    @Produces
	    @RequestScoped
	    protected EntityManager createEntityManager() {
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
	        return factory.createEntityManager();
	    }
	    protected void closeEntityManager(@Disposes EntityManager entityManager) {
	        if (entityManager.isOpen()) {
	            entityManager.close();
	        }
	    }
 
}