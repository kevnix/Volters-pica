package uzdevumsPica;
import javax.swing.JOptionPane;



public class Picerija {

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pasûtîjumu", "Apskatît pasûtîjumus", "Apturçt programmu"};
		String izvele;
		int masivaL;
		Klients[] klientuMasivs = null;
		Pica[] picuMasivs = null;
		
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
				
				//klientu skaits
				do{
					masivaL = Integer.parseInt(JOptionPane.showInputDialog("Cik klientus pievienosi?"));
				}while(masivaL<1);
				//klientu masiva izveide
				klientuMasivs = new Klients[masivaL];
				//klientu datu ievade
				for(int i=0; i<klientuMasivs.length; i++){
					vards = JOptionPane.showInputDialog("Kâ sauc "+(i+1)+". klientu?");
					talrunis = JOptionPane.showInputDialog("Kâds ir "+(i+1)+". klienta tâlruòa nr?");
					//piegade ja ne
					int yesno = JOptionPane.showOptionDialog(null, "Vai nepiecieðama piegâde? (3 EUR)", "Piegâde", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, piegadesIzveles, piegadesIzveles[0]);
					//ja ir piegade tad prasa adresi, ja nav tad uz vietas
					if(yesno == 0){
						piegade = true;
						adrese = JOptionPane.showInputDialog("Kâda ir "+(i+1)+". klienta adrese?");
					}else{
						piegade = false;
						adrese = "uz vietas";
					}
					
					
					//pievieno izveidoto klientu masivam
					klientuMasivs[i] = new Klients(vards, adrese, talrunis);
				}
				
				JOptionPane.showMessageDialog(null, "Klienti reìistrçti! Tagad pierakstam viòu pasûtîjumus!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				
				picuMasivs = new Pica[masivaL];
				for(int i=0; i<picuMasivs.length; i++){
					//izmeru izvele
					izmers = (String)JOptionPane.showInputDialog(null, "Izvçlies izmçru"
							+ "\nS - 4.99EUR"
							+"\nM - 9.99EUR"
							+"\nL - 14.99EUR"
							+"\nM - 20.00EUR", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, izmeruIzvele, izmeruIzvele[0]);
					
					//piedevu skaits
					int piedevuSk;
					do{
						piedevuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik piedevas? (1.50 EUR)", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE));
					}while(piedevuSk<0 || piedevuSk>5);
					
					
					//piedevu izvele
					String[] piedevas = new String[piedevuSk];
					for(int j=0; j<piedevuSk; j++){
						piedevas[j] = (String)JOptionPane.showInputDialog(null, "Izvçlies "+(j+1)+". piedevu", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, piedevuIzvele, piedevuIzvele[0]);
					}
					
					//mercu skaits
					int mercuSk;
					do{
						mercuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik mçrces? (0.90 EUR)", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE));
					}while(mercuSk<0 || mercuSk>5);
					
					//mercu izvele
					String[] merces = new String[mercuSk];
					for(int j=0; j<mercuSk; j++){
						merces[j] = (String)JOptionPane.showInputDialog(null, "Izvçlies "+(j+1)+". mçrci", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, mercuIzvele, mercuIzvele[0]);
					}
					
					
					
					//pievieno izveidoto picu masivam
					picuMasivs[i] = new Pica(izmers, piedevuSk, piedevas, mercuSk, merces, piegade);
					JOptionPane.showMessageDialog(null, (i+1)+". pica reìistrçta!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case "Apskatît pasûtîjumus":
				if(klientuMasivs.length<1){
					JOptionPane.showMessageDialog(null, "Nav reìistrçtu klientu!", "Íïûda!", JOptionPane.ERROR_MESSAGE);
				}else{
					for(int i=0; i<klientuMasivs.length; i++){
						JOptionPane.showMessageDialog(null, "Informâcija par "+(i+1)+". klientu:"
								+ "\nVârds: "+klientuMasivs[i].getVards()
								+ "\nTâlrunis: "+klientuMasivs[i].getTalrunis()
								+ "\nAdrese: "+klientuMasivs[i].getAdrese()
								+ "\nIzmçrs: "+picuMasivs[i].getIzmers()
								+ "\nPiedevas: "+picuMasivs[i].getPiedevas()
								+ "\nMçrces: "+picuMasivs[i].getMerces());
						
										
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
