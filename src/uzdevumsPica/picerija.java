package uzdevumsPica;
import javax.swing.JOptionPane;

public class picerija {

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pasîtîjumu", "Apskatît pasûtîjumus", "Apturçt programmu"};
		String izvele;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Izvçlies darbîbu", "Izvçle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			switch(izvele){
			case "Pievienot pasîtîjumu":
				
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
