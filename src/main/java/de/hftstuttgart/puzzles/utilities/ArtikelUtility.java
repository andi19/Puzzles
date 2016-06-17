package de.hftstuttgart.puzzles.utilities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import de.hftstuttgart.puzzles.model.Artikel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Enum ArtikelUtility.
 */
public enum ArtikelUtility {
	
	/** The instance. */
	INSTANCE;
	
	/** The entity manager. */
	private static EntityManager em = DatenbankConnectionUtility.getEntityManager();
	
	/**
	 * Load all artikel.
	 *
	 * @return the observable list
	 */
	@SuppressWarnings("unchecked")
	public static ObservableList<Artikel> loadAllArtikel() {
		ObservableList<Artikel> artikelList = FXCollections.observableArrayList();
		Query q = em.createQuery("select t from Artikel t");
		List<Artikel> artList = q.getResultList();
		for (Artikel artikel : artList) {
			artikelList.add(artikel);
		}
		return artikelList;
	}
	
	
	/**
	 * Adds the artikel.
	 *
	 * @param artikel the artikel
	 */
	public static void addArtikel(Artikel artikel){
		em.getTransaction().begin();
		em.persist(artikel);
		em.getTransaction().commit();		
	}
	
	/**
	 * Edits the artikel.
	 *
	 * @param artikel the artikel
	 */
	public static void editArtikel(Artikel artikel){
		em.getTransaction().begin();
		em.merge(artikel);
		em.getTransaction().commit();		
	}
	
	/**
	 * Delete artikel.
	 *
	 * @param artikel the artikel
	 */
	public static void deleteArtikel(Artikel artikel){
		em.getTransaction().begin();
		em.remove(em.merge(artikel));
		em.getTransaction().commit();
	}
}
