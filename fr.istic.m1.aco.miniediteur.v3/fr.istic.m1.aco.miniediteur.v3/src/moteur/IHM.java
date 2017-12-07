package moteur;
import Command.*;
import java.util.HashMap;
import java.util.Scanner;

public class IHM {
	
	Scanner sc = new Scanner(System.in);
	private  HashMap<String, Command> map = new HashMap<String, Command>();	// map commande
	private String str = "";
	
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
		Scanner sch = new Scanner(System.in);
		System.out.println("Debut>\n");
		bob[0] = sch.nextInt();
		System.out.println("Fin>(-1 pour selectionner jusqu'a la fin)\n");
		bob[1] = sch.nextInt();
		return bob;
	}
	

	public HashMap<String, Command> getMap() {
		return map;
	}
	public void setMap(HashMap<String, Command> map) {
		this.map = map;
	}
	
	/**
	 * La boucle d'execution princnipale
	 */
	public void boucle() {
		boolean exec = true;	// boolean de boucle d'execution
		System.out.println("Bievenue dans LA V3 Cool! rentrer votre texte ou votre commande en commençant par #\n"
				+ "(#delete #copier #coller #couper #selectionner #close #start #stop #replay #undo #redo)\n\n");
		
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
				System.out.println("Merci d'avoir utilisee V2 BOF! Votre texte: \n");
				afficher.execute();
			}else {
				Command inserer = map.get("#inserer");
				inserer.execute();
				}
			
		}
		
	}
}

