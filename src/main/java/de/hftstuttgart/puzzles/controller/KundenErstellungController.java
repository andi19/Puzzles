package de.hftstuttgart.puzzles.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import de.hftstuttgart.puzzles.main.Main;
import de.hftstuttgart.puzzles.model.Kunde;
import de.hftstuttgart.puzzles.utilities.KundeUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * The Class KundenErstellungController.
 */
public class KundenErstellungController {

	/** The count. */
	private static int count = 0;

	/** The vorname. */
	@FXML
	private TextField mVorname;
	
	/** The nachname. */
	@FXML
	private TextField mNachname;
	
	/** The mail. */
	@FXML
	private TextField mMail;
	
	/** The telefon. */
	@FXML
	private TextField mTelefon;
	
	/** The gruppe. */
	@FXML
	private TextField mGruppe;
	
	/** The adresse. */
	@FXML
	private TextArea mAdresse;
	
	/** The geschlecht. */
	@FXML
	private ComboBox<String> mGeschlecht;
	
	/** The abbrechen. */
	@FXML
	private Button mAbbrechen;
	
	/** The hinzufuegen. */
	@FXML
	private Button mHinzufuegen;

	/**
	 * Hinzufuegen.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#mHinzufuegen].onAction
	@FXML
	public void hinzufuegen(ActionEvent event) {
		int i = Integer.parseInt(mTelefon.getText());
		String timeStampNummer = new SimpleDateFormat("yyyyMMdd")
				.format(Calendar.getInstance().getTime());
		Kunde k = new Kunde(getKuerzel() + timeStampNummer
				+ fortlaufendeNummer(), mVorname.getText(),
				mNachname.getText(), mGeschlecht.getSelectionModel()
						.getSelectedItem(), mAdresse.getText(),
				mMail.getText(), i);
		KundeUtility.addKunde(k);
		Main.mKunde = k;
		Stage stage = (Stage) mHinzufuegen.getScene().getWindow();
		stage.close();
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

	/**
	 * Gets the kuerzel.
	 *
	 * @return the kuerzel
	 */
	public String getKuerzel() {
		return mNachname.getText().substring(0,2).toUpperCase() + mVorname.getText().substring(0,2).toUpperCase();
	}
}
