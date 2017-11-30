package Command;
import Memento.*;
import moteur.*;

public class Coller extends CommandImp{

	public Coller (Moteur lm,Enregistreur e){
		super(lm,e);

	}
	
	@Override
	/**
	 * @info execute la commande Coller
	 */
	public void execute(){
		LM.Coller();
		if(records.getRecording()) {
			records.add(this,((new MementoColler() )));//Ajoute la commande ainsi que le memento correspondant dans la LinkedHashmap de l'enregistreur records
		}
		estrejoue=false;
	}


}
