package de.hftstuttgart.puzzles.utilitytests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hftstuttgart.puzzles.model.Artikeleinheit;
import de.hftstuttgart.puzzles.model.Auftrag;
import de.hftstuttgart.puzzles.modeltests.TestUtility;
import de.hftstuttgart.puzzles.utilities.AuftragUtility;
import de.hftstuttgart.puzzles.utilities.DatenbankConnectionUtility;

public class AuftragUtilityTest {
	
	private Auftrag auftrag;
	private TestUtility tU = new TestUtility();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DatenbankConnectionUtility.getEntityManager();
	}

	@Before
	public void setUp() throws Exception {
		auftrag = TestUtility.auftrag;
	}

	@Test
	public void testAddAuftrag() {
		List<Artikeleinheit> alTest = new ArrayList<Artikeleinheit>();
		
		alTest.addAll(tU.artikeleinheitListe());
		
		AuftragUtility.addAuftrag(auftrag, alTest);
		TestUtility.auftragListe = AuftragUtility.loadAllAuftraege();
		Assert.assertTrue(TestUtility.auftragListe.contains(auftrag));
	}

	@Test
	public void testEditAuftrag() {
		Auftrag neuerAuftrag = null;
		List<Artikeleinheit> alTest = new ArrayList<Artikeleinheit>();
	
		alTest.addAll(tU.artikeleinheitListe());
		
		AuftragUtility.addAuftrag(auftrag, alTest);
		 auftrag.setArtikelliste(alTest);
		 AuftragUtility.editAuftrag(auftrag);
		 TestUtility.auftragListe=AuftragUtility.loadAllAuftraege();
		 if(TestUtility.auftragListe.contains(auftrag))
			 neuerAuftrag=auftrag;
		 
		 Assert.assertTrue(neuerAuftrag.getArtikelliste().equals(alTest));
	}

	@Test
	public void testDeleteAuftrag() {
		AuftragUtility.deleteAuftrag(auftrag);
		TestUtility.auftragListe=AuftragUtility.loadAllAuftraege();
		Assert.assertFalse(TestUtility.auftragListe.contains(auftrag));
	}

}
