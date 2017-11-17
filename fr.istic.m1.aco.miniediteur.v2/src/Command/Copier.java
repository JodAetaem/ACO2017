package Command;
import moteur.*;
import Memento.*;
public class Copier extends CommandImp{
	
	
	public Copier (Moteur lm,Enregistreur e){
		super(lm,e);
	}
	
	@Override
	public void execute(){
		LM.Copier();
		if(records.getRecording()) {
			records.add(this,new MementoCopier());
		}
		estrejoue=false;
	}
}
