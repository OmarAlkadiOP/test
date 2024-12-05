package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import FabrikMethode.ConcreteCreatorAB;
import FabrikMethode.Creator;
import FabrikMethode.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class TeppichModel implements Observable{
	
	//3
	LinkedList<Observer> liste = new LinkedList<Observer>();
	//3
	/*private static TeppichModel instanz=null;
	  //Zumachen 3.3
	  public static TeppichModel getInstanz() {
	    if(instanz == null) {
	      instanz = new TeppichModel();
	    }
	    return instanz;
	  }
	  */
	  //ChatGpt
	  private TeppichModel() {
		  
	  }
	
	
	public LinkedList<Observer> getListe() {
		return liste;
		
	}

	public void setListe(LinkedList<Observer> liste) {
		this.liste = liste;
		notifyObservers();
		
	}


	private static Teppich teppich;
	private static TeppichModel model;

	
	
	public static TeppichModel getTeppichModel() {
		if(model == null) {
			return model = new TeppichModel();
		}
		return model;
	}

	public void schreibeTeppichInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("TeppichAusgabe.csv", false));
		aus.write(teppich.gibTeppichZurueck(';'));
		aus.close();
		notifyObservers();

	}



	public void leseAusDatei(String typ) throws IOException {
		Creator creator = new ConcreteCreatorAB();
		Product reader = creator.factoryMethod(typ);
		
		String [] zeile = reader.leseAusDatei();
		
		reader.schliessDatei();
		
		this.teppich = new Teppich(Integer.parseInt(zeile[0]), 
				zeile[1], 
				Float.parseFloat(zeile[2]), 
				Float.parseFloat(zeile[3]), 
				zeile[4].split("_"));
				notifyObservers();
		
	}

	public Teppich getTeppich() {
		return teppich;
	}

	public void setTeppich(Teppich teppich) {
		TeppichModel.teppich = teppich;
		notifyObservers();
	}
	@Override
	public void addObserver(Observer obs) {
		liste.add(obs);
		
	}
	@Override
	public void removeObserver(Observer obs) {
		liste.remove(obs);
		
	}
	@Override
	public void notifyObservers() {
		
		for (Observer o : liste) {
		      o.update();
		    }
	}
	

}