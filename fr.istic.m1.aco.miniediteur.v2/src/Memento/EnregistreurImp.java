package Memento;
import java.util.HashMap;

import Command.*;

public class EnregistreurImp {
	private HashMap<Memento,Command> hm ;
	private boolean isrecording ;
	private boolean isreplaying;
	public EnregistreurImp() {
		hm=new HashMap<Memento,Command>();
		isrecording = false;
		isreplaying=false;
	}
	public boolean getRecording(){
		return isrecording;
	}
	public boolean getReplaying(){
		return isreplaying;
	}
	public void execute() {
		for (Memento key   : hm.keySet()) {
		     hm.get(key).execute();  //get() is less efficient 
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
