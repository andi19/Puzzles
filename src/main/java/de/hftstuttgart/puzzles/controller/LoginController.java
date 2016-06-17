package de.hftstuttgart.puzzles.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import de.hftstuttgart.puzzles.main.Main;
import de.hftstuttgart.puzzles.main.MainView;
import de.hftstuttgart.puzzles.model.Mitarbeiter;
import de.hftstuttgart.puzzles.utilities.FehlerUtility;
import de.hftstuttgart.puzzles.utilities.MitarbeiterUtility;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * The Class LoginController.
 */
public class LoginController implements Initializable {

	/** The main view. */
	private MainView mV = new MainView();

	/** The mitarbeiter id textfeld. */
	@FXML
	private TextField mMitarbeiterIDTextfeld;
	
	/** The passwortfeld. */
	@FXML
	private PasswordField mPasswortfeld;
	
	/** The login button. */
	@FXML
	private Button mLoginButton;
	
	/** The mitarbeiter list. */
	List<Mitarbeiter> mitarbeiterList = new ArrayList<Mitarbeiter>();
	
	/** The list. */
	List<Mitarbeiter> mList;

	/**
	 * Login button.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#mLoginButton].onAction
	@FXML
	public void loginButton(ActionEvent event) {
		System.out.println("test");
		handleLogin();
	}

	/**
	 * Handle login.
	 */
	public void handleLogin() {
		for (Mitarbeiter m : mList) {
			if (mMitarbeiterIDTextfeld.getText().equals(m.getMitarbeiternumerLogin())
					&& mPasswortfeld.getText().equals(m.getPasswort())) {
				Main.mMitarbeiterLoggedIn = m;
				mV.uebersicht();
				Stage stage = (Stage) mLoginButton.getScene().getWindow();
				stage.close();
			}
		}
		if(Main.mMitarbeiterLoggedIn==null){
		FehlerUtility.falschesPasswort();}
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mList = MitarbeiterUtility.loadAllMitarbeiter();
		mMitarbeiterIDTextfeld.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					handleLogin();
				}
			}
		});
		mPasswortfeld.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					handleLogin();
				}
			}
		});
	}
}
