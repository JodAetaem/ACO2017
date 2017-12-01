package Command;
import moteur.*;
import undoRedo.UndoRedo;
import Memento.*;


public class Inserer  extends CommandImp{
	private IHM ihm;
	private UndoRedo r;
	public Inserer (Moteur lm, IHM ihm,Enregistreur e, UndoRedo r){
		super(lm,e);
		this.ihm = ihm;
		this.r = r;
	}
	
	@Override
	public void execute(){
		this.r.addPrevious(LM);
		this.r.noMoreRedo();
		String str;
		if(!estrejoue) {
			str = this.ihm.getTexte();
			LM.Inserer(str);
		}
		else {
			str = ((MementoInserer) memento).getS();
			LM.Inserer(str);
		}
		if(records.getRecording()) {
			
			records.add(this, new MementoInserer(str));
		}
		estrejoue = false;
	}
}
