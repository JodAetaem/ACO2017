package undoRedo;

import java.util.Stack;

import moteur.Moteur;

public class UndoRedo {
	
	private Stack<State> undo = new Stack<State>();
	private Stack<State> redo = new Stack<State>();
	
	public UndoRedo(Moteur mot) {
		addPrevious(mot);
	}
	
	// Getters setters
	public Stack<State> getUndo() {
		return undo;
	}
	public void setUndo(Stack<State> undo) {
		this.undo = undo;
	}
	public Stack<State> getRedo() {
		return redo;
	}
	public void setRedo(Stack<State> redo) {
		this.redo = redo;
	}
	
	/////
	
	/**
	 * ajoute un state précédent a partir du moteur
	 * @param mot
	 */
	public void addPrevious(Moteur mot) {
		undo.push(new StateImp(mot));
	}
	
	/**
	 * ajoute un state précédent a partir du moteur
	 * @param mot
	 */
	public void addNext(Moteur mot) {
		redo.push(new StateImp(mot));
	}
	
	/**
	 * Change le moteur pour son état précédent
	 * @param mot
	 */
	public void theUndo(Moteur mot) {
		State action;
		if(!getUndo().isEmpty()) {
			action = getUndo().pop();
			addNext(mot);
			mot.setTexte(action.getEtatTexte());
			mot.finDuTexte();
		}
		else {
			System.out.println("Impossible de revenir en arrière");
		}
	}
	
	
	/**
	 * Change le moteur pour son état suivant
	 * @param mot
	 */
	public void theRedo(Moteur mot) {
		State action;
		if(!getRedo().isEmpty()) {
			action = getRedo().pop();
			addPrevious(mot);
			mot.setTexte(action.getEtatTexte());
			mot.finDuTexte();
		}
		else {
			System.out.println("Impossible d'aller plus loin");
		}
	}
	
	/**
	 * Vide le redo car une action a été faite après le redo
	 */
	public void noMoreRedo() {
		getRedo().clear();
	}
	

}
