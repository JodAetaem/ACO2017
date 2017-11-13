package Command;

import Memento.Enregistreur;
import moteur.Moteur;

public class Replay extends CommandImp{
	private Enregistreur r;
	public Replay(Moteur lemoteur,Enregistreur r) {
		super(lemoteur);
		
		
	}

	@Override
	public void execute() {
		r.execute();
		
	}
}
