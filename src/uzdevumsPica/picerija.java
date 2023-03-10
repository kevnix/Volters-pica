package uzdevumsPica;
import javax.swing.JOptionPane;



public class Picerija {

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pas�t�jumu", "Apskat�t pas�t�jumus", "Aptur�t programmu"};
		String izvele;
		int masivaL;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Izv�lies darb�bu", "Izv�le", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			switch(izvele){
			case "Pievienot pas�t�jumu":
				String vards, adrese, talrunis, izmers;
				String[] izmeruIzvele = {"S", "M", "L", "XL"}, piedevuIzvele = {"Siers", "Bekons", "��i��is", "Vistas fileja", "Malt� ga�a", "Sarkanie s�poli", "�ampinjoni", "Tom�ti", "Paprika", "Kukur�za", "Anan�si", "Ol�vas"},
						piedevas, merces;
				do{
					masivaL = Integer.parseInt(JOptionPane.showInputDialog("Cik klientus pievienosi?"));
				}while(masivaL<1);
				
				Klients[] klientuMasivs = new Klients[masivaL];
				for(int i=0; i<klientuMasivs.length; i++){
					adrese = JOptionPane.showInputDialog("K�da ir klienta adrese?");
					talrunis = JOptionPane.showInputDialog("K�ds ir klienta t�lru�a nr?");
					vards = JOptionPane.showInputDialog("K� sauc klientu?");
						
					klientuMasivs[i] = new Klients(vards, adrese, talrunis);
				}
				
				Pica[] picuMasivs = new Pica[masivaL];
				for(int i=0; i<picuMasivs.length; i++){
					izmers = (String)JOptionPane.showInputDialog(null, "Izv�lies izm�ru", "Izv�le", JOptionPane.QUESTION_MESSAGE, null, izmeruIzvele, izmeruIzvele[0]);
					
					int piedevuSk = Integer.parseInt(JOptionPane.showInputDialog("Cik piedevas?"));
					for(int j=0; j<piedevuSk; j++){
						piedevas[j] = JOptionPane.showInputDialog("K�ds ir klienta t�lru�a nr?");
					}
					
					vards = (String)JOptionPane.showInputDialog(null, "Izv�lies izm�ru", "Izv�le", JOptionPane.QUESTION_MESSAGE, null, piedevuIzvele, piedevuIzvele[0]);
						
					picuMasivs[i] = new Pica(vards, adrese, talrunis);
				}
				break;
				
			case "Nolas�t skait�us no faila":
				
				break;
				
			case "Aptur�t programmu":
				JOptionPane.showMessageDialog(null, "Programma aizv�rta!", "Inform�cija", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			
		}while(!izvele.equalsIgnoreCase("Aptur�t programmu"));

	}

}
