package uzdevumsPica;

public class Pica {
	String izmers;
	String[] piedevas;
	String[] merces;
	double cena;
	int piedevuSk, mercuSk;
	boolean piegade;
	
	public Pica(String izmers, int piedevuSk, String[] piedevas, int mercuSk, String[] merces, boolean piegade){
		this.izmers=izmers;
		this.piedevas=piedevas;
		this.merces=merces;
		this.piedevuSk=piedevuSk;
		this.mercuSk=mercuSk;
		this.piegade=piegade;
		
	}
	
	public String getIzmers(){
		return izmers;
	}
	public String getPiedevas(){
		StringBuilder sb = new StringBuilder();
		for(String str : piedevas)
			sb.append(str).append(", ");
		return sb.substring(0, sb.length()-1);
	}
	
	public String getMerces(){
		StringBuilder sb = new StringBuilder();
		for(String str : merces)
			sb.append(str).append(", ");
		return sb.substring(0, sb.length()-1);
	}
	
	public double getCena(){
		return cena;
	}
	
	public int getPiedevuSk(){
		return piedevuSk;
	}
	
	public double getMercuSk(){
		return mercuSk;
	}
}
