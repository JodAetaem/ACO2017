package undoRedo;

import moteur.Moteur;

public class StateImp implements State {

	private StringBuffer etatTexte;

	// Getters Setters
	/**
	 * @return etatTexte
	 */
	@Override 
	public StringBuffer getEtatTexte() {
		return etatTexte;
	}
	/**
	 * etatTexte devient le nouveau etatTexte
	 */
	@Override 
	public void setEtatTexte(StringBuffer etatTexte) {
		this.etatTexte = etatTexte;
	}
	
	/**
	 * crée un nouveau state a partir du moteur
	 * @param mot moteur du nouveau state
	 */
	public StateImp(Moteur mot) {
		setEtatTexte(new StringBuffer (mot.getTexte()));
	}
	
	/**
	 * @param mot le moteur dont ce state devient une copie
	 */
	@Override 
	public void setState(Moteur mot) {
		setEtatTexte(new StringBuffer (mot.getTexte()));
	}
	
	
}
