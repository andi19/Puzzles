package de.hftstuttgart.puzzles.controller;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import de.hftstuttgart.puzzles.model.Artikel;
import de.hftstuttgart.puzzles.model.Artikeleinheit;
import de.hftstuttgart.puzzles.utilities.ArtikelUtility;

/**
 * The Class ArtikelUebersichtController.
 */
public class ArtikelUebersichtController implements Initializable {

	/** The hinzufuegen button. */
	@FXML
	private Button mHinzufuegenButton;
	
	/** The abbrechen button. */
	@FXML
	private Button mAbbrechenButton;
	
	/** The artikel view. */
	@FXML
	private TableView<Artikel> mArtikelView;
	
	/** The artikelnummer. */
	@FXML
	private TableColumn<Artikel, String> mArtikelnummer;
	
	/** The name. */
	@FXML
	private TableColumn<Artikel, String> mName;
	
	/** The beschreibung. */
	@FXML
	private TableColumn<Artikel, String> mBeschreibung;
	
	/** The preis. */
	@FXML
	private TableColumn<Artikel, String> mPreis;

	/** The auftragcontroller. */
	private AuftragController mAC;

	/** The list. */
	private ObservableList<Artikel> mList;

	/**
	 * Hinzufuegen.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#mHinzufuegenButton].onAction
	@FXML
	public void hinzufuegen(ActionEvent event) {
		mAC.mArtikelliste = toList(mList);
		mAC.aktualisiereTabelle();
		Stage stage = (Stage) mHinzufuegenButton.getScene().getWindow();
		stage.close();
	}

	/**
	 * Abbrechen.
	 *
	 * @param event the event
	 */
	// Event Listener on Button[#mAbbrechenButton].onAction
	@FXML
	public void abbrechen(ActionEvent event) {
		Stage stage = (Stage) mAbbrechenButton.getScene().getWindow();
		stage.close();
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mArtikelnummer
				.setCellValueFactory(new PropertyValueFactory<Artikel, String>(
						"Artikelnummer"));
		mName.setCellValueFactory(new PropertyValueFactory<Artikel, String>(
				"Name"));
		mBeschreibung
				.setCellValueFactory(new PropertyValueFactory<Artikel, String>(
						"Beschreibung"));
		mPreis.setCellValueFactory(new PropertyValueFactory<Artikel, String>(
				"Preis"));
		mArtikelView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		mArtikelView.setItems(ArtikelUtility.loadAllArtikel());
		mArtikelView.getSelectionModel().setSelectionMode(
				SelectionMode.MULTIPLE);
		mArtikelView.addEventFilter(MouseEvent.MOUSE_CLICKED,
				new MyEventHandlerTable());
	}

	/**
	 * To list.
	 *
	 * @param ol the ol
	 * @return the observable list
	 */
	private ObservableList<Artikeleinheit> toList(ObservableList<Artikel> ol) {
		ObservableList<Artikeleinheit> list = FXCollections.observableArrayList();

		Iterator<Artikel> i = ol.iterator();
		while (i.hasNext()) {
			Artikel art = i.next();
			Artikeleinheit a = new Artikeleinheit(art, 1);
			list.add(a);
		}
		return list;
	}

	/**
	 * Instantiates a new artikel uebersicht controller.
	 *
	 * @param aC the a c
	 */
	public ArtikelUebersichtController(AuftragController aC) {
		this.mAC = aC;
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
			mList = mArtikelView.getSelectionModel().getSelectedItems();
		}
	}

}
