package uzdevumsPica;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Picerija {

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pasûtîjumu", "Apskatît pasûtîjumus", "Apturçt programmu"};
		String izvele;
		ArrayList<Klients> klientuArrayList = new ArrayList<Klients>();
		ArrayList<Pica> picuArrayList = new ArrayList<Pica>();
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Izvçlies darbîbu", "Izvçle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			switch(izvele){
			case "Pievienot pasûtîjumu":
				String vards, adrese, talrunis, izmers;
				String[] izmeruIzvele = {"S", "M", "L", "XL"}, 
						piedevuIzvele = {"Siers", "Bekons", "Ðíiòíis", "Vistas fileja", "Maltâ gaïa", "Sarkanie sîpoli", "Ðampinjoni", "Tomâti", "Paprika", "Kukurûza", "Ananâsi", "Olîvas"},
						mercuIzvele = {"Tomâtu", "Majonçze", "BBQ", "Íiploku", "Marinara", "Ranèo", "Saldâ èili"},
						piegadesIzveles = {"Jâ", "Nç"};
				boolean piegade = false;
				
				
				//klientu datu ievade
					vards = JOptionPane.showInputDialog("Kâ sauc klientu?");
					talrunis = JOptionPane.showInputDialog("Kâds ir klienta tâlruòa nr?");
					//piegade ja ne
					int yesno = JOptionPane.showOptionDialog(null, "Vai nepiecieðama piegâde? (3 EUR)", "Piegâde", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, piegadesIzveles, piegadesIzveles[0]);
					//ja ir piegade tad prasa adresi, ja nav tad uz vietas
					if(yesno == 0){
						piegade = true;
						adrese = JOptionPane.showInputDialog("Kâda ir klienta adrese?");
					}else{
						piegade = false;
						adrese = "uz vietas";
					}
					
					
					//pievieno izveidoto klientu arraylistam
					klientuArrayList.add(new Klients(vards, adrese, talrunis));
				
				
				JOptionPane.showMessageDialog(null, "Klients reìistrçts! Tagad pierakstam viòa pasûtîjumu!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				
	
					//izmeru izvele
					izmers = (String)JOptionPane.showInputDialog(null, "Izvçlies izmçru"
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
						piedevas[j] = (String)JOptionPane.showInputDialog(null, "Izvçlies "+(j+1)+". piedevu", "Pica", JOptionPane.QUESTION_MESSAGE, null, piedevuIzvele, piedevuIzvele[0]);
					}
					
					//mercu skaits
					int mercuSk;
					do{
						mercuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik mçrces? (0.90 EUR)", "Pica", JOptionPane.QUESTION_MESSAGE));
					}while(mercuSk<0 || mercuSk>5);
					
					//mercu izvele
					String[] merces = new String[mercuSk];
					for(int j=0; j<mercuSk; j++){
						merces[j] = (String)JOptionPane.showInputDialog(null, "Izvçlies "+(j+1)+". mçrci", "Pica", JOptionPane.QUESTION_MESSAGE, null, mercuIzvele, mercuIzvele[0]);
					}
					
					
					
					//pievieno izveidoto picu arraylistam
					picuArrayList.add(new Pica(izmers, piedevuSk, piedevas, mercuSk, merces, piegade));
					JOptionPane.showMessageDialog(null, "Pica reìistrçta!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case "Apskatît pasûtîjumus":
				if(klientuArrayList.size()<1){
					JOptionPane.showMessageDialog(null, "Nav reìistrçtu klientu!", "Íïûda!", JOptionPane.ERROR_MESSAGE);
				}else{
					for(int i=0; i<klientuArrayList.size(); i++){
						JOptionPane.showMessageDialog(null, "Informâcija par "+(i+1)+". klientu:"
								+ "\nVârds: "+klientuArrayList.get(i).getVards()
								+ "\nTâlrunis: "+klientuArrayList.get(i).getTalrunis()
								+ "\nAdrese: "+klientuArrayList.get(i).getAdrese()
								+ "\nIzmçrs: "+picuArrayList.get(i).getIzmers()
								+ "\nPiedevas: "+picuArrayList.get(i).getPiedevas()
								+ "\nMçrces: "+picuArrayList.get(i).getMerces()
								+ "\nCena: "+picuArrayList.get(i).aprekinatCenu());
						
										
					}
				}
				
				
				
				break;
				
			case "Apturçt programmu":
				JOptionPane.showMessageDialog(null, "Programma aizvçrta!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			
		}while(!izvele.equalsIgnoreCase("Apturçt programmu"));

	}

}
