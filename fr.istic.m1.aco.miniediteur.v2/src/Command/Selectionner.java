package Command;


import java.util.Scanner;

import moteur.*;

public class Selectionner extends CommandImp {
	Scanner sc = new Scanner(System.in);

	public Selectionner(Moteur lemoteur) {
		super(lemoteur);
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

	@Override
	public void execute() {
		int[] debfin = new int[2];
		getInt(debfin);
		LM.Selectionner(debfin[0],debfin[1]);
	}

}
