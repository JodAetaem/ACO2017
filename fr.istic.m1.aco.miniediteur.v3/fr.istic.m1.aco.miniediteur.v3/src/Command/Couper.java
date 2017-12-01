package Command;
import moteur.*;
import undoRedo.UndoRedo;
import Memento.*;
public class Couper extends CommandImp{
	
	private UndoRedo r;
	
	public Couper (Moteur lm,Enregistreur e, UndoRedo r){
		super(lm,e);
		
		this.r = r;
	}
	
	@Override
	public void execute(){
		this.r.addPrevious(LM);
		this.r.noMoreRedo();
		LM.Couper();
		if(records.getRecording()) {
			records.add(this,new MementoCouper());
		}estrejoue=false;
	}
}
