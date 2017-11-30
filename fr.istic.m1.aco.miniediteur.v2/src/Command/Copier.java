package Command;
import moteur.*;
import Memento.*;
public class Copier extends CommandImp{
	
	
	public Copier (Moteur lm,Enregistreur e){
		super(lm,e);
	}
	
	@Override
	/**
	 * @info execute la commande copier
	 */
	public void execute(){
		LM.Copier();
		if(records.getRecording()) {
			records.add(this,new MementoCopier());//Ajoute la commande ainsi que le memento correspondant dans la LinkedHashmap de l'enregistreur records
		}
		estrejoue=false;
	}
}
