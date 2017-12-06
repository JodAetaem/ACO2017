package Command;

import Memento.Enregistreur;
import Memento.MementoSupprimer;
import moteur.Moteur;
import undoRedo.UndoRedo;

public class Supprimer extends CommandImp {
	private UndoRedo r;
	public Supprimer (Moteur lm,Enregistreur e, UndoRedo u){
		super(lm,e);
		this.r = u;
	}
	@Override
	public void execute() {
		this.r.addPrevious(LM);
		this.r.noMoreRedo();
		LM.delete();
		if(records.getRecording()) {
			records.add(this,new MementoSupprimer());//Ajoute la commande ainsi que le memento correspondant dans la LinkedHashmap de l'enregistreur records
		}estrejoue=false;
	}
}
