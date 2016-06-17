package de.hftstuttgart.puzzles.utilitytests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hftstuttgart.puzzles.model.Artikel;
import de.hftstuttgart.puzzles.modeltests.TestUtility;
import de.hftstuttgart.puzzles.utilities.ArtikelUtility;
import de.hftstuttgart.puzzles.utilities.DatenbankConnectionUtility;

public class ArtikelUtilityTest {
	
	private Artikel artikel;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DatenbankConnectionUtility.getEntityManager();
	}

	@Before
	public void setUp() throws Exception {
	artikel = TestUtility.artikel;
	}


	@Test
	public void testAddArtikel() {
		ArtikelUtility.addArtikel(artikel);
		TestUtility.artikelListe = ArtikelUtility.loadAllArtikel();
		Assert.assertTrue(TestUtility.artikelListe.contains(artikel));
	}

	@Test
	public void testEditArtikel() {
		 Artikel neuerArtikel = null;
			
		 ArtikelUtility.addArtikel(artikel);
		 artikel.setName("Neu");
		 ArtikelUtility.editArtikel(artikel);
		 TestUtility.artikelListe=ArtikelUtility.loadAllArtikel();
		 if(TestUtility.artikelListe.contains(artikel))
			 neuerArtikel=artikel;
		 
		 Assert.assertTrue(neuerArtikel.getName().equals("Neu"));
	}

	@Test
	public void testDeleteArtikel() {
		ArtikelUtility.deleteArtikel(artikel);
		TestUtility.artikelListe=ArtikelUtility.loadAllArtikel();
		Assert.assertFalse(TestUtility.artikelListe.contains(artikel));
	}

}
