package de.hftstuttgart.puzzles.utilitytests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hftstuttgart.puzzles.model.Kunde;
import de.hftstuttgart.puzzles.modeltests.TestUtility;
import de.hftstuttgart.puzzles.utilities.DatenbankConnectionUtility;
import de.hftstuttgart.puzzles.utilities.KundeUtility;

public class KundeUtilityTest {
	
	private Kunde kunde;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DatenbankConnectionUtility.getEntityManager();
	}

	@Before
	public void setUp() throws Exception {
		kunde = TestUtility.kunde;
	}

	@Test
	public void testAddKunde() {
		KundeUtility.addKunde(kunde);
		TestUtility.kundeListe = KundeUtility.loadAllKunden();
		Assert.assertTrue(TestUtility.kundeListe.contains(kunde));
	}

	@Test
	public void testEditKunde() {
		 Kunde neuerKunde = null;
			
		 KundeUtility.addKunde(kunde);
		 kunde.setNachname("Neu");
		 KundeUtility.editKunde(kunde);
		 TestUtility.kundeListe=KundeUtility.loadAllKunden();
		 if(TestUtility.kundeListe.contains(kunde))
			 neuerKunde=kunde;
		 
		 Assert.assertTrue(neuerKunde.getNachname().equals("Neu"));
	}

	@Test
	public void testDeleteKunde() {
		KundeUtility.deleteKunde(kunde);
		TestUtility.kundeListe=KundeUtility.loadAllKunden();
		Assert.assertFalse(TestUtility.kundeListe.contains(kunde));
	}

}
