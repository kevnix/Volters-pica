package uzdevumsPica;
import javax.swing.JOptionPane;

public class picerija {

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pas�t�jumu", "Apskat�t pas�t�jumus", "Aptur�t programmu"};
		String izvele;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Izv�lies darb�bu", "Izv�le", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			switch(izvele){
			case "Pievienot pas�t�jumu":
				
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
