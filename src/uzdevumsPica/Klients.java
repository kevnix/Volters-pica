package uzdevumsPica;

public class Klients {
	String vards, adrese, talrunis;
	
	public Klients(String vards, String adrese, String talrunis){
		this.vards=vards;
		this.adrese=adrese;
		this.talrunis=talrunis;
	}
	
	public String getVards(){
		return vards;
	}
	public String getAdrese(){
		return adrese;
	}
	public String getTalrunis(){
		return "+371 "+talrunis;
	}
}
