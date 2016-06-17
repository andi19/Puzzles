package de.hftstuttgart.puzzles.modeltests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hftstuttgart.puzzles.model.Kunde;

public class KundeTest {
	
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
	public void testKunde() {
		for(Kunde k : testUtility.kundenListe()){
			Assert.assertNotNull(k);
		}
	}

	@Test
	public void testGetKundennummer() {
		for(Kunde k : testUtility.kundenListe()){
			String test = k.getKundennummer();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetKundennummer() {
		for(Kunde k : testUtility.kundenListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				k.setKundennummer(rs.nextString());
				Assert.assertNotNull(k);
			}	
		}
	}

	@Test
	public void testGetVorname() {
		for(Kunde k : testUtility.kundenListe()){
			String test = k.getVorname();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetVorname() {
		for(Kunde k : testUtility.kundenListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				k.setVorname(rs.nextString());
				Assert.assertNotNull(k);
			}			
		}
	}

	@Test
	public void testGetAdresse() {
		for(Kunde k : testUtility.kundenListe()){
			String test = k.getAdresse();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetAdresse() {
		for(Kunde k : testUtility.kundenListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				k.setAdresse(rs.nextString());
				Assert.assertNotNull(k);
			}		
		}
	}

	@Test
	public void testGetMail() {
		for(Kunde k : testUtility.kundenListe()){
			String test = k.getMail();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetMail() {
		for(Kunde k : testUtility.kundenListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				k.setMail(rs.nextString());
				Assert.assertNotNull(k);
			}			
		}
	}

	@Test
	public void testGetTelefon() {
		for(Kunde k : testUtility.kundenListe()){
			int test = k.getTelefon();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetTelefon() {
		for(Kunde k : testUtility.kundenListe()){
			for (int i = 2; i < testUtility.count; i++) {
				k.setTelefon(i);
				Assert.assertNotNull(k);
			}		
		}
	}

	@Test
	public void testGetGeschlecht() {
		for(Kunde k : testUtility.kundenListe()){
			String test = k.getGeschlecht();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetGeschlecht() {
		for(Kunde k : testUtility.kundenListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				k.setGeschlecht(rs.nextString());
				Assert.assertNotNull(k);
			}			
		}
	}

	@Test
	public void testGetNachname() {
		for(Kunde k : testUtility.kundenListe()){
			String test = k.toString();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetNachname() {
		for(Kunde k : testUtility.kundenListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				k.setNachname(rs.nextString());
				Assert.assertNotNull(k);
			}			
		}
	}

	@Test
	public void testToString() {
		for(Kunde k : testUtility.kundenListe()){
			String test = k.toString();
			Assert.assertNotNull(test);
		}
	}

	@Test
	public void testSetGruppe() {
		for(Kunde k : testUtility.kundenListe()){
			for (int i = 2; i < testUtility.count; i++) {
				RandomString rs = new RandomString(i);
				k.setGruppe(rs.nextString());
				Assert.assertNotNull(k);
			}			
		}
	}

	@Test
	public void testGetGruppe() {
		for(Kunde k : testUtility.kundenListe()){
			int test = k.getGruppe();
			Assert.assertNotNull(test);
		}
	}

}
