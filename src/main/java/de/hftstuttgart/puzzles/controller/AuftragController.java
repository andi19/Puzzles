package de.hftstuttgart.puzzles.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import de.hftstuttgart.puzzles.main.Main;
import de.hftstuttgart.puzzles.main.MainView;
import de.hftstuttgart.puzzles.model.Artikeleinheit;
import de.hftstuttgart.puzzles.model.Auftrag;
import de.hftstuttgart.puzzles.model.Mitarbeiter;
import de.hftstuttgart.puzzles.utilities.AuftragUtility;
import de.hftstuttgart.puzzles.utilities.FehlerUtility;

/**
 * The Class AuftragController.
 */
public class AuftragController implements Initializable {

	/** The count. */
	private static int count = 0;

	/** The auftragsdetails. */
	@FXML
	private Button mAuftragsdetails;

	/** The artikelhinzufügen. */
	@FXML
	private Button mArtikelhinzufügen;

	/** The kundeninformationen. */
	@FXML
	private Button mKundeninformationen;

	/** The abbrechen. */
	@FXML
	private Button mAbbrechen;

	/** The auftrag anlegen. */
	@FXML
	private Button mAuftragAnlegen;

	/** The text feld. */
	@FXML
	private TextArea mTextFeld;

	/** The auftragsnummer. */
	@FXML
	private Label mAuftragsnummer;

	/** The kunde vorname. */
	@FXML
	private Label mKundeVorname;

	/** The kunde nachname. */
	@FXML
	private Label mKundeNachname;

	/** The kunde kundennummer. */
	@FXML
	private Label mKundeKundennummer;

	/** The artikel view. */
	@FXML
	private TableView<Artikeleinheit> mArtikelView;

	/** The artikel column. */
	@FXML
	private TableColumn<Artikeleinheit, String> mArtikelColumn;

	/** The beschreibung column. */
	@FXML
	private TableColumn<Artikeleinheit, String> mBeschreibungColumn;

	/** The preis column. */
	@FXML
	private TableColumn<Artikeleinheit, String> mPreisColumn;

	/** The menge column. */
	@FXML
	private TableColumn<Artikeleinheit, String> mMengeColumn;

	/** The main view */
	private MainView mV = new MainView();

	/** The text feld visibility. */
	private boolean mTextFeldVisibility = false;

	/** The mitarbeiter. */
	private Mitarbeiter mMitarbeiter = Main.mMitarbeiterLoggedIn;

	/** The artikelliste. */
	public ObservableList<Artikeleinheit> mArtikelliste;

	/**
	 * Reihe ausgewaehlt.
	 *
	 * @return true, if successful
	 */
	private boolean reiheAusgewaehlt() {
		if (mArtikelView.getSelectionModel().getSelectedItem() != null) {
			return true;
		} else
			return false;
	}

	/**
	 * Aktualisiere tabelle.
	 */
	public void aktualisiereTabelle() {
		mArtikelView.setItems(mArtikelliste);
		if (Main.mKunde != null) {
			mKundeVorname.setText(Main.mKunde.getVorname());
			mKundeNachname.setText(Main.mKunde.getNachname());
			mKundeKundennummer.setText(Main.mKunde.getKundennummer());
		}
	}

	/**
	 * Sets the auftragsnummer.
	 *
	 * @param eingabe
	 *            the new auftragsnummer
	 */
	public void setAuftragsnummer(String eingabe) {
		mAuftragsnummer.setText(eingabe);
	}

	/**
	 * Auftragsdetails hinzufuegen.
	 *
	 * @param event
	 *            the event
	 */
	// Event Listener on Button[#mAuftragsdetails].onAction
	@FXML
	public void auftragsdetailsHinzufuegen(ActionEvent event) {
		if (mTextFeldVisibility == false) {
			mTextFeld.setVisible(true);
			mTextFeldVisibility = true;
		} else {
			mTextFeld.setVisible(false);
			mTextFeldVisibility = false;
		}
	}

