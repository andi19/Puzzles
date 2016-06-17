package de.hftstuttgart.puzzles.utilities;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import de.hftstuttgart.puzzles.model.Artikeleinheit;

/**
 * The Enum ArtikeleinheitUtility.
 */
public enum ArtikeleinheitUtility {
	
	/** The instance. */
	INSTANCE;
	
	/** The entity manager. */
	private static EntityManager em = DatenbankConnectionUtility.getEntityManager();

	/**
	 * Load all artikel einheit.
	 *
	 * @return the observable list
	 */
	@SuppressWarnings("unchecked")
	public static ObservableList<Artikeleinheit> loadAllArtikelEinheit() {
		ObservableList<Artikeleinheit> artikelList = FXCollections.observableArrayList();
		Query q = em.createQuery("select t from Artikeleinheit t");
		List<Artikeleinheit> artList = q.getResultList();
		for (Artikeleinheit artikel : artList) {
			artikelList.add(artikel);
		}
		return artikelList;
	}

	/**
	 * Adds the artikel einheit.
	 *
	 * @param artikel the artikel
	 */
	public static void addArtikelEinheit(Artikeleinheit artikel) {
		em.getTransaction().begin();
		em.persist(artikel);
		em.getTransaction().commit();
	}

	/**
	 * Edits the artikel einheit.
	 *
	 * @param artikel the artikel
	 */
	public static void editArtikelEinheit(Artikeleinheit artikel) {
		em.getTransaction().begin();
		em.merge(artikel);
		em.getTransaction().commit();
	}

	/**
	 * Delete artikel.
	 *
	 * @param artikel the artikel
	 */
	public static void deleteArtikel(Artikeleinheit artikel) {
		em.getTransaction().begin();
		em.remove(em.merge(artikel));
		em.getTransaction().commit();
	}
}
