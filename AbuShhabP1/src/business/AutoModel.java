package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import reader.ConcreteCreaterAB;
import reader.Creater;
import reader.Product;

public class AutoModel {
	private Auto auto;

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public void schreibeAutoInCsvDatei() throws IOException {

		BufferedWriter aus = new BufferedWriter(new FileWriter("AutosAusgabe.csv", false));
		aus.write(auto.gibAutoZurueck(';'));
		aus.close();
	}

	public void leseAusDatei(String typ) throws IOException {
		BufferedReader ein = null;
		String[] zeile = ein.readLine().split(";");
		this.auto = new Auto(zeile[0], zeile[1], Float.parseFloat(zeile[2]), zeile[3], zeile[4].split(";"));
		ein.close();
	}
	
	public void leseAutosAusCsvDatei(String typ) throws IOException {
		
		Creater reader = new ConcreteCreaterAB();
		Product product = reader.factoryMethod(typ);
		
		String[] zeile = product.leseAusDatei();
		this.auto = new Auto(zeile[0], zeile[1], Float.parseFloat(zeile[2]), zeile[3], zeile[4].split(";"));
		product.schliesseDatei();
	}
	
	public void leseAutosAusTxtDatei(String typ) throws IOException {
		
		Creater reader = new ConcreteCreaterAB();
		Product product = reader.factoryMethod(typ);
		
		String[] zeile = product.leseAusDatei();
		this.auto = new Auto(zeile[0], zeile[1], Float.parseFloat(zeile[2]), zeile[3], zeile[4].split(";"));
		product.schliesseDatei();
	}
}
