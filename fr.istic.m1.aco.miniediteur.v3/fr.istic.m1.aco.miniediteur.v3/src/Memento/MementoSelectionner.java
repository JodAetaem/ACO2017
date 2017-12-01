package Memento;

import moteur.Selection;

public class MementoSelectionner  extends MementoImp {
	private Selection sel ;
	public MementoSelectionner (int a, int b) {
		sel = new Selection (a,b);
	}
	public Selection getSel() {
		return sel;
	}

	public void setSel(Selection sel) {
		this.sel = sel;
	} 
	
	
}
