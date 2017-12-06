package receiver;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Command.Inserer;
import Memento.Enregistreur;
import Memento.EnregistreurImp;
import Memento.MementoInserer;
import Memento.MementoSelectionner;
import moteur.Editeur;
import undoRedo.State;
import undoRedo.StateImp;
import undoRedo.UndoRedo;

public class UndoRedoTest {
	
	private Enregistreur recordeur;
	private Editeur editor;
	private UndoRedo undoredo;

	@Before
	public void setUp() throws Exception {
		recordeur = new EnregistreurImp ();
		editor = new Editeur();
		undoredo = new UndoRedo(editor.getMoteur());
		
		editor.getIHM().init("#couper", editor.getCouper());
		editor.getIHM().init("#coller", editor.getColler());
		editor.getIHM().init("#copier", editor.getCopier());
		editor.getIHM().init("#inserer", editor.getInserer());
		editor.getIHM().init("#selectionner", editor.getSelectionner());
		editor.getIHM().init("#afficher", editor.getTexte());
		editor.getIHM().init("#start", editor.getStart());
		editor.getIHM().init("#stop", editor.getStop());
		editor.getIHM().init("#replay", editor.getReplay());
		editor.getIHM().init("#delete", editor.getDelete());
		
		editor.getIHM().init("#undo", editor.getUndo());
		editor.getIHM().init("#redo", editor.getRedo());
	}
	

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Verifie que lors d'une execution du commande changeant l'état du moteur, un nouveau
	 * state apparait dans le undoredo.undo
	 */
	@Test
	public final void testAddPrevious() { // TODO
		int tailleavant = editor.getUndoredo().getUndo().size();
		editor.getIHM().getMap().get("#couper").execute();
		int tailleapres =  editor.getUndoredo().getUndo().size();
		assertTrue(tailleavant<tailleapres);
		
		
		editor.getIHM().getMap().get("#couper").execute();
		tailleavant =  editor.getUndoredo().getUndo().size();
		assertTrue(tailleavant>tailleapres);
		
		
		editor.getIHM().getMap().get("#delete").execute();
		tailleapres =  editor.getUndoredo().getUndo().size();
		assertTrue(tailleavant<tailleapres);
		
	}

	/**
	 * Après un Undo, le state du moteur redo est bien enregistré dans undoredo.redo, mais supprimé après
	 * un appel d'une nouvelle commande importante
	 */
	@Test
	public final void testAddNext() {
		
		editor.getIHM().getMap().get("#couper").execute();
		int tailleavant = editor.getUndoredo().getRedo().size();
		editor.getIHM().getMap().get("#undo").execute();	// rajoute un state dans undo
		int tailleapres =  editor.getUndoredo().getRedo().size();
		assertTrue(tailleavant<tailleapres);
		editor.getIHM().getMap().get("#couper").execute(); // exectuer une fonctionn vide le redo
		tailleavant = editor.getUndoredo().getRedo().size();
		assertTrue(tailleavant<tailleapres);
		
	}

	/**
	 * Test l'execution du TheUndo (= #undo dans notre editeur de texte)
	 */
	@Test
	public final void testTheUndo() {
		editor.getIHM().getMap().get("#couper").execute(); //nouveau state dans undoredo
		int tailleavant = editor.getUndoredo().getUndo().size();
		editor.getUndoredo().theUndo(editor.getMoteur()); //enlève un state de undoredo et change le moteur
		int tailleapres =  editor.getUndoredo().getUndo().size();
		assertTrue(tailleavant>tailleapres);
	}

	/**
	 * Test l'execution du TheRedo (= #redo dans notre editeur de texte)
	 */
	@Test
	public final void testTheRedo() {
		editor.getIHM().getMap().get("#couper").execute();
		editor.getIHM().getMap().get("#undo").execute(); // rajoute un state Redo
		int tailleavant = editor.getUndoredo().getRedo().size();
		editor.getUndoredo().theRedo(editor.getMoteur()); //-1 state dans Redo
		int tailleapres =  editor.getUndoredo().getRedo().size();
		assertTrue(tailleavant>tailleapres);
		
		
	}

	/**
	 * test que l'on vide la Stack<StateImp> redo dans undoredo
	 */
	@Test
	public final void testNoMoreRedo() {
		editor.getIHM().getMap().get("#couper").execute();
		editor.getIHM().getMap().get("#undo").execute();
		int tailleavant = editor.getUndoredo().getRedo().size();
		editor.getUndoredo().noMoreRedo();
		int tailleapres =  editor.getUndoredo().getRedo().size();
		assertTrue(tailleavant>tailleapres);
		
	}

}
