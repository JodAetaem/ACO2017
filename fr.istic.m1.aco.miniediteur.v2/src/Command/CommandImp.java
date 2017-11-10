package Command;
import Memento.Memento;
import moteur.*;

public abstract class CommandImp implements Command{
	
	protected Moteur LM=new MoteurImp("");
	protected Memento memento ;
	protected boolean estrejoue;
	
	
	public CommandImp (Moteur lemoteur){
		LM = lemoteur ;
	}
	public Memento getMemento () {
		return memento;
	}
	public void setMemento (Memento m) {
		memento = m;
	}
}
