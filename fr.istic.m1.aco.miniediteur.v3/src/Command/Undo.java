package Command;

import Memento.Enregistreur;
import moteur.Moteur;
import undoRedo.UndoRedo;

public class Undo extends CommandImp{
	private UndoRedo r;
	
	public Undo (Moteur lm,Enregistreur e, UndoRedo r){
		super(lm,e);
		this.r = r;
	}

	@Override
	public void execute() {
		r.theUndo(LM);
		
	}

}
