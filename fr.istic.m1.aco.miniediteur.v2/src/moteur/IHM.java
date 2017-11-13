package moteur;
import Command.*;
import Memento.*;
import java.util.HashMap;
import java.util.Scanner;

public class IHM {
	
	Scanner sc = new Scanner(System.in);
	private  HashMap<String, Command> map = new HashMap<String, Command>();	// map commande
	private String str = "";
	private Enregistreur record ;
	
	public void init(String str, Command cmd){
		map.put(str, cmd);
		}
	public String getTexte(){
		return str ;
	}
	
	/**
	 * 
	 * @return tableau de 2 int contenant le debut (0) et la fin (1)
	 */
	public int[] getInt(int[] bob){
		System.out.println("Debut>\n");
		bob[0] = sc.nextInt();
		System.out.println("Fin>\n");
		bob[1] = sc.nextInt();
		return bob;
	}

	
	public void boucle() {
		boolean exec = true;	// boolean de boucle d'execution
		System.out.println("Bievenue dans LA V1 NULLE! rentrer votre texte ou votre commande en commençant par #\n"
				+ "(#copier #coller #couper #selectionner #close)\n\n");
		
		while(exec){	// Boucle d'action : les commandes commences par #
			Command afficher = map.get("#afficher");
			afficher.execute();
			System.out.println("\n >");
			str = sc.nextLine();
		
			if(map.containsKey(str)){
				map.get(str).execute();
				
			} else if(str.equals("#close")){
				exec = false;
				sc.close();
				System.out.println("Merci d'avoir utilisee V1 nulle! Votre texte: \n");
				afficher.execute();
			}else {
				Command inserer = map.get("#inserer");
				inserer.execute();
				}
			
		}
		
	}
}

