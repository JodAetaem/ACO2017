package Command;
import Memento.*;
import moteur.Moteur;

public class Stop extends CommandImp {
	public Stop(Moteur lemoteur,Enregistreur e) {
		super(lemoteur,e);
		

	}

	@Override
	public void execute() {
		records.stop();
		System.out.println("fin del'enregistrement");
		//a ajouter dans la map de records si on veut faire macro de macro 
	
	}

}
