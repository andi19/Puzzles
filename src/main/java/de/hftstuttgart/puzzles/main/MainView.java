package de.hftstuttgart.puzzles.main;

import java.io.IOException;

import de.hftstuttgart.puzzles.controller.ArtikelUebersichtController;
import de.hftstuttgart.puzzles.controller.AuftragController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Class MainView.
 */
public class MainView {
	
	/** The stage. */
	private static Stage stage;	
	
	/** The root. */
	private Parent root;
	
	/**
	 * Gets the stage.
	 *
	 * @return the stage
	 */
	public Stage getStage(){
		return stage;
	}
	
	/**
	 * Uebersicht.
	 */
	public void uebersicht(){
		try {
			root = FXMLLoader.load(getClass().getResource("/view/Overview.fxml"));
			stage = new Stage();
			stage.setTitle("Puzzles-CRM-Software");
			stage.setScene(new Scene(root, 1000, 600));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Kunden uebersicht.
	 */
	public void kundenUebersicht(){
		try {
			root = FXMLLoader.load(getClass().getResource("/view/KundenUebersicht.fxml"));
			stage = new Stage();
			stage.setTitle("Kundenübersicht");
			stage.setScene(new Scene(root, 800, 400));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Auftrag.
	 */
	public void auftrag(){
		try {
			root = FXMLLoader.load(getClass().getResource("/view/Auftrag.fxml"));
			stage = new Stage();
			stage.setTitle("Auftragserstellung");
			stage.setScene(new Scene(root, 600, 400));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Login.
	 */
	public void login(){
		try {
			root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
			stage = new Stage();
			stage.setTitle("Login");
			stage.setScene(new Scene(root, 400, 200));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Artikel.
	 *
	 * @param auftragcontoller ac
	 */
	public void artikel(AuftragController aC){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ArtikelUebersicht.fxml"));
			ArtikelUebersichtController mAuc = new ArtikelUebersichtController(aC);
					loader.setController(mAuc);
			root = loader.load();
			//root = FXMLLoader.load(getClass().getResource("/view/ArtikelUebersicht.fxml"));
			stage = new Stage();
			stage.setTitle("Artikel Hinzufügen");
			stage.setScene(new Scene(root, 500, 400));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Kunden erstellung.
	 */
	public void kundenErstellung(){
		try {
			root = FXMLLoader.load(getClass().getResource("/view/KundenErstellung.fxml"));
			stage = new Stage();
			stage.setTitle("Kundenerstellung");
			stage.setScene(new Scene(root, 500, 400));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
