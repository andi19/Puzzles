package de.hftstuttgart.puzzles.modeltests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hftstuttgart.puzzles.model.Artikel;
import de.hftstuttgart.puzzles.model.Artikeleinheit;

public class ArtikeleinheitTest {

	private TestUtility testUtility = new TestUtility();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testArtikeleinheit() {
		for (Artikeleinheit a : testUtility.artikeleinheitListe()) {
			Assert.assertNotNull(a);
		}
	}

	@Test
	public void testGetArtikel() {
		for (Artikeleinheit a : testUtility.artikeleinheitListe()) {
			Artikel test = a.getArtikel();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetArtikel() {
		for (Artikeleinheit a : testUtility.artikeleinheitListe()) {
			for (int i = 2; i < testUtility.count; i++) {
				for (Artikel k : testUtility.artikelListe()) {
					a.setArtikel(k);
					Assert.assertNotNull(a);
				}
			}
		}
	}

	@Test
	public void testGetMenge() {
		for (Artikeleinheit a : testUtility.artikeleinheitListe()) {
			int test = a.getMenge();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetMenge() {
		for (Artikeleinheit a : testUtility.artikeleinheitListe()) {
			for (int i = 2; i < testUtility.count; i++) {
				a.setMenge(i);
				Assert.assertNotNull(a);
			}
		}
	}

	@Test
	public void testIncreaseM() {
		for (Artikeleinheit a : testUtility.artikeleinheitListe()) {
			a.increaseM();
			Assert.assertNotNull(a);
		}
	}

	@Test
	public void testDecreasedM() {
		for (Artikeleinheit a : testUtility.artikeleinheitListe()) {
			a.decreasedM();
			Assert.assertNotNull(a);
		}
	}

	@Test
	public void testToString() {
		for (Artikeleinheit a : testUtility.artikeleinheitListe()) {
			String test = a.toString();
			Assert.assertNotNull(test);
		}
	}

}
