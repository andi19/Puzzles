package de.hftstuttgart.puzzles.utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The Enum DatenbankConnectionUtility.
 */
public enum DatenbankConnectionUtility {
	
	/** The instance. */
	INSTANCE;
	
	/** The Constant PERSISTENCE_UNIT_NAME. */
	private static final String PERSISTENCE_UNIT_NAME = "jpa";
	
	/** The factory. */
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);;
	
	/** The entity manager. */
	private static EntityManager em = factory.createEntityManager();
	
	/**
	 * Gets the factory.
	 *
	 * @return the factory
	 */
	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
	/**
	 * Gets the entity manager.
	 *
	 * @return the entity manager
	 */
	public static EntityManager getEntityManager() {
		return em;
	}

}
