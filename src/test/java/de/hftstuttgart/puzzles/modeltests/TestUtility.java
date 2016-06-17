package de.hftstuttgart.puzzles.modeltests;

import java.util.ArrayList;
import java.util.List;

import de.hftstuttgart.puzzles.model.Artikel;
import de.hftstuttgart.puzzles.model.Artikeleinheit;
import de.hftstuttgart.puzzles.model.Auftrag;
import de.hftstuttgart.puzzles.model.Kunde;
import de.hftstuttgart.puzzles.model.Mitarbeiter;

public class TestUtility {

	public final int count = 5;
	
	
	public static Artikel artikel = new Artikel(1234,"testArtikel","defaultTest",100.0);
	public static Artikeleinheit artikeleinheit = new Artikeleinheit(artikel, 5);
	public static Kunde kunde = new Kunde("BABA1234","Ba","Ba","m","Straﬂe 1234", "ba@web.de", 9876);
	public static Auftrag auftrag = new Auftrag("SAAN1234",kunde, new ArrayList<Artikeleinheit>(), "30.05.2016","defaultTest");

	public static List<Artikel> artikelListe;
	public static List<Artikeleinheit> artikeleinheitListe;
	public static List<Kunde> kundeListe;
	public static List<Auftrag> auftragListe;
	
	public List<Kunde> kundenListe() {
		List<Kunde> list = new ArrayList<Kunde>();
		for (int i = 2; i < count; i++) {
			for (int j = 2; j < count; j++) {
				for (int k = 2; k < count; k++) {
					for (int l = 2; l < count; l++) {
						for (int m = 2; m < count; m++) {
							for (int n = 2; n < count; n++) {
								RandomString kN = new RandomString(i);
								RandomString vN = new RandomString(j);
								RandomString nN = new RandomString(k);
								RandomString aD = new RandomString(l);
								RandomString mA = new RandomString(m);
								Kunde kList = new Kunde(kN.nextString(), vN.nextString(), nN.nextString(), "m",
										aD.nextString(), mA.nextString(), n);
								list.add(kList);
							}
						}
					}
				}
			}
		}
		return list;
	}

	public List<Artikel> artikelListe() {
		List<Artikel> list = new ArrayList<Artikel>();
		for (int i = 2; i < count; i++) {
			for (int j = 2; j < count; j++) {
				for (int k = 2; k < count; k++) {
					RandomString nA = new RandomString(i);
					RandomString bE = new RandomString(j);
					Artikel aList = new Artikel(i, nA.nextString(), bE.nextString(), (double) Math.random() * count);
					list.add(aList);
				}
			}
		}
		return list;
	}

	public List<Mitarbeiter> mitarbeiterListe() {
		List<Mitarbeiter> list = new ArrayList<Mitarbeiter>();
		for (int i = 2; i < count; i++) {
			for (int j = 2; j < count; j++) {
				for (int k = 2; k < count; k++) {
					for (int l = 2; l < count; l++) {
						RandomString mN = new RandomString(i);
						RandomString vB = new RandomString(j);
						RandomString nN = new RandomString(k);
						RandomString pW = new RandomString(l);
						Mitarbeiter mList = new Mitarbeiter(mN.nextString(), vB.nextString(), nN.nextString(),
								pW.nextString());
						list.add(mList);
					}
				}
			}
		}
		return list;
	}

	public List<Artikeleinheit> artikeleinheitListe() {
		List<Artikeleinheit> list = new ArrayList<Artikeleinheit>();
		for (int i = 1; i < count; i++) {
			for (Artikel a : artikelListe()) {
				Artikeleinheit aList = new Artikeleinheit(a, i);
				list.add(aList);
			}
		}
		return list;
	}

	public List<Auftrag> auftragListe() {
		List<Auftrag> list = new ArrayList<Auftrag>();
		for (int i = 2; i < count; i++) {
			for (int j = 2; j < count; j++) {
				for (int k = 2; k < count; k++) {
					for (Kunde kunde : kundenListe()) {
						RandomString aN = new RandomString(i);
						RandomString dA = new RandomString(j);
						RandomString nO = new RandomString(k);
						Auftrag aList = new Auftrag(aN.nextString(), kunde, artikeleinheitListe(), dA.nextString(),
								nO.nextString());
						list.add(aList);
					}
				}
			}
		}
		return list;
	}

}
