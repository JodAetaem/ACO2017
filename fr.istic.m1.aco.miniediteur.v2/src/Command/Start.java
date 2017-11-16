package Command;
import Memento.*;
import moteur.Moteur;
public class Start extends CommandImp {
	public Start(Moteur lemoteur,Enregistreur e) {
		super(lemoteur,e);
		
		
	}

	@Override
	public void execute() {
		records.start();
		System.out.println("Demmarage de l'enregistrement");
	 //a ajouter dans la map de record si on veut faire des macros de macro 

		
	}
	
}
