package Command;
import Memento.Memento;
import moteur.*;

public class Coller extends CommandImp{
	
	public Coller (Moteur lm){
		super(lm);
	}
	
	@Override
	public void execute(){
		LM.Coller();
	}


}
