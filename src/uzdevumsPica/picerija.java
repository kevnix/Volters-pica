package uzdevumsPica;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;



public class Picerija {
	
	static void ierakstit(HashMap<Klients, ArrayList<Pica>> hashmap){
		try{
			FileWriter fw = new FileWriter("pasutijumi.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			
			for (Klients i : hashmap.keySet()) {
				String output="";
				 output+= 	"\nV�rds: "+i.getVards()
							+ "\nT�lrunis: "+i.getTalrunis()
							+ "\nAdrese: "+i.getAdrese()
							+ "\n**************************";
				 ArrayList<Pica> picas = hashmap.get(i);
				 
				 for(int j=0; j<picas.size(); j++) {
					 output+= 	"\n"+(j+1)+". pica"
							 	+ "\nIzm�rs: "+picas.get(j).getIzmers()
							 	+ "\nPiedevas: "+picas.get(j).getPiedevas()
							 	+ "\nM�rces: "+picas.get(j).getMerces()
							 	+ "\nCena: "+picas.get(j).aprekinatCenu()+" EUR"
							 	+ "\n----------------------------------------";
				 }
				 pw.print(output);
				 output="";
				}
			pw.println("\n______________");
			pw.close();
			JOptionPane.showMessageDialog(null, "Mas�vs veiksm�gi ierakst�ts fail�!", "Inform�cija", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Probl�ma ierakstot mas�vu fail�!", "K��da", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pas�t�jumu", "Apskat�t pas�t�jumus", "No�emt pas�t�jumu",  "Aptur�t programmu"};
		String izvele;
		HashMap<Klients, ArrayList<Pica>> picuHM = new HashMap<Klients, ArrayList<Pica>>();
		int picuSk;
		
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
					
					do{
						talrunis = JOptionPane.showInputDialog("K�ds ir klienta t�lru�a nummurs?");
					}while(talrunis.length()!=8);
					
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
					Klients klients = new Klients(vards, adrese, talrunis);
					picuHM.put(klients, new ArrayList<Pica>());
				
				
				JOptionPane.showMessageDialog(null, "Klients re�istr�ts! Tagad pierakstam vi�a pas�t�jumu!", "Inform�cija", JOptionPane.INFORMATION_MESSAGE);
				
				//picu skaits
				picuSk = Integer.parseInt(JOptionPane.showInputDialog("Ievadi picu skaitu"));	
				for(int i=0; i<picuSk; i++){
					//izmeru izvele
					izmers = (String)JOptionPane.showInputDialog(null, "Izv�lies izm�ru"
							+ "\nS - 4.99 EUR"
							+"\nM - 9.99 EUR"
							+"\nL - 14.99 EUR"
							+"\nXL - 20.00 EUR", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, izmeruIzvele, izmeruIzvele[0]);
					
					//piedevu skaits
					int piedevuSk;
					do{
						piedevuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik piedevas? (1.50 EUR)", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE));
					}while(piedevuSk<0 || piedevuSk>5);
					
					
					//piedevu izvele
					String[] piedevas = new String[piedevuSk];
					for(int j=0; j<piedevuSk; j++){
						piedevas[j] = (String)JOptionPane.showInputDialog(null, "Izv�lies "+(j+1)+". piedevu", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, piedevuIzvele, piedevuIzvele[0]);
					}
					
					//mercu skaits
					int mercuSk;
					do{
						mercuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik m�rces? (0.90 EUR)", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE));
					}while(mercuSk<0 || mercuSk>5);
					
					//mercu izvele
					String[] merces = new String[mercuSk];
					for(int j=0; j<mercuSk; j++){
						merces[j] = (String)JOptionPane.showInputDialog(null, "Izv�lies "+(j+1)+". m�rci", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, mercuIzvele, mercuIzvele[0]);
					}
					
					
					
					//pievieno izveidoto picu hashmapam
					picuHM.get(klients).add(new Pica(izmers, piedevuSk, piedevas, mercuSk, merces, piegade ));
					JOptionPane.showMessageDialog(null, "Pica re�istr�ta!", "Inform�cija", JOptionPane.INFORMATION_MESSAGE);
				}
					
				break;
				
			case "Apskat�t pas�t�jumus":
				if(picuHM.isEmpty()){
					JOptionPane.showMessageDialog(null, "Nav re�istr�tu klientu!", "���da!", JOptionPane.ERROR_MESSAGE);
				}else{
					//saliek klienta informaciju vienaa stringaa
					for (Klients i : picuHM.keySet()) {
						String output="";
						 output+= 	"\nV�rds: "+i.getVards()
									+ "\nT�lrunis: "+i.getTalrunis()
									+ "\nAdrese: "+i.getAdrese()
									+ "\n**************************";
						 ArrayList<Pica> picas = picuHM.get(i);
						 
						 for(int j=0; j<picas.size(); j++) {
							 output+= 	"\n"+(j+1)+". pica"
									 	+ "\nIzm�rs: "+picas.get(j).getIzmers()
									 	+ "\nPiedevas: "+picas.get(j).getPiedevas()
									 	+ "\nM�rces: "+picas.get(j).getMerces()
									 	+ "\nCena: "+picas.get(j).aprekinatCenu()+" EUR"
									 	+ "\n----------------------------------------";
						 }
						 
						 JOptionPane.showMessageDialog(null, output, "Inform�cija par "+i.getVards(), JOptionPane.INFORMATION_MESSAGE);
						 output="";
						}
					
				}
			
				break;
				
			case "No�emt pas�t�jumu":
				String pagvards;
				boolean nonemts=false;
				if(picuHM.isEmpty()){
					JOptionPane.showMessageDialog(null, "Nav re�istr�tu klientu!", "���da!", JOptionPane.ERROR_MESSAGE);
				}else{
					//parada klientu sarakstu
					String output="";
					for (Klients i : picuHM.keySet()) {
						 output+= "\n"+i.getVards();
						 
						}
					JOptionPane.showMessageDialog(null, output, "Klientu saraksts ", JOptionPane.INFORMATION_MESSAGE);
					
					//ievadi vardu
					pagvards = JOptionPane.showInputDialog("Ievadi klienta v�rdu");
					//nonemsana
					for (Klients i : picuHM.keySet()) {
						if(pagvards.equals(i.getVards())){
							picuHM.remove(i);
							nonemts=true;
						}else{
							nonemts=false;
							
						}
						
					}
					//parbaud vai ir nonemts
					if(nonemts=false){
						JOptionPane.showMessageDialog(null, "Klients ar ��du v�rdu nav re�istr�ts!", "K��da", JOptionPane.ERROR_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "Klients no�emts!", "Inform�cija", JOptionPane.INFORMATION_MESSAGE);
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
