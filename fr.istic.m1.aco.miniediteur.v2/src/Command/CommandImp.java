package Command;
import Memento.*;
import moteur.*;

public abstract class CommandImp implements Command{
	
	protected Moteur LM=new MoteurImp("");
	protected Memento memento  ;
	protected boolean estrejoue;
	protected Enregistreur records;
	
	public void setEstRejoue () {
		estrejoue = true;
	}
	public CommandImp (Moteur lemoteur,Enregistreur r){
		LM = lemoteur ;
		records = r;
		estrejoue=false;
	}
	public Memento getMemento () {
		return memento;
	}
	public void setMemento (Memento m) {
		memento = m;
		estrejoue=true;
	}
}
