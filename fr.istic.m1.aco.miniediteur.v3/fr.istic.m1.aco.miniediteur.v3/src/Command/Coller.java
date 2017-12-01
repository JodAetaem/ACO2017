package Command;
import Memento.*;
import moteur.*;
import undoRedo.UndoRedo;

public class Coller extends CommandImp{
	
	private UndoRedo r ;

	public Coller (Moteur lm,Enregistreur e, UndoRedo r){
		super(lm,e);
		this.r = r;

	}
	
	@Override
	public void execute(){
		this.r.addPrevious(LM);
		this.r.noMoreRedo();
		LM.Coller();
		if(records.getRecording()) {
			records.add(this,((new MementoColler() )));
		}
		estrejoue=false;
	}


}
