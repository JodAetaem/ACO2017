package Memento;

import Command.*;

public interface Enregistreur {
	public Enregistreur getEnregistreur();
	public void setEnregistreur(Enregistreur e);
	public void start();
	public void stop();
	public void execute();
	public void add(Command c,Memento m);
}
