package Command;
import Memento.*;

import moteur.*;

public class Selectionner extends CommandImp {
	private IHM ihm;
	

	public Selectionner(Moteur lemoteur,Enregistreur r,IHM ihm) {
		super(lemoteur,r);
		this.ihm=ihm;
	}
	

	@Override
	public void execute() {
		int[] debfin = new int[2];
		if(!estrejoue) {
			ihm.getInt(debfin);
			LM.Selectionner(debfin[0],debfin[1]);
			
		}
		else {	
			int start = ((MementoSelectionner) memento).getSel().getStart();
			int end = ((MementoSelectionner) memento).getSel().getEnd();
			LM.Selectionner(start,end);
		}
		if(records.getRecording()) {
			records.add(this,new MementoSelectionner(debfin[0],debfin[1]));
		}
		estrejoue=false;
	}

}
