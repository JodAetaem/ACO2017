package Command;
import Memento.*;



public interface Command {
	
	
	public void execute();
	public Memento getMemento ();
	public void setMemento (Memento m);
}
