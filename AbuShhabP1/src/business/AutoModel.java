package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;
import reader.ConcreteCreaterAB;
import reader.Creater;
import reader.Product;

public class AutoModel implements Observable{
	private Auto auto;
	private static AutoModel autoModel;
	Vector<Observer> observers = new Vector<Observer>();
	
	private AutoModel() {
	}
	
	
	
	public static AutoModel getAutoModel() {
		if (autoModel == null) {
			autoModel = new AutoModel();
		}
		return autoModel;
	}

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
		notifyObservers();
	}

	public void leseAusDatei(String typ) throws IOException {
		BufferedReader ein = null;
		String[] zeile = ein.readLine().split(";");
		this.auto = new Auto(zeile[0], zeile[1], Float.parseFloat(zeile[2]), zeile[3], zeile[4].split(";"));
		ein.close();
		notifyObservers();
	}
	
	public void leseAutosAusCsvDatei(String typ) throws IOException {
		
		Creater reader = new ConcreteCreaterAB();
		Product product = reader.factoryMethod(typ);
		
		String[] zeile = product.leseAusDatei();
		this.auto = new Auto(zeile[0], zeile[1], Float.parseFloat(zeile[2]), zeile[3], zeile[4].split(";"));
		product.schliesseDatei();
		notifyObservers();
	}
	
	public void leseAutosAusTxtDatei(String typ) throws IOException {
		
		Creater reader = new ConcreteCreaterAB();
		Product product = reader.factoryMethod(typ);
		
		String[] zeile = product.leseAusDatei();
		this.auto = new Auto(zeile[0], zeile[1], Float.parseFloat(zeile[2]), zeile[3], zeile[4].split(";"));
		product.schliesseDatei();
		notifyObservers();
	}



	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
		
	}



	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
		
	}



	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
		
	}
}
