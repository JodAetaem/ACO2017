package Command;
import moteur.*;
public class Copier extends CommandImp{
	
	
	public Copier (Moteur lm){
		super(lm);
	}
	
	@Override
	public void execute(){
		LM.Copier();
	}
}
