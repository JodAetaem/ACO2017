package Memento;

public class MementoInserer extends MementoImp {
	private String s;
	
	/**
	 * @info constructeur du memento inserer
	 * @param s
	 */
	public MementoInserer (String s) {
		this.s=s;
	}
	
	/**
	 * @info getter
	 * @return
	 */
	public String getS() {
		return s;
	}
	
	
	/**
	 * @info setter
	 * @param s
	 */
	public void setS(String s) {
		this.s = s;
	}
	
}
