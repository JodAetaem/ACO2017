package receiver;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Memento.Enregistreur;
import Memento.EnregistreurImp;
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
		
		Stack<State> redoCompare = new Stack<State>();
		
		editor.getIHM().init("#couper", editor.getCouper());
		editor.getIHM().init("#coller", editor.getColler());
		editor.getIHM().init("#copier", editor.getCopier());
		editor.getIHM().init("#inserer", editor.getInserer());
		editor.getIHM().init("#selectionner", editor.getSelectionner());
		editor.getIHM().init("#afficher", editor.getTexte());
		editor.getIHM().init("#start", editor.getStart());
		editor.getIHM().init("#stop", editor.getStop());
		editor.getIHM().init("#replay", editor.getReplay());
		
		editor.getIHM().init("#undo", editor.getUndo());
		editor.getIHM().init("#redo", editor.getRedo());
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAddPrevious() { // TODO
		/*
		Stack<State> undoCompare = new Stack<State>();
		undoCompare.push(new StateImp(editor.getMoteur()));
		assertTrue(undoCompare.equals(undoredo.getUndo()) ); //stackVide?
		*/
		editor.getMoteur().Inserer("Bonjour le Monde");
		StateImp comparateur = new StateImp(editor.getMoteur());
		editor.getMoteur().Selectionner(0, 7);
		editor.getIHM().getMap().get("#couper").execute();
		State compare = editor.getUndoredo().getUndo().peek();
		
		assertTrue(comparateur.getEtatTexte() == compare.getEtatTexte());
		//editor.getIHM().getMap().get("#start").execute();
	}

	@Test
	public final void testAddNext() {
		
	}

	@Test
	public final void testTheUndo() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testTheRedo() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testNoMoreRedo() {
		fail("Not yet implemented"); // TODO
	}

}
