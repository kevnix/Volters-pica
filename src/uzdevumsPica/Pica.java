package uzdevumsPica;

public class Pica {
	String izmers;
	String[] piedevas;
	String[] merces;
	
	public Pica(String izmers, String[] piedevas, String[] merces){
		this.izmers=izmers;
		this.piedevas=piedevas;
		this.merces=merces;
		
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
}
