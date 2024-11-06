package business;

public class Auto {

	// kennzeichen des Buergeramtes
	private String kennzeichen;
	// Oeffnungszeiten
	private String modell;
	private float tagespreis;
	// Strasse und Hausnummer des Buergeramtes
	private String typ;
	// modell des Buergeramtes
	private String[] vermietetVonBis;

	public Auto(String kennzeichen, String modell, float tagespreis, String typ, String[] vermietetVonBis) {
		this.kennzeichen = kennzeichen;
		this.modell = modell;
		this.tagespreis = tagespreis;
		this.typ = typ;
		this.vermietetVonBis = vermietetVonBis;
	}

	public String getkennzeichen() {
		return kennzeichen;
	}

	public void setkennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public String getmodell() {
		return modell;
	}

	public void setmodell(String modell) {
		this.modell = modell;
	}

	public float gettagespreis() {
		return tagespreis;
	}

	public void settagespreis(float tagespreis) {
		this.tagespreis = tagespreis;
	}

	public String gettyp() {
		return typ;
	}

	public void settyp(String typ) {
		this.typ = typ;
	}

	public String[] getVermietetVonBis() {
		return vermietetVonBis;
	}

	public void setVermietetVonBis(String[] vermietetVonBis) {
		this.vermietetVonBis = vermietetVonBis;
	}

	public String getVermietetVonBisAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for (i = 0; i < this.getVermietetVonBis().length - 1; i++) {
			ergebnis = ergebnis + this.getVermietetVonBis()[i] + trenner;
		}
		return ergebnis + this.getVermietetVonBis()[i];
	}

	public String gibAutoZurueck(char trenner) {
		return this.getkennzeichen() + trenner + this.getmodell() + trenner + this.gettagespreis() + trenner
				+ this.gettyp() + trenner + "\n" + this.getmodellAlsString(trenner) + "\n";
	}
}
