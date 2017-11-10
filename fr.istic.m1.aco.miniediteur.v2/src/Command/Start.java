package Command;
import Memento.*;
import moteur.Moteur;
public class Start extends CommandImp {
	private Enregistreur r;
	public Start(Moteur lemoteur,Enregistreur r) {
		super(lemoteur);
		
		
	}

	@Override
	public void execute() {
		r.start();
		
	}
	
}
