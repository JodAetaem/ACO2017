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
	/**
	 * execute la commande inserer 
	 */
	public void execute(){
		String str;
		if(!estrejoue) { // Dans le cas ou ca n'est pas un replay 
			str = this.ihm.getTexte();
			LM.Inserer(str);
		}
		else {//dans le cas ou c'est un replay 
			str = ((MementoInserer) memento).getS();
			LM.Inserer(str);
		}
		if(records.getRecording()) {//dans le cas d'un enregistrement
			
			records.add(this, new MementoInserer(str));//Ajoute la commande ainsi que le memento et son attribu txt correspondant la LinkedHashmap de l'enregistreur records
		}
		estrejoue = false;
	}
}
