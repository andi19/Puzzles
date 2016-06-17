package de.hftstuttgart.puzzles.modeltests;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hftstuttgart.puzzles.model.Artikeleinheit;
import de.hftstuttgart.puzzles.model.Auftrag;
import de.hftstuttgart.puzzles.model.Kunde;
import de.hftstuttgart.puzzles.model.Status;

public class AuftragTest {

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
	public void testAuftrag() {
		for(Auftrag a : testUtility.auftragListe()){
			Assert.assertNotNull(a);
		}
	}

	@Test
	public void testGetKunde() {
		for(Auftrag a : testUtility.auftragListe()){
			Kunde test = a.getKunde();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetKunde() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArtikelliste() {
		for(Auftrag a : testUtility.auftragListe()){
			List<Artikeleinheit> test = a.getArtikelliste();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetArtikelliste() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAuftragsnummer() {
		for(Auftrag a : testUtility.auftragListe()){
			String test = a.getAuftragsnummer();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetAuftragsnummer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDatum() {
		for(Auftrag a : testUtility.auftragListe()){
			String test = a.getDatum();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetDatum() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNotiz() {
		for(Auftrag a : testUtility.auftragListe()){
			String test = a.getNotiz();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetNotiz() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStatus() {
		for(Auftrag a : testUtility.auftragListe()){
			Status test = a.getStatus();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetAbholbereit() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
