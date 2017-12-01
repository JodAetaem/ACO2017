package moteur;


/**
 * @info Implémentation du moteur 
 * @generated
 */

public class MoteurImp implements Moteur
{
	/**
	 * @info Buffer de texte 
	 * @generated
	 * @ordered
	 */
	
	private StringBuffer texte;

	/**
	 * @info PressPapier
	 * @generated
	 * @ordered
	 */
	
	private String presspaper;
	/**
	 * @info portion de texte selectionner. Si end == start , alors position courante
	 * @generated
	 * @ordered
	 */
	
	private Selection selection;//c'est un test #passalivaire mdr
	
	

	public StringBuffer getTexte() {
		return texte;
	}

	public void setTexte(StringBuffer texte) {
		this.texte = texte;
	}

	public String getPresspaper() {
		return presspaper;
	}

	public void setPresspaper(String presspaper) {
		this.presspaper = presspaper;
	}

	public Selection getSelection() {
		return selection;
	}


	/**
	 *@info constructeur
	 * @generated
	 */
	public MoteurImp(String texteinit){
		texte = new StringBuffer (texteinit);
		presspaper="";
		selection = new Selection();
		selection.selection(0,0);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void Selectionner(int start, int end) {
		if(texte.length()<end || texte.length()<start){
			System.err.println("Erreur: Debut ou fin de taille incorrect");
		}
		else if (end<start){
			System.err.println("Erreur : end<Start");
		}
		else{
		selection.setStart(start);
		selection.setEnd(end);
		}
	}

	/**
	 *@info colle le texte precedement copier a la position courante
	 * @generated
	 * @ordered
	 */
	
	public void Coller() {
		Inserer(presspaper);
		}

	/**
	 * @info coupe le texte selectionner
	 * @generated
	 * @ordered
	 */
	
	public void Couper() {
		Copier();
		texte.delete(selection.getStart(), selection.getEnd());
		selection.setEnd(selection.getStart());
	}

	/**
	 * @info inserer le texte parameter a la position courante
	 * @generated
	 * @ordered
	 */
	
	public void Inserer(String phrase) {
		if (selection.getEnd()==selection.getStart()){
			texte.insert(selection.getStart(), phrase.toCharArray());
			selection.setStart(selection.getStart()+phrase.length());	// on positionne le curseur a la fin de la string colle
			selection.setEnd(selection.getStart());
		}
		else {
			texte.delete(selection.getStart(), selection.getEnd());
			texte.insert(selection.getStart(), phrase.toCharArray());
			selection.setStart(selection.getStart()+phrase.length());	// on positionne le curseur a la fin de la string colle
			selection.setEnd(selection.getStart());
		}
	}

	/**
	 * @info copie la selection courante
	 * @generated
	 * @ordered
	 */
	
	public void Copier() {
		presspaper = texte.substring(selection.getStart(), selection.getEnd());
			}
	
	/**
	 * @info suppression de la selection
	 */
	
	
	public void delete() {
		if(selection.getStart()==selection.getEnd()) {
		selection.setStart(selection.getStart()-1);
		}
		texte.delete(selection.getStart(),selection.getEnd());
	}
}

