package Command;
import moteur.*;

public class Couper extends CommandImp{
	
	public Couper (Moteur lm){
		super(lm);
	}
	
	@Override
	public void execute(){
		LM.Couper();
	}
}
