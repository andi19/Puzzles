package de.hftstuttgart.puzzles.modeltests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hftstuttgart.puzzles.model.Mitarbeiter;

public class MitarbeiterTest {
	
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
	public void testMitarbeiter() {
		for(Mitarbeiter m : testUtility.mitarbeiterListe()){
			Assert.assertNotNull(m);
		}
	}

	@Test
	public void testGetMitarbeiternummer() {
		for(Mitarbeiter m : testUtility.mitarbeiterListe()){
			String test = m.getMitarbeiternummer();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetMitarbeiternummer() {
		for(Mitarbeiter m : testUtility.mitarbeiterListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				m.setMitarbeiternummer(rs.nextString());
				Assert.assertNotNull(m);
			}	
		}
	}

	@Test
	public void testGetVorname() {
		for(Mitarbeiter m : testUtility.mitarbeiterListe()){
			String test = m.getVorname();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetVorname() {
		for(Mitarbeiter m : testUtility.mitarbeiterListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				m.setVorname(rs.nextString());
				Assert.assertNotNull(m);
			}	
		}
	}

	@Test
	public void testGetNachname() {
		for(Mitarbeiter m : testUtility.mitarbeiterListe()){
			String test = m.getNachname();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetNachname() {
		for(Mitarbeiter m : testUtility.mitarbeiterListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				m.setNachname(rs.nextString());
				Assert.assertNotNull(m);
			}	
		}
	}

	@Test
	public void testGetPasswort() {
		for(Mitarbeiter m : testUtility.mitarbeiterListe()){
			String test = m.getPasswort();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetPasswort() {
		for(Mitarbeiter m : testUtility.mitarbeiterListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				m.setPasswort(rs.nextString());
				Assert.assertNotNull(m);
			}	
		}
	}

	@Test
	public void testToString() {
		for(Mitarbeiter m : testUtility.mitarbeiterListe()){
			String test = m.toString();
			Assert.assertNotNull(test);
		}
	}
}
