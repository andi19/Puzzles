package de.hftstuttgart.puzzles.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Artikel.
 */
@Entity
@Table(name = "ARTIKEL_TABLE")
public class Artikel {
	
	/** The artikelnummer. */
	@Id
	@Column(name="ARTIKELNUMMER")
	private int mArtikelnummer;
	
	/** The name. */
	@Column(name="NAME")
	private String mName;
	
	/** The beschreibung. */
	@Column(name="BESCHREIBUNG")
	private String mBeschreibung;
	
	/** The preis. */
	@Column(name="PREIS")
	private double mPreis;
	
	/** The artikeleinheit. */
	@OneToMany(targetEntity=Artikeleinheit.class, mappedBy="mArtikel",
			cascade={CascadeType.ALL},orphanRemoval=true)
	private List<Artikeleinheit> mArtikeleinheit;
	
	/**
	 * Instantiates a new artikel.
	 */
	public Artikel(){	
	}

	/**
	 * Instantiates a new artikel.
	 *
	 * @param artikelnummer the artikelnummer
	 * @param name the name
	 * @param beschreibung the beschreibung
	 * @param preis the preis
	 */
	public Artikel(int artikelnummer, String name, String beschreibung,
			double preis) {
		this.mArtikelnummer = artikelnummer;
		this.mName = name;
		this.mBeschreibung = beschreibung;
		this.mPreis = preis;
	}

	public int getArtikelnummer() {
		return mArtikelnummer;
	}

	public void setArtikelnummer(int produktnummer) {
		this.mArtikelnummer = produktnummer;
	}

	public double getPreis() {
		return mPreis;
	}

	public void setPreis(double preis) {
		this.mPreis = preis;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
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
		return mName;
	}

}
