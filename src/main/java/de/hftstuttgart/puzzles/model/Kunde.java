package de.hftstuttgart.puzzles.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Kunde.
 */
@Entity
@Table(name = "KUNDEN_TABLE")
public class Kunde {

	/** The kundennummer. */
	@Id	
	@Column(name="KUNDENNUMMER")
	private String mKundennummer;
	
	/** The vorname. */
	@Column(name="VORNAME")
	private String mVorname;
	
	/** The nachname. */
	@Column(name="NACHNAME")
	private String mNachname;
	
	/** The adresse. */
	@Column(name="ADRESSE")
	private String mAdresse;
	
	/** The mail. */
	@Column(name="MAIL")
	private String mMail;
	
	/** The gruppe. */
	@Column(name="GRUPPE")
	private int mGruppe;
	
	/** The telefon. */
	@Column(name="TELEFON")
	private int mTelefon;
	
	/** The geschlecht. */
	@Column(name="GESCHLECHT")
	private String mGeschlecht;
	
	/** The auftrag. */
	@OneToMany(targetEntity=Auftrag.class, mappedBy="mKunde",
			cascade={CascadeType.ALL},orphanRemoval=true)
	private List<Auftrag> auftrag;

	/**
	 * Instantiates a new kunde.
	 */
	public Kunde() {
	}

	/**
	 * Instantiates a new kunde.
	 *
	 * @param kundennummer the kundennummer
	 * @param vorname the vorname
	 * @param nachname the nachname
	 * @param geschlecht the geschlecht
	 * @param adresse the adresse
	 * @param mail the mail
	 * @param telefon the telefon
	 */
	public Kunde(String kundennummer, String vorname, String nachname,
			String geschlecht, String adresse, String mail, int telefon) {
		this.mKundennummer = kundennummer;
		this.mVorname = vorname;
		this.mNachname = nachname;
		this.mGeschlecht = geschlecht;
		this.mAdresse = adresse;
		this.mMail = mail;
		this.mTelefon = telefon;
	}

	public String getKundennummer() {
		return mKundennummer;
	}

	public void setKundennummer(String kundennummer) {
		this.mKundennummer = kundennummer;
	}

	public String getVorname() {
		return mVorname;
	}

	public void setVorname(String vorname) {
		this.mVorname = vorname;
	}

	public String getAdresse() {
		return mAdresse;
	}

	public void setAdresse(String mAdresse) {
		this.mAdresse = mAdresse;
	}

	public String getMail() {
		return mMail;
	}

	public void setMail(String mMail) {
		this.mMail = mMail;
	}

	public int getTelefon() {
		return mTelefon;
	}

	public void setTelefon(int mTelefon) {
		this.mTelefon = mTelefon;
	}

	public String getGeschlecht() {
		return mGeschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.mGeschlecht = geschlecht;
	}

	public String getNachname() {
		return mNachname;
	}

	public void setNachname(String nachname) {
		this.mNachname = nachname;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return mVorname + " " + mNachname;
	}

	public void setGruppe(String gruppe) {
		this.mGruppe = Integer.parseInt(gruppe);
	}
	
	public int getGruppe() {
		return mGruppe;
	}

}