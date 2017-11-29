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
		/*
		recordeur.start();
		lemoteur.Selectionner(0, 7);// Seletionne "Bonjour"
		lemoteur.Couper();
		lemoteur.Selectionner(100, 100);// Mets le curseur a la fin 
		lemoteur.Coller();
		recordeur.stop();
		assertTrue(lemoteur.getTexte().toString().equals(" le MondeBonjour")); //les commandes on bien été éxécuté ?
		recordeur.execute();
		System.out.println(lemoteur.getTexte().toString());
		assertTrue(lemoteur.getTexte().toString().equals("deBonjour le Mon"));
		*/
		
		
		editor.getIHM().init("#couper", editor.getCouper());
		editor.getIHM().init("#coller", editor.getColler());
		editor.getIHM().init("#copier", editor.getCopier());
		editor.getIHM().init("#inserer", editor.getInserer());
		editor.getIHM().init("#selectionner", editor.getSelectionner());
		editor.getIHM().init("#afficher", editor.getTexte());
		editor.getIHM().init("#start", editor.getStart());
		editor.getIHM().init("#stop", editor.getStop());
		editor.getIHM().init("#replay", editor.getReplay());
		
		editor.getMoteur().Inserer("Bonjour le Monde");
		System.out.println(editor.getMoteur().getTexte().toString());
		
		editor.getIHM().getMap().get("#start").execute();
		editor.getMoteur().Selectionner(0, 7);
		//editor.getIHM().getMap().get("#selectionner").execute();
		editor.getIHM().getMap().get("#couper").execute();
		editor.getMoteur().Selectionner(100, 100);
		//editor.getIHM().getMap().get("#selectionner").execute();
		editor.getIHM().getMap().get("#coller").execute();
		editor.getIHM().getMap().get("#stop").execute();
		assertTrue(editor.getMoteur().getTexte().toString().equals(" le MondeBonjour")); //les commandes on bien été éxécuté ?
		editor.getIHM().getMap().get("#replay").execute();
		System.out.println(editor.getRecordeur().getReplaying());
		/*
		System.out.println(editor.getMoteur().getTexte().toString());
		assertTrue(editor.getMoteur().getTexte().toString().equals("deBonjour le Mon"));
		*/
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
		assertFalse(recordeur.getMap().equals(hmDeTest)); // add rajoute bien dans le recordeur?
		
	}

}
