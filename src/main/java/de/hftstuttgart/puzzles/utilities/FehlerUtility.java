package de.hftstuttgart.puzzles.utilities;

import java.awt.Toolkit;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * The Class FehlerUtility.
 */
public class FehlerUtility {

	/**
	 * Falsches passwort.
	 */
	public static void falschesPasswort() {
		Alert alert = new Alert(AlertType.ERROR);
		Toolkit.getDefaultToolkit().beep();
		alert.setTitle("Fehler");
		alert.setHeaderText("");
		alert.setContentText("Falsches Passwort oder MitarbeiterID");
		alert.showAndWait();
	}
	
	/**
	 * Keine reihe.
	 */
	public static void keineReihe(){
		Alert alert = new Alert(AlertType.ERROR);
		Toolkit.getDefaultToolkit().beep();
		alert.setTitle("Fehler");
		alert.setHeaderText("");
		alert.setContentText("Kein Auftrag ausgewaehlt");
		alert.showAndWait();
	}
	
	/**
	 * Kein ergebnis.
	 */
	public static void keinErgebnis(){
		Alert alert = new Alert(AlertType.ERROR);
		Toolkit.getDefaultToolkit().beep();
		alert.setTitle("Fehler");
		alert.setHeaderText("");
		alert.setContentText("Keine Uebereinstimmung");
		alert.showAndWait();
	}
	
	/**
	 * Kein kunde.
	 */
	public static void keinKunde(){
		Alert alert = new Alert(AlertType.ERROR);
		Toolkit.getDefaultToolkit().beep();
		alert.setTitle("Fehler");
		alert.setHeaderText("");
		alert.setContentText("Kein Kunde ausgewaehlt");
		alert.showAndWait();
	}
	
	/**
	 * Keine artikel.
	 */
	public static void keineArtikel(){
		Alert alert = new Alert(AlertType.ERROR);
		Toolkit.getDefaultToolkit().beep();
		alert.setTitle("Fehler");
		alert.setHeaderText("");
		alert.setContentText("Keine Artikel ausgewaehlt");
		alert.showAndWait();
	}
	
	/**
	 * Ausgedruckt.
	 */
	public static void ausgedruckt(){
		Alert alert = new Alert(AlertType.ERROR);
		Toolkit.getDefaultToolkit().beep();
		alert.setTitle("Fehler");
		alert.setHeaderText("");
		alert.setContentText("Buchhaltung kontaktieren");
		alert.showAndWait();
	}
}
