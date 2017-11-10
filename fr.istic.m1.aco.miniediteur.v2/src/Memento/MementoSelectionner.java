package Memento;

import moteur.Selection;

public class MementoSelectionner  extends MementoImp {
	private Selection sel ;
	public MementoSelectionner (Selection s) {
		sel=s;
	}
	public Selection getSel() {
		return sel;
	}

	public void setSel(Selection sel) {
		this.sel = sel;
	} 
	
	
}
