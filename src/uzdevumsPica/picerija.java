package uzdevumsPica;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




public class Picerija {
	//static File directory = "S:"+File.separator+"KV_Eclipse"+File.separator+"Volters_pica";
	//static String atrasanasVieta = directory.getAbsolutePath();
	
	static void ierakstit(HashMap<Klients, ArrayList<Pica>> hashmap){
		try{
			FileWriter fw = new FileWriter("pasutijumi.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			
			for (Klients i : hashmap.keySet()) {
				String output="";
				 output+= 	"\nVârds: "+i.getVards()
							+ "\nTâlrunis: "+i.getTalrunis()
							+ "\nAdrese: "+i.getAdrese()
							+ "\n********************";
				 ArrayList<Pica> picas = hashmap.get(i);
				 
				 for(int j=0; j<picas.size(); j++) {
					 output+= 	"\n"+(j+1)+". pica"
							 	+ "\nIzmçrs: "+picas.get(j).getIzmers()
							 	+ "\nPiedevas: "+picas.get(j).getPiedevas()
							 	+ "\nMçrces: "+picas.get(j).getMerces()
							 	+ "\nCena: "+picas.get(j).aprekinatCenu()+" EUR"
							 	+ "\n---------------------";
				 }
				 pw.print(output);
				 output="";
				}
			pw.println("\n___________________________________");
			pw.close();
			JOptionPane.showMessageDialog(null, "Pasûtîjums veiksmîgi ierakstîts failâ!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Problçma ierakstot pasûtîjumu failâ!", "Kïûda", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static void apskatit(){
		String teksts, str="";
		
		try{
			FileReader fr = new FileReader("pasutijumi.txt");
			BufferedReader br = new BufferedReader(fr);
			while((teksts = br.readLine())!=null){
				str+=teksts+"\n";
			}
			JScrollPane scroll=new JScrollPane(new JTextArea(str));
			scroll.setPreferredSize( new Dimension( 300, 500 ) );
			br.close();
			JOptionPane.showMessageDialog(null, scroll, "Pasûtîjumi", JOptionPane.PLAIN_MESSAGE );
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kïûda nolasot failu", "Brîdinâjums", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public static void main(String[] args) {
		String[] darbibas = {"Pievienot pasûtîjumu", "Apskatît pasûtîjumus", "Noòemt pasûtîjumu",  "Apturçt programmu"};
		String izvele;
		HashMap<Klients, ArrayList<Pica>> picuHM = new HashMap<Klients, ArrayList<Pica>>();
		int picuSk;
		
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
					
					do{
						talrunis = JOptionPane.showInputDialog("Kâds ir klienta tâlruòa nummurs?");
					}while(talrunis.length()!=8);
					
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
					Klients klients = new Klients(vards, adrese, talrunis);
					picuHM.put(klients, new ArrayList<Pica>());
				
				
				JOptionPane.showMessageDialog(null, "Klients reìistrçts! Tagad pierakstam viòa pasûtîjumu!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
				
				//picu skaits
				picuSk = Integer.parseInt(JOptionPane.showInputDialog("Ievadi picu skaitu"));	
				for(int i=0; i<picuSk; i++){
					//izmeru izvele
					izmers = (String)JOptionPane.showInputDialog(null, "Izvçlies izmçru"
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
					
					
					
					//pievieno izveidoto picu hashmapam
					picuHM.get(klients).add(new Pica(izmers, piedevuSk, piedevas, mercuSk, merces, piegade ));
					JOptionPane.showMessageDialog(null, "Pica reìistrçta!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
					
				}
					ierakstit(picuHM);
					
				break;
				
			case "Apskatît pasûtîjumus":
				apskatit();
			
				break;
				
			case "Noòemt pasûtîjumu":
				String pagvards;
				boolean nonemts=false;
				if(picuHM.isEmpty()){
					JOptionPane.showMessageDialog(null, "Nav reìistrçtu klientu!", "Íïûda!", JOptionPane.ERROR_MESSAGE);
				}else{
					//parada klientu sarakstu
					String output="";
					for (Klients i : picuHM.keySet()) {
						 output+= "\n"+i.getVards();
						 
						}
					JOptionPane.showMessageDialog(null, output, "Klientu saraksts ", JOptionPane.INFORMATION_MESSAGE);
					
					//ievadi vardu
					pagvards = JOptionPane.showInputDialog("Ievadi klienta vârdu");
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
						JOptionPane.showMessageDialog(null, "Klients ar ðâdu vârdu nav reìistrçts!", "Kïûda", JOptionPane.ERROR_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "Klients noòemts!", "Informâcija", JOptionPane.INFORMATION_MESSAGE);
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
