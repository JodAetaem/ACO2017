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
	/**
	 * @return Stack<State> undo , la stack des états précédents
	 */
	public Stack<State> getUndo() {
		return undo;
	}
	/**
	 * 
	 * @param undo : la Stack<State> dont undo deviens la copie
	 */
	public void setUndo(Stack<State> undo) {
		this.undo = undo;
	}
	/**
	 * @return Stack<State> redo, la stack des états suivants
	 */
	public Stack<State> getRedo() {
		return redo;
	}
	/**
	 * 
	 * @param redo : la Stack<State> dont redo deviens la copie
	 */
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
