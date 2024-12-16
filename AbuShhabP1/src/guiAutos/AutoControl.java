package guiAutos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Auto;
import business.AutoModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class AutoControl implements Observer {

	private AutoModel autoModel;
	private AutoView autoView;

	public AutoControl(Stage primaryStage) {
		super();
		this.autoModel = AutoModel.getAutoModel();
		this.autoView = new AutoView(autoModel, this, primaryStage);
		autoModel.addObserver(this);
	}

	public void nehmeAutoAuf() {
		try {
			this.autoModel.addAuto(new Auto(autoView.getTxtKennzeichen().getText(), autoView.getTxtModell().getText(),
					Float.parseFloat(autoView.getTxtTagesPreis().getText()), autoView.getTxtTyp().getText(),
					autoView.getTxtVermietetVonBis().getText().split(";")));
			this.autoView.zeigeInformationsfensterAn("Das Auto wurde aufgenommen!");
		} catch (Exception exc) {
			this.autoView.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

	public void leseAusDatei(String typ){
		
		try {
			if ("csv".equals(typ)) {
				this.autoModel.leseAutosAusCsvDatei(typ);
			}else if("txt".equals(typ)) {
				this.autoModel.leseAutosAusTxtDatei(typ);
			}
			this.autoView.zeigeInformationsfensterAn("Auto wurde aufgenommen!");
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
			this.autoView.zeigeInformationsfensterAn("Die Autos wurden gespeichert!");
		} catch (IOException exc) {
			this.autoView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.autoView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

	@Override
	public void update() {
		autoView.zeigeAutosAn();
		
		
	}

}
