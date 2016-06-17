package de.hftstuttgart.puzzles.main;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;
import de.hftstuttgart.puzzles.model.Kunde;
import de.hftstuttgart.puzzles.model.Mitarbeiter;


/**
 * The Class Main.
 */
public class Main extends Application {

	/** The mitarbeiter logged in. */
	public static Mitarbeiter mMitarbeiterLoggedIn;
	
	/** The kunde. */
	public static Kunde mKunde;
	
	/** The main view. */
	public static MainView mV = new MainView();

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) {
		mV.login();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws SQLException the SQL exception
	 */
	public static void main(String[] args) throws SQLException {
		launch(args);
	}	
}