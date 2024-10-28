package business;

public class Auto {
	
	// kennzeichen des Buergeramtes
    private String kennzeichen;
    // Oeffnungszeiten
    private float vermietetVonBis;
    private float tagespreis;
    // Strasse und Hausnummer des Buergeramtes
    private String typ;
    // modell des Buergeramtes
    private String[] modell;

    public Auto(String kennzeichen, float vermietetVonBis, float tagespreis,
    	String typ, String[] modell){
   		this.kennzeichen = kennzeichen;
  	    this.vermietetVonBis = vermietetVonBis;
   	    this.tagespreis = tagespreis;
   	    this.typ = typ;
   	    this.modell = modell;
    }
    
	public String getkennzeichen() {
		return kennzeichen;
	}

	public void setkennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public float getvermietetVonBis() {
		return vermietetVonBis;
	}

	public void setvermietetVonBis(float vermietetVonBis) {
		this.vermietetVonBis = vermietetVonBis;
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

	public String[] getmodell() {
		return modell;
	}

	public void setmodell(String[] modell) {
		this.modell = modell;
	}
	
	public String getmodellAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getmodell().length - 1; i++) {
			ergebnis = ergebnis + this.getmodell()[i] + trenner; 
		}
		return ergebnis	+ this.getmodell()[i];
	}
	
	public String gibBuergeramtZurueck(char trenner){
  		return this.getkennzeichen() + trenner 
  			+ this.getvermietetVonBis() + trenner
  		    + this.gettagespreis() + trenner
  		    + this.gettyp() + trenner + "\n"
  		    + this.getmodellAlsString(trenner) + "\n";
  	}
}

