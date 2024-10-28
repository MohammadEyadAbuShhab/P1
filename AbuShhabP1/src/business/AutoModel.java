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

	private void schreibeAutosInCsvDatei() {
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("BuergeraemterAusgabe.csv", true));
			aus.write(auto.gibBuergeramtZurueck(';'));
			aus.close();
		}	
		catch(IOException exc){
			exc.printStackTrace();
		}
	}
}
