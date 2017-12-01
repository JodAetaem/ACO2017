package Command;

import Memento.Enregistreur;
import moteur.Moteur;

public class Supprimer extends CommandImp {
	public Supprimer (Moteur lm,Enregistreur e){
		super(lm,e);
	}
	@Override
	public void execute() {
		LM.delete();
	}
}
