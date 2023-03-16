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
			sb.append(str).append("; ");
		return sb.substring(0, sb.length()-1);
	}
	
	public String getMerces(){
		StringBuilder sb = new StringBuilder();
		for(String str : merces)
			sb.append(str).append("; ");
		return sb.substring(0, sb.length()-1);
	}
	
	public double aprekinatCenu(){
		double cena = 0;
		//ja piegade ir tad cenai pievieno 3 EUR
		if(piegade==true){
			cena += 3;
		}
		//cenai pieveno cenu pec izmera
		switch(izmers){
		case "S":
			cena += 4.99;
			break;
		case "M":
			cena += 9.99;
			break;
		case "L":
			cena += 14.99;
			break;
		case "XL":
			cena += 19.99;
			break;
		}
		//cenai pieveno piedevu cenu
		cena += piedevuSk*1.5;
		//cenai pieveno mercu cenu
		cena += mercuSk*0.9;
		
		return cena;
	}
	
	public int getPiedevuSk(){
		return piedevuSk;
	}
	
	public double getMercuSk(){
		return mercuSk;
	}
}
