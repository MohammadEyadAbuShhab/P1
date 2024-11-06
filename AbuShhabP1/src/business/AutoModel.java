package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AutoModel {
	private Auto auto;

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	private void schreibeAutoInCsvDatei() {
		try {
			BufferedWriter aus = new BufferedWriter(new FileWriter("AutoAusgabe.csv", true));
			aus.write(auto.gibAutoZurueck(';'));
			aus.close();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
