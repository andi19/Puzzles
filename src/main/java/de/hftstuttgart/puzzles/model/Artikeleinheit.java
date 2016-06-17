package de.hftstuttgart.puzzles.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Artikeleinheit.
 */
@Entity
@Table(name = "ARTIKELEINHEIT_TABLE")
public class Artikeleinheit implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
 
	/** The artikeleinheitnummer. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ARTIKELEINHEITNUMMER")
	private int mArtikeleinheitnummer;
	
	/** The menge. */
	@Column(name = "MENGE")
	private int mMenge;
	
	/** The artikel. */
	@ManyToOne(targetEntity=Artikel.class)
	@JoinColumn(name="ARTIKEL_TABLE_ARTIKELNUMMER")
	private Artikel mArtikel;
	
	/** The beschreibung. */
	private String mBeschreibung;
	
	/** The preis. */
	private double mPreis;

	/**
	 * Instantiates a new artikeleinheit.
	 */
	public Artikeleinheit() {
	
	}

	/**
	 * Instantiates a new artikeleinheit.
	 *
	 * @param artikel the artikel
	 * @param menge the menge
	 */
	public Artikeleinheit(Artikel artikel, int menge) {
		this.mArtikel = artikel;
		this.mMenge = menge;
		this.mBeschreibung = mArtikel.getBeschreibung();
		this.mPreis = mArtikel.getPreis();
	}

	public Artikel getArtikel() {
		return mArtikel;
	}

	public void setArtikel(Artikel artikel) {
		this.mArtikel = artikel;
	}

	public int getMenge() {
		return mMenge;
	}

	public void setMenge(int menge) {
		this.mMenge = menge;
	}

	/**
	 * Increase menge.
	 */
	public void increaseM() {
		mMenge++;
	}

	/**
	 * Decreased menge.
	 */
	public void decreasedM() {
		mMenge--;
	}

	public double getPreis() {
		return mPreis;
	}

	public void setPreis(double preis) {
		this.mPreis = preis;
	}

	public String getBeschreibung() {
		return mBeschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.mBeschreibung = beschreibung;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Artikeleinheit [mArtikel=" + mArtikel + ", mBeschreibung="
				+ mBeschreibung + ", mPreis=" + mPreis + ", mMenge=" + mMenge
				+ "]";
	}
}
