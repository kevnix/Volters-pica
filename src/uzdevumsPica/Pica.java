package uzdevumsPica;

public class Pica {
	String izmers;
	String[] piedevas;
	String[] merces;
	double cena;
	
	public Pica(String izmers, String[] piedevas, String[] merces, double cena){
		this.izmers=izmers;
		this.piedevas=piedevas;
		this.merces=merces;
		this.cena=cena;
		
	}
	
	public String getIzmers(){
		return izmers;
	}
	public String[] getPiedevas(){
		return piedevas;
	}
	public String[] getMerces(){
		return merces;
	}
	public double getCena(){
		return cena;
	}
}
