package Command;
import moteur.*;

public class Inserer  extends CommandImp{
	private IHM ihm;
	public Inserer (Moteur lm, IHM ihm){
		super(lm);
		this.ihm = ihm;
	}
	
	@Override
	public void execute(){
		String str = this.ihm.getTexte();
		LM.Inserer(str);
	}
}
