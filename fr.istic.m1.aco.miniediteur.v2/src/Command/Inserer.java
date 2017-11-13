package Command;
import moteur.*;
import Memento.*;


public class Inserer  extends CommandImp{
	private IHM ihm;
	public Inserer (Moteur lm, IHM ihm){
		super(lm);
		this.ihm = ihm;
	}
	
	@Override
	public void execute(){
		if(!estrejoue) {
		String str = this.ihm.getTexte();
		LM.Inserer(str);
		}
		else {
			String str = ((MementoInserer) memento).getS();
			LM.Inserer(str);
		}
	}
}
