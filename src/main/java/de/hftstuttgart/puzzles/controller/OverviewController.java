package de.hftstuttgart.puzzles.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import de.hftstuttgart.puzzles.main.Main;
import de.hftstuttgart.puzzles.main.MainView;
import de.hftstuttgart.puzzles.model.Auftrag;
import de.hftstuttgart.puzzles.model.Status;
import de.hftstuttgart.puzzles.utilities.AuftragUtility;
import de.hftstuttgart.puzzles.utilities.FehlerUtility;
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

/**
 * The Class OverviewController.
 */
public class OverviewController implements Initializable {

	/** The uebersicht button. */
	@FXML
	private Button mUebersichtButton;
	
	/** The auftrag button. */
	@FXML
	private Button mAuftragButton;
	
	/** The kundenuebersicht button. */
	@FXML
	private Button mKundenuebersichtButton;
	
	/** The details button. */
	@FXML
	private Button mDetailsButton;
	
	/** The ausgeliefert button. */
	@FXML
	private Button mAusgeliefertButton;
	
	/** The neuausdrucken button. */
	@FXML
	private Button mNeuausdruckenButton;
	
	/** The loeschen button. */
	@FXML
	private Button mLoeschenButton;
	
	/** The suchen button. */
	@FXML
	private Button mSuchenButton;
	
	/** The such feld. */
	@FXML
	private TextField mSuchFeld;
	
	/** The auftrags table view. */
	@FXML
	private TableView<Auftrag> mAuftragsTableView;
	
	/** The auftragsnummer. */
	@FXML
	private TableColumn<Auftrag, String> mAuftragsnummer;
	
	/** The datum. */
	@FXML
	private TableColumn<Auftrag, String> mDatum;
	
	/** The status. */
	@FXML
	private TableColumn<Auftrag, String> mStatus;
	
	/** The notiz. */
	@FXML
	private TableColumn<Auftrag, String> mNotiz;
	
	/** The kunde. */
	@FXML
	private TableColumn<Auftrag, String> mKundeColumn;
	
	/** The mitarbeiter logged in. */
	@FXML
	private Label mMitarbeiterLoggedIn;
	
	/** The beschreibung. */
	@FXML
	private Label mBeschreibung;
	
	/** The kunde. */
	@FXML
	private Label mKunde;
	
	/** The start. */
	@FXML
	private Label mStart;
	
	/** The ende. */
	@FXML
	private Label mEnde;
	
	/** The kundennummer. */
	@FXML
	private Label mKundennummer;

	/** The auftrag. */
	private Auftrag mAuftrag;

	/** The main view. */
	private MainView mV = new MainView();

	/**
	 * Reihe ausgewaehlt.
	 *
	 * @return true, if successful
	 */
	private boolean reiheAusgewaehlt() {
		if (mAuftragsTableView.getSelectionModel().getSelectedItem() != null) {
			return true;
		} else
			return false;
	}

	/**
	 * Table aktualisieren.
	 */
	private void tableAktualisieren() {
		mAuftragsTableView.setItems(AuftragUtility.loadAllAuftraege());
	}

	/**
	 * Uebersicht.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#uebersicht].onAction
	@FXML
	public void uebersicht(ActionEvent event) {
		tableAktualisieren();

	}

	/**
	 * Auftrag.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#auftrag].onAction
	@FXML
	public void auftrag(ActionEvent event) {
		mV.auftrag();
	}

	/**
	 * Kundenuebersicht.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#kundenuebersicht].onAction
	@FXML
	public void kundenuebersicht(ActionEvent event) {
		mV.kundenUebersicht();
	}

	/**
	 * Details.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#details].onAction
	@FXML
	public void details(ActionEvent event) {
		if (reiheAusgewaehlt() == true) {
			// do something
		} else {
			FehlerUtility.keineReihe();
		}
	}

	/**
	 * Suchen.
	 *
	 * @param event the event
	 * @throws SQLException the SQL exception
	 */
	// Event Listener on Button[#suchen].onAction
	@FXML
	public void suchen(ActionEvent event) throws SQLException {
		if (mSuchFeld.getText().equals("")) {
			tableAktualisieren();
		} else if (AuftragUtility.loadAllAuftraegeSuchen(mSuchFeld.getText()) != null) {
			mAuftragsTableView.setItems(AuftragUtility.loadAllAuftraegeSuchen(mSuchFeld.getText()));
		} else {
			FehlerUtility.keinErgebnis();
		}

	}

	/**
	 * Ausgeliefert.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#ausgeliefert].onAction
	@SuppressWarnings("static-access")
	@FXML
	public void ausgeliefert(ActionEvent event) {
		if (reiheAusgewaehlt() == true) {
			mAuftrag = mAuftragsTableView.getSelectionModel().getSelectedItem();
			Status s = null;
			mAuftrag.setStatus(s.ausgeliefert);
			AuftragUtility.editAuftrag(mAuftrag);

			tableAktualisieren();
		} else {
			FehlerUtility.keineReihe();
		}
	}

	/**
	 * Neuausdrucken.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#neuausdrucken].onAction
	@FXML
	public void neuausdrucken(ActionEvent event) {
		if (reiheAusgewaehlt() == true) {
			FehlerUtility.ausgedruckt();
		} else {
			FehlerUtility.keineReihe();
		}
	}

	/**
	 * Loeschen.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#loeschen].onAction
	@FXML
	public void loeschen(ActionEvent event) {
		if (reiheAusgewaehlt() == true) {
			AuftragUtility.deleteAuftrag(mAuftragsTableView.getSelectionModel().getSelectedItem());
			mBeschreibung.setText("");
			mStart.setText("");
			mEnde.setText("");
			mKunde.setText("");
			mKundennummer.setText("");
			tableAktualisieren();
		} else {
			FehlerUtility.keineReihe();
		}
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		mMitarbeiterLoggedIn
				.setText(Main.mMitarbeiterLoggedIn.getVorname() + " " + Main.mMitarbeiterLoggedIn.getNachname());
		mAuftragsnummer.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("Auftragsnummer"));
		mDatum.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("Datum"));
		mStatus.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("Status"));
		mNotiz.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("Notiz"));
		mKundeColumn.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("Kunde"));
		mAuftragsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		mAuftragsTableView.setItems(AuftragUtility.loadAllAuftraege());
		mAuftragsTableView.addEventFilter(MouseEvent.MOUSE_CLICKED, new MyEventHandlerTable());
		mMitarbeiterLoggedIn.addEventFilter(MouseEvent.MOUSE_CLICKED, new MyEventHandlerLogin());
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
				mAuftrag = mAuftragsTableView.getSelectionModel().getSelectedItem();
				mBeschreibung.setText(mAuftrag.getNotiz());
				mStart.setText(mAuftrag.getDatum());
				mEnde.setText("");
				mKunde.setText(mAuftrag.getKunde().getVorname() + " " + mAuftrag.getKunde().getNachname());
				mKundennummer.setText(mAuftrag.getKunde().getKundennummer());
			}
		}
	}

	/**
	 * The Class MyEventHandlerLogin.
	 */
	private class MyEventHandlerLogin implements EventHandler<MouseEvent> {
		
		/* (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 */
		@Override
		public void handle(MouseEvent t) {
			Stage stage = (Stage) mMitarbeiterLoggedIn.getScene().getWindow();
			stage.close();
			mV.login();
			Main.mMitarbeiterLoggedIn = null;
		}
	}
}
