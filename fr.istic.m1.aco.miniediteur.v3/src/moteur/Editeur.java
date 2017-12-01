/**
 * @(#) editorteur.java
 */
// Client
package moteur;
import Command.*;
import Memento.*;
import undoRedo.UndoRedo;


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
	private UndoRedo undoredo = new UndoRedo(lemoteur);
	
	private Start start = new Start(this.lemoteur,this.recordeur);
	private Stop stop = new Stop(this.lemoteur,this.recordeur);
	private Replay replay=new Replay(this.lemoteur,this.recordeur);
	private Inserer inserer = new Inserer(this.lemoteur,this.interfaces,this.recordeur, this.undoredo);
	private Couper couper = new Couper(this.lemoteur,this.recordeur,this.undoredo);
	private Coller coller = new Coller(this.lemoteur,this.recordeur,this.undoredo);
	private Copier copier = new Copier(this.lemoteur,this.recordeur);
	private Selectionner selectionner = new Selectionner(this.lemoteur,this.recordeur,this.interfaces);
	private GetTexte texte = new GetTexte(this.lemoteur,this.recordeur);
	private Undo undo = new Undo(this.lemoteur,this.recordeur,this.undoredo);
	private Redo redo = new Redo(this.lemoteur,this.recordeur,this.undoredo);
	
	public Moteur getMoteur(){
		return this.lemoteur;
	}
	public IHM getIHM(){
		return this.interfaces;
	}
	
	public Enregistreur getRecordeur() {
		return recordeur;
	}
	public void setRecordeur(Enregistreur recordeur) {
		this.recordeur = recordeur;
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
	
	public Coller getColler() {
		return coller;
	}
	public void setColler(Coller coller) {
		this.coller = coller;
	}
	public Copier getCopier() {
		return copier;
	}
	public void setCopier(Copier copier) {
		this.copier = copier;
	}
	public Inserer getInserer() {
		return inserer;
	}
	public void setInserer(Inserer inserer) {
		this.inserer = inserer;
	}
	public Selectionner getSelectionner() {
		return selectionner;
	}
	public void setSelectionner(Selectionner selectionner) {
		this.selectionner = selectionner;
	}
	public GetTexte getTexte() {
		return texte;
	}
	public void setTexte(GetTexte texte) {
		this.texte = texte;
	}
	public Start getStart() {
		return start;
	}
	public void setStart(Start start) {
		this.start = start;
	}
	public Stop getStop() {
		return stop;
	}
	public void setStop(Stop stop) {
		this.stop = stop;
	}
	public Replay getReplay() {
		return replay;
	}
	public void setReplay(Replay replay) {
		this.replay = replay;
	}
	
	public Undo getUndo() {
		return undo;
	}
	public void setUndo(Undo undo) {
		this.undo = undo;
	}
	public Redo getRedo() {
		return redo;
	}
	public void setRedo(Redo redo) {
		this.redo = redo;
	}
	public static void main (String[] args){
	Editeur editor = new Editeur();
	//On met toutes les commandes dans la hashmap de l'IHM 
	editor.interfaces.init("#couper", editor.getCouper());
	editor.interfaces.init("#coller", editor.getColler());
	editor.interfaces.init("#copier", editor.getCopier());
	editor.interfaces.init("#inserer", editor.getInserer());
	editor.interfaces.init("#selectionner", editor.getSelectionner());
	editor.interfaces.init("#afficher", editor.getTexte());
	editor.interfaces.init("#start", editor.getStart());
	editor.interfaces.init("#stop", editor.getStop());
	editor.interfaces.init("#replay", editor.getReplay());
	
	editor.interfaces.init("#undo", editor.getUndo());
	editor.interfaces.init("#redo", editor.getRedo());
			
	//c'est parti
	editor.interfaces.boucle();	
	
	
	
	
	}
	
}

