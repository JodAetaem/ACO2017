package Command;
import moteur.*;
import Memento.*;


public class Inserer  extends CommandImp{
	private IHM ihm;
	public Inserer (Moteur lm, IHM ihm,Enregistreur e){
		super(lm,e);
		this.ihm = ihm;
	}
	
	@Override
	public void execute(){
		if(!estrejoue) {
		String str = this.ihm.getTexte();
		LM.Inserer(str);
		}
		else {
			//String str = records.getMap();//..getS(); TODO
			//LM.Inserer(str);
		}
		if(records.getRecording()) {
			records.add(this,(MementoInserer) memento);
		}
		estrejoue = false;
	}
}
