package undoRedo;

import moteur.Moteur;

public interface State {
	
	public StringBuffer getEtatTexte();
	public void setEtatTexte(StringBuffer etatTexte);
	public void setState(Moteur mot);

}
