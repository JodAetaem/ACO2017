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
		String str;
		if(!estrejoue) {
			str = this.ihm.getTexte();
			LM.Inserer(str);
		}
		else {
			str = ((MementoInserer) memento).getS();
			LM.Inserer(str);
		}
		if(records.getRecording()) {
			
			records.add(this, new MementoInserer(str));
		}
		estrejoue = false;
	}
}
