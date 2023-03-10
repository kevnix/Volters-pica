package uzdevumsPica;
import javax.swing.JOptionPane;



public class Picerija {

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pasîtîjumu", "Apskatît pasûtîjumus", "Apturçt programmu"};
		String izvele;
		int masivaL;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Izvçlies darbîbu", "Izvçle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			switch(izvele){
			case "Pievienot pasûtîjumu":
				String vards, adrese, talrunis, izmers;
				String[] izmeruIzvele = {"S", "M", "L", "XL"}, piedevuIzvele = {"Siers", "Bekons", "Ðíiòíis", "Vistas fileja", "Maltâ gaïa", "Sarkanie sîpoli", "Ðampinjoni", "Tomâti", "Paprika", "Kukurûza", "Ananâsi", "Olîvas"},
						piedevas, merces;
				do{
					masivaL = Integer.parseInt(JOptionPane.showInputDialog("Cik klientus pievienosi?"));
				}while(masivaL<1);
				
				Klients[] klientuMasivs = new Klients[masivaL];
				for(int i=0; i<klientuMasivs.length; i++){
					adrese = JOptionPane.showInputDialog("Kâda ir klienta adrese?");
					talrunis = JOptionPane.showInputDialog("Kâds ir klienta tâlruòa nr?");
					vards = JOptionPane.showInputDialog("Kâ sauc klientu?");
						
					klientuMasivs[i] = new Klients(vards, adrese, talrunis);
				}
				
				Pica[] picuMasivs = new Pica[masivaL];
				for(int i=0; i<picuMasivs.length; i++){
					izmers = (String)JOptionPane.showInputDialog(null, "Izvçlies izmçru", "Izvçle", JOptionPane.QUESTION_MESSAGE, null, izmeruIzvele, izmeruIzvele[0]);
					
					int piedevuSk = Integer.parseInt(JOptionPane.showInputDialog("Cik piedevas?"));
					for(int j=0; j<piedevuSk; j++){
						piedevas[j] = JOptionPane.showInputDialog("Kâds ir klienta tâlruòa nr?");
					}
					
					vards = (String)JOptionPane.showInputDialog(null, "Izvçlies izmçru", "Izvçle", JOptionPane.QUESTION_MESSAGE, null, piedevuIzvele, piedevuIzvele[0]);
						
					picuMasivs[i] = new Pica(vards, adrese, talrunis);
				}
				break;
				
			case "Nolasît skaitïus no faila":
				
				break;
				
			case "Apturçt programmu":
				JOptionPane.showMessageDialog(null, "Programma aizvçrta!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			
		}while(!izvele.equalsIgnoreCase("Apturçt programmu"));

	}

}
