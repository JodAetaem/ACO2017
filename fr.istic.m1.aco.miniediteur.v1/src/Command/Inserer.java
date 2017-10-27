package Command;
import moteur.*;

public class Inserer  extends CommandImp{
	String txt;
	public Inserer (Moteur lm, String st){
		super(lm);
		this.txt = st;
	}
	
	@Override
	public void execute(){
		LM.Inserer(txt);
	}
}
