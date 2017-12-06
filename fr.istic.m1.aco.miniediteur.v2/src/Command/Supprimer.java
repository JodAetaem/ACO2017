package Command;

import Memento.Enregistreur;
import Memento.MementoSupprimer;
import moteur.Moteur;

public class Supprimer extends CommandImp {
	public Supprimer (Moteur lm,Enregistreur e){
		super(lm,e);
	}
	@Override
	public void execute() {
		LM.delete();
		if(records.getRecording()) {
			records.add(this,new MementoSupprimer());//Ajoute la commande ainsi que le memento correspondant dans la LinkedHashmap de l'enregistreur records
		}estrejoue=false;
	}
}
