package Memento;

public class MementoInserer extends MementoImp {
	private String s;
	
	
	public MementoInserer (String s) {
		this.s=s;
	}
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
}
