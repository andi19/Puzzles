package de.hftstuttgart.puzzles.modeltests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hftstuttgart.puzzles.model.Artikel;

public class ArtikelTest {
	
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
	public void testArtikel() {
		for(Artikel a : testUtility.artikelListe()){
			Assert.assertNotNull(a);
		}
	}

	@Test
	public void testGetArtikelnummer() {
		for(Artikel a : testUtility.artikelListe()){
			int test = a.getArtikelnummer();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetArtikelnummer() {
		for(Artikel a : testUtility.artikelListe()){
			for (int i = 2; i < testUtility.count; i++) {
				a.setArtikelnummer(i);
				Assert.assertNotNull(a);
			}	
		}
	}

	@Test
	public void testGetPreis() {
		for(Artikel a : testUtility.artikelListe()){
			double test = a.getPreis();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetPreis() {
		for(Artikel a : testUtility.artikelListe()){
			for (int i = 2; i < testUtility.count; i++) {
				a.setPreis((double)i + (double)i/10);
				Assert.assertNotNull(a);
			}	
		}
	}

	@Test
	public void testGetName() {
		for(Artikel a : testUtility.artikelListe()){
			String test = a.getName();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetName() {
		for(Artikel a : testUtility.artikelListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				a.setName(rs.nextString());
				Assert.assertNotNull(a);
			}	
		}
	}

	@Test
	public void testGetBeschreibung() {
		for(Artikel a : testUtility.artikelListe()){
			String test = a.getBeschreibung();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetBeschreibung() {
		for(Artikel a : testUtility.artikelListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				a.setBeschreibung(rs.nextString());
				Assert.assertNotNull(a);
			}	
		}
	}

	@Test
	public void testToString() {
		for(Artikel a : testUtility.artikelListe()){
			String test = a.toString();
			Assert.assertNotNull(test);
		}
	}

}
