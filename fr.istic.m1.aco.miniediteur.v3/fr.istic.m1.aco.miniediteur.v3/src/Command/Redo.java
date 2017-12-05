package Command;

import Memento.Enregistreur;
import moteur.Moteur;
import undoRedo.UndoRedo;

public class Redo extends CommandImp{
	private UndoRedo r;
	
	public Redo (Moteur lm,Enregistreur e, UndoRedo r){
		super(lm,e);
		this.r = r;
	}

	@Override
	public void execute() {
		r.theRedo(LM);
		
	}

}
