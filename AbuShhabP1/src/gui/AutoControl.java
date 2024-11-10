package gui;

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

	public void nehmeAutoAuf() {
		try {
			this.autoModel.setAuto(new Auto(autoView.getTxtKennzeichen().getText(), autoView.getTxtModell().getText(),
					Float.parseFloat(autoView.getTxtTagesPreis().getText()), autoView.getTxtTyp().getText(),
					autoView.getTxtVermietetVonBis().getText().split(";")));
			this.autoView.zeigeInformationsfensterAn("Das Auto wurde aufgenommen!");
		} catch (Exception exc) {
			this.autoView.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

	public void leseAusDatei(String typ) {
		try {
			this.autoModel.leseAusDatei(typ);
		} catch (IOException exc) {
			this.autoView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			this.autoView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!" + exc.getMessage());
			// exc.printStackTrace(); // Detaillierte Ausgabe des Fehlers in der Konsole
		}
	}

	public void schreibeAutoInCsvDatei() {
		try {
			this.autoModel.schreibeAutoInCsvDatei();
			this.autoView.zeigeInformationsfensterAn("Die auto wurden gespeichert!");
		} catch (IOException exc) {
			this.autoView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.autoView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

}
