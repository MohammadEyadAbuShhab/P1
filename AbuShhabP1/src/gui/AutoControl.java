package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Auto;
import business.AutoModel;
import javafx.stage.Stage;

public class AutoControl {

	private AutoModel autoModel;
	private AutoView autoView;
	private Auto auto;

	public AutoControl(Stage primaryStage) {
		super();
		this.autoModel = new AutoModel();
		this.autoView = new AutoView(autoModel, this, primaryStage);
	}

	private void schreibeAutoInCsvDatei() {
		try {
			BufferedWriter aus = new BufferedWriter(new FileWriter("AutosrAusgabe.csv", true));
			aus.write(auto.gibAutoZurueck(';'));
			aus.close();
			autoView.zeigeInformationsfensterAn("Die Autos wurden gespeichert!");
		} catch (IOException exc) {
			autoView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			autoView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

}
