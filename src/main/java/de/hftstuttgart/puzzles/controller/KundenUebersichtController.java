package de.hftstuttgart.puzzles.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import de.hftstuttgart.puzzles.main.Main;
import de.hftstuttgart.puzzles.main.MainView;
import de.hftstuttgart.puzzles.model.Kunde;
import de.hftstuttgart.puzzles.utilities.AuftragUtility;
import de.hftstuttgart.puzzles.utilities.FehlerUtility;
import de.hftstuttgart.puzzles.utilities.KundeUtility;

/**
 * The Class KundenUebersichtController.
 */
public class KundenUebersichtController implements Initializable {

	/** The kunden view. */
	@FXML
	private TableView<Kunde> mKundenView;
	
	/** The kundennummer. */
	@FXML
	private TableColumn<Kunde, String> mKundennummer;
	
	/** The vorname. */
	@FXML
	private TableColumn<Kunde, String> mVorname;
	
	/** The nachname. */
	@FXML
	private TableColumn<Kunde, String> mNachname;
	
	/** The hinzufuegen. */
	@FXML
	private Button mHinzufuegen;
	
	/** The abbrechen. */
	@FXML
	private Button mAbbrechen;
	
	/** The suchen button. */
	@FXML
	private Button mSuchenButton;
	
	/** The such feld. */
	@FXML
	private TextField mSuchFeld;
	
	/** The geschlecht. */
	@FXML
	private Label mGeschlecht;
	
	/** The mail. */
	@FXML
	private Label mMail;
	
	/** The telefon. */
	@FXML
	private Label mTelefon;
	
	/** The adresse. */
	@FXML
	private Label mAdresse;
	
	/** The gruppe. */
	@FXML
	private Label mGruppe;

	/** The kunde. */
	private Kunde mKunde;

	/** The main view. */
	private MainView mV = new MainView();

	/**
	 * Reihe ausgewaehlt.
	 *
	 * @return true, if successful
	 */
	private boolean reiheAusgewaehlt() {
		if (mKundenView.getSelectionModel().getSelectedItem() != null) {
			return true;
		} else
			return false;
	}

	/**
	 * Hinzufuegen.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#mHinzufuegen].onAction
	@FXML
	public void hinzufuegen(ActionEvent event) {
		mV.kundenErstellung();
	}

	/**
	 * Abbrechen.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#mAbbrechen].onAction
	@FXML
	public void abbrechen(ActionEvent event) {
		Stage stage = (Stage) mAbbrechen.getScene().getWindow();
		stage.close();
	}

	/**
	 * Suchen.
	 *
	 * @param event the event
	 * @throws SQLException the SQL exception
	 */
	// Event Listener on Button[#mSuchenButton].onAction
	@FXML
	public void suchen(ActionEvent event) throws SQLException {
		if (mSuchFeld.getText().equals("")) {
			mKundenView.setItems(KundeUtility.loadAllKunden());
		} else if (AuftragUtility.loadAllAuftraegeSuchen(mSuchFeld.getText()) != null) {
			mKundenView.setItems(KundeUtility.loadAllKundenSuchen(mSuchFeld.getText()));
		} else {
			FehlerUtility.keinErgebnis();
		}

	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		mKundennummer.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Kundennummer"));
		mVorname.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Vorname"));
		mNachname.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Nachname"));
		mKundenView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		mKundenView.setItems(KundeUtility.loadAllKunden());
		mKundenView.addEventFilter(MouseEvent.MOUSE_CLICKED, new MyEventHandlerTable());
	}

	/**
	 * The Class MyEventHandlerTable.
	 */
	private class MyEventHandlerTable implements EventHandler<MouseEvent> {
		
		/* (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 */
		@Override
		public void handle(MouseEvent t) {
			if (reiheAusgewaehlt() == true) {
				mKunde = mKundenView.getSelectionModel().getSelectedItem();
				mGeschlecht.setText(mKunde.getGeschlecht());
				mMail.setText(mKunde.getMail());
				mTelefon.setText(Integer.toString(mKunde.getTelefon()));
				String str = "";
				String[] rsl;
				rsl = mKunde.getAdresse().split(",");
				for (String s : rsl) {
					str = str + s + "\n";
				}
				mAdresse.setText(str);
				mGruppe.setText(String.valueOf(mKunde.getGruppe()));

				if (t.getClickCount() == 2) {
					mKunde = mKundenView.getSelectionModel().getSelectedItem();
					Main.mKunde = mKunde;
					Stage stage = (Stage) mAbbrechen.getScene().getWindow();
					stage.close();
				}
			}
		}
	}
}
