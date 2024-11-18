package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product {
	
	BufferedReader br = null;
	public ConcreteProductA() {
		try {
			br = new BufferedReader(new FileReader("AutosAusgabe.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] zeile = br.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();
	}

}
