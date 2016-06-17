package de.hftstuttgart.puzzles.utilities;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import de.hftstuttgart.puzzles.model.Artikeleinheit;
import de.hftstuttgart.puzzles.model.Auftrag;
import de.hftstuttgart.puzzles.model.Kunde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Enum AuftragUtility.
 */
public enum AuftragUtility {
	
	/** The instance. */
	INSTANCE;
	
	/** The entity manager. */
	private static EntityManager em = DatenbankConnectionUtility.getEntityManager();

	/**
	 * Load all auftraege.
	 *
	 * @return the observable list
	 */
	@SuppressWarnings("unchecked")
	public static ObservableList<Auftrag> loadAllAuftraege() {
		ObservableList<Auftrag> auftragList = FXCollections.observableArrayList();
		Query q = em.createQuery("select t from Auftrag t");
		List<Auftrag> aufList = q.getResultList();
		for (Auftrag auftrag : aufList) {
			auftragList.add(auftrag);
		}
		return auftragList;
	}

	/**
	 * Load all auftraege suchen.
	 *
	 * @param suchen the suchen
	 * @return the observable list
	 * @throws SQLException the SQL exception
	 */
	@SuppressWarnings("unchecked")
	public static ObservableList<Auftrag> loadAllAuftraegeSuchen(String suchen) throws SQLException {
		ObservableList<Auftrag> auftragList = FXCollections.observableArrayList();

		Query q = em.createQuery(
				"select a from Auftrag a WHERE (a.mAuftragsnummer LIKE :suchen) " + "OR (a.mDatum LIKE :suchen)");
		q.setParameter("suchen", "%" + suchen + "%");
		if (q.getResultList().isEmpty()) {
			ObservableList<Kunde> k = KundeUtility.loadAllKundenSuchen(suchen);
			q = em.createQuery("select a from Auftrag a WHERE a.mKunde IN :kunden");
			q.setParameter("kunden", k);
		}
		List<Auftrag> aufList = q.getResultList();
		for (Auftrag auftrag : aufList) {
			auftragList.add(auftrag);
		}		
		if (q.getResultList().isEmpty()) {
			return null;
		}
		return auftragList;
	}

	/**
	 * Adds the auftrag.
	 *
	 * @param auftrag the auftrag
	 * @param list the list
	 */
	public static void addAuftrag(Auftrag auftrag, List<Artikeleinheit> list) {
		Iterator<Artikeleinheit> listIterator = list.iterator();
		while (listIterator.hasNext()) {
			Artikeleinheit artikel = listIterator.next();
			ArtikeleinheitUtility.addArtikelEinheit(artikel);
		}
		em.getTransaction().begin();
		em.persist(auftrag);
		em.getTransaction().commit();
	}

	/**
	 * Edits the auftrag.
	 *
	 * @param auftrag the auftrag
	 */
	public static void editAuftrag(Auftrag auftrag) {
		em.getTransaction().begin();
		em.merge(auftrag);
		em.getTransaction().commit();
	}

	/**
	 * Delete auftrag.
	 *
	 * @param auftrag the auftrag
	 */
	public static void deleteAuftrag(Auftrag auftrag) {
		em.getTransaction().begin();
		em.remove(em.merge(auftrag));
		em.getTransaction().commit();
	}
}
