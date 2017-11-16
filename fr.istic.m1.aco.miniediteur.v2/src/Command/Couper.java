package Command;
import moteur.*;
import Memento.*;
public class Couper extends CommandImp{
	
	public Couper (Moteur lm,Enregistreur e){
		super(lm,e);
	}
	
	@Override
	public void execute(){
		LM.Couper();
		if(records.getRecording()) {
			records.add(this,((MementoCouper) memento));
		}estrejoue=false;
	}
}
