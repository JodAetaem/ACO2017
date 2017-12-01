package Command;

import Memento.Enregistreur;
import moteur.Moteur;

public class Replay extends CommandImp{
	public Replay(Moteur lemoteur,Enregistreur e) {
		super(lemoteur,e);
		
		
	}

	@Override
	public void execute() {
		records.execute();
		//a ajouter dans la map de records si on veut rejouer des macro pendant une macro
	}
}
