package Command;
import Memento.*;
import moteur.*;

public class Coller extends CommandImp{

	public Coller (Moteur lm,Enregistreur e){
		super(lm,e);

	}
	
	@Override
	public void execute(){
		LM.Coller();
		if(records.getRecording()) {
			records.add(this,((MementoColler) memento));
		}
		estrejoue=false;
	}


}
