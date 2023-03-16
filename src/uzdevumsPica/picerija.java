package uzdevumsPica;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Picerija {

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pas�t�jumu", "Apskat�t pas�t�jumus", "Aptur�t programmu"};
		String izvele;
		ArrayList<Klients> klientuArrayList = new ArrayList<Klients>();
		ArrayList<Pica> picuArrayList = new ArrayList<Pica>();
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Izv�lies darb�bu", "Izv�le", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			switch(izvele){
			case "Pievienot pas�t�jumu":
				String vards, adrese, talrunis, izmers;
				String[] izmeruIzvele = {"S", "M", "L", "XL"}, 
						piedevuIzvele = {"Siers", "Bekons", "��i��is", "Vistas fileja", "Malt� ga�a", "Sarkanie s�poli", "�ampinjoni", "Tom�ti", "Paprika", "Kukur�za", "Anan�si", "Ol�vas"},
						mercuIzvele = {"Tom�tu", "Majon�ze", "BBQ", "�iploku", "Marinara", "Ran�o", "Sald� �ili"},
						piegadesIzveles = {"J�", "N�"};
				boolean piegade = false;
				
				
				//klientu datu ievade
					vards = JOptionPane.showInputDialog("K� sauc klientu?");
					talrunis = JOptionPane.showInputDialog("K�ds ir klienta t�lru�a nr?");
					//piegade ja ne
					int yesno = JOptionPane.showOptionDialog(null, "Vai nepiecie�ama pieg�de? (3 EUR)", "Pieg�de", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, piegadesIzveles, piegadesIzveles[0]);
					//ja ir piegade tad prasa adresi, ja nav tad uz vietas
					if(yesno == 0){
						piegade = true;
						adrese = JOptionPane.showInputDialog("K�da ir klienta adrese?");
					}else{
						piegade = false;
						adrese = "uz vietas";
					}
					
					
					//pievieno izveidoto klientu arraylistam
					klientuArrayList.add(new Klients(vards, adrese, talrunis));
				
				
				JOptionPane.showMessageDialog(null, "Klients re�istr�ts! Tagad pierakstam vi�a pas�t�jumu!", "Inform�cija", JOptionPane.INFORMATION_MESSAGE);
				
	
					//izmeru izvele
					izmers = (String)JOptionPane.showInputDialog(null, "Izv�lies izm�ru"
							+ "\nS - 4.99EUR"
							+"\nM - 9.99EUR"
							+"\nL - 14.99EUR"
							+"\nXL - 20.00EUR", "Pica", JOptionPane.QUESTION_MESSAGE, null, izmeruIzvele, izmeruIzvele[0]);
					
					//piedevu skaits
					int piedevuSk;
					do{
						piedevuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik piedevas? (1.50 EUR)", "Pica", JOptionPane.QUESTION_MESSAGE));
					}while(piedevuSk<0 || piedevuSk>5);
					
					
					//piedevu izvele
					String[] piedevas = new String[piedevuSk];
					for(int j=0; j<piedevuSk; j++){
						piedevas[j] = (String)JOptionPane.showInputDialog(null, "Izv�lies "+(j+1)+". piedevu", "Pica", JOptionPane.QUESTION_MESSAGE, null, piedevuIzvele, piedevuIzvele[0]);
					}
					
					//mercu skaits
					int mercuSk;
					do{
						mercuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik m�rces? (0.90 EUR)", "Pica", JOptionPane.QUESTION_MESSAGE));
					}while(mercuSk<0 || mercuSk>5);
					
					//mercu izvele
					String[] merces = new String[mercuSk];
					for(int j=0; j<mercuSk; j++){
						merces[j] = (String)JOptionPane.showInputDialog(null, "Izv�lies "+(j+1)+". m�rci", "Pica", JOptionPane.QUESTION_MESSAGE, null, mercuIzvele, mercuIzvele[0]);
					}
					
					
					
					//pievieno izveidoto picu arraylistam
					picuArrayList.add(new Pica(izmers, piedevuSk, piedevas, mercuSk, merces, piegade));
					JOptionPane.showMessageDialog(null, "Pica re�istr�ta!", "Inform�cija", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case "Apskat�t pas�t�jumus":
				if(klientuArrayList.size()<1){
					JOptionPane.showMessageDialog(null, "Nav re�istr�tu klientu!", "���da!", JOptionPane.ERROR_MESSAGE);
				}else{
					for(int i=0; i<klientuArrayList.size(); i++){
						JOptionPane.showMessageDialog(null, "Inform�cija par "+(i+1)+". klientu:"
								+ "\nV�rds: "+klientuArrayList.get(i).getVards()
								+ "\nT�lrunis: "+klientuArrayList.get(i).getTalrunis()
								+ "\nAdrese: "+klientuArrayList.get(i).getAdrese()
								+ "\nIzm�rs: "+picuArrayList.get(i).getIzmers()
								+ "\nPiedevas: "+picuArrayList.get(i).getPiedevas()
								+ "\nM�rces: "+picuArrayList.get(i).getMerces()
								+ "\nCena: "+picuArrayList.get(i).aprekinatCenu());
						
										
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
