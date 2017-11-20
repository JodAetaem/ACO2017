package receiver;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Command.*;
import Memento.Enregistreur;
import Memento.EnregistreurImp;
import Memento.Memento;
import Memento.MementoCopier;
import moteur.Editeur;
import moteur.IHM;
import moteur.Moteur;
import moteur.MoteurImp;

public class TestEnregistreurImp {
	
	private Moteur lemoteur;
	private IHM interfaces;
	private Enregistreur recordeur;
	private Editeur editor;

	@Before
	public void setUp() throws Exception {
		lemoteur = new MoteurImp("Bonjour le Monde");
		interfaces = new IHM();
		recordeur = new EnregistreurImp ();
		editor = new Editeur();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testEnregistreurImp() {
		 // TODO
	}

	@Test // retourne l'état de recording, faux avant le start et après le stop.
	public final void testGetRecording() {
		assertTrue(recordeur.getRecording()==false);
		recordeur.start();
		assertTrue(recordeur.getRecording()==true);
		recordeur.stop();
		assertTrue(recordeur.getRecording()==false);
		recordeur.stop();	// si on fait deux stop d'affilé, toujours correct ?
		assertTrue(recordeur.getRecording()==false);
		recordeur.start();
		recordeur.stop();
		assertTrue(recordeur.getRecording()==false);
	}

	@Test // false par defaut, true si on lance execute()
	public final void testGetReplaying() {
		assertTrue(recordeur.getReplaying() ==false);
		recordeur.execute();
		assertTrue(recordeur.getReplaying() ==true);
		
	}

	@Test
	public final void testPp() {
	// NOT TODO , fonction inutile
	}

	@Test
	public final void testExecute() {
		fail("Not yet implemented"); // TODO
	}

	@Test // on verifie que la HM de recordeur est bien vide a l'init
	public final void testGetMap() {
		LinkedHashMap<Memento,Command> hmDeTest = new LinkedHashMap<>() ;
		assertTrue(recordeur.getMap().equals(hmDeTest));
	}

	@Test
	public final void testStart() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testStop() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAdd() {
		LinkedHashMap<Memento,Command> hmDeTest = new LinkedHashMap<>() ;
		assertTrue(recordeur.getMap().equals(hmDeTest));	// vide par defaut ?
		
		recordeur.add(editor.getCouper(),new MementoCopier());
		hmDeTest.put(new MementoCopier(), editor.getCouper());
		assertTrue(recordeur.getMap().equals(hmDeTest));
		
	}

}
