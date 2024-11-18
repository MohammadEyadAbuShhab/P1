package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductB extends Product {

	BufferedReader br = null;
	
	public ConcreteProductB() {
		try {
			br = new BufferedReader(new FileReader("AutosAusgabe.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		
		String[] ergebnisZeile = new String[5];
		String zeile = br.readLine();
		int i = 0;

		while (i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = br.readLine();
			i++;
		}
		System.err.println("Hallo");
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();
		
	}

}
