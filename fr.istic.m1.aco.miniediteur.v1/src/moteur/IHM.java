package moteur;
import Command.*;
import java.util.HashMap;
import java.util.Scanner;

public class IHM {
	
	Scanner sc = new Scanner(System.in);

	public static void init(HashMap<String,Command> hashish, Moteur lemoteur){
			hashish.put("#copier", new Copier(lemoteur));
			hashish.put("#coller", new Coller(lemoteur));
			hashish.put("#selectionner", new Selectionner(lemoteur));
			hashish.put("#couper", new Couper(lemoteur));
			
		}
	public String getTexte(){
		return sc.nextLine();
	}

	
	public static void main(String[] args) {
		IHM lihm = new IHM();	// l'ihm
		Moteur lemoteur = new MoteurImp("");	// le moteur
		boolean exec = true;	// boolean de boucle d'execution
		HashMap<String, Command> map = new HashMap<String, Command>();	// map commande
		init(map, lemoteur);
		String str ;	// La str tape
		
		
		
		
		System.out.println("Bievenue dans LA V1 NULLE! rentrer votre texte ou votre commande en commençant par #\n"
				+ "(#copier #coller #couper #selectionner #close)\n\n");
		
		while(exec){	// Boucle d'action : les commandes commences par #
			System.out.println(lemoteur.getTexte());
			System.out.println("\n >");
			str = lihm.sc.nextLine();
		
			if(map.containsKey(str)){
				map.get(str).execute();
				
			} else if(str.equals("#close")){
				exec = false;
				lihm.sc.close();
				System.out.println("Merci d'avoir utilisé V1 nulle! Votre texte: \n" + lemoteur.getTexte());
			}else {
				new Inserer(lemoteur, str).execute();
				}
			
		}
		
	}
}





/*		A JETER PLUS TARD QUAND ON SERA SUR WESH
 * 
 * 		while(exec){	// Boucle d'action : les commandes commences par #
			System.out.println(lemoteur.getTexte());
			System.out.println("\n >");
			str = lihm.sc.nextLine();
		
			if(str.equals("#copier")){
				
			} else if(str.equals("#coller")){
				Coller.execute();
			} else if(str.equals("#couper")){
				lemoteur.Couper();
			}else if(str.equals("#selectionner")){
				System.out.println("\n > Debut");
				debut = lihm.sc.nextInt();
				System.out.println("\n > Fin");
				fin = lihm.sc.nextInt();
				lemoteur.Selectionner(debut,fin);
				lihm.sc.nextLine();
			} else if(str.equals("#close")){
				exec = false;
				lihm.sc.close();
				System.out.println("Merci d'avoir utilisé V1 nulle! Votre texte: \n" + lemoteur.getTexte());
			}else {lemoteur.Inserer(str);}
			
		}
 * 
 * 
 * */
