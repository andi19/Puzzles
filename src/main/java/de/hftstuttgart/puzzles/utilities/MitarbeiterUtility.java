package de.hftstuttgart.puzzles.utilities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import de.hftstuttgart.puzzles.model.Mitarbeiter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Enum MitarbeiterUtility.
 */
public enum MitarbeiterUtility {
	
	/** The instance. */
	INSTANCE;
	
	/** The entity manager. */
	private static EntityManager em = DatenbankConnectionUtility.getEntityManager();
	
	/**
	 * Load all mitarbeiter.
	 *
	 * @return the observable list
	 */
	@SuppressWarnings("unchecked")
	public static ObservableList<Mitarbeiter> loadAllMitarbeiter() {
		ObservableList<Mitarbeiter> mitarbeiterList = FXCollections.observableArrayList();
		Query q = em.createQuery("select t from Mitarbeiter t");
		List<Mitarbeiter> mList = q.getResultList();
		for (Mitarbeiter mitarbeiter : mList) {
			mitarbeiterList.add(mitarbeiter);
		}
		return mitarbeiterList;
	}

}
