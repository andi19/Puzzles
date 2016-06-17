package de.hftstuttgart.puzzles.utilities;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import de.hftstuttgart.puzzles.model.Kunde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Enum KundeUtility.
 */
public enum KundeUtility {
	
	/** The instance. */
	INSTANCE;
	
	/** The entity manager. */
	private static EntityManager em = DatenbankConnectionUtility.getEntityManager();

	/**
	 * Load all kunden.
	 *
	 * @return the observable list
	 */
	@SuppressWarnings("unchecked")
	public static ObservableList<Kunde> loadAllKunden() {
		ObservableList<Kunde> kundeList = FXCollections.observableArrayList();
		Query q = em.createQuery("select t from Kunde t");
		List<Kunde> kList = q.getResultList();
		for (Kunde kunde : kList) {
			kundeList.add(kunde);
		}
		return kundeList;
	}

	/**
	 * Load all kunden suchen.
	 *
	 * @param suchen the suchen
	 * @return the observable list
	 * @throws SQLException the SQL exception
	 */
	@SuppressWarnings("unchecked")
	public static ObservableList<Kunde> loadAllKundenSuchen(String suchen) throws SQLException {
		ObservableList<Kunde> kundeList = FXCollections.observableArrayList();

		Query q = em.createQuery("select t from Kunde t WHERE t.mKundennummer LIKE :suchen "
				+ "OR t.mNachname LIKE :suchen OR t.mVorname LIKE:suchen ");
		q.setParameter("suchen", "%" + suchen + "%");

		List<Kunde> kList = q.getResultList();
		for (Kunde kunde : kList) {
			kundeList.add(kunde);
		}
		if (q.getResultList().isEmpty()) {
			return null;
		}
		return kundeList;

	}

	/**
	 * Adds the kunde.
	 *
	 * @param kunde the kunde
	 */
	public static void addKunde(Kunde kunde) {
		em.getTransaction().begin();
		em.persist(kunde);
		em.getTransaction().commit();
	}

	/**
	 * Edits the kunde.
	 *
	 * @param kunde the kunde
	 */
	public static void editKunde(Kunde kunde) {
		em.getTransaction().begin();
		em.merge(kunde);
		em.getTransaction().commit();
	}

	/**
	 * Delete kunde.
	 *
	 * @param kunde the kunde
	 */
	public static void deleteKunde(Kunde kunde) {
		em.getTransaction().begin();
		em.remove(em.merge(kunde));
		em.getTransaction().commit();
	}

}
