package moteur;
import Command.*;
import java.util.HashMap;
import java.util.Scanner;

public class IHM {
	
	Scanner sc = new Scanner(System.in);
	private  HashMap<String, Command> map = new HashMap<String, Command>();	// map commande
	private String str = "";
	/**
	 * 
	 * @param str
	 * @param cmd
	 * @info ajoute la string s qui executera la commande cmd dans la map 
	 */
	public void init(String str, Command cmd){
		map.put(str, cmd);
		}
	
	/**
	 * 
	 * @return la string qui sera renvoyer par l'utilisateur via le scanner
	 */
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
		sch.close();
		return bob;
	}
	

	public HashMap<String, Command> getMap() {
		return map;
	}
	public void setMap(HashMap<String, Command> map) {
		this.map = map;
	}
	
	
	public void boucle() {
		boolean exec = true;	// boolean de boucle d'execution
		System.out.println("Bievenue dans LA V2 BOF! rentrer votre texte ou votre commande en commenÃ§ant par #\n"
				+ "(#copier #coller #couper #selectionner #close)\n\n");
		
		while(exec){	// Boucle d'action : les commandes commences par #
			Command afficher = map.get("#afficher");
			afficher.execute();
			System.out.println("\n >");
			str = sc.nextLine();
		
			if(map.containsKey(str)){
				map.get(str).execute();
				
			} else if(str.equals("#close")){//cas d'arret de l'éxecution 
				exec = false;
				sc.close();
				System.out.println("Merci d'avoir utilisee V2 BOF! Votre texte: \n");
				afficher.execute();
			}else {//cas de defaut qui est un inserer
				Command inserer = map.get("#inserer");
				inserer.execute();
				}
			
		}
		
	}
}

