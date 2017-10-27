package Command;
import moteur.*;

public abstract class CommandImp implements Command{
	
	protected Moteur LM=new MoteurImp("");
	
	
	
	public CommandImp (Moteur lemoteur){
		LM = lemoteur ;
	}
}
