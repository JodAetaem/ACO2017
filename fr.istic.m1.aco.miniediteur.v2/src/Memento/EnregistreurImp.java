package Memento;
import java.util.HashMap;

import Command.*;

public class EnregistreurImp implements Enregistreur {
	private HashMap<Memento,Command> hm ;
	private boolean isrecording ;
	private boolean isreplaying;
	public EnregistreurImp() {
		hm=new HashMap<Memento,Command>();
		isrecording = false;
		isreplaying=false;//a enlever si on veut faire des macro de macro ! 
	}
	public boolean getRecording(){
		return isrecording;
	}
	public boolean getReplaying(){
		return isreplaying;
	}
	public void execute() {
		isreplaying=true;
		for (Memento key   : hm.keySet()) {
			hm.get(key).setMemento(key);
		    hm.get(key).execute();  
		}    
	}
	public HashMap<Memento,Command> getMap (){
		return this.hm;
	}
	public void start() {
		if(!isreplaying) {
		isrecording=true;
		}
	}
	public void stop() {
		isrecording=false;
	}
	
	public void add (Command c, Memento m) {
		hm.put(m, c);//solar
	}

}
