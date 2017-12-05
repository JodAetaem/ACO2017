package Memento;

import java.util.HashMap;

import Command.*;

public interface Enregistreur {
	public boolean getRecording();
	public boolean getReplaying();
	public void start();
	public void stop();
	public void execute();
	public void add(Command c,Memento m);
	public HashMap<Memento,Command> getMap();
}
