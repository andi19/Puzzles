package de.hftstuttgart.puzzles.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Mitarbeiter.
 */
@Entity
@Table(name = "MITARBEITER_TABLE")
public class Mitarbeiter {
	
	
	/** The mitarbeiternummer. */
	@Id
	@Column(name = "MITARBEITERNUMMER")
	private String mMitarbeiternummer;

	/** The vorname. */
	@Column(name = "VORNAME")
	private String mVorname;
	
	/** The nachname. */
	@Column(name = "NACHNAME")
	private String mNachname;
	
	/** The passwort. */
	@Column(name = "PASSWORT")
	private String mPasswort;
	
	/**
	 * Instantiates a new mitarbeiter.
	 */
	public Mitarbeiter(){
		
	}

	/**
	 * Instantiates a new mitarbeiter.
	 *
	 * @param mitarbeiternummer the mitarbeiternummer
	 * @param vorname the vorname
	 * @param nachname the nachname
	 * @param passwort the passwort
	 */
	public Mitarbeiter(String mitarbeiternummer, String vorname, String nachname, String passwort) {
		this.mMitarbeiternummer = mitarbeiternummer;
		this.mVorname = vorname;
		this.mNachname = nachname;
		this.mPasswort = passwort;
	}

	public String getMitarbeiternummer() {
		return mMitarbeiternummer.toUpperCase();
	}
	
	public String getMitarbeiternumerLogin(){
		return mMitarbeiternummer;
	}

	public void setMitarbeiternummer(String mitarbeiternummer) {
		this.mMitarbeiternummer = mitarbeiternummer;
	}

	public String getVorname() {
		return mVorname;
	}

	public void setVorname(String vorname) {
		this.mVorname = vorname;
	}

	public String getNachname() {
		return mNachname;
	}

	public void setNachname(String nachname) {
		this.mNachname = nachname;
	}

	public String getPasswort() {
		return mPasswort;
	}

	public void setPasswort(String passwort) {
		this.mPasswort = passwort;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mitarbeiter [mitarbeiternummer=" + mMitarbeiternummer + ", vorname=" + mVorname + ", nachname="
				+ mNachname + ", passwort=" + mPasswort + "]";
	}
}
