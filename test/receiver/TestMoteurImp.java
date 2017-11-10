package receiver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import moteur.Moteur;
import moteur.MoteurImp;

public class TestMoteurImp {
	
	private Moteur lemoteur;
	
	//rajouter devant tout les tests
	@Before
	public void init(){
	lemoteur = new MoteurImp("PONCHOUR MONSIEUR COMMENT ALLEZ FOUS ????");	//Phrase de base de nos test
	}
	
	
	
	@Test
	public void testMoteurImp() {
		assertTrue(lemoteur.getTexte().toString().equals("PONCHOUR MONSIEUR COMMENT ALLEZ FOUS ????"));
	}

	@Test
	public void testSelectionner() {
		lemoteur.Selectionner(0,7);
		assertTrue((lemoteur.getSelection().getStart()==0)&& lemoteur.getSelection().getEnd()==7 );
		lemoteur.Selectionner(0, 45);	// Une selection plus grande que la phrase --> erreur
		assertFalse((lemoteur.getSelection().getStart()==0)&& lemoteur.getSelection().getEnd()==45 );
		lemoteur.Selectionner(13, 10);	// une selection incoh�rente --> erreur
		assertFalse((lemoteur.getSelection().getStart()==13)&& lemoteur.getSelection().getEnd()==10);
	}

	@Test
	public void testColler() {
		lemoteur.Selectionner(0, 9);	// Copie de "PONCHOUR "
		lemoteur.Copier();
		lemoteur.Selectionner(9, 9);	// On colle a la 9�me position
		lemoteur.Coller();
		
		assertTrue(lemoteur.getTexte().toString().equals("PONCHOUR PONCHOUR MONSIEUR COMMENT ALLEZ FOUS ????"));
		
		
	}

	@Test
	public void testCouper() {
		lemoteur.Selectionner(0, 9);	
		lemoteur.Couper();	// on coupe "PONCHOUR " et on v�rifie qu'il a bien disparu
		assertTrue(lemoteur.getTexte().toString().equals("MONSIEUR COMMENT ALLEZ FOUS ????"));
		assertTrue(lemoteur.getPresspaper().equals("PONCHOUR ")); // on regarde le contenu du presse papier
		lemoteur.Selectionner(28, 28);
		lemoteur.Coller();	// on le colle a la fin de la phrase
		assertTrue(lemoteur.getTexte().toString().equals("MONSIEUR COMMENT ALLEZ FOUS PONCHOUR ????"));
		
	}

	@Test
	public void testInserer() {
		lemoteur.Selectionner(0, 0);
		lemoteur.Inserer("abc123");	// on ins�re "abc123" en position 0
		assertTrue(lemoteur.getTexte().toString().equals("abc123PONCHOUR MONSIEUR COMMENT ALLEZ FOUS ????"));
		lemoteur.Selectionner(0, 47); //on s�l�ctionne toute la phrase, puis on colle pardessus
		lemoteur.Inserer("ABC");
		assertTrue(lemoteur.getTexte().toString().equals("ABC"));	// la phrase est bien supprim� et remplacer
		assertTrue((lemoteur.getSelection().getStart()==3)&& lemoteur.getSelection().getEnd()==3 ); //le curseur est bien a la fin de la phrase
	}

	@Test
	public void testCopier() {
		assertTrue(lemoteur.getPresspaper().equals(""));
		lemoteur.Selectionner(0, 8);
		lemoteur.Copier();
		assertTrue(lemoteur.getPresspaper().equals("PONCHOUR"));
		lemoteur.Selectionner(0, 1);	// On copie "P"
		lemoteur.Copier();
		assertTrue(lemoteur.getPresspaper().equals("P"));
		lemoteur.Selectionner(0, 3);	// On copie "PON"
		lemoteur.Copier();
		assertTrue(lemoteur.getPresspaper().equals("PON"));
		lemoteur.Copier();
		assertFalse(lemoteur.getPresspaper().equals("P"));	// On v�rifie que la premi�re copie a disparu
		
	}

}
