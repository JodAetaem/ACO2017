package Command;
import moteur.*;
import Memento.*;
public class GetTexte extends CommandImp {
	
	
	public GetTexte (Moteur lm,Enregistreur e) {
		super(lm,e);
	}
	@Override
	/**
	 * @info execute la commande GetText qui print le text courrant dans le moteur
	 */
	public void execute(){
		 System.out.println(LM.getTexte());
		 estrejoue=false;
	}
}
