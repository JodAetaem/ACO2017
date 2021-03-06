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
import Memento.*;
import moteur.Editeur;

public class TestEnregistreurImp {
	
	private Enregistreur recordeur;
	private Editeur editor;

	@Before
	public void setUp() throws Exception {
		recordeur = new EnregistreurImp ();
		editor = new Editeur();
		

		
		editor.getIHM().init("#couper", editor.getCouper());
		editor.getIHM().init("#coller", editor.getColler());
		editor.getIHM().init("#copier", editor.getCopier());
		editor.getIHM().init("#inserer", editor.getInserer());
		editor.getIHM().init("#selectionner", editor.getSelectionner());
		editor.getIHM().init("#afficher", editor.getTexte());
		editor.getIHM().init("#start", editor.getStart());
		editor.getIHM().init("#stop", editor.getStop());
		editor.getIHM().init("#replay", editor.getReplay());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test // retourne l'�tat de recording, faux avant le start et apr�s le stop.
	public final void testGetRecording() {
		assertTrue(recordeur.getRecording()==false);
		recordeur.start();
		assertTrue(recordeur.getRecording()==true);
		recordeur.stop();
		assertTrue(recordeur.getRecording()==false);
		recordeur.stop();	// si on fait deux stop d'affil�, toujours correct ?
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
	public final void testExecute() {
		
		editor.getMoteur().Inserer("Bonjour le Monde");//Initialisation du texte
		
		editor.getIHM().getMap().get("#start").execute();//start recording
		MementoSelectionner sel1 = new MementoSelectionner(0,7);
		editor.getRecordeur().add(editor.getIHM().getMap().get("#selectionner"), sel1);
		editor.getMoteur().Selectionner(0, 7);//selection de bonjour
		editor.getIHM().getMap().get("#couper").execute();
		MementoSelectionner sel2 = new MementoSelectionner(100,-1);
		editor.getRecordeur().add(editor.getIHM().getMap().get("#selectionner"), sel2);
		editor.getMoteur().Selectionner(100, -1);//positionnement du curseur a la fin
		editor.getIHM().getMap().get("#coller").execute();
		editor.getIHM().getMap().get("#stop").execute();//fin du record
		assertTrue(editor.getMoteur().getTexte().toString().equals(" le MondeBonjour")); //les commandes on bien �t� �x�cut� ?
		editor.getIHM().getMap().get("#replay").execute();
		assertTrue(editor.getMoteur().getTexte().toString().equals("deBonjour le Mon"));//Le replay passe bien 
		
		
	}

	@Test // on verifie que la HM de recordeur est bien vide a l'init
	public final void testGetMap() {
		LinkedHashMap<Memento,Command> hmDeTest = new LinkedHashMap<>() ;
		assertTrue(recordeur.getMap().equals(hmDeTest));
	}

	@Test
	public final void testStart() {
		editor.getIHM().getMap().get("#start").execute();
		assertTrue(editor.getRecordeur().getRecording()); //Apr�s le Start, recording = true
		editor.getIHM().getMap().get("#stop").execute();
		assertFalse(editor.getRecordeur().getRecording());//Apr�s le stop, recording = false
		
	}

	@Test
	public final void testStop() {
		assertTrue(!editor.getRecordeur().getRecording()); // Par defaut a False ?
		editor.getIHM().getMap().get("#start").execute();
		assertFalse(!editor.getRecordeur().getRecording()); //Apr�s le d�marrage, Recording = True
		editor.getIHM().getMap().get("#stop").execute();
		assertFalse(editor.getRecordeur().getRecording()); // Apr�s le Stop : Recording = False
	}

	@Test
	public final void testAdd() {
		LinkedHashMap<Memento,Command> hmDeTest = new LinkedHashMap<>() ;
		assertTrue(recordeur.getMap().equals(hmDeTest));	// vide par defaut ?
		
		recordeur.add(editor.getCouper(),new MementoCopier());
		assertFalse(recordeur.getMap().equals(hmDeTest)); // add rajoute bien dans le recordeur?
		
	}

}
