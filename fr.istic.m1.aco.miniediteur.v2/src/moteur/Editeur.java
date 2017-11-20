/**
 * @(#) editorteur.java
 */
// Client
package moteur;
import Command.*;
import Memento.*;


/**
 * Classe qui fait la jonction entre l'IHM et le Moteur.
 * 
 * 
 *
 */
public class Editeur{
	
	private Moteur lemoteur = new MoteurImp("");
	private IHM interfaces = new IHM();
	private Enregistreur recordeur = new EnregistreurImp ();
	private Start start = new Start(this.lemoteur,this.recordeur);
	private Stop stop = new Stop(this.lemoteur,this.recordeur);
	private Replay replay=new Replay(this.lemoteur,this.recordeur);
	private Inserer inserer = new Inserer(this.lemoteur,this.interfaces,this.recordeur);
	private Couper couper = new Couper(this.lemoteur,this.recordeur);
	private Coller coller = new Coller(this.lemoteur,this.recordeur);
	private Copier copier = new Copier(this.lemoteur,this.recordeur);
	private Selectionner selectionner = new Selectionner(this.lemoteur,this.recordeur,this.interfaces);
	private GetTexte texte = new GetTexte(this.lemoteur,this.recordeur);
	
	public Moteur getMoteur(){
		return this.lemoteur;
	}
	public IHM getIHM(){
		return this.interfaces;
	}
	
	public IHM getInterfaces() {
		return interfaces;
	}
	
	public void setInterfaces(IHM interfaces) {
		this.interfaces = interfaces;
	}
	
	public Couper getCouper() {
		return couper;
	}
	public void setCouper(Couper couper) {
		this.couper = couper;
	}
	
	
	public static void main (String[] args){
	Editeur editor = new Editeur();
	//On met toutes les commandes dans la hashmap de l'IHM 
	editor.interfaces.init("#couper", editor.couper);
	editor.interfaces.init("#coller", editor.coller);
	editor.interfaces.init("#copier", editor.copier);
	editor.interfaces.init("#inserer", editor.inserer);
	editor.interfaces.init("#selectionner", editor.selectionner);
	editor.interfaces.init("#afficher", editor.texte);
	editor.interfaces.init("#start", editor.start);
	editor.interfaces.init("#stop", editor.stop);
	editor.interfaces.init("#replay", editor.replay);
			
	//c'est parti
	editor.interfaces.boucle();	
	
	
	
	
	}
}

