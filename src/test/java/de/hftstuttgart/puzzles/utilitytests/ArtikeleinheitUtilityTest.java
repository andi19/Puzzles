package de.hftstuttgart.puzzles.utilitytests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hftstuttgart.puzzles.model.Artikel;
import de.hftstuttgart.puzzles.model.Artikeleinheit;
import de.hftstuttgart.puzzles.modeltests.TestUtility;
import de.hftstuttgart.puzzles.utilities.ArtikeleinheitUtility;
import de.hftstuttgart.puzzles.utilities.DatenbankConnectionUtility;

public class ArtikeleinheitUtilityTest {

	private Artikeleinheit artikeleinheit;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DatenbankConnectionUtility.getEntityManager();
	}

	@Before
	public void setUp() throws Exception {
		artikeleinheit = TestUtility.artikeleinheit;
	}

	@Test
	public void testAddArtikelEinheit() {
		ArtikeleinheitUtility.addArtikelEinheit(artikeleinheit);
		TestUtility.artikeleinheitListe = ArtikeleinheitUtility
				.loadAllArtikelEinheit();
		Assert.assertTrue(TestUtility.artikeleinheitListe
				.contains(artikeleinheit));
	}

	@Test
	public void testEditArtikelEinheit() {
		Artikeleinheit neueArtikeleinheit = null;

		ArtikeleinheitUtility.addArtikelEinheit(artikeleinheit);
		artikeleinheit.setArtikel(new Artikel(9876, "TESTNAME",
				"TESTBESCHREIBUNG", 200.0));
		ArtikeleinheitUtility.editArtikelEinheit(artikeleinheit);
		TestUtility.artikeleinheitListe = ArtikeleinheitUtility
				.loadAllArtikelEinheit();
		if (TestUtility.artikeleinheitListe.contains(artikeleinheit))
			neueArtikeleinheit = artikeleinheit;

		Assert.assertTrue(neueArtikeleinheit.getArtikel().equals(10));
	}

	@Test
	public void testDeleteArtikel() {
		ArtikeleinheitUtility.deleteArtikel(artikeleinheit);
		TestUtility.artikeleinheitListe = ArtikeleinheitUtility
				.loadAllArtikelEinheit();
		Assert.assertFalse(TestUtility.artikeleinheitListe
				.contains(artikeleinheit));
	}

}