	/**
	 * Artikel hinzufuegen.
	 *
	 * @param event
	 *            the event
	 */
	// Event Listener on Button[#mArtikelhinzufügen].onAction
	@FXML
	public void artikelHinzufuegen(ActionEvent event) {
		mV.artikel(this);
	}

	/**
	 * Kunden informationen.
	 *
	 * @param event
	 *            the event
	 */
	// Event Listener on Button[#mKundeninformationen].onAction
	@FXML
	public void kundenInformationen(ActionEvent event) {
		mV.kundenUebersicht();
	}

	/**
	 * Abbrechen.
	 *
	 * @param event
	 *            the event
	 */
	// Event Listener on Button[#mAbbrechen].onAction
	@FXML
	public void abbrechen(ActionEvent event) {
		Stage stage = (Stage) mAbbrechen.getScene().getWindow();
		stage.close();
	}

	/**
	 * Auftrag anlegen.
	 *
	 * @param event
	 *            the event
	 */
	// Event Listener on Button[#mAuftragAnlegen].onAction
	@FXML
	public void auftragAnlegen(ActionEvent event) {
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar
				.getInstance().getTime());
		String timeStampNummer = new SimpleDateFormat("yyyyMMdd")
				.format(Calendar.getInstance().getTime());
		Auftrag auftrag = new Auftrag(mMitarbeiter.getMitarbeiternummer()
				+ timeStampNummer + fortlaufendeNummer(), Main.mKunde,
				mArtikelliste, timeStamp, mTextFeld.getText());
		if (Main.mKunde != null) {
			if (mArtikelliste != null) {
				AuftragUtility.addAuftrag(auftrag, mArtikelliste);
				count++;
				Stage stage = (Stage) mAuftragAnlegen.getScene().getWindow();
				stage.close();
			} else {
				FehlerUtility.keineArtikel();
			}
		} else {
			FehlerUtility.keinKunde();
		}

	}

	/**
	 * Fortlaufende nummer.
	 *
	 * @return the string
	 */
	private String fortlaufendeNummer() {
		String returnString = "";
		if (count >= 1000) {
			returnString = Integer.toString(count);
		} else if (count >= 100) {
			returnString = "0" + Integer.toString(count);
		} else if (count >= 10) {
			returnString = "00" + Integer.toString(count);
		} else {
			returnString = "000" + Integer.toString(count);
		}
		return returnString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		String timeStampNummer = new SimpleDateFormat("yyyyMMdd")
				.format(Calendar.getInstance().getTime());
		setAuftragsnummer(mMitarbeiter.getMitarbeiternummer() + timeStampNummer
				+ fortlaufendeNummer());
		mArtikelColumn
				.setCellValueFactory(new PropertyValueFactory<Artikeleinheit, String>(
						"Artikel"));
		mBeschreibungColumn
				.setCellValueFactory(new PropertyValueFactory<Artikeleinheit, String>(
						"Beschreibung"));
		mPreisColumn
				.setCellValueFactory(new PropertyValueFactory<Artikeleinheit, String>(
						"Preis"));
		mMengeColumn
				.setCellValueFactory(new PropertyValueFactory<Artikeleinheit, String>(
						"Menge"));
		mArtikelView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		mArtikelliste = FXCollections.observableArrayList();
		mArtikelView.addEventFilter(MouseEvent.MOUSE_CLICKED,
				new MyEventHandlerTable());

	}

	/**
	 * The Class MyEventHandlerTable.
	 */
	private class MyEventHandlerTable implements EventHandler<MouseEvent> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 */
		@Override
		public void handle(MouseEvent t) {
			if (reiheAusgewaehlt() == true) {
				mArtikelView.getSelectionModel().getSelectedItem().increaseM();
				aktualisiereTabelle();
			}
		}
	}
}
