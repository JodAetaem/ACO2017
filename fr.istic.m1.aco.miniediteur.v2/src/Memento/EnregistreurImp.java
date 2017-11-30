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
	
	/**
	 * @info lance le replay
	 */
	public void execute() {
		if(!isrecording) {//check si on est en train de record ou non
		isreplaying=true;
		for (Memento key   : hm.keySet()) {//execute chaque commande qui ont été fait et donc ajouté dans la map
			hm.get(key).setMemento(key);
		    hm.get(key).execute();  
		}
		
		}
		else {System.out.println("You can't execute a macro while recording");}//cas ou on est en cours de recording
	}
	public HashMap<Memento,Command> getMap (){
		return this.hm;
	}
	/**
	 * @info lance l'enregistrement
	 */
	public void start() {
		if(isrecording) {//si on essaye de record while recording
			System.out.println("You're already recording");
		}
		else if(!isreplaying) {//cas ou on est ni en train de replay ni en train de record
		isrecording=true;
		System.out.println("recording has started");
		}
		else {//cas ou on est en train de replay
			System.out.println("You can't make macros inside a macro, maybe in a future version, easy to implement");
		}
	}
	
	/**
	 * @info fin de l'enregistrement
	 */
	public void stop() {
		if(isrecording) {//cas ou on avait bien un enregistrement en cour
		isrecording=false;
		System.out.println("recording has been end ");
		}
		else {System.out.println("There is no current recording");}//cas si on lance stop avant de start
	}
	/**
	 * @info ajout de la commande et du memento dans la map de l'enregistreur
	 * 
	 */
	public void add (Command c, Memento m) {
		hm.put(m, c);//solar
	}

}
