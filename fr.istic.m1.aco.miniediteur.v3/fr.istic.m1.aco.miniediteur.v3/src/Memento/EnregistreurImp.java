package Memento;
import java.util.HashMap;
import java.util.LinkedHashMap;

import Command.*;

public class EnregistreurImp implements Enregistreur {
	private LinkedHashMap<Memento,Command> hm ;
	private boolean isrecording ;
	private boolean isreplaying;
	public EnregistreurImp() {
		hm=new LinkedHashMap<Memento,Command>();
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
		if(!isrecording) {
		isreplaying=true;
		for (Memento key   : hm.keySet()) {
			hm.get(key).setMemento(key);
		    hm.get(key).execute();  
		}
		
		}
		else {System.out.println("You can't execute a macro while recording");}
	}
	public HashMap<Memento,Command> getMap (){
		return this.hm;
	}
	public void start() {
		if(isrecording) {
			System.out.println("You're already recording");
		}
		else if(!isreplaying) {
		isrecording=true;
		System.out.println("recording has started");
		}
		else {
			System.out.println("You can't make macros inside a macro, maybe in a future version, easy to implement");
		}
	}
	public void stop() {
		if(isrecording) {
		isrecording=false;
		System.out.println("recording has been end ");
		}
		else {System.out.println("There is no current recording");}
	}
	
	public void add (Command c, Memento m) {
		hm.put(m, c);//solar
	}

}
