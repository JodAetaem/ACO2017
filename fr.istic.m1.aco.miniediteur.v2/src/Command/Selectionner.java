package Command;
import Memento.*;

import moteur.*;

public class Selectionner extends CommandImp {
	private IHM ihm;
	

	public Selectionner(Moteur lemoteur,Enregistreur r,IHM ihm) {
		super(lemoteur,r);
		this.ihm=ihm;
	}
	

	@Override
	/**
	 @info execute la commande selectionner 
	 */
	public void execute() {
		int[] debfin = new int[2]; //le tableaux de 2 int qui permets de set la selection 
		if(!estrejoue) {
			/* dans le cas ou ca n'est pas un replay
			en cours on doit ask a l'utilisateur le debut et fin de la selection 
			via la fonction get int*/
		
			
			ihm.getInt(debfin);
			LM.Selectionner(debfin[0],debfin[1]);
			
		}
		else {	// cas ou on est dans un replay donc les int sont a prendre dans le memento 
			int start = ((MementoSelectionner) memento).getSel().getStart();
			int end = ((MementoSelectionner) memento).getSel().getEnd();
			LM.Selectionner(start,end);
		}
		if(records.getRecording()) {//dans le cas ou on est en train de record
			records.add(this,new MementoSelectionner(debfin[0],debfin[1]));//Ajoute la commande ainsi que le memento correspondant dans la LinkedHashmap de l'enregistreur records
		}
		estrejoue=false;
	}

}
