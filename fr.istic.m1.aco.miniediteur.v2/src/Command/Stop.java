package Command;
import Memento.*;
import moteur.Moteur;

public class Stop extends CommandImp {
	private Enregistreur r ;
	public Stop(Moteur lemoteur) {
		super(lemoteur);

	}

	@Override
	public void execute() {
		r.stop();
		
	}

}
