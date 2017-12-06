package Command;
import moteur.*;
import Memento.*;
public class Couper extends CommandImp{
	
	public Couper (Moteur lm,Enregistreur e){
		super(lm,e);
	}
	
	@Override
	/**
	 * @info execute la commande Couper
	 */
	public void execute(){
		LM.Couper();
		if(records.getRecording()) {
			records.add(this,new MementoCouper());//Ajoute la commande ainsi que le memento correspondant dans la LinkedHashmap de l'enregistreur records
		}estrejoue=false;
	}
}
