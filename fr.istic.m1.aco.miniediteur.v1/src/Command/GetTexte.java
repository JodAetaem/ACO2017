package Command;
import moteur.*;

public class GetTexte extends CommandImp {
	
	
	public GetTexte (Moteur lm) {
		super(lm);
	}
	@Override
	public void execute(){
		LM.getTexte();
	}
}
