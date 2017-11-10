package Memento;
import java.util.HashMap;

import Command.*;

public class EnregistreurImp {
	private HashMap<Memento,Command> hm ;
	private boolean isrecording ;
	public EnregistreurImp() {
		hm=new HashMap<Memento,Command>();
		isrecording = false;
	}
	public boolean getRecording(){
		return isrecording;
	}
	public void execute() {
		
	}
	public void start() {
		isrecording=true;
	}
	public void stop() {
		isrecording=false;
	}
	
	public void add (Command c, Memento m) {
		hm.put(m, c);//solar
	}
}
