package de.hftstuttgart.puzzles.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Auftrag.
 */
@Entity
@Table(name = "AUFTRAG_TABLE")
public class Auftrag {
	
	
	
	/** The auftragsnummer. */
	@Id
	@Column(name = "AUFTRAGSNUMMER")
	private String mAuftragsnummer;

	/** The datum. */
	@Column(name = "DATUM")
	private String mDatum;

	/** The kunde. */
	@ManyToOne(targetEntity=Kunde.class)
	@JoinColumn(name="KUNDE_TABLE_KUNDENNUMMER")
	private Kunde mKunde;

	/** The artikeleinheit table. */
	@ManyToMany(targetEntity = Artikeleinheit.class)
	@JoinColumn(name = "ARTIKELEINHEITNUMMER")
	private List<Artikeleinheit> ARTIKELEINHEIT_TABLE;

	/** The notiz. */
	@Column(name = "NOTIZ")
	private String mNotiz;

	/** The status. */
	@Column(name = "STATUS")
	private Status mStatus;	

	/**
	 * Instantiates a new auftrag.
	 */
	public Auftrag() {
	}

	/**
	 * Instantiates a new auftrag.
	 *
	 * @param auftragsnummer the auftragsnummer
	 * @param kunde the kunde
	 * @param artikelListe the artikel liste
	 * @param datum the datum
	 * @param notiz the notiz
	 */
	public Auftrag(String auftragsnummer, Kunde kunde,
			List<Artikeleinheit> artikelListe, String datum, String notiz) {
		this.mAuftragsnummer = auftragsnummer;
		this.mKunde = kunde;
		this.ARTIKELEINHEIT_TABLE = artikelListe;
		this.mDatum = datum;
		this.mNotiz = notiz;
		this.mStatus = Status.auftragErstellt;
	}

	/**
	 * Instantiates a new auftrag with status.
	 *
	 * @param auftragsnummer the auftragsnummer
	 * @param kunde the kunde
	 * @param artikelListe the artikel liste
	 * @param datum the datum
	 * @param notiz the notiz
	 * @param status the status
	 */
	public Auftrag(String auftragsnummer, Kunde kunde,
			List<Artikeleinheit> artikelListe, String datum, String notiz,
			Status status) {
		this.mAuftragsnummer = auftragsnummer;
		this.mKunde = kunde;
		this.ARTIKELEINHEIT_TABLE = artikelListe;
		this.mDatum = datum;
		this.mNotiz = notiz;
		this.mStatus = status;
	}

	public Kunde getKunde() {
		return mKunde;
	}

	public void setKunde(Kunde kunde) {
		this.mKunde = kunde;
	}

	public List<Artikeleinheit> getArtikelliste() {
		return ARTIKELEINHEIT_TABLE;
	}

	public void setArtikelliste(List<Artikeleinheit> artikelListe) {
		this.ARTIKELEINHEIT_TABLE = artikelListe;
	}

	public String getAuftragsnummer() {
		return mAuftragsnummer;
	}

	public void setAuftragsnummer(String auftragsnummer) {
		this.mAuftragsnummer = auftragsnummer;
	}

	public String getDatum() {
		return mDatum;
	}

	public void setDatum(String datum) {
		this.mDatum = datum;
	}

	public String getNotiz() {
		return mNotiz;
	}

	public void setNotiz(String notiz) {
		this.mNotiz = notiz;
	}

	public Status getStatus() {
		return mStatus;
	}

	public void setStatus(Status status) {
		mStatus = status;
	}

	/**
	 * Sets the abholbereit.
	 *
	 * @return the status
	 */
	public Status setAbholbereit() {
		setStatus(Status.abholbereit);
		return getStatus();
	}

	/**
	 * Gesamt preis.
	 *
	 * @return the double
	 */
	public double gesamtPreis() {
		double r = 0.0;
		for (Artikeleinheit aE : ARTIKELEINHEIT_TABLE) {
			r = r + (aE.getArtikel().getPreis() * aE.getMenge());
		}
		return r;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Auftrag [mAuftragsnummer=" + mAuftragsnummer + ", mNotiz="
				+ mNotiz + ", mKunde=" + mKunde + ", mArtikelliste="
				+ ARTIKELEINHEIT_TABLE + ", mDatum=" + mDatum + ", mStatus=" + mStatus
				+ "]";
	}
}