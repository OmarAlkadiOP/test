package business;

public class Teppich {
	
	//  -> ArtikelNummer von teppich
    private int artikelNummer;
    //  -> KategorieTyp
    private String kategorie;
    // Bereite 
    private float bereite;
    // -> Laenge
    private float laenge;
    // -> Farben
    private String[] farben;

  
    
	public Teppich(int artikelNummer, String kategorie, float bereite, float laenge, String[] farben) {
		super();
		this.artikelNummer = artikelNummer;
		this.kategorie = kategorie;
		this.bereite = bereite;
		this.laenge = laenge;
		this.farben = farben;
	}

	

	public int getArtikelNummer() {
		return artikelNummer;
	}



	public void setArtikelNummer(int artikelNummer) {
		this.artikelNummer = artikelNummer;
	}



	public String getKategorie() {
		return kategorie;
	}



	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}



	public float getBereite() {
		return bereite;
	}



	public void setBereite(float bereite) {
		this.bereite = bereite;
	}



	public float getLaenge() {
		return laenge;
	}



	public void setLaenge(float laenge) {
		this.laenge = laenge;
	}



	public String[] getFarben() {
		return farben;
	}



	public void setFarben(String[] farben) {
		this.farben = farben;
	}


	
	public String getFarbenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getFarben().length - 1; i++) {
			ergebnis = ergebnis + this.getFarben()[i] + trenner; 
		}
		return ergebnis	+ this.getFarben()[i];
	}
	
	public String gibTeppichZurueck(char trenner){
  		return ""+this.getArtikelNummer() + trenner 
  			+ this.getKategorie() + trenner
  		    + this.getBereite() + trenner
  		    + this.getLaenge() + trenner 
  		    + this.getFarbenAlsString(trenner) + "\n";
  	}
}