/**
 * @(#) Editeur.java
 */
// Client
package moteur;
import Command.*;


/**
 * Classe qui fait la jonction entre l'IHM et le Moteur.
 * 
 * 
 *
 */
public class Editeur{
	
	private Moteur lemoteur = new MoteurImp("");
	private IHM interfaces = new IHM();
	
	private Inserer inserer = new Inserer(this.lemoteur,this.interfaces);
	private Couper couper = new Couper(this.lemoteur);
	private Coller coller = new Coller(this.lemoteur);
	private Copier copier = new Copier(this.lemoteur);
	private Selectionner selectionner = new Selectionner(this.lemoteur);
	private GetTexte texte = new GetTexte(this.lemoteur);
	
	public Moteur getMoteur(){
		return this.lemoteur;
	}
	public IHM getIHM(){
		return this.interfaces;
	}
	public Inserer getInserer(){
		return this.inserer;
	}
	public Couper getCouper(){
		return this.couper;
	}
	public Coller getColler(){
		return this.coller;
	}
	public Copier getCopier(){
		return this.copier;
	}
	public Selectionner getSelectionner(){
		return this.selectionner;
	}
	public GetTexte getGetTexte() {
		return this.texte;
	}
	public static void main (String[] args){
	/*fonction boucle dans L'IHM qui demande commande
	 * juste avant faut creer une fonction dans ihm init qui ajouter les instance de l'editeur dans la map
	
	*
	*
	*
	*/
	Editeur edi = new Editeur();
	//On met toutes les fonctions dans la hashmap de l'IHM 
	edi.getIHM().init("#couper", edi.getCouper());
	edi.getIHM().init("#coller", edi.getColler());
	edi.getIHM().init("#copier", edi.getCopier());
	edi.getIHM().init("#inserer", edi.getInserer());
	edi.getIHM().init("#selectionner", edi.getSelectionner());
	edi.getIHM().init("#afficher", edi.getGetTexte());
	edi.getIHM().boucle();	
	
	
	
	
	}
}

