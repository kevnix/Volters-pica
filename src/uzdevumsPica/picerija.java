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
						mercuIzvele = {"BBQ", "Íiploku", "Marinara", "Ranèo", "Saldâ èili"},
						piegade = {"Jâ", "Nç"};
				
				do{
					masivaL = Integer.parseInt(JOptionPane.showInputDialog("Cik klientus pievienosi?"));
				}while(masivaL<1);
				
				klientuMasivs = new Klients[masivaL];
				for(int i=0; i<klientuMasivs.length; i++){
					vards = JOptionPane.showInputDialog("Kâ sauc "+(i+1)+". klientu?");
					talrunis = JOptionPane.showInputDialog("Kâds ir "+(i+1)+". klienta tâlruòa nr?");
					adrese = JOptionPane.showInputDialog("Kâda ir "+(i+1)+". klienta adrese?");
					
					
					klientuMasivs[i] = new Klients(vards, adrese, talrunis);
				}
				
				JOptionPane.showMessageDialog(null, "Klienti reìistrçti! Tagad pierakstam viòu pasûtîjumus!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				
				picuMasivs = new Pica[masivaL];
				for(int i=0; i<picuMasivs.length; i++){
					izmers = (String)JOptionPane.showInputDialog(null, "Izvçlies izmçru", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, izmeruIzvele, izmeruIzvele[0]);
					
					
					int piedevuSk;
					do{
						piedevuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik piedevas?", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE));
					}while(piedevuSk<0 || piedevuSk>5);
					
					
					
					String[] piedevas = new String[piedevuSk];
					for(int j=0; j<piedevuSk; j++){
						piedevas[j] = (String)JOptionPane.showInputDialog(null, "Izvçlies "+(j+1)+". piedevu", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, piedevuIzvele, piedevuIzvele[0]);
					}
					
					int mercuSk;
					do{
						mercuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik mçrces?", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE));
					}while(mercuSk<0 || mercuSk>5);
					
					
					
					String[] merces = new String[mercuSk];
					for(int j=0; j<mercuSk; j++){
						merces[j] = (String)JOptionPane.showInputDialog(null, "Izvçlies "+(j+1)+". mçrci", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, mercuIzvele, mercuIzvele[0]);
					}
					
					picuMasivs[i] = new Pica(izmers, piedevuSk, piedevas, mercuSk, merces);
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
								+ "\nAdrese: "+klientuMasivs[i].getAdrese());
						
			
								JOptionPane.showMessageDialog(null, "Informâcija par "+(i+1)+". klienta picu:"
										+ "\nIzmçrs: "+picuMasivs[i].getIzmers()
										+"\nPiedevas: "+picuMasivs[i].getPiedevas()
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
