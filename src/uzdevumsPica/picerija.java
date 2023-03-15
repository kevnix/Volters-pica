package uzdevumsPica;
import javax.swing.JOptionPane;



public class Picerija {

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pas�t�jumu", "Apskat�t pas�t�jumus", "Aptur�t programmu"};
		String izvele;
		int masivaL;
		Klients[] klientuMasivs = null;
		Pica[] picuMasivs = null;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Izv�lies darb�bu", "Izv�le", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			switch(izvele){
			case "Pievienot pas�t�jumu":
				String vards, adrese, talrunis, izmers;
				String[] izmeruIzvele = {"S", "M", "L", "XL"}, 
						piedevuIzvele = {"Siers", "Bekons", "��i��is", "Vistas fileja", "Malt� ga�a", "Sarkanie s�poli", "�ampinjoni", "Tom�ti", "Paprika", "Kukur�za", "Anan�si", "Ol�vas"},
						mercuIzvele = {"BBQ", "�iploku", "Marinara", "Ran�o", "Sald� �ili"},
						piegade = {"J�", "N�"};
				
				do{
					masivaL = Integer.parseInt(JOptionPane.showInputDialog("Cik klientus pievienosi?"));
				}while(masivaL<1);
				
				klientuMasivs = new Klients[masivaL];
				for(int i=0; i<klientuMasivs.length; i++){
					vards = JOptionPane.showInputDialog("K� sauc "+(i+1)+". klientu?");
					talrunis = JOptionPane.showInputDialog("K�ds ir "+(i+1)+". klienta t�lru�a nr?");
					adrese = JOptionPane.showInputDialog("K�da ir "+(i+1)+". klienta adrese?");
					
					
					klientuMasivs[i] = new Klients(vards, adrese, talrunis);
				}
				
				JOptionPane.showMessageDialog(null, "Klienti re�istr�ti! Tagad pierakstam vi�u pas�t�jumus!", "Inform�cija", JOptionPane.INFORMATION_MESSAGE);
				
				picuMasivs = new Pica[masivaL];
				for(int i=0; i<picuMasivs.length; i++){
					izmers = (String)JOptionPane.showInputDialog(null, "Izv�lies izm�ru", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, izmeruIzvele, izmeruIzvele[0]);
					
					
					int piedevuSk;
					do{
						piedevuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik piedevas?", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE));
					}while(piedevuSk<0 || piedevuSk>5);
					
					
					
					String[] piedevas = new String[piedevuSk];
					for(int j=0; j<piedevuSk; j++){
						piedevas[j] = (String)JOptionPane.showInputDialog(null, "Izv�lies "+(j+1)+". piedevu", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, piedevuIzvele, piedevuIzvele[0]);
					}
					
					int mercuSk;
					do{
						mercuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik m�rces?", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE));
					}while(mercuSk<0 || mercuSk>5);
					
					
					
					String[] merces = new String[mercuSk];
					for(int j=0; j<mercuSk; j++){
						merces[j] = (String)JOptionPane.showInputDialog(null, "Izv�lies "+(j+1)+". m�rci", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, mercuIzvele, mercuIzvele[0]);
					}
					
					picuMasivs[i] = new Pica(izmers, piedevuSk, piedevas, mercuSk, merces);
					JOptionPane.showMessageDialog(null, (i+1)+". pica re�istr�ta!", "Inform�cija", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case "Apskat�t pas�t�jumus":
				if(klientuMasivs.length<1){
					JOptionPane.showMessageDialog(null, "Nav re�istr�tu klientu!", "���da!", JOptionPane.ERROR_MESSAGE);
				}else{
					for(int i=0; i<klientuMasivs.length; i++){
						JOptionPane.showMessageDialog(null, "Inform�cija par "+(i+1)+". klientu:"
								+ "\nV�rds: "+klientuMasivs[i].getVards()
								+ "\nT�lrunis: "+klientuMasivs[i].getTalrunis()
								+ "\nAdrese: "+klientuMasivs[i].getAdrese());
						
			
								JOptionPane.showMessageDialog(null, "Inform�cija par "+(i+1)+". klienta picu:"
										+ "\nIzm�rs: "+picuMasivs[i].getIzmers()
										+"\nPiedevas: "+picuMasivs[i].getPiedevas()
										+ "\nM�rces: "+picuMasivs[i].getMerces());
					}
				}
				
				
				
				break;
				
			case "Aptur�t programmu":
				JOptionPane.showMessageDialog(null, "Programma aizv�rta!", "Inform�cija", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			
		}while(!izvele.equalsIgnoreCase("Aptur�t programmu"));

	}

}
