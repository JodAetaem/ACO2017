package receiver;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Memento.Enregistreur;
import Memento.EnregistreurImp;
import moteur.IHM;
import moteur.Moteur;
import moteur.MoteurImp;

public class TestEnregistreurImp {
	
	private Moteur lemoteur;
	private IHM interfaces;
	private Enregistreur recordeur;

	@Before
	public void setUp() throws Exception {
		lemoteur = new MoteurImp("Bonjour le Monde");
		interfaces = new IHM();
		recordeur = new EnregistreurImp ();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testEnregistreurImp() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetRecording() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetReplaying() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testPp() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testExecute() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetMap() {
		fail("Not yet implemented"); // TODO
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
		fail("Not yet implemented"); // TODO
	}

}
