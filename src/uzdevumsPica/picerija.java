package uzdevumsPica;
import javax.swing.JOptionPane;



public class Picerija {

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pasûtîjumu", "Apskatît pasûtîjumus", "Apturçt programmu"};
		String izvele;
		int masivaL;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Izvçlies darbîbu", "Izvçle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			switch(izvele){
			case "Pievienot pasûtîjumu":
				String vards, adrese, talrunis, izmers;
				String[] izmeruIzvele = {"S", "M", "L", "XL"}, 
						piedevuIzvele = {"Siers", "Bekons", "Ðíiòíis", "Vistas fileja", "Maltâ gaïa", "Sarkanie sîpoli", "Ðampinjoni", "Tomâti", "Paprika", "Kukurûza", "Ananâsi", "Olîvas"},
						mercuIzvele = {"BBQ", "Íiploku", "Marinara", "Ranèo", "Saldâ èili"};
				
				do{
					masivaL = Integer.parseInt(JOptionPane.showInputDialog("Cik klientus pievienosi?"));
				}while(masivaL<1);
				
				Klients[] klientuMasivs = new Klients[masivaL];
				for(int i=0; i<klientuMasivs.length; i++){
					adrese = JOptionPane.showInputDialog("Kâda ir "+(i+1)+". klienta adrese?");
					talrunis = JOptionPane.showInputDialog("Kâds ir "+(i+1)+". klienta tâlruòa nr?");
					vards = JOptionPane.showInputDialog("Kâ sauc "+(i+1)+". klientu?");
						
					klientuMasivs[i] = new Klients(vards, adrese, talrunis);
				}
				
				JOptionPane.showMessageDialog(null, "Klienti reìistrçti! Tagad pierakstam viòu pasûtîjumus!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				
				Pica[] picuMasivs = new Pica[masivaL];
				Double cena = null;
				for(int i=0; i<picuMasivs.length; i++){
					izmers = (String)JOptionPane.showInputDialog(null, "Izvçlies izmçru", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, izmeruIzvele, izmeruIzvele[0]);
					
					//cena pçc izmçra
					switch (izmers){
					case "S":
						cena = 4.99;
						break;
					case "M":
						cena = 9.99;
						break;
					case "L":
						cena = 14.99;
						break;
					case "XL":
						cena = 20.00;
						break;
					}
					
					int piedevuSk;
					do{
						piedevuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik piedevas?", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE));
					}while(piedevuSk<0 || piedevuSk>5);
					
					//cena pçc piedevu skaitu
					cena = cena + piedevuSk*1.65;
					
					String[] piedevas = new String[piedevuSk];
					for(int j=0; j<piedevuSk; j++){
						piedevas[j] = (String)JOptionPane.showInputDialog(null, "Izvçlies "+(j+1)+". piedevu", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, piedevuIzvele, piedevuIzvele[0]);
					}
					
					int mercuSk;
					do{
						mercuSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik mçrces?", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE));
					}while(mercuSk<0 || mercuSk>5);
					
					//cena pçc mçrèu skaita
					cena = cena + mercuSk*0.90;
					
					String[] merces = new String[mercuSk];
					for(int j=0; j<mercuSk; j++){
						merces[j] = (String)JOptionPane.showInputDialog(null, "Izvçlies "+(j+1)+". mçrci", (i+1)+". pica", JOptionPane.QUESTION_MESSAGE, null, mercuIzvele, mercuIzvele[0]);
					}
					
					picuMasivs[i] = new Pica(izmers, piedevas, merces, cena);
					JOptionPane.showMessageDialog(null, (i+1)+". pica reìistrçta!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case "Apskatît pasûtîjumus":
				 //= (String)JOptionPane.showInputDialog(null, "Izvçlies izmçru", "Izvçle", JOptionPane.QUESTION_MESSAGE, null, izmeruIzvele, izmeruIzvele[0]);
				
				
				break;
				
			case "Apturçt programmu":
				JOptionPane.showMessageDialog(null, "Programma aizvçrta!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			
		}while(!izvele.equalsIgnoreCase("Apturçt programmu"));

	}

}
