package Memento;

import moteur.Selection;

public class MementoSelectionner  extends MementoImp {
	private Selection sel ;
	
	/**
	 * @param a = le debut de la selection
	 * @param b = la fin de la selection
	 */
	public MementoSelectionner (int a, int b) {
		sel = new Selection (a,b);
	}
	/**
	 * 
	 * @return la selection courante
	 */
	public Selection getSel() {
		return sel;
	}

	/**
	 * 
	 * @param sel = la nouvelle selection
	 */
	public void setSel(Selection sel) {
		this.sel = sel;
	} 
	
	
}
