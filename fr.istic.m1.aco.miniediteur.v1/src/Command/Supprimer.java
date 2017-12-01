package Command;

import moteur.Moteur;

public class Supprimer extends CommandImp {
	public Supprimer (Moteur lm){
		super(lm);
	}
	@Override
	public void execute() {
		LM.delete();
	}
}
